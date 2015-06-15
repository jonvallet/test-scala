import com.jonvallet.scala.tree.{Empty, Node}

val node = Node(5,Node(1,Empty,Empty),Empty)
node.invert

Node(5, Empty, Empty)