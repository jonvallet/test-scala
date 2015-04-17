package com.jonvallet.scala.exercises.arithmetic

import scala.annotation.tailrec

/**
 * @author Jon Vallet
 */
object MyArithmetic {

  def isPrime(i: Int): Boolean = {

    @tailrec
    def isPrimeRec(n: Int): Boolean = (n, i % n) match {
      case (1,_) => true
      case (_,0) => false
      case _ => isPrimeRec(n-1)
    }

    isPrimeRec(i-1)
  }

}
