package com.jonvallet.scala.euler

import scala.io.Source

/**
  * Created by jvallet on 08/06/16.
  */
object Problem22 {

  def main(args: Array[String]) = {
    val file= Source.fromFile("src/main/resources/p022_names.txt")
    val abcValues = "abcdefghijklmnopqrstuvwxyz".zipWithIndex.map(a => (a._1 , (a._2+1))).toMap

    val lines = file.getLines().toList

    val names = for {
      line <- lines
      name <- line.split(",")
    }yield name.replace("\"", "")

    val sortedNames = names.sorted

    val sortedMap = sortedNames.zipWithIndex.map(a=> (a._1, (a._2+1))).toMap

    def worth (word: String) = word.toLowerCase.map(abcValues).sum
    def score(word: String) = worth(word) * sortedMap(word)

    val result = sortedNames.map(score).sum

    println(s"The result is $result")

  }

}
