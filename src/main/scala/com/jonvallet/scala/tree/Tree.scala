package com.jonvallet.scala.tree

/**
 * Created by jon on 15/06/15.
 */
trait Tree [+T] {
  def invert: Tree [T]
}

case class Node[T](elem: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  override def toString = "{" + left + elem + right + "}"
  override def invert: Tree[T] = Node(elem, right.invert, left.invert)
}

case object Empty extends Tree[Nothing] {
  override def toString = "."
  override def invert: Tree[Nothing] = Empty
}

