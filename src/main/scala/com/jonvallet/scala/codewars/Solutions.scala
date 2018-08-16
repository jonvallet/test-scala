package com.jonvallet.scala.codewars

object Solutions {
  def isAlphabetic(s: String): Boolean = s.sorted.equals(s)
  def johnChoose(length: Int, oldDistance: Int, newDistances: Seq[Int]): Option[Int] = {
    val oldNumberOfholes = length % oldDistance
    ???
  }
  def calculateWork(length: Int, oldDistance: Int, newDistance: Int): Int = {
    val oldNumberOfholes = length % oldDistance
    val oldJob: List [(Int, Int)] = (0 to oldNumberOfholes).map(index => (index, index * oldDistance)).toList
    val newJob: List []
  }
}
