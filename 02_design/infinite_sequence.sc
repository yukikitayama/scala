def from(n: Int): Stream[Int] = n #:: from(n + 1)

// infinite stream of multiple of 4 natural numbers
val nats = from(0)
val m4s = nats map (_ * 4)

(m4s take 100).toList

// the sieve of eratosthenes
def sieve(s: Stream[Int]): Stream[Int] =
  s.head #:: sieve(s.tail filter (_ % s.head != 0))

val primes = sieve(from(2))
primes.take(30).toList
def sqrtStream(x: Double): Stream[Double] = {
  def improve(guess: Double) = (guess + x / guess) / 2
  lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)
  guesses
}

sqrtStream(4).take(10).toList

def isGoodEnough(guess: Double, x: Double) =
  scala.math.abs((guess * guess - x) / x) < 0.0001

sqrtStream(4) filter (isGoodEnough(_, 4))