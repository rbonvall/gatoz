package cl.mez.gatoz
package booleans

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class BooleanCombinablesSpecs extends GatozTest {

  describe("BooleanCombinables") {
    it("has eight associative binary operations") {
      BooleanBinaryOperator.all.foreach { f =>
        println(s"${f.toString} ${f.isAssociative(Booleans).toString}")
      }
      BooleanBinaryOperator.all.filter( _.isAssociative(Booleans)).length shouldEqual 8
    }

  }

}
