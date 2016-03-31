package com.jonvallet.scala

import scala.collection.mutable.LinkedHashMap

/**
  * Created by j.vallet@gmail.com on 29/03/16.
  */
package object sums {
  def sums(totals : LinkedHashMap[String, Int])(keys: List[String], students: Int): LinkedHashMap [String, Int] = {

    keys.foreach(key => totals.get(key) match {
      case Some(value) => totals.put(key, students + value)
      case None => totals.put(key, students)
    })
    totals
  }

  def formatInput (line: String): (List[String], Int) = {
    val tokens: Array[String] = line.split("\\s{2,}")
    val length = tokens.length

    val total = tokens(length -1).substring(1).toInt

    (tokens.take(length -1).toList, total)
  }

  def getKeysToPrint(a: List[String], b: List[String]): List[String] = {

    assert(a.length == b.length)

    var result: List[String] = List()

    for (i <- 0 until a.length) {
      if (a(i) != b(i)) result = a(i) :: result
    }

    result
  }
}
