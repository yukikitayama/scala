import scala._

case class Person(name: String, age: Int)

val persons = List(Person("Yuki", 31),
  Person("Tomoki", 27),
  Person("Someone", 28),
  Person("Anotherone", 18))

for (p <- persons if p.age > 20) yield p.name

// equivalent to
persons filter (p => p.age > 20) map (p => p.name)

def scalarProduct(xs: List[Double], ys: List[Double]): Double =
  (for ((x, y) <- xs zip ys) yield x * y).sum

val nums1: List[Double] = List(1.0, 2.0, 3.0)
val nums2: List[Double] = List(4.0, 5.0, 6.0)

scalarProduct(nums1, nums2)
1*4 + 2*5 + 3*6