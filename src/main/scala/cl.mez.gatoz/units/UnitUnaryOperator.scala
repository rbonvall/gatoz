package cl.mez.gatoz.units

import cl.mez.gatoz.UnaryOperator

case class UnitUnaryOperator() extends UnaryOperator[Unit] {
  def apply(u: Unit): Unit = u
}


object UnitUnaryOperator {

  val only = UnitUnaryOperator()
  def all = List(only)

}

