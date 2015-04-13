package com.jonvallet.scala.duplicates

import scala.annotation.tailrec


/**
 * Created by jon on 21/01/15.
 */
object StringDuplicates {

  @tailrec
  private def duplicates(s: List[Char], acc: List[Char]): List[Char] = s match {

    case List() => acc
    case xs :: tail => if (tail.contains(xs) && !acc.contains(xs)) duplicates(tail, acc ++ List(xs)) else duplicates(tail, acc)

  }

  def duplicates(s: String): String = s match {
    case null => ""
    case s => duplicates(s.toList, List()) mkString ("")
  }


}
