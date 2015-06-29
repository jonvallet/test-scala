import com.jonvallet.scala.tree.{Empty, Node, Tree}


def invert[T](tree: Tree): Tree = tree match {
  case Empty => Empty
  case Node(left, value, right) => Node( invert(right),value , invert(left))
}

val node = Node(Node(1), 5, Node(3))
node.invert
invert(node)
Node(5) insert 2 insert 2 insert 3 insert 12