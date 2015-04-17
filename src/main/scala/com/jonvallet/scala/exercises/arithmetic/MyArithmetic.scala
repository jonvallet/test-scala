package com.jonvallet.scala.exercises.arithmetic

import scala.annotation.tailrec

/**
 * @author Jon Vallet
 */
object MyArithmetic {


  def isPrime(i: Int): Boolean = {
    (i > 1) && (primes takeWhile { _ <= Math.sqrt(i) } forall { i % _ != 0 })
  }

  lazy val primes: Stream [Int] = 2 #:: Stream.from(3).filter( i => primes.takeWhile(j => j * j <= i).forall(k => i % k > 0))


  def gcd(d1: Int, d2: Int): Int = {
    if (d2 > d1)
      gcd(d2, d1)
    else {
      def substract(a: Int, b: Int, k: Int): (Int, Int) = {
        val sub = a - b
        if (sub > 0)
          substract(sub, b, k + 1)
        else
          (a, k)
      }

      val a = substract(d1, d2, 0)

      if (a._1 == 0)
        d1
      else
        gcd(d2, d1 - d2 * a._2)
    }
  }

}
