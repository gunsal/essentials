trait Shape {
  def sides: Int

  def perimeter: Double

  def area: Double
}

case class Circle(radius: Double) extends Shape {
  val sides = 1
  val perimeter = 2 * radius * math.Pi
  val area = radius * radius * math.Pi
}

sealed trait Rectangular extends Shape {
  def width: Double
  def height: Double
  val sides = 4
  override val perimeter = 2 * width + 2 * height
  override val area = width * height
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

val x = Square(2)
x.width
x.height
x.perimeter
x.area