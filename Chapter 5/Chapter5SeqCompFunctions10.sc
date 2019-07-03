sealed trait Maybe[A] {

  def fold[B](full: A => B, empty: B): B =
    this match {
      case Full(v) => full(v)
      case Empty() => empty
    }

  def flatMap[B](fn: A => Maybe[B]): Maybe[B] =
    this match {
      case Full(v) => fn(v)
      case Empty() => Empty[B]()
    }
}

final case class Full[A](in: A) extends Maybe[A]
final case class Empty[A]() extends Maybe[A]

val perhaps = Empty[Int]
val perhapss = Full(1)

def mightFail1: Maybe[Int] =
  Full(1)
def mightFail2: Maybe[Int] =
  Full(2)
def mightFail3: Maybe[Int] =
  Empty()

mightFail1 flatMap { x =>
  mightFail2 flatMap { y =>
    mightFail3 flatMap { z =>
      Full(x + y + z)
    }
  }
}