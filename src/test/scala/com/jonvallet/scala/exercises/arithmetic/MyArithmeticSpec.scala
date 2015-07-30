package com.jonvallet.scala.exercises.arithmetic

import org.scalatest.{Matchers, FlatSpec}
import MyArithmetic._

import scala.collection.immutable.Range.Inclusive

/**
 * @author Jon Vallet
 */
class MyArithmeticSpec extends FlatSpec with Matchers {

  "MyArithmetic.isPrime(7)" should "return true" in {
    MyArithmetic.isPrime(7) should be (true)
  }

  "MyArithmetic.isPrime(8)" should "return false" in {
    MyArithmetic.isPrime(8) should be (false)
  }

  "MyArithmetic.gcd(36, 63)" should "return 9" in {
    MyArithmetic.gcd(36, 63) should be (9)
  }

  "MyArithmetic.gcd(63, 36)" should "be equal to MyArithmetic.gcd(36, 63)" in {
    MyArithmetic.gcd(63, 36) should be (MyArithmetic.gcd(36, 63))
  }

  "MyArithmetic.gcd(124, 98)" should "return 2" in {
    MyArithmetic.gcd(124, 98) should be (2)
  }

  "35.isCoprimeTo(64)" should "return true" in {
    35.isCoprimeTo(64) should be (true)
  }

  "10.totient" should "return 4" in {
    10.totient should be (4)
  }

  "315.primeFactors" should "return List(3, 3, 5, 7)" in {
    315.primeFactors should be (List(3, 3, 5, 7))
  }

  "104472.primeFactors" should "return List(2, 2, 2, 3, 3, 1451)" in {
    104472.primeFactors should be (List(2, 2, 2, 3, 3, 1451))
  }

  "315.primeFactorsMultiplicity" should "return List((3, 2), (5,1), (7,1))" in {
    315.primeFactorsMultiplicity should be (List((3, 2), (5,1), (7,1)))
  }

  "listPrimesInRange(7 to 31)" should "return List(7, 11, 13, 17, 19, 23, 29, 31)" in {
    listPrimesInRange(7 to 31) should be (List(7, 11, 13, 17, 19, 23, 29, 31))
  }

  "28.goldbach" should "return (5, 23)" in {
    28.goldbach should be ((5, 23))
  }

  "goldbachList(9 to 12)" should "return List((3, 7),(5, 7)" in {
    goldbachList(9 to 12) should be (List((3, 7),(5, 7)))
  }

  "goldbachListLimited(1 to 1000, 50)" should "return List((73, 919))" in {
    goldbachListLimited(4 to 1000, 50) should be (List((73, 919)))
  }

}
