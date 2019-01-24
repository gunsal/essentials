case class Person(firstName: String, lastName: String)

object Stormtrooper {
  def inspect(person: Person): String =
    person match {
      case Person("Luke", "Skywalker") => "Stop rebel scum"
      case Person("Han", "Solo") => "Stop rebel scum"
      case Person(f, l) => s"Move along $l"
    }
}

Stormtrooper.inspect(Person("Luke", "Skywalker"))
Stormtrooper.inspect(Person("Han", "Solo"))
Stormtrooper.inspect(Person("Victor", "Hugo"))