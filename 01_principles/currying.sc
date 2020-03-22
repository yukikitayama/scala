// currying
// something like every function maps to n nested anonymous witch each taking one parameter
// something like n nested anonymous function in body

// for example
// def sum(f: Int => Int)(a: Int, b: Int): Int = ...
// (Int => Int) => (Int, Int) => Int
// Int => Int => Int is equal to Int => (Int => Int)

// a is lower bound and b is upper bound
def sum(f: Int => Int)(a: Int, b: Int): Int = {
  def sumF(a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sumF(a + 1, b)
  sumF(a, b)
}
// test
sum(x => x)(1, 3)
sum(x => x * x)(1, 3)
// check
1 * 1 + 2 * 2 + 3 * 3

def product(f: Int => Int)(a: Int, b: Int): Int =
  // if bound is empty
  if (a > b) 1
  else f(a) * product(f)(a + 1, b)
// test
product(x => x * x)(1, 3)
// check
(1 * 1) * (2 * 2) * (3 * 3)

def factorial(n: Int) = product(x => x)(1, n)
// test
factorial(4)
// check
4 * 3 * 2 * 1

def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a:Int, b: Int): Int =
  if (a > b) zero
  else combine(f(a), mapReduce(f, combine, zero)(a+1, b))
def productNew(f: Int => Int)(a: Int, b: Int): Int =
  mapReduce(f, (x, y) => x * y, 1)(a, b)
// test
productNew(x => x * x)(1, 3)
// check
product(x => x * x)(1, 3)