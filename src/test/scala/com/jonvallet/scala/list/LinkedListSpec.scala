package com.jonvallet.scala.list

import org.scalatest.{Matchers, FlatSpec}
import com.jonvallet.scala.list.LinkedList._

/**
  * Created by j.vallet@validus-ivc.co.uk on 14/12/15.
  */
class LinkedListSpec extends FlatSpec with Matchers {

  "Head(5,Empty)" should "have a value of 5" in {
    val list = Head(5, Empty)
    list.value should be(5)
  }

  "get(2, Head(1, Head(2, Head(3))))" should "return Some(3)" in {
    get(2, Head(1, Head(2, Head(3)))) should be (Some(3))
  }

  "reverse(LinkedList(1,2,3,4))" should "return LinkedList(4,3,2,1" in {
    reverse(LinkedList(4,3,2,1)) should be (LinkedList(1,2,3,4))
  }

}
