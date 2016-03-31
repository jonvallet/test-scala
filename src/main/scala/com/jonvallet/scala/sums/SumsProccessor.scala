package com.jonvallet.scala.sums

import scala.collection.mutable
import scala.io.Source

/**
  * Created by j.vallet@validus-ivc.co.uk on 29/03/16.
  */
object  SumsProccessor {
  def main (args: Array[String]): Unit = {
    val file = Source.fromFile("resources/input.txt")

    val iterator = file.getLines()
    val result: mutable.LinkedHashMap[String, Int] = mutable.LinkedHashMap()
    var previousEntry = formatInput(iterator.next())

    sums(result)(previousEntry._1, previousEntry._2)

    for (line <- iterator) {
      if (line.length > 0) {
        val entry = formatInput(line)
        val keysToPrint = getKeysToPrint(previousEntry._1, entry._1)
        for (key <- keysToPrint) println(s"$key ${result(key)}")
        sums(result)(entry._1, entry._2)
        previousEntry = entry
        if (!iterator.hasNext) for (key <- entry._1.reverse) println(s"$key ${result(key)}")
      }
    }

  }
}
