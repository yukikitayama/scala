import scala._

val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
val capitalOfCountry = Map("Japan" -> "Tokyo", "US" -> "Washington")

// map is iterable and function
capitalOfCountry("Japan")

// if not key, default returns None, option
capitalOfCountry get "China"

def showCapital(country: String) = capitalOfCountry.get(country) match {
  case Some(capital) => capital
  case None => "missing data"
}

// test
showCapital("US")
showCapital("China")

// SQL operations
val fruits = List("apple", "banana", "orange", "lemon")
fruits sortWith (_.length < _.length)
fruits.sorted
fruits groupBy (_.length)
// res6: scala.collection.immutable.Map[Int,List[String]] = HashMap(5 -> List(apple, lemon), 6 -> List(banana, orange))

class polynomial(terms0: Map[Int, Double]) {
  // auxiliary constructor
  // * means repeated parameter, sequence
  def this(bindings: (Int, Double)*) = this(bindings.toMap)
  val terms = terms0 withDefaultValue 0.0
  // ++ is concatenation
  def addPoly(other: polynomial) = new polynomial(terms ++ (other.terms map adjust))
  def adjust(term: (Int, Double)): (Int, Double) = {
    val (exp, coeff) = term
    // terms get exp match {
    //   case Some(coeff1) => exp -> (coeff + coeff1)
    //   case None => exp -> coeff
    // }
    exp -> (coeff + terms(exp))
  }
  override def toString =
    // to sort, convert to list
    (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString " + "
}

// test
val p1 = new polynomial(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2))
val p2 = new polynomial(Map(0 -> 3.0, 3 -> 7.0))
p1 addPoly p2
// res7: polynomial = 6.2x^5 + 11.0x^3 + 2.0x^1 + 3.0x^0
p1.terms(7)

// test of auxiliary constructor
val p3 = new polynomial(1 -> 2.0, 3 -> 4.0, 5 -> 6.2)

// partial function
// if error, return exception, to avoid it, use withDefaultValue
val cap1 = capitalOfCountry withDefaultValue "<unknown>"
cap1("China")
