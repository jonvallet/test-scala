package com.jonvallet.scala

import com.jonvallet.scala.tree.{Tree, Empty, Node}

import scala.annotation.tailrec

/**
 * Created by jon on 12/10/15.
 */
package object sorting {

  def isSort[A](list: List[A])(implicit order: A => Ordered[A]): Boolean = list match {
    case head :: Nil => true
    case head :: tail => if (head > tail.head) false else isSort(tail)
  }

  def bubbleSort(list: List[Int]) : List[Int] = {
    def sort(as: List[Int], bs: List[Int]): List[Int] =
      if (as.isEmpty) bs
      else bubble(as, Nil, bs)

    def bubble(as: List[Int], zs: List[Int], bs: List[Int]): List[Int] = as match {
      case h1 :: h2 :: t =>
        if (h1 > h2) bubble(h1 :: t, h2 :: zs, bs)
        else bubble(h2 :: t, h1 :: zs, bs)
      case h1 :: Nil => sort(zs, h1 :: bs)
    }

    sort(list, Nil)
  }

  def imperativeBubbleSort(list: List[Int]): List[Int] = {

    assert(list.size > 1)

    var ordered = false
    val array = list.toArray
    val range = 0 to list.size-2

    while (!ordered) {
      ordered = true
      for (i <- range) {
        if (array(i) > array(i+1)) {
          val c = array(i+1)
          array(i+1) = array(i)
          array(i) = c
          ordered = false
        }
      }
    }

    array.toList
  }

  def treeSort(set: Set[Int]): List[Int] = {
    def getTree(tree: Tree[Int], set: Set[Int]): Tree[Int] = if (set.isEmpty) tree else getTree(tree.insert(set.head), set.tail)

    getTree(Node(set.head), set.tail).asList
  }

  def insertionSort(list: List[Int]): List[Int] = {


    var result: List[Int] = List(list.head)

    def insertInto(l: List[Int], e: Int): List[Int] = l match {
      case Nil => List(e)
      case head :: tail => if (head > e) e :: head:: tail else head :: insertInto(tail, e)
    }

    for (elem <- list.tail) {
      result = insertInto(result, elem)
    }

    result
  }

  def insertionSortImperative(l: List[Int]): List[Int] = {

    val a = l.toArray

    for (i <- 1 until a.length) {
      // A[ i ] is added in the sorted sequence A[0, .. i-1]
      // save A[i] to make a hole at index iHole
      val item = a(i)
      var iHole = i
      // keep moving the hole to next smaller index until A[iHole - 1] is <= item
      while (iHole > 0 && a(iHole - 1) > item) {
        // move hole to next smaller index
        a(iHole) = a(iHole - 1)
        iHole = iHole - 1
      }
      // put item in the hole
      a(iHole) = item
    }
    a.toList
  }

}
