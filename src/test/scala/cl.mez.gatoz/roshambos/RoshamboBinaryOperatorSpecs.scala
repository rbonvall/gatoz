package cl.mez.gatoz
package roshambos


class RoshamboBinaryOperatorSpecs extends GatozTest {
  implicit val allRoshambos = Roshambo

  describe("RoshamboBinaryOperator") {

    it("has 19683 distinct operators") {
      RoshamboBinaryOperator.all.length shouldEqual 19683
    }

    it("has 113 distinct associative operators") {
      RoshamboBinaryOperator.all.count(_.isAssociative) shouldEqual 113
    }

  }

}
