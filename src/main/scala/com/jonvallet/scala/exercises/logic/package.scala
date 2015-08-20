package com.jonvallet.scala.exercises

/**
 * Created by jonvallet on 10/08/15.
 */
package object logic {

  type TruthTable = Map[(Boolean, Boolean), Boolean]

  object S99Logic {
    def and (a: Boolean, b: Boolean): Boolean = a && b
    def or (a: Boolean, b: Boolean): Boolean = a || b
    def nand (a: Boolean, b: Boolean): Boolean = !and(a,b)
    def nor (a: Boolean, b: Boolean): Boolean = !or(a,b)
    def xor (a: Boolean, b: Boolean): Boolean = !equ(a,b)
    def impl (a: Boolean, b: Boolean): Boolean = !(a && !b)
    def equ (a: Boolean, b: Boolean): Boolean = a equals b
  }

  def table2(function: (Boolean, Boolean) => Boolean): TruthTable = {
    Map(
      (true, true) -> function(true, true),
      (true, false) -> function(true, false),
      (false, true) -> function(false, true),
      (false, false) -> function(false, false)
    )
  }

  def print(table: TruthTable): Unit = {
    println("A     B     result")
    val list = for {
      entry <- table
      a = entry._1._1
      b = entry._1._2
      c = entry._2
    }yield (f"$a%-5s $b%-5s $c%-5s")

    list foreach (println)
  }

}
