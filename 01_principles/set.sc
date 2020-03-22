import scala._

val fruits = Set("apple", "banana", "orange")
val nums = (1 to 6).toSet

fruits filter (_.startsWith("a"))
nums map (_ + 2)
nums contains 2
