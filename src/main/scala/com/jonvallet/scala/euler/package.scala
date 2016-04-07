package com.jonvallet.scala

/**
  * Created by j.vallet@validus-ivc.co.uk on 01/04/16.
  */
package object euler {

  def sum(l: Seq[Int]) = l.fold(0)((a, b) => a + b)

  def isPrime(n: Long): Boolean = primes.takeWhile(p => p*p <= n).forall(n % _ > 0)

  lazy val primes: Stream[Long] = 2L #:: Stream.iterate(3L)(_ + 1L).filter(isPrime)

  def factors(n: Long):List[Long] = primes.takeWhile(p => p*p <= n).filter(n % _ == 0).toList

  def isPalindrome(s: String) = s == s.reverse

  def getPalindromes(n: Int): Seq[(Int, Int)] = {
    val range = n to 1 by -1
    for {
      a <- range
      b <- a to 1 by -1
      if (isPalindrome(s"${a*b}"))
    } yield (a,b)
  }

  def getMax(s: Seq[(Int, Int)]) = s.fold(s.head)((a,b) => if ((a._1 + a._2) > (b._1 + b._2)) a else b )

  def isSmallestMultiple(n: Int, range: Range): Boolean = {
    range.forall(n % _ == 0)
  }

  def findSmallestMultiple(range: Range): Int = {
    var i = 1
    while (!isSmallestMultiple(i, range)) i += 1

    i
  }

  def sumOfSquares(range: Range): Int = {
    range.map(p => p*p).fold(0)((a,b) => a + b)
  }

  def squareOfSums(range: Range): Int = {
    val sum = range.fold(0)((a,b) => a + b)
    sum * sum
  }
}
