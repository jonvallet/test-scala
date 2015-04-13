package com.jonvallet.scala.duplicates

import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by jon on 21/01/15.
 */
class StringDuplicateSpec extends FlatSpec with Matchers{

  "StringDuplicates.duplicates('Java')" should " return a" in {
    StringDuplicates.duplicates("Java") should be ("a")
  }

  "StringDuplicates.duplicates('Javav')" should " return av" in {
    StringDuplicates.duplicates("Javav") should be ("av")
  }

  "StringDuplicates.duplicates('Javava')" should " return av" in {
    StringDuplicates.duplicates("Javava") should be ("av")
  }

  "StringDuplicates.duplicates('')" should " return ''" in {
    StringDuplicates.duplicates("") should be ("")
  }

  "StringDuplicates.duplicates(null)" should " return ''" in {
    StringDuplicates.duplicates(null) should be ("")
  }

}
