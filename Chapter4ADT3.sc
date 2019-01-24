//Using pattern matching
sealed trait TrafficLight {
  def next : TrafficLight =
    this match {
      case Red => Green
      case Green => Yellow
      case Yellow => Red
  }
}
case object Green extends TrafficLight
case object Red extends TrafficLight
case object Yellow extends TrafficLight

Green.next
Yellow.next
Red.next
println("asd")

//Using polymorphism
/*
sealed trait TrafficLight {
  def next: TrafficLight
}

case object Green extends TrafficLight {
  def next: TrafficLight = Yellow
}

case object Red extends TrafficLight {
  def next: TrafficLight = Green
}

case object Yellow extends TrafficLight {
  def next: TrafficLight = Red
}*/
