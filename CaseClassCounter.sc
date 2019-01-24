case class Counter(count: Int = 0) {
  def dec: Counter = copy(count = count - 1)

  def inc: Counter = copy(count = count + 1)
}

val x = Counter(0)
val y = Counter().inc
y.count
Counter().inc.dec.count
Counter().inc.dec == Counter().dec.inc

case class Person(firstName: String, lastName: String) {
  def name: String = firstName + " " + lastName
}

object Person {
  def apply(name: String): Person = {
    val parts = name.split(" ")
    apply(parts(0), parts(1))
  }
}

Person("Gorkem", "Unsal")
Person("Emre Cullu")

