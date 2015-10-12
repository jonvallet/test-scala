package com.jonvallet.scala.sorting

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by jon on 12/10/15.
 */
class SortingSpec extends FlatSpec with Matchers {

  "bubbleSort(List(2,9,4,2,1,3)" should "return List(1, 2, 2, 3, 4, 9)" in {
    bubbleSort(List(2,9,4,2,1,3)) should be (List(1, 2, 2, 3, 4, 9))
  }

  "treeSort(List(2,9,4,2,1,3)" should "return List(1, 2, 2, 3, 4, 9)" in {
    treeSort(List(2,9,4,2,1,3)) should be (List(1, 2, 2, 3, 4, 9))
  }

}
