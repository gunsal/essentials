trait Feline {
  def colour: String
  def sound: String
}

trait BigCat extends Feline{
  val sound: String = "Roar"
}

case class Cat(colour: String,
               favFood: String) extends Feline {
  val sound: String = "Meow"
}

case class Lion(colour: String,
                maneSize: Int) extends BigCat {
}

case class Tiger(colour: String) extends Feline {
  val sound: String = "Roar"
}

case class Panther(colour: String) extends Feline {
  val sound: String = "Roar"
}

Panther("Black").sound