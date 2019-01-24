sealed trait Tree
case class Node(left: Tree, right: Tree) extends Tree
case class Leaf(element: Int) extends Tree

object TreeOps {
  def sum(tree: Tree): Int = tree match {
      case Leaf(el) => el
      case Node(tr1, tr2) => sum(tr1) + sum(tr2)
    }

  def double(tree: Tree): Tree = tree match {
    case Leaf(el) => Leaf(el * 2)
    case Node(tr1, tr2) => Node(double(tr1), double(tr2))
  }
}
TreeOps.sum(Node(Leaf(2), Leaf(3)))
TreeOps.double(Node(Leaf(2), Leaf(3)))
