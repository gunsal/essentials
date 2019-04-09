case class Pair[A, B](str: A, num: B){
  def one = str
  def two= num
}

val pair = Pair("hi", 2)

pair.one
pair.two

Tuple2("hi", 2)
("wow", 7)

def tuplized[A, B](in: (A, B)) =in._1

tuplized(("asd", 2))

def tups[A, B](in: (A, B)): B = in._2

("strins", 4) match {
  case (a,b) => a+b
}
