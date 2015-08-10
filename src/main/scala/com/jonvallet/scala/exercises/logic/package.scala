package com.jonvallet.scala.exercises

/**
 * Created by jonvallet on 10/08/15.
 */
package object logic {
  object S99Logic {
    def and (a: Boolean, b: Boolean): Boolean = a && b
    def or (a: Boolean, b: Boolean): Boolean = a || b
    def nand (a: Boolean, b: Boolean): Boolean = !and(a,b)
    def nor (a: Boolean, b: Boolean): Boolean = !or(a,b)
    def xor (a: Boolean, b: Boolean): Boolean = !equ(a,b)
    def impl (a: Boolean, b: Boolean): Boolean = !(a && !b)
    def equ (a: Boolean, b: Boolean): Boolean = a equals b
  }

  def table2(function: (Boolean, Boolean) => Boolean): Map[(Boolean, Boolean), Boolean] = {
    Map(
      (true, true) -> function(true, true),
      (true, false) -> function(true, false),
      (false, true) -> function(false, true),
      (false, false) -> function(false, false)
    )
  }
}
