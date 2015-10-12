package com.jonvallet.scala

/**
 * Created by jon on 12/10/15.
 */
package object sorting {

  def isSort[A <% Ordered[A]](list: List[A]): Boolean = list match {
    case head :: Nil => true
    case head :: tail => if (head > tail.head) false else isSort(tail)
  }

  def bubbleSort[A <% Ordered[A]](list: List[A]): List[A] = {
    println(list)

    if (isSort(list)) list
    else if (list.head > list.tail.head) bubbleSort(list.tail.head :: list.head :: list.tail.tail)
    else bubbleSort(list.head :: bubbleSort(list.tail))
  }

}
