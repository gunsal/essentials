case class Person(firstName: String, lastName: String){
  def name = s"$firstName $lastName"
}

val dave = new Person("Dave", "Little")

val newDave = new Person("Dave", "Little")

dave.equals(newDave)

dave == newDave

val copyDave = dave.copy()

copyDave.name

Person("Emre", "Cullu") == Person("Emre", "Cullu")

