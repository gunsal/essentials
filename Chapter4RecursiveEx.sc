sealed trait Tree {
  def sum: Int
  def double: Tree
}
case class Node(left: Tree, right: Tree) extends Tree {
  override def sum: Int = left.sum + right.sum

  override def double: Tree = Node(left.double, right.double)
}
case class Leaf(element: Int) extends Tree {
  override def sum: Int = element

  override def double: Tree = Leaf(element * 2)
}

Node(Leaf(2), Leaf(3))
Node(Leaf(2), Leaf(3)).double
