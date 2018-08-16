package com.jonvallet.scala.codewars

import org.scalatest.{FlatSpec, Matchers}

class SolutionsSpec extends FlatSpec with Matchers {

  "isAlphabetic" should "return true for 'abc'" in {
    Solutions.isAlphabetic("abc") should be (true)
  }

  it should "return false for 'cba'" in {
    Solutions.isAlphabetic("cba") should be (false)
  }

  "jhonChoose" should "return Some(25)" in {
    Solutions.johnChoose(300, 50, Vector(30, 25)) should be (Some(25))
  }

}
