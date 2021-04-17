package cl.mez.gatoz
package booleans

import munit.FunSuite

class BooleanCombinablesSpecs extends FunSuite {

  test("BooleanCombinables has eight associative binary operations") {
    BooleanBinaryOperator.all.foreach { f =>
      println(s"${f.toString} ${f.isAssociative(Booleans).toString}")
    }
    assertEquals(BooleanBinaryOperator.all.filter( _.isAssociative(Booleans)).size, 8)
  }

}
