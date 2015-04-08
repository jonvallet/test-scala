package com.jonvallet.scala.exercises.lists

import java.util.NoSuchElementException

import scala.annotation.tailrec
import scala.collection.immutable.Stream.cons
import scala.util.Random

/**
 * @author Jon Vallet
 */
object MyList {

  def combinations[A](n: Int, list: List[A]): List[List[A]] = {
    if (list.isEmpty || n > list.length)
      Nil
    else
      (list.head :: list.tail.take(n - 1)) :: combinations(n, list.head :: list.tail.tail)
  }

  def randomPermute[A](list: List[A]): List[A] = Random.shuffle(list)

  def lotto(n: Int, m: Int): List[Int] = randomSelect(n, 1 until m+1 toList)

  def randomSelect[A](n: Int, list: List[A]): List[A] = {
    val shuffle = Random.shuffle(list)
    shuffle take n
  }

  def range(start: Int, end: Int): List[Int] = start until end +1 toList

  def insertAt[A](e: A, n: Int, list: List[A]): List[A] = {
    val splitted = split(n, list)
    splitted._1 ++ List(e) ++ splitted._2
  }

  def removeAt[A](n: Int, list: List[A]): (List[A], A) = ((list take n) ++ (list drop n +1), list(n))

  def rotate[A](i: Int, list: List[A]): List[A] = {
    if (i == 0)
      list
    else if (i > 0)
      rotate(i -1, list.tail ++ List(list.head))
    else
      rotate(i+1, list.last :: list.take(list.length-1))
  }

  def slice[A](start: Int, end: Int, list: List[A]): List[A] = list drop start take (end - start)

  def split[A](n: Int, list: List[A]): (List[A], List[A]) = list.splitAt(n)

  def drop[A](n: Int, list: List[A]): List[A] = list match {
    case Nil => Nil
    case _ => {
      val (init, rest) = list.splitAt(n-1)
      if (rest != Nil) init ++ drop(n, rest.tail) else init
    }
  }

  def duplicateN[A](n: Int, list: List[A]): List[A] = list.flatMap(e => List.fill(n)(e))

  def duplicate[A](list: List[A]): List[A] = list.flatMap(e => List(e,e))

  def encodeDirect[A](list: List[A]): List[(Int, A)] = list match {
    case Nil => Nil
    case head :: _ => {
      val (packed, rest) = list.span(_ == head)
      (packed.length, head) :: encodeDirect(rest)
    }
  }

  def decode[A](list: List[(Int, A)]): List[A] = list.flatMap(e => List.fill(e._1)(e._2))

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
