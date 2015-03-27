package com.jonvallet.scala.exercises

import org.scalatest.{Matchers, FlatSpec}

/**
 * @author Jon Vallet
 */
class MyListSpec extends FlatSpec with Matchers {

  "MyList.last(List(1,1,2,3,5,8))" should "return 8" in {
    MyList.last(List(1,1,2,3,5,8)) should be (8)
  }

  "MyList.penultimate(List(1,1,2,3,5,8))" should "return 5" in {
    MyList.penultimate(List(1,1,2,3,5,8)) should be (5)
  }

  "MyList.nth(2, List(1,1,2,3,5,8))" should "return 2" in {
    MyList.nth(2, List(1,1,2,3,5,8)) should be (2)
  }

  "MyList.length(List(1,1,2,3,5,8))" should "return 6" in {
    MyList.length(List(1,1,2,3,5,8)) should be (6)
  }

  "MyList.reverse(List(1,1,2,3,5,8))" should "return List(8,5,3,2,1,1)" in {
    MyList.reverse(List(1,1,2,3,5,8)) should be (List(8,5,3,2,1,1))
  }

  "MyList.isPalindrome(List(1,2,3,2,1))" should "return true" in {
    MyList.isPalindrome(List(1,2,3,2,1)) should be (true)
  }

  "MyList.isPalindrome(List(1,1,3,2,1))" should "return false" in {
    MyList.isPalindrome(List(1,1,3,2,1)) should be (false)
  }
}
