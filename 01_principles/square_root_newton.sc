// to use abs function
import scala.math._

// Newton's method to estimate square roots
object session {
  // : Double, recursive function needs to specify return type
  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)

  def isGoodEnough(guess: Double, x: Double) =
    abs(guess * guess - x) / x < 0.001

  def improve(guess: Double, x: Double) =
    (guess + x / guess) / 2

  def sqrt(x: Double) = sqrtIter(1, x)
}

// test the function
session.sqrt(2)
session.sqrt(4)