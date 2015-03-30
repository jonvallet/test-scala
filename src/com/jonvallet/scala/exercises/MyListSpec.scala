package com.jonvallet.scala.exercises

import org.scalatest.{Matchers, FlatSpec}

/**
 * @author Jon Vallet
 */
class MyListSpec extends FlatSpec with Matchers {

  "MyList.last(List(1,1,2,3,5,8))" should "return 8" in {
    MyList.last(List(1, 1, 2, 3, 5, 8)) should be(8)
  }

  "MyList.penultimate(List(1,1,2,3,5,8))" should "return 5" in {
    MyList.penultimate(List(1, 1, 2, 3, 5, 8)) should be(5)
  }

  "MyList.nth(2, List(1,1,2,3,5,8))" should "return 2" in {
    MyList.nth(2, List(1, 1, 2, 3, 5, 8)) should be(2)
  }

  "MyList.length(List(1,1,2,3,5,8))" should "return 6" in {
    MyList.length(List(1, 1, 2, 3, 5, 8)) should be(6)
  }

  "MyList.reverse(List(1,1,2,3,5,8))" should "return List(8,5,3,2,1,1)" in {
    MyList.reverse(List(1, 1, 2, 3, 5, 8)) should be(List(8, 5, 3, 2, 1, 1))
  }

  "MyList.isPalindrome(List(1,2,3,2,1))" should "return true" in {
    MyList.isPalindrome(List(1, 2, 3, 2, 1)) should be(true)
  }

  "MyList.isPalindrome(List(1,1,3,2,1))" should "return false" in {
    MyList.isPalindrome(List(1, 1, 3, 2, 1)) should be(false)
  }

  "MyList.flatten(List(List(1, 1), 2, List(3, List(5, 8))))" should "return List(1, 1, 2, 3, 5, 8)" in {
    MyList.flatten(List(List(1, 1), 2, List(3, List(5, 8)))) should be(List(1, 1, 2, 3, 5, 8))
  }

  "MyList.compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))" should
    "return List('a, 'b, 'c, 'a, 'd, 'e)" in {
    MyList.compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should be(List('a, 'b, 'c, 'a, 'd, 'e))
  }

  "MyList.pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))" should
    "return List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))" in {
    MyList.pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should
      be(List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)))
  }

  "MyList.encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))" should
    "return List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))" in {
    MyList.encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should
      be(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
  }

  "MyList.encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))" should
    "return List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))" in {
    MyList.encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should
    be(List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e)))
  }

  "MyList.decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))" should
    "return List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)" in {
    MyList.decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))) should
    be (List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  }

  "MyList.encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))" should
    "return List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))" in {
    MyList.encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) should
      be(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
  }

  "MyList.duplicate(List('a, 'b, 'c, 'c, 'd)))" should
    "return List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)" in {
    MyList.duplicate(List('a, 'b, 'c, 'c, 'd)) should be (List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd))
  }

  "MyList.duplicateN(3, List('a, 'b, 'c, 'c, 'd))" should
    "return List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)" in {
    MyList.duplicateN(3,List('a, 'b, 'c, 'c, 'd)) should be (List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd))
  }

  "MyList.drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))" should
    "return List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)" in {
    MyList.drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) should
    be (List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k))
  }

  "MyList.split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))" should
    "return (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))" in {
    MyList.split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) should
    be ((List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }

}
