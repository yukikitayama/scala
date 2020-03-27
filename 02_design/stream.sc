val xs = Stream.cons(1, Stream.cons(2, Stream.empty))

(1 to 1000).toStream

def streamRange(lo: Int, hi: Int): Stream[Int] = {
  print(lo + " ")
  if (lo >= hi) Stream.empty
  else Stream.cons(lo, streamRange(lo + 1, hi))
}
streamRange(1, 4)
streamRange(1, 10).take(3).toList

def listRange(lo: Int, hi: Int): List[Int] = {
  if (lo >= hi) Nil
  else lo :: listRange(lo + 1, hi)
}
listRange(1, 4)

def isPrime(n: Int): Boolean = {
  if (n <= 1) false
  else if (n == 2) true
  else !(2 until n).exists(x => n % x == 0)
}

isPrime(2)
isPrime(5)
isPrime(6)

((1000 to 10000).toStream filter isPrime)(2)

// #:: produces stream
// x #:: xs == Stream.cons(x, xs)