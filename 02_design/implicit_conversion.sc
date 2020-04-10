sealed trait Json
case class JNumber(value: BigDecimal) extends Json
case class JString(value: String) extends Json
case class JBoolean(value: Boolean) extends Json
case class JArray(elems: List[Json]) extends Json
case class JObject(fields: (String, Json)*) extends Json

JObject("name" -> JString("Paul"), "age" -> JNumber(42))

// implicit conversion is implicit definition taking exactly one parameter

// def obj(fields: (String, Json)*): Json = JObject(fields: _*)
// object Json {
//   import scala.language.implicitConversions
//   implicit def stringToJson(s: String): Json = JString(s)
//   implicit def intToJson(n: Int): Json = JNumber(n)
// }
// obj("name" -> "Paul", "age" -> 42)