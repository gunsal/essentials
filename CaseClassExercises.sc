case class Director(firstName: String,
                    lastName: String,
                    yearOfBirth: Int) {

  def name: String = s"$firstName $lastName"

  def older(d1: Director, d2: Director): Director =
    if (d1.yearOfBirth < d2.yearOfBirth) d1 else d2
}

case class Film(name: String,
                yearOfRelease: Int,
                imdbRating: Double,
                director: Director) {

  def directorsAge: Int = yearOfRelease - director.yearOfBirth

  def isDirectedBy(director: Director): Boolean =
    this.director == director

  def newer(f1: Film, f2: Film): Film =
    if (f1.yearOfRelease > f2.yearOfRelease) f1 else f2

  def highestRating(f1: Film, f2: Film): Film = {
    val f1Rating = f1.imdbRating
    val f2Rating = f2.imdbRating
    if (f1Rating > f2Rating) f1 else f2
  }

  def oldestDirectorAtTheTime(f1: Film, f2: Film): Director = {
    if (f1.directorsAge > f2.directorsAge) f1.director else f2.director
  }
}