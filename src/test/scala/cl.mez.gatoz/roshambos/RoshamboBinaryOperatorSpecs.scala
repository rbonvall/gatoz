package cl.mez.gatoz
package roshambos

import munit.FunSuite

class RoshamboBinaryOperatorSpecs extends FunSuite {
  implicit val allRoshambos = Roshambo

  test("RoshamboBinaryOperator has 19683 distinct operators") {
    assertEquals(RoshamboBinaryOperator.all.size, 19683)
  }

  test("RoshamboBinaryOperator has 113 distinct associative operators") {
    assertEquals(RoshamboBinaryOperator.all.count(_.isAssociative), 113)
  }

}
