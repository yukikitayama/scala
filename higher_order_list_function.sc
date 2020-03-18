import scala._

// if using map, code becomes shorter
// map is method of the List class
def scaleList(xs: List[Double], factor: Double) =
  xs map (x => x * factor)

// test
val nums: List[Double] = List(1.0, 2.0, 2.5)
scaleList(nums, 2.0)

// something above can be implemented with pattern matching
def squareList(xs: List[Int]): List[Int] = xs match {
  case Nil => Nil
  case y :: ys => y * y :: squareList(ys)
}

// test
val nums2: List[Int] = List(1, 2, 3)
squareList(nums2)

// filter
// also method of list class
def positiveElements(xs: List[Int]): List[Int] =
  xs filter (x => x > 0)

// test
val nums3: List[Int] = List(1, -1, 2, -2, 3)
positiveElements(nums3)

// other methods
nums3 filterNot (x => x > 0)
nums3 partition (x => x > 0)
// get pair
// res4: (List[Int], List[Int]) = (List(1, 2, 3),List(-1, -2))

// returns longest prefix with the condition
nums3 takeWhile (x => x > -2)
// res5: List[Int] = List(1, -1, 2)

// give remainder
nums3 dropWhile (x => x > 0)
// res6: List[Int] = List(-1, 2, -2, 3)

// span is combination of takeWhile and dropWhile
nums3 span (x => x > 0)
// res7: (List[Int], List[Int]) = (List(1),List(-1, 2, -2, 3))

// function to pack consecutive duplicates of list elements into sublits
val data = List("a", "a", "a", "b", "c", "c", "a")

def pack[T](xs: List[T]): List[List[T]] = xs match {
  // case list is empty
  case Nil => Nil
  // case list is nonempty
  case x :: xs1 =>
    val (first, rest) = xs span (y => y == x)
    first :: pack(rest)
}

// test
pack(data)
// res8: List[List[String]] = List(List(a, a, a), List(b), List(c, c), List(a))

// run-length encoding of a list
// used for compression of images
def encode[T](xs: List[T]): List[(T, Int)] = {
  // pack returns list of list, so ys is sublist
  pack(xs) map (ys => (ys.head, ys.length))
}

encode(data)