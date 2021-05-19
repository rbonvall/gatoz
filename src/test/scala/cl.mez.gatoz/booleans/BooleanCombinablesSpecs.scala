package cl.mez.gatoz
package booleans

import munit.FunSuite

class BooleanCombinablesSpecs extends FunSuite {
  given AllValues[Boolean] = Booleans

  test("BooleanCombinables has eight associative binary operations") {
    BooleanBinaryOperator.all.foreach { f =>
      println(s"${f.toString} ${f.isAssociative.toString}")
    }
    assertEquals(BooleanBinaryOperator.all.filter( _.isAssociative).size, 8)
  }

}
