package com.jonvallet.scala.list



object LinkedList {
  trait LinkedList[+T]

  case class Head[T](value: T, tail: LinkedList[T]) extends LinkedList[T] {
    override def toString = createString(this)
  }

  object Empty extends LinkedList[Nothing] {
    override def toString = "_"
  }

  object Head {
    def apply[T](value: T): Head[T] = Head(value, Empty)
  }

  def insert[T](i: T, linkedList: LinkedList[T]) = Head(i, linkedList)

  def reverse[T](l: LinkedList[T]): LinkedList[T] = {

    def reverse(acc: LinkedList[T], l: LinkedList[T]): LinkedList[T] = l match {
      case Empty => acc
      case Head(value, tail) => reverse(insert(value, acc), tail)
    }

    reverse(Empty, l)
  }

  def apply[T](values: T*): LinkedList[T] = {
    var result: LinkedList[T] = Empty

    for (value <-values) result = Head(value, result)

    reverse(result)
  }

  def createString[T](list: LinkedList[T]): String = list match {
    case Head(value, tail) => value.toString+"->"+tail.toString
    case Empty => Empty.toString
  }

  def get[T](index: Int, l: LinkedList[T]): Option[T] = (index, l) match {
    case (_, Empty) => None
    case (0, Head(value, _)) => Some(value)
    case (index, Head(_, tail)) => get(index - 1, tail)
  }
}
