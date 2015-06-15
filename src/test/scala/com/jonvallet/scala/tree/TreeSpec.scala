package com.jonvallet.scala.tree

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by jon on 15/06/15.
 */
class TreeSpec extends FlatSpec with Matchers{

  "Node(5,Node(1,Empty,Empty),Empty).invert" should " return Node(5,Empty,Node(1,Empty,Empty))" in {
    val tree = Node(5,Node(1,Empty,Empty),Empty)
    val expectedValue = "{.5{.1.}}"
    val actualValue = tree.invert.toString

    actualValue should be (expectedValue)

  }

}
