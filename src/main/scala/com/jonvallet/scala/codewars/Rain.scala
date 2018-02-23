package com.jonvallet.scala.codewars

import scala.math._

object Rain {

  def mean(city: String, data: String): Double = {
    formatData(data).get(city) match {
      case Some(cityPrecipitations) =>
        cityPrecipitations.sum / cityPrecipitations.length
      case None => -1
    }
  }

  def variance(city: String, data: String): Double = {
    val m = mean(city, data)
    formatData(data).get(city) match {
      case Some(cityPrecipitations) =>
        cityPrecipitations.map(e => pow(e - m, 2)).sum / cityPrecipitations.length
      case None => -1
    }
  }

  def formatData(data: String): Map[String, List[Double]]  = {
    val lines = data.split("\n")
    val formattedLines: Array[(String, List[Double])] = for {
      line <- lines
      array = line.split(":")
      city: String = array(0)
      precipitations = array(1)
      formatted: List[Double] = precipitations.split(",").map(e => e.split(" ")(1).toDouble).toList
    } yield (city, formatted)

    formattedLines.toMap
  }
}
