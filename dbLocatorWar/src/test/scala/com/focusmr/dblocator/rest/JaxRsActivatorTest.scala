package com.focusmr.dblocator.rest

import _root_.scala.Predef._
import java.lang.annotation.Annotation
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.scalatest.matchers.MustMatchers


@RunWith(classOf[JUnitRunner])
class JaxRsActivatorTest extends FunSuite with MustMatchers {

  test("should have rest in path") {
    val a = new JaxRsActivator
    val annotations: Array[Annotation] = a.getClass.getAnnotations
    println(annotations.deep.mkString("\n"))
    if (annotations.length != 1) {
      fail()
    }
    annotations(0).toString must include("/rest")
  }
}
