def findMin(seq: Seq[Int]): Int = {
  seq.foldLeft(Int.MaxValue) {
    (current, seqValue) =>
      println(current)
      Math.min(current, seqValue)
  }
}

def smallest(seq: Seq[Int]): Int =
  seq.foldLeft(Int.MaxValue)(math.min)

findMin(Seq(8, 9, 1, 1, 2, 4, 3, 4, 0))

smallest(Seq(8, 9, 1, 1, 2, 4, 3, 4))

def insert(seq: Seq[Int], elt: Int): Seq[Int] = {
  if (seq.contains(elt))
    seq
  else
    elt +: seq
}

def unique(seq: Seq[Int]): Seq[Int] = {
  seq.foldLeft(Seq.empty[Int])(insert _)
}

def reverse(seq: Seq[Int]): Seq[Int] = {
  seq.foldLeft(Seq.empty[Int]) { (seq, elt) =>
    println("elt " + elt)
    elt +: seq
  }
}

val y = reverse(Seq(8, 9, 1, 1, 2, 4, 3, 4, 0))

def newMap[A, B](seq: Seq[A], f: A => B): Seq[B] = {
  seq.foldRight(Seq.empty[B]) {
    (elt, seq) => f(elt) +: seq
  }
}

def foldLeft[A, B](seq: Seq[A], zero: B, f: (B, A) => B): B = {
  var result = zero
  seq.foreach { elt => result = f(result, elt) }
  result
}