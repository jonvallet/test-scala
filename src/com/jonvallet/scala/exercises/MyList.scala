package com.jonvallet.scala.exercises

import java.util.NoSuchElementException

import scala.annotation.tailrec

/**
 * @author Jon Vallet
 */
object MyList {
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
