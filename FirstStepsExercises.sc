class Director(
                val firstName: String,
                val lastName: String,
                val yearOfBirth: Int) {
  def name: String =
    s"$firstName $lastName"

  def copy(
            firstName: String = this.firstName,
            lastName: String = this.lastName,
            yearOfBirth: Int = this.yearOfBirth) =
    new Director(firstName, lastName, yearOfBirth)
}

object Director {
  def apply(fn: String, ln: String, yob: Int): Director =
    new Director(fn, ln, yob)

  def older(d1: Director, d2: Director): Director =
    if (d1.yearOfBirth <= d2.yearOfBirth)
      d1
    else
      d2
}

class Film(val name: String,
           val yearOfRelease: Int,
           val imdbRating: Double,
           val director: Director) {
  def directorsAge =
    yearOfRelease - director.yearOfBirth

  def isDirectedBy(director: Director) =
    this.director == director

  def copy(name: String = this.name,
           yearOfRelease: Int = this.yearOfRelease,
           imdbRating: Double = this.imdbRating,
           director: Director = this.director): Film =
    new Film(name, yearOfRelease, imdbRating, director)
}

object Film {
  def apply(
             name: String,
             yearOfRelease: Int,
             imdbRating: Double,
             director: Director): Film =
    new Film(name, yearOfRelease, imdbRating, director)

  def newer(film1: Film, film2: Film): Film =
    if (film1.yearOfRelease < film2.yearOfRelease) film1 else film2

  def highestRating(film1: Film, film2: Film): Double = {
    val rating1 = film1.imdbRating
    val rating2 = film2.imdbRating
    if (rating1 > rating2) rating1 else rating2
  }

  def oldestDirectorAtTheTime(film1: Film, film2: Film): Director =
    if (film1.directorsAge > film2.directorsAge)
      film1.director
    else
      film2.director
}