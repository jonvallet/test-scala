package com.jonvallet.scala.tree

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by jon on 15/06/15.
 */
class TreeSpec extends FlatSpec with Matchers{

  "Node(5,Node(1,Empty,Empty),Empty).invert" should "return Node(5,Empty,Node(1,Empty,Empty))" in {
    val tree = Node(Node(1), 5, Empty)
    val expectedValue = Node(Empty, 5, Node(1))
    val actualValue = tree.invert

    actualValue should be (expectedValue)

  }

  "Node(5).insert(2).insert(7)" should "return Node(Node(1), 5, Node(2)" in {
    val expectedValue = Node(Node(1), 5, Node(7))
    val actualValue = Node(5) insert 1 insert 7

    actualValue should be (expectedValue)
  }

  "Node(5).insert(5)" should "return Node(5)" in {
    val expectedValue = Node(5)
    val actualValue = Node(5) insert 5

    actualValue should be (expectedValue)
  }

  "Node(5.0).insert(2.0).insert(7.0)" should "return Node(Node(1.0), 5.0, Node(2.0)" in {
    val expectedValue = Node(Node(1.0), 5.0, Node(7.2))
    val actualValue = Node(5.0) insert 1.0 insert 7.2

    actualValue should be (expectedValue)
  }

}
