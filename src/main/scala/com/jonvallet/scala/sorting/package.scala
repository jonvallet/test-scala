package com.jonvallet.scala

import com.jonvallet.scala.tree.{Tree, Empty, Node}

/**
 * Created by jon on 12/10/15.
 */
package object sorting {

  def isSort[A](list: List[A])(implicit order: A => Ordered[A]): Boolean = list match {
    case head :: Nil => true
    case head :: tail => if (head > tail.head) false else isSort(tail)
  }

  def bubbleSort[A](list: List[A])(implicit order: A => Ordered[A]): List[A] = {
    if (isSort(list)) list
    else if (list.head > list.tail.head) bubbleSort(list.tail.head :: list.head :: list.tail.tail)
    else bubbleSort(list.head :: bubbleSort(list.tail))
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

  def treeSort[A](list: List[A])(implicit order: A => Ordered[A]): List[A] = {
    def getTree(tree: Tree[A], list: List[A]): Tree[A] = if (list.isEmpty) tree else getTree(tree.insert(list.head), list.tail)

    getTree(Node(list.head), list.tail).asList
  }

}
