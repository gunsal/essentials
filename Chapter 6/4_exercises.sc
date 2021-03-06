case class Film(
                 name: String,
                 yearOfRelease: Int,
                 imdbRating: Double)
case class Director(
                     firstName: String,
                     lastName: String,
                     yearOfBirth: Int,
                     films: Seq[Film])
val memento = new Film("Memento", 2000, 8.5)
val darkKnight = new Film("Dark Knight", 2008, 9.0)
val inception = new Film("Inception", 2010, 8.8)
val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7)
val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9)
val unforgiven = new Film("Unforgiven", 1992, 8.3)
val granTorino = new Film("Gran Torino", 2008, 8.2)
val invictus = new Film("Invictus", 2009, 7.4)
val predator = new Film("Predator", 1987, 7.9)
val dieHard = new Film("Die Hard", 1988, 8.3)
val huntForRedOctober = new Film("The Hunt for Red October", 1990,
  7.6)
val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8)
val eastwood = new Director("Clint", "Eastwood", 1930,
  Seq(highPlainsDrifter, outlawJoseyWales, unforgiven, granTorino,
    invictus))
val mcTiernan = new Director("John", "McTiernan", 1951,
  Seq(huntForRedOctober, thomasCrownAffair, predator, dieHard))
val nolan = new Director("Christopher", "Nolan", 1970,
  Seq(memento, darkKnight, inception))
val someGuy = new Director("Just", "Some Guy", 1990,
  Seq())
val directors = Seq(eastwood, mcTiernan, nolan, someGuy)
// TODO: Write your code here!

def findFilms(numberOfFilms: Int) =
  directors.filter(_.films.size > numberOfFilms)

def findByYear(year: Int) =
  directors.find(_.yearOfBirth < year)

def directorBornBeforeWithBackCatalogOfSize(year: Int, numberOfFilms:
Int): Seq[Director] = {
  val byAge = directors.filter(_.yearOfBirth < year)
  val byFilms = directors.filter(_.films.length > numberOfFilms)
  byAge.filter(x => byFilms.contains(x))
}
println("")
val x1 = nolan.films.map(film => film.name)
println("s")
val x2 = directors.flatMap(director => director.films.map(_.name))

val x3 = mcTiernan.films.foldLeft(Int.MaxValue){
  (current, film) =>
    println("current " + current)
    println("year of release " + film.yearOfRelease)
    math.min(current, film.yearOfRelease)
}

val x4 = directors.flatMap(director => director.films).sortWith{
  (f1, f2) =>
    f1.imdbRating > f2.imdbRating
}

val films = directors.flatMap(_.films)
films.foldLeft(0.0)((sum, film) => sum + film.imdbRating) / films.
  length

directors.
  flatMap(director => director.films).
  sortWith((a, b) => a.yearOfRelease < b.yearOfRelease).
  headOption

val years = films.map(_.yearOfRelease).min
