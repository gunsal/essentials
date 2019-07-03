val z = for {
  a <- Seq(1, 2, 3)
  b <- Seq(100, 200, 300)
} yield a + b

println(z)