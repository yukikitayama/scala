package week4

// T is type parameter
// define base trait
trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

// type erasure, type parameter are removed before evaluating the program

// val is evaluated when the object first initialized
// def is evaluated each time when it is referenced

// subtyping
// implementation
class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}
class Nil[T] extends List[T] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

// function also can have type parameter

// singleton is a list of a single element
// def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])
