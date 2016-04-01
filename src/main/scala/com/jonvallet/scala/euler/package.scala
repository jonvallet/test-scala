package com.jonvallet.scala

/**
  * Created by j.vallet@validus-ivc.co.uk on 01/04/16.
  */
package object euler {

  def sum(l: Seq[Int]) = l.fold(0)((a, b) => a + b)

  def isPrime(n: BigInt): Boolean = primes.takeWhile(p => p*p <= n).forall((a) => n % a != 0)

  lazy val primes: Stream[BigInt] = BigInt(2) #:: Stream.iterate(BigInt(3))(_ + 1).filter(n => isPrime(n))

  def factors(n: BigInt):List[BigInt] = primes.takeWhile(p => p*p <= n).filter(p => n % p == 0).toList

}
