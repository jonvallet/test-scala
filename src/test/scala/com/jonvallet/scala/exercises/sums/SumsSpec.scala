package com.jonvallet.scala.exercises.sums

import org.scalatest.{FlatSpec, Matchers}
import com.jonvallet.scala.sums._

import scala.collection.mutable

/**
  * Created by j.vallet@gmail.com on 29/03/16.
  */
class SumsSpec extends FlatSpec with Matchers {
    "sums(mutable.LinkedhashMap())(\"PS 122\", 1000))" should "return Map(\"PS 122\" -> 1000)" in {
        sums(mutable.LinkedHashMap())(List("PS 122"), 1000) should be (Map("PS 122" -> 1000))
    }
    "sums(mutable.LinkedHashMap(\"a\" -> 100)(\"a\", 1)" should "return Map(\"a\" -> 101)" in {
        sums(mutable.LinkedHashMap("a" -> 100))(List("a"), 1) should be (Map("a" -> 101))
    }

    "formatInput(\"NY        NYC             PS 122            K1000\")" should "return (List(NY, NYC, PS 122),1000))" in {
        formatInput("NY        NYC             PS 122            K1000") should be ((List("NY", "NYC", "PS 122"),1000))
    }

    "getKeysToPrint(List(a,b,c), List(a,b,d)" should "return List(c)" in {
        getKeysToPrint(List("a", "b", "c"), List("a", "b", "d")) should be (List("c"))
    }

    "getKeysToPrint(List(a,b,c), List(a,f,g)" should "return List(c, b)" in {
        getKeysToPrint(List("a", "b", "c"), List("a", "f", "g")) should be (List("c","b"))
    }

    "getKeysToPrint(List(a,b,c), List(x,y,z)" should "return List(c, b, a)" in {
        getKeysToPrint(List("a", "b", "c"), List("x", "y", "z")) should be (List("c","b","a"))
    }
}
