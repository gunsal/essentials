val x = Some(123)
val y = Some(321)

val u = for {
  a <- x
  b <- y
} yield a + b

def divide(numerator: Int, denominator: Int) =
  if (denominator == 0) None else Some(numerator / denominator)

def divideOptions(numerator: Option[Int], denominator: Option[Int]) =
  for {
    a <- numerator
    b <- denominator
    c <- divide(a, b)
  } yield c

def readInt(str: String): Option[Int] =
  if (str matches "-?\\d+") Some(str.toInt) else None

def sum(optionA: Option[Int], optionB: Option[Int]): Option[Int] =
  optionA.flatMap(a => optionB.map(b => a + b))
def extract(optionA: Option[Int], optionB: Option[Int]): Option[Int] =
  optionA.flatMap(a => optionB.map(b => a - b))

Seq(readInt("1"), readInt("b"), readInt("3")).flatMap(x => x)

def calculator(operand1: String, operator: String, operand2: String) = {
  def calcInternal(a: Int, b: Int) =
    operator match {
      case "+" => Some(a + b)
      case "-" => Some(a - b)
      case "*" => Some(a * b)
      case "/" => divide(a, b)
      case _ => None
    }
  val result =
    readInt(operand1) flatMap { a =>
      readInt(operand2) flatMap { b =>
        calcInternal(a, b) map { result =>
          result
        }
      }
    }
  result match {
    case Some(number) => println(s"The answer is $number!")
    case None => println(s"Error calculating $operand1 $operator $operand2")
  }
}