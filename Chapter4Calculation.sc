sealed trait Calculation

final case class Success(result: Int) extends Calculation

final case class Failure(reason: String) extends Calculation

object Calculator {
  def +(calc: Calculation, num: Int): Calculation = {
    calc match {
      case Success(result) => Success(result + num)
      case Failure(reason) => Failure(reason)
    }
  }

  def -(calc: Calculation, num: Int): Calculation = {
    calc match {
      case Success(result) => Success(result - num)
      case Failure(reason) => Failure(reason)
    }
  }

  def /(calc: Calculation, num: Int): Calculation = {
    (calc, num) match {
      case (Failure(reason), _)   => Failure(reason)
      case (Success(_), 0)        => Failure("Division by zero")
      case (Success(value), num)  => Success(value/num)
    }
  }
}

assert(Calculator.+(Success(1), 1) == Success(2))
assert(Calculator.-(Success(1), 1) == Success(0))
assert(Calculator.+(Failure("Badness"), 1) == Failure("Badness"))

assert(Calculator./(Success(4), 2) == Success(2))
assert(Calculator./(Success(4), 0) == Failure("Division by zero"))
assert(Calculator./(Failure("Badness"), 0) == Failure("Badness"))

println("sadad")