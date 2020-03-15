val pair = ("apple", 2)
// pair: (String, Int) = (appled,2)

val (label, value) = pair
// label: String = apple
// value: Int = 2

// scala.Tuple2 is case class with two argument _1 and _2
// https://www.scala-lang.org/api/current/scala/Tuple2.html
val label = pair._1
val value = pair._2

// to let Nil, :: and so on work, import scala
import scala._

def mergeSort(xs: List[Int]): List[Int] = {
  val n = xs.length / 2
  if (n == 0) xs
  else {
    def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if (x < y) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }

    val (fst, snd) = xs splitAt n
    merge(mergeSort(fst), mergeSort(snd))
  }
}

// test
val nums = List(2, -4, 5, 7, 1)
mergeSort(nums)
// res0: List[Int] = List(-4, 1, 2, 5, 7)