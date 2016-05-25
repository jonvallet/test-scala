package com.jonvallet.scala

import scala.annotation.tailrec

/**
  * Created by j.vallet@validus-ivc.co.uk on 01/04/16.
  */
package object euler {

  def sum(l: Seq[Int]) = l.fold(0)((a, b) => a + b)

  def isPrime(n: Long): Boolean = {
    if (n == 1) false
    else if (n <4) true
    else if (n % 2 == 0) false
    else if (n < 9) true
    else if (n % 3 == 0) false
    else primes.takeWhile(p => p*p <= n).forall(n % _ > 0)
  }

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

  def sumRange(range: Range): Int = {
    val n = range.last
    (n * (n + 1)) / 2
  }

  def sumOfSquares(range: Range): Int = {
    range.map(p => p*p).fold(0)((a,b) => a + b)
  }

  def squareOfSums(range: Range): Int = {
    val sum = sumRange(range)
    sum * sum
  }

  def collatz(n: Int):List[Long] = {

    @tailrec
    def tailCollatz(n: Long, acc: List[Long]): List[Long] = {
      if (n == 1)
        acc
      else if (n % 2 == 0)
        tailCollatz(n/2, n/2 :: acc)
      else
        tailCollatz(n*3+1L, n*3+1L :: acc)
    }

    tailCollatz(n, List())

  }

  def longestCollazt(region: Int) = {
    val r = 1 to region  map (n => (collatz(n).length, n))
    r.foldLeft(r.head)((a, b) => if (a._1 > b._1) a else b)._2
  }
}
