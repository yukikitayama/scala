// import scala.math.Ordering
import scala._

// lt is a member of trait Ordering, return true if x < y in the ordering lt(x, y)
// "lt" is less than
// xs is different from xs1, xs1 is temporary in pattern matching
// implicit parameters let compiler figure out the right implicit to pass based on demanded type
// implicit needs to be visible when the function is called
def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
  val n = xs.length / 2
  if (n == 0) xs
  else {
    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if (ord.lt(x, y)) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }

    val (fst, snd) = xs splitAt n
    merge(msort(fst), msort(snd))
  }
}

// test
val nums = List(2, -4, 5, 7, 1)
val fruits = List("apple", "pineapple", "orange", "banana")
msort(nums)
msort(fruits)