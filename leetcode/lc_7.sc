object Solution {
  def reverse(x: Int): Int = {

    // return 0 when the reversed integer overflow
    if (!validInteger(x)) {
      0
    }

    if (x < 0) {
      -util(-x)
    } else {
      util(x)
    }
  }

  def util(x: Int): Int = {
    var result: Long = 0
    var vx = x

    // module 10 produces ones place number as remainder, then push to tens place
    while (vx != 0) {
      result = result * 10 + vx % 10
      if (!validInteger(result)) {
        0
      } else {
        // vx is Int, so ones place number disappears as float
        vx /= 10
      }
    }
    // cast Long to Int
    result.toInt
  }

  // Long is 64 bit signed value
  def validInteger(x: Long): Boolean = {
    // Int.MaxValue, the largest value representable as an Int
    if (!(x > Int.MaxValue) && !(x < Int.MinValue)) {
      true
    } else {
      false
    }
  }
}

Solution

val x1: Int = 123
val x2: Int = -123
val x3: Int = 120

Solution.reverse(x1)
Solution.reverse(x2)
Solution.reverse(x3)
