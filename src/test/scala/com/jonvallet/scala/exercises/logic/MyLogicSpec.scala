package com.jonvallet.scala.exercises.logic

import com.jonvallet.scala.exercises.logic
import org.scalatest.{Matchers, FlatSpec}
import logic.S99Logic._

/**
 * Created by jonvallet on 10/08/15.
 */
class MyLogicSpec extends FlatSpec with Matchers {

  "and test cases" should "be valid" in {
    and(true, true) should be (true)
    and(true, false) should be (false)
    and(false, true) should be (false)
    and(false, false) should be (false)
  }

  "or test cases" should "be valid" in {
    or(true, true) should be (true)
    or(true, false) should be (true)
    or(false, true) should be (true)
    or(false, false) should be (false)
  }

  "nand test cases" should "be valid" in {
    nand(true, true) should be (false)
    nand(true, false) should be (true)
    nand(false, true) should be (true)
    nand(false, false) should be (true)
  }

  "nor test cases" should "be valid" in {
    nor(true, true) should be (false)
    nor(true, false) should be (false)
    nor(false, true) should be (false)
    nor(false, false) should be (true)
  }

  "xor test cases" should "be valid" in {
    xor(true, true) should be (false)
    xor(true, false) should be (true)
    xor(false, true) should be (true)
    xor(false, false) should be (false)
  }

  "impl test cases" should "be valid" in {
    impl(true, true) should be (true)
    impl(true, false) should be (false)
    impl(false, true) should be (true)
    impl(false, false) should be (true)
  }

  "equ test cases" should "be valid" in {
    equ(true, true) should be (true)
    equ(true, false) should be (false)
    equ(false, true) should be (false)
    equ(false, false) should be (true)
  }

  "table2((a: Boolean, b: Boolean) => and(a, or(a,b)))" should "returnt he truth table" in {
    table2((a: Boolean, b: Boolean) => and(a, or(a,b))) should be (Map( (true, true) ->true,
                                                                    (true, false) ->true,
                                                                    (false, true) ->false,
                                                                    (false, false) ->false
                                                                   ))
  }

  "gray(3)" should "rerturn List(000, 001, 011, 010, 110, 111, 101, 100)" in {
    gray(3) should be (List("000", "001", "011", "010", "110", "111", "101", "100"))
  }

}
