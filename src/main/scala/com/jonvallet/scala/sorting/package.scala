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

  def treeSort[A](list: List[A])(implicit order: A => Ordered[A]): List[A] = {
    def getTree(tree: Tree[A], list: List[A]): Tree[A] = if (list.isEmpty) tree else getTree(tree.insert(list.head), list.tail)

    getTree(Node(list.head), list.tail).asList
  }

}
