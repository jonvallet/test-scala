package com.jonvallet.scala.exercises.arithmetic

import scala.annotation.tailrec

object MyArithmetic {


  def isPrime(i: Int): Boolean = {
    (i > 1) && (primes takeWhile { _ <= Math.sqrt(i) } forall { i % _ != 0 })
  }

  lazy val primes: Stream [Int] = 2 #:: Stream.from(3).filter( i => primes.takeWhile(j => j * j <= i).forall(k => i % k > 0))

  def listPrimesInRange(range: Range): List[Int] = primes.dropWhile(_<range.head).takeWhile(_<=range.last).toList

  @tailrec
  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd (b, a % b)

  def goldbachList(range: Range): List[(Int,Int)] = range.filter(_%2 == 0).map(_.goldbach).toList

  def goldbachListLimited(range: Range, limited: Int) = goldbachList(range).filter(_._1 > limited)


  implicit class RichInt(m: Int) {
    def isCoprimeTo(b: Int): Boolean = gcd(m, b) == 1

    /**
     * Euler's so-called totient function phi(m) is defined as the number of positive integers r (1 <= r <= m) that are coprime to m.
     * @return
     */
    def totient: Int = (1 to m).count(_ isCoprimeTo m)

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

    def goldbach: (Int, Int) = {
      assert(m > 2, "Int with value:"+m+" must be greater than 2")
      assert(m % 2 == 0, "Int value:"+m+" must be even")
      val range = listPrimesInRange(1 to m)

      val result = for {
                     a <- range
                     b <- range
                     if (a + b == m)
                   }yield(a, b)
      result.head
    }

  }

}
