import scala._

// vector
// up to 32
val vec = Vector(1, 2, 3, 4)
// :+ and +: are concatenation
vec :+ 5
// res0: scala.collection.immutable.Vector[Int] = Vector(1, 2, 3, 4, 5)
0 +: vec
// res1: scala.collection.immutable.Vector[Int] = Vector(0, 1, 2, 3, 4)

// array
val xs = Array(1, 2, 3, 4)
xs map (x => x * 2)
xs.sum
xs.max
val s = "Hello world"
s filter (c => c.isUpper)
s exists (c => c.isUpper)

// range
val r: Range = 1 until 5

// zip makes sequence of pairs
val pairs = List(1, 2, 3) zip s

s flatMap (c => List(c, '.'))

// scalar product
// linear combination which often appears in statistics
def scalarProduct(xs: List[Double], ys: List[Double]): Double =
  (xs zip ys).map(xy => xy._1 * xy._2).sum

val nums1: List[Double] = List(1.0, 2.0, 3.0)
val nums2: List[Double] = List(4.0, 5.0, 6.0)
scalarProduct(nums1, nums2) // res8: Double = 32.0
// check
1*4 + 2*5 + 3*6

// pattern matching version
def scalarProduct_pm(xs: List[Double], ys: List[Double]): Double =
  (xs zip ys).map{case (x, y) => x * y}.sum

scalarProduct_pm(nums1, nums2) // res10: Double = 32.0

def isPrime(n: Int): Boolean =
  (2 until n) forall (d => n % d != 0)

isPrime(2) // true
isPrime(3) // true
isPrime(4) // false