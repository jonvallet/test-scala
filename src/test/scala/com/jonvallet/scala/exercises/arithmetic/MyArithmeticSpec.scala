package com.jonvallet.scala.exercises.arithmetic

import org.scalatest.{Matchers, FlatSpec}
import MyArithmetic._

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

  "10 totient" should "return 4" in {
    10.totient should be (4)
  }

}
