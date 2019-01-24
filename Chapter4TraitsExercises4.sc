sealed trait Color{
  def rgbRed: Double = 255
  def rgbGreen: Double = 255
  def rgbBlue: Double = 255

  def red: String = "red"
  def yellow: String = "yellow"
  def pink: String = "pink"

  def findColor(color: String): String=
    color match {
      case "red" => "red"
      case "yellow" => "yellow"
      case "pink" => "pink"
    }
}

sealed trait Shape extends Color {
  def sides: Int
  def perimeter: Double
  def area: Double
}

sealed trait Rectangular extends Shape {
  def width: Double
  def height: Double
  val sides = 4
  override val perimeter = 2 * width + 2 * height
  override val area = width * height
}

case class Circle(radius: Double, colour: String) extends Shape {
  val sides = 1
  val perimeter = 2 * radius * math.Pi
  val area = radius * radius * math.Pi
}

case class Square(size: Double) extends Rectangular {
  val width = size
  val height = size
  override val perimeter = 2 * width + 2 * height
  override val area = width * height
}

case class Rectangle(
                      val width: Double,
                      val height: Double
                    ) extends Rectangular

object Draw{
  def apply(shape: Shape): String =
    shape match {
      case Circle(radius, color) =>
        s"A $color circle of radius $radius"
      case Rectangle(width, height) =>
        s"A rectangle of witdh ${width}cm and height ${height}cm"
      case Square(size) =>
        s"A square of size $size cm"
    }
}

Draw(Circle(2, "yellow"))
Draw(Rectangle(2, 3))