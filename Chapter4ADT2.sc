sealed trait Food
case object Antelope extends Food
case object TigerFood extends Food
case object Licorice extends Food
case class CatFood(food: String) extends Food

sealed trait Feline
final case class Lion() extends Feline
final case class Tiger() extends Feline
final case class Panther() extends Feline
final case class Cat(favFood: String) extends Feline

object Diner {
  def dinner(feline: Feline): Food =
    feline match {
      case Lion() => Antelope
      case Tiger() => TigerFood
      case Panther() => Licorice
      case Cat(food) => CatFood(food)
    }
}

Diner.dinner(Cat("yemek"))

/*
sealed trait Feline{
  def dinner: Food
}
final case class Lion() extends Feline{
  def dinner: Food = Antelope
}
final case class Tiger() extends Feline{
  def dinner: Food = TigerFood
}
final case class Panther() extends Feline{
  def dinner: Food = Licorice
}
final case class Cat(favFood: String) extends Feline{
  def dinner: Food = CatFood(favFood)
}*/
