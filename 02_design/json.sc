abstract class JSON
case class JSeq (elems: List[JSON]) extends JSON
case class JObj (bindings: Map[String, JSON]) extends JSON
case class JNum (num: Double) extends JSON
case class JStr (str: String) extends JSON
case class JBool (b: Boolean) extends JSON
case object JNull extends JSON

val data = JObj(Map(
  "firstName" -> JStr("Yuki"),
  "lastName" -> JStr("Kitayama"),
  "address" -> JObj(Map(
    "streetAddress" -> JStr("West 116th Street and Broadway"),
    "state" -> JStr("NY"),
    "postalCode" -> JStr("10027")
  )),
  "phoneNumbers" -> JSeq(List(
    JObj(Map(
      "type" -> JStr("home"),
      "number" -> JStr("646 111-1111")
    )),
    JObj(Map(
      "type" -> JStr("work"),
      "number" -> JStr("646 222-2222")
    ))
  ))
))

def show(json: JSON): String = json match {
  case JSeq(elems) =>
    "[" + (elems map show mkString ", ") + "]"
  case JObj(bindings) =>
    val assocs = bindings map {
      // use backslash \ to escape quotes
      case (key, value) => "\"" + key + "\": " + show(value)
    }
    "{" + (assocs mkString ", ") + "}"
  case JNum(num) => num.toString
  case JStr(str) => "\"" + str + "\""
  case JBool(b) => b.toString
  case JNull => "null"
}

// test
show(data)


