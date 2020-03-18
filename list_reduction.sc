import scala._

def sumList1(xs: List[Int]): Int = xs match {
  case Nil => 0
  case y :: ys => y + sumList1(ys)
}

// test
val nums: List[Int] = List(1, 2, 3, 4, 5)
sumList1(nums)

// reduceLeft does some operation between adjacent elements of a list
def sumList2(xs: List[Int]): Int =
  (0 :: xs) reduceLeft ((x, y) => x + y)

// test
sumList2(nums)

// ((x, y) => x + y)) can be written (_ + _)
// _ is a new parameter from left to right
def sumList3(xs: List[Int]): Int =
  (0 :: xs) reduceLeft (_ + _)

// test
sumList3(nums)

// reduceLeft is only for nonempty list
// foldLeft can be applied to empty list because of accumulator z
// z is returned if the list is empty
// below 0 is accumulator
def sumList4(xs: List[Int]): Int =
  (xs foldLeft 0) (_ + _)

// test
val emptyNums = Nil
sumList4(nums)
sumList4(emptyNums)

