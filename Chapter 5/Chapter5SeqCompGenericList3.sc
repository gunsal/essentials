sealed trait LinkedList[A]{
  def length: Int =
    this match {
      case End() => 0
      case Pair(hd, tl) => 1 + tl.length
    }
}
final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]
final case class End[A]() extends LinkedList[A]

val example = Pair(1, Pair(2, Pair(3, End())))
val secondExample = Pair(6, End()).length
assert(example.length == 3)
assert(example.tail.length == 2)
assert(End().length == 0)