package com.jonvallet.scala.list

import scala.annotation.tailrec


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

  def add[T](i: T, linkedList: LinkedList[T]) = Head(i, linkedList)

  def reverse[T](l: LinkedList[T]): LinkedList[T] = {

    def reverse(acc: LinkedList[T], l: LinkedList[T]): LinkedList[T] = l match {
      case Empty => acc
      case Head(value, tail) => reverse(add(value, acc), tail)
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

  def concat [T](l1: LinkedList[T], l2: LinkedList[T]): LinkedList[T] = concatRec(reverse(l1), l2)

  @tailrec
  private def concatRec[T](l1: LinkedList[T], l2: LinkedList[T]): LinkedList[T] = {
    l1 match {
      case Empty => l2
      case Head(head, tail) => concatRec(tail, add(head, l2))
    }
  }

  def insert[T](elem: T, position: Int, list: LinkedList[T]): LinkedList[T] = {

    @tailrec
    def insertRec(lead: LinkedList[T], elem: T, position: Int, rest: LinkedList[T]): LinkedList[T] = {
      if (position == 0) concatRec(lead, add(elem, rest))
      else rest match {
        case Head(a, tail) => insertRec(add(a, lead), elem, position = position - 1, tail)
      }
    }

    insertRec(Empty, elem, position, list)
  }
}
