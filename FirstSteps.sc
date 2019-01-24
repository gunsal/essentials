/*class Adder(amount: Int){
  def add(in: Int): Int = in + amount
}*/

class Adder(amount: Int) {
  def apply(in: Int): Int = in + amount
}

val add3 = new Adder(3)

add3.apply(2)
add3.apply(4)

class Timestamp(val second: Long)

object Timestamp {
  def apply(hours: Int, mins: Int, seconds: Int): Timestamp =
    new Timestamp(hours * 3600 + mins * 60 + seconds)
}

val a = Timestamp(1,1,1).second
