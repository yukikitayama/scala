object Solution {
  def checkMultiples(n: Int): String = {
    // numbers are 0 by module 3 and 5
    val numbers = (n % 3, n % 5)

    // pattern matching (https://docs.scala-lang.org/tour/pattern-matching.html)
    numbers match {
      // _ is catch all, case of any other possible values
      case (0, 0) => "FizzBuzz"
      case (0, _) => "Fizz"
      case (_, 0) => "Buzz"
      case (_, _) => n.toString
    }
  }

  def fizzBuzz(n: Int): List[String] = {
    // to is predefined methods to create a range
    // map() method applies transformation, taking function as a parameter
    (1 to n).toList.map(checkMultiples)
  }
}

// test
Solution.fizzBuzz(1)
Solution.fizzBuzz(3)
Solution.fizzBuzz(15)