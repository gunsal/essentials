sealed trait LinkedList[A] {
  def map[B](fn: A => B): LinkedList[B] =
    this match {
      case Pair(hd, tl) => Pair(fn(hd), tl.map(fn))
      case End() => End[B]()
    }
}
case class Pair[A](hd: A, tl: LinkedList[A]) extends LinkedList[A]
case class End[A]() extends LinkedList[A]

val list: LinkedList[Int] = Pair(1, Pair(2, Pair(3, End())))

list.map(_ * 2)
list.map(_ + 1)
list.map(_ / 3)

sealed trait Maybe[A] {
  def flatMap[B](fn: A => Maybe[B]): Maybe[B] =
    this match {
      case Full(v) => fn(v)
      case Empty() => Empty[B]()
    }
  def map[B](fn: A => B): Maybe[B] =
    this match {
      case Full(v) => Full(fn(v))
      case Empty() => Empty[B]()
    }
}

final case class Full[A](value: A) extends Maybe[A]
final case class Empty[A]() extends Maybe[A]

val list2 = List(1, 2, 3)

list2.flatMap(x => List(x, -x))

val list3: List[Maybe[Int]] = List(Full(3), Full(2), Full(1))

list3.map{ maybe =>
  maybe.flatMap[Int]{x =>
    if(x % 2 == 0)
      Full(x)
    else
      Empty()
  }
}

sealed trait Sum[A, B] {
  def fold[C](error: A => C, success: B => C): C =
    this match {
      case Failure(v) => error(v)
      case Success(v) => success(v)
    }
  def map[C](f: B => C): Sum[A, C] =
    this match {
      case Failure(v) => Failure(v)
      case Success(v) => Success(f(v))
    }
  def flatMap[C](f: B => Sum[A, C]) =
    this match {
      case Failure(v) => Failure(v)
      case Success(v) => f(v)
    }}
final case class Failure[A, B](value: A) extends Sum[A, B]
final case class Success[A, B](value: B) extends Sum[A, B]


val xx = List(1 , 2 ,3)