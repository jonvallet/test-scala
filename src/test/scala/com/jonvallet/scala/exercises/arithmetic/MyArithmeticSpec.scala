package com.jonvallet.scala.exercises.arithmetic

import org.scalatest.{Matchers, FlatSpec}

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

//  "MyArithmetic.gcd(36, 63)" should "return 9" in {
//    MyArithmetic.gcd(36, 63) should be (9)
//  }

}
