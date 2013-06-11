package com.focusmr.dblocator.client

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSpec


@RunWith(classOf[JUnitRunner])
class DbLocatorExceptionTest extends FunSpec {
  describe("DbLocator exception") {
    it("should have default constructor") {
      val cause = new RuntimeException("test")
      val exception = new DbLocatorException(cause)
      exception.getCause === cause
    }
  }
}
