package com.focusmr.dblocator.client

import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.matchers.ShouldMatchers


@RunWith(classOf[JUnitRunner])
class CountryTest extends FunSuite with ShouldMatchers {
  test("country with empty string should throw exception") {
    intercept[IllegalArgumentException] {
      Country.from("")
    }
  }
  test("should produce some toString") {
    val from = Country.from("cz")
    from.toString.isEmpty should be(false)
    from.toString should include("country")
  }
  test("two countries should equal") {
    Country.from("cz") === Country.from("cz")
  }
}
