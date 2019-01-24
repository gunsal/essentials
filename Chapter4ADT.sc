import scala.io.Source

sealed trait TrafficLight
case object Red extends TrafficLight
case object Yellow extends TrafficLight
case object Green extends TrafficLight

sealed trait Calculation
final case class Success(result: Int) extends Calculation
final case class Fail(message: String) extends Calculation

sealed trait Source
case object Well extends Source
case object Spring extends Source
case object Tap extends Source

final case class Water(size: Int, source: Source, carbonated: Boolean)




