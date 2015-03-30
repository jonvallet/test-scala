package com.jonvallet.scala.exercises

import java.util.NoSuchElementException

import scala.annotation.tailrec

/**
 * @author Jon Vallet
 */
object MyList {

  def decode[A](list: List[(Int, A)]): List[A] = list match {
    case Nil => Nil
    case head :: tail => (0 until head._1).map(_ => head._2).toList ++ decode(tail)
  }

  def encodeModified[A](list: List[A]): List[Any] = encode(list).map(x => if (x._1 == 1) x._2 else x)

  def encode[A](list: List[A]): List[(Int, A)] = pack(list).map(x => (x.length, x.head))

  def pack[A](list: List[A]): List[List[A]] = list match {
    case Nil => Nil
    case head :: _ => {
      val (packed, rest) = list.span(_ == head)
      packed :: pack(rest)
    }
  }

  def compress[A](list: List[A]): List[A] = {
    @tailrec
    def compressrec(acc: List[A], list: List[A]): List[A] = list match {
      case Nil => acc
      case head :: Nil => acc ++ List(head)
      case head :: tail => if (head equals tail.head) compressrec(acc, tail) else compressrec(acc ++ List(head), tail)
    }
    compressrec(List(), list)
  }

  def flatten(list: List[Any]): List[Any] = list flatMap {
    case elem: List[_] => flatten(elem)
    case e => List(e)
  }

  def isPalindrome[A](list: List[A]): Boolean = list equals reverse(list)

  def reverse[A](list: List[A]): List[A] = list.foldLeft(List[A]()) { (a, b) => b :: a }

  def length[A](list: List[A]): Int = list.foldRight(0) { (_, c) => 1 + c }

  @tailrec
  def nth[A](i: Int, list: List[A]): A = (i, list) match {
    case (0, head :: _) => head
    case (n, head :: tail) => nth(n - 1, tail)
    case (_) => throw new scala.NoSuchElementException
  }

  @tailrec
  def penultimate[A](list: List[A]): A = list match {
    case head :: tail :: Nil => head
    case head :: tail => penultimate(tail)
    case _ => throw new scala.NoSuchElementException
  }

  @tailrec
  def last[A](list: List[A]): A = list match {
    case head :: Nil => head
    case head :: tail => last(tail)
    case _ => throw new NoSuchElementException
  }
}
