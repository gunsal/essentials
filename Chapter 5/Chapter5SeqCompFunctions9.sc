sealed trait Sum[A, B] {

  def fold[C](lef: A => C, rig: B => C): C =
    this match {
      case Left(x) => lef(x)
      case Right(x) => rig(x)
    }
}

case class Left[A, B](value: A) extends Sum[A, B]
case class Right[A, B](value: B) extends Sum[A, B]

Left[Int, String](1).value
Right[Int, String]("foo").value

val sum: Sum[Int, String] = Right("Hey there")

sum match {
  case Left(x) => x.toString
  case Right(x) => x
}


sealed trait Maybe[A] {

  def fold[B](full: A => B, empty: B): B =
    this match {
      case Full(v) => full(v)
      case Empty() => empty
    }
}

final case class Full[A](in: A) extends Maybe[A]
final case class Empty[A]() extends Maybe[A]

val perhaps = Empty[Int]
val perhapss = Full(1)
