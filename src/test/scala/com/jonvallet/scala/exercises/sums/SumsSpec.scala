package com.jonvallet.scala.exercises.sums

import org.scalatest.{FlatSpec, Matchers}
import com.jonvallet.scala.sums.sums

/**
  * Created by j.vallet@validus-ivc.co.uk on 29/03/16.
  */
class SumsSpec extends FlatSpec with Matchers {
    "sums(Map())(\"PS 122\", 1000))" should "return Map(\"PS 122\" -> 1000)" in {
        sums(Map())("PS 122", 1000) should be (Map("PS 122" -> 1000))
    }
}
