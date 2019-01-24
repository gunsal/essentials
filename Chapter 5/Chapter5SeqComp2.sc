final case class Box[A](value: A)

Box(2)
Box("Hello World")
Box(true)

def generic[A](in: A): A = in

generic("hi there")
generic(4)

sealed trait Result[A]
final case class Success[A](result: A) extends Result[A]
final case class Failure[A](reason: String) extends Result[A]
