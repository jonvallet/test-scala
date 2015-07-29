package com.jonvallet.scala.exercises.arithmetic

import scala.annotation.tailrec




object MyArithmetic {


  def isPrime(i: Int): Boolean = {
    (i > 1) && (primes takeWhile { _ <= Math.sqrt(i) } forall { i % _ != 0 })
  }

  lazy val primes: Stream [Int] = 2 #:: Stream.from(3).filter( i => primes.takeWhile(j => j * j <= i).forall(k => i % k > 0))

  @tailrec
  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd (b, a % b)

  implicit class RichInt(m: Int) {
    def isCoprimeTo(b: Int): Boolean = gcd(m, b) == 1

    /**
     * Euler's so-called totient function phi(m) is defined as the number of positive integers r (1 <= r <= m) that are coprime to m.
     * @return
     */
    def totient: Int = (1 to m) filter (_ isCoprimeTo m) length

    def primeFactors: List[Int] = {

      def primeRec(a: Int, factors: Stream[Int]): List[Int] = {
        if (factors.head > a)
          List()
        else if (a % factors.head == 0)
          factors.head :: primeRec(a / factors.head, factors)
        else
          primeRec(a, factors.tail)
      }

      primeRec(m, primes)
    }

    def primeFactorsMultiplicity: List[(Int, Int)] = m.primeFactors.groupBy(a => a).map {case (k,v) => (k, v.length)}.toList.sortBy(_._1)

  }

}
