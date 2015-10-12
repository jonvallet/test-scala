package com.jonvallet.scala

/**
 * Created by jon on 12/10/15.
 */
package object sorting {

  def isSort(list: List[Int]): Boolean = list match {
    case head :: Nil => true
    case head :: tail => if (head > tail.head) false else isSort(tail)
  }

  def bubleSort (list: List[Int]): List[Int] = {
    if (isSort(list)) list
    else if (list.head > list.tail.head) bubleSort(list.tail ++ List(list.head))
    else bubleSort(list.head :: bubleSort(list.tail))
  }

}
