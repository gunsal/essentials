import java.util.Date

trait Visitor {
  def id: String
  def createdAt: Date
  def age: Long = new Date().getTime - createdAt.getTime
  def older(v1: Visitor, v2: Visitor): Boolean =
    v1.createdAt.before(v2.createdAt)
}

case class Anonymous(
                      id: String,
                      createdAt: Date = new Date()
                    ) extends Visitor

case class User(
                 id: String,
                 email: String,
                 createdAt: Date = new Date()
               ) extends Visitor

def older(v1: Visitor, v2: Visitor): Boolean =
  v1.createdAt.before(v2.createdAt)

older(User("s", "asd"), Anonymous("asd"))

val anon = Anonymous("anon1")

anon.createdAt
anon.age

