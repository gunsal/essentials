sealed trait DivisionResult
case class Finite(value: Int) extends DivisionResult
case object Infinite extends DivisionResult

object divide {
  def apply(x: Int, y: Int): DivisionResult =
    if (y == 0) Infinite else Finite(x / y)
}

divide(6, 2) match {
  case Finite(value) => println(s"Its a finite number $value")
  case Infinite => println("Infiniteeeeeeeeee")
}

divide(6, 0) match {
  case Finite(value) => println(s"Its a finite number $value")
  case Infinite => println("Infiniteeeeeeeeee")
}