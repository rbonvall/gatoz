package cl.mez.gatoz
package roshambos


class RoshamboBinaryOperatorSpecs extends GatozTest {

  describe("RoshamboBinaryOperator") {

    it("has 19683 possible values") {
      RoshamboBinaryOperator.all.length shouldEqual 19683
    }

  }

}
