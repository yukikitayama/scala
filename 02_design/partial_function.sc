val f1: String => String = { case "denver" => "colorado"}
f1("denver")
// scala.MatchError
// f1("colorado")

val f2: PartialFunction[String, String] =
  { case "denver" => "colorado"}

f2.isDefinedAt("denver")
f2.isDefinedAt("colorado")

val f3: PartialFunction[List[Int], String] = {
  case Nil => "one"
  case x :: y :: rest => "two"
}

f3.isDefinedAt(List(1, 2, 3))

val f4: PartialFunction[List[Int], String] = {
  case Nil => "one"
  case x :: rest =>
    rest match {
      case Nil => "one"
    }
}

// returns true, but warning
// because pattern matching does not account for all possible cases
f4.isDefinedAt(List(1, 2, 3))