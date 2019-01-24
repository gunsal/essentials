sealed trait Expression{
  def eval: Computation =
    this match {
      case Addition(a1, a2) => a1.eval match {
        case Fail(reason)  => Fail(reason)
        case Success(sux1) =>
          a2.eval match {
            case Fail(reason)   => Fail(reason)
            case Success(sux2)  => Success(sux1 + sux2)
          }
      }
      case Substraction(s1, s2) => s1.eval match {
        case Fail(reason)   => Fail(reason)
        case Success(sux1)  =>
          s2.eval match {
            case Fail(reason)   => Fail(reason)
            case Success(sux2)  => Success(sux1 + sux2)
          }
      }
      case Division(d1, d2) => d1.eval match {
        case Fail(reason) => Fail(reason)
        case Success(sux1) =>
          d2.eval match {
            case Fail(reason)  => Fail(reason)
            case Success(sux2) =>
              if(sux2==0) Fail("Division by Zero") else Success(sux1 / sux2)
          }
      }
      case SquareRoot(sq1) => sq1.eval match {
        case Fail(reason)  => Fail(reason)
        case Success(sux1) =>
          if(sux1 < 0) Fail("Negative Number") else Success(Math.sqrt(sux1))
      }
      case Number(value)   => Success(value)
    }
}

final case class Addition(left: Expression, right: Expression) extends Expression
final case class Substraction(left: Expression, right: Expression) extends Expression
final case class Number(value: Double) extends Expression
final case class Division(left: Expression, right: Expression) extends Expression
final case class SquareRoot(value: Expression) extends Expression

sealed trait Computation
final case class Success(result: Double) extends Computation
final case class Fail(reason: String) extends Computation

Addition(SquareRoot(Number(-1.0)), Number(2.0)).eval
Addition(SquareRoot(Number(4.0)), Number(2.0)).eval

assert(Addition(SquareRoot(Number(-1.0)), Number(2.0)).eval == Fail("Negative Number"))
assert(Addition(SquareRoot(Number(4.0)), Number(2.0)).eval == Success(4.0))
assert(Division(Number(4), Number(0)).eval == Fail("Division by Zero"))
