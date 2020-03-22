// annotation ensures correctness of encodings

// tailrec ensures a method is tail-recursive
// if not, it fails to compile and throw error message
@scala.annotation.tailrec
def greatestCommonDivisor(x: Int, y: Int): Int = {
  if (y == 0) x else greatestCommonDivisor(y, x % y)
}

// test
greatestCommonDivisor(6, 12)
greatestCommonDivisor(14, 49)

// tail recursion: a function calls itself at last action and stack is reused
// it keeps memory requirement constant

// it is not tail recursion below because it has n * and expression becomes bigger in each call
// if put @tailrec before this, it fails
def factorial(n: Int): Int =
  if (n == 0) 1 else n * factorial(n - 1)

// test
factorial(4)

// factorial with tail recursion
def factorialTailRec(n: Int): Int = {
  @scala.annotation.tailrec
  def loop(accumulator: Int, n: Int): Int =
    if (n == 0) accumulator
    else loop(accumulator * n, n - 1)
  loop(1, n)
}

/*when n = 4,
loop(accumulator = 1, n = 4)
n is not 0
  = loop(1 * 4, 4 - 1)
  = loop(4, 3)
n is not 0
  = loop(4 * 3, 3 - 1)
  = loop(12, 2)
n is not 0
  = loop(12 * 2, 2 - 1)
  = loop(24, 1)
n is not 0
  = loop(24 * 1, 1 - 1)
  = loop(24, 0)
n is 0
  = 24*/

// test
factorialTailRec(4)
