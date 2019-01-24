sealed trait Color {
  def red: Double
  def green: Double
  def blue: Double

  def isLight: Boolean = (red + green + blue) / 3.0 > 0.5
  def isDark: Boolean = !isLight
}

case object Red extends Color {
  val red = 1
  val green = 0
  val blue = 0
}

case object Yellow extends Color {
  val red = 1
  val green = 1
  val blue = 0
}

case object Pink extends Color {
  val red = 1
  val green = 0
  val blue = 1
}

final case class CustomColor(red: Double,
                             green: Double,
                             blue: Double) extends Color

sealed trait Shape {
  def sides: Int
  def perimeter: Double
  def area: Double
  def color: Color
}

final case class Circle(radius: Double, color: Color) extends Shape {
  val sides = 1
  val perimeter = 2 * radius * math.Pi
  val area = radius * radius * math.Pi
}

sealed trait Rectangular extends Shape {
  def width: Double
  def height: Double
  val sides = 4
  val perimeter = 2 * width + 2 * height
  val area = width * height
}

final case class Square(size: Double, color: Color) extends Rectangular {
  val width = size
  val height = size
}

final case class Rectangle(
                      val width: Double,
                      val height: Double,
                      color: Color
                    ) extends Rectangular

object Draw{
  def apply(shape: Shape): String =
    shape match {
      case Circle(radius, color) =>
        s"A ${Draw(color)} circle of radius $radius"
      case Rectangle(width, height, color) =>
        s"A ${Draw(color)} rectangle of witdh ${width}cm and height ${height}cm"
      case Square(size, color) =>
        s"A ${Draw(color)} square of size ${size}cm"
    }

  def apply(color: Color): String =
    color match {
      case Red => "red"
      case Yellow => "yellow"
      case Pink => "pink"
      case color => if(color.isLight) "light" else "dark"
    }
}

Draw(Square(2, Yellow))
Draw(Rectangle(3, 4, CustomColor(0.4, 0.4, 0.6)))
Draw(Red)