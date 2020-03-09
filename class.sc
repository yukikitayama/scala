// class
// use class to make data structure
// class definition makes a type and a constructor

class Rational(x: Int, y: Int) {
  // members
  def numerator = x
  def denominator = y

  // methods
  // we can use Rational as data type
  def add(another: Rational) =
    // need new to construct class
    // the result from new "class" is called "object"
    new Rational(
      numerator * another.denominator + another.numerator * denominator,
      denominator + another.denominator
    )

  // we can use our class as result type
  // inside class, no need prefix to numerator
  def negative: Rational = new Rational(- numerator, denominator)

  def subtract(another: Rational) = add(another.negative)

  // another method
  override def toString = numerator + "/" + denominator
}

// use new to construct class
new Rational(1, 2)

val x = new Rational(1, 3)
// . is infix operator to select members
x.numerator
x.denominator

val y = new Rational(5, 7)
// test method
x.add(y)

val z = new Rational(3, 2)
x.subtract(y).subtract(z)
