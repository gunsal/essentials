val y = Seq("a", "wet", "dog").flatMap(x => x.permutations.toList)

val z = Seq(1, 2, 3).flatMap(num => Seq(num, num * 10))

Seq(1, 2, 3).foldLeft(0)(_ + _)