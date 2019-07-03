val x = Seq(1, 2, 3)

for {
  z <- x
} yield z * 2

val data = Seq(Seq(1), Seq(2, 3), Seq(4, 5, 6))

data.flatMap(_.map(_*2))

for {
  subseq <- data
  element <- subseq
} yield element * 2

for {
  seq <- Seq(Seq(1), Seq(2, 4))
  elt <- seq
} println(elt * 2)