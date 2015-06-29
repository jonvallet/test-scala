package com.jonvallet.scala.tree

import Ordering.Implicits._

/**
 * Created by jon on 15/06/15.
 */
trait Tree {
  def invert: Tree
  def insert(elem: Int): Tree
}

case class Node(left: Tree, elem: Int, right: Tree) extends Tree {
  override def toString = "{" + left + elem + right + "}"
  def invert: Tree = Node(right.invert, elem, left.invert)
  def insert(e: Int): Tree = {
    if (e equals elem)
      this
    else if (e < elem)
      Node(left.insert(e), elem, right)
    else
      Node(left, elem, right.insert(e))
  }
}

case object Empty extends Tree {
  override def toString = "."
  def invert: Tree = Empty
  def insert(elem: Int): Tree = Node(elem)
}

object Node {
  def apply(value: Int): Node = Node(Empty, value, Empty)
}

