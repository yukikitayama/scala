
import scala._

def isPrime(n: Int) =
  (2 until n) forall (n % _ != 0)

val n = 7

// produce sum is prime
(1 until n) flatMap (i =>
  (1 until i) map (j => (i, j))) filter (pair =>
    isPrime(pair._1 + pair._2))

