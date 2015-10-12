package com.jonvallet.scala.tree

/**
 * Created by jon on 15/06/15.
 */
trait Tree[+T]{
  def invert: Tree[T]
  def insert[U >: T](elem: U)(implicit ev1: U => Ordered[U]): Tree[U]
  def asList: List[T]
}

case class Node[+T](left: Tree[T], elem: T, right: Tree[T]) extends Tree[T] {
  override def toString = "{" + left + elem + right + "}"
  def invert: Tree[T] = Node(right.invert, elem, left.invert)
  def insert[U >: T](e: U)(implicit ev1: U => Ordered[U]): Tree[U] = {
    if (e < elem)
      Node(left.insert(e), elem, right)
    else
      Node(left, elem, right.insert(e))
  }
  def asList: List[T] = left.asList ++ List(elem) ++ right.asList
}

case object Empty extends Tree[Nothing] {
  override def toString = "."
  def invert: Tree[Nothing] = Empty
  def insert[U >: Nothing](elem: U)(implicit ev1: U => Ordered[U]): Tree[U] = Node(elem)
  def asList: List[Nothing] = List()
}

object Node {
  def apply[T](value: T): Node[T] = Node(Empty, value, Empty)
}

