trait Expr
// making case class, not class, allows us to use it in pattern matching
case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr

// case class does not need new
def show(e: Expr): String = e match {
  case Number(x) => x.toString
  case Sum(left, right) => show(left) + "+" + show(right)
}

// test
show(Sum(Number(1), Number(2)))