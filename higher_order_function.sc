// range with lower a and upper b

// f is a parameter of some function, type Int to Int
def sum(f: Int => Int, a: Int, b: Int): Int =
  if (a > b) 0
  else f(a) + sum(f, a + 1, b)

// identity function
def id(x: Int): Int = x
def cube(x: Int): Int = x * x * x
def factorial(x: Int): Int = if (x == 0) 1 else x * factorial(x - 1)

factorial(4)

def sumInts(a: Int, b: Int): Int = sum(id, a, b)
sumInts(1, 5)
1 + 2 + 3 + 4 + 5
def sumCubes(a: Int, b: Int): Int = sum(cube, a, b)
sumCubes(1, 2)
1 + 2 * 2 * 2
def sumFactorials(a: Int, b: Int): Int = sum(factorial, a, b)
sumFactorials(1, 3)
1 + 2 + 3 * 2

// anonymous function
(x: Int) => x * x * x
// we do not need to define each function for sum if we pass anonymous functions
def sumCubesAnonymous(a: Int, b: Int): Int = sum((x: Int) => x * x * x, a, b)
sumCubesAnonymous(1, 2)

// sum function using linear recursion
def sumLinearRec(f: Int => Int, a: Int, b: Int) = {
  @ scala.annotation.tailrec
  def loop(a: Int, accumulator: Int): Int =
    if (a > b) accumulator
    else loop(a + 1, f(a) + accumulator)
  loop(a, 0)
}

/* when a = 3, b = 5
  loop(3, 0)
  = loop(3 + 1, 3 * 3 + 0)
  = loop(4, 9)
a = 4 < b = 5
  = loop(4 + 1, 4 * 4 + 9)
  = loop(5, 25)
a = 5 = b = 5
  = loop(5 + 1, 5 * 5 + 25)
  = loop(6, 50)
a = 6 > b = 5
  = 50*/

// test
// passing anonymous function to a parameter
sumLinearRec(x => x * x, 3, 5)