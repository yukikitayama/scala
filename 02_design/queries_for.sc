case class Book(title: String, authors: List[String])

val books = Set(
  Book(
    title = "Deep Learning with Python",
    authors = List("Chollet, Francois")),
  Book(
    title = "A First Course in Bayesian Statistical Methods",
    authors = List("Hoff, Peter")),
  Book(
    title = "Applied Linear Regression Models",
    authors = List("Kutner, Michael", "Nachtsheim, Christopher", "Neter, John")),
  Book(
    title = "Natural Language Processing with Python",
    authors = List("Bird, Steven", "Klein, Ewan")),
  Book(
    title = "Reinforcement Learning An Introduction",
    authors = List("Sutton, Richard", "Barto, Andrew")),
  Book(
    title = "Handbook of Learning and Approximate Dynamic Programming",
    authors = List("Si, Jennie", "Barto, Andrew", "Powell, Warren", "Wunsch, Don")
  )
)

// find title of book whose author has last name Bird
for (b <- books; a <- b.authors if a startsWith "Bird,")
  yield b.title
// res0: scala.collection.immutable.Set[String] =
// HashSet(Natural Language Processing with Python)

// find author who have written at least 2 books
for {
  b1 <- books
  b2 <- books
  if b1 != b2
  a1 <- b1.authors
  a2 <- b2.authors
  if a1 == a2
} yield a1
// res1: scala.collection.immutable.Set[String] =
// HashSet(Barto, Andrew)


