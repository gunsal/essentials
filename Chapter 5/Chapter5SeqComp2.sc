final case class Box[A](value: A)

Box(2)
Box("Hello World")
Box(true)

def generic[A](in: A): A = in

generic("hi there")
generic(4)


//A result of Type A is either a Success of type A or a FAilure with
// a String reason
sealed trait Result[A]
final case class Success[A](result: A) extends Result[A]
final case class Failure[A](reason: String) extends Result[A]
