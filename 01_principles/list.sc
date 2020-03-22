// list is immutable and recursive. Array is flat.
val fruit = scala.List("apples",  "oranges", "pears")

println(fruit)

// :: is cons, Nil is empty list,
val fruitSame = "apples" :: ("oranges" :: ("pears" :: Nil))

println(fruitSame)

// :: is right-hand operand, so using :: method, above can also be constructed as below
val fruitSame2 = Nil.::("pears").::("oranges").::("apples")

println(fruitSame2)

fruit.head
fruit.tail
fruit.isEmpty

// remove element at given index
def removeAt(n: Int, xs: List[String]) = (xs take n) ::: (xs drop n + 1)

// test
removeAt(1, fruit)
