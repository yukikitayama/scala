// abstract class allow definitions to have no body
abstract class IntSet {
  // no bodies
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

// abstract classes can have members (definitions) without an implementation
// abstract classes can be made without "new" operator

// binary trees

// extends
// following NonEmpty and Empty extend IntSet
// it means they (NonEmpty and Empty) are subclasses of a base class "IntSet"
// so they conform to the type of IntSet
// definitions of subclasses implement abstract functions in base class
class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  override def toString = "{" + left + elem + right + "}"
  def union(other: IntSet): IntSet =
    ((left union right) union other) incl elem
}

class Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  override def toString = "."
  def union(other: IntSet): IntSet = other
}

// test
val t1 = new NonEmpty(3, new Empty, new Empty)
val t2 = t1 incl 4

