package cl.mez.gatoz.units

import cl.mez.gatoz.BinaryOperator

case class UnitBinaryOperator() extends BinaryOperator[Unit] {
  def apply(u: Unit, v: Unit): Unit = ()
}

object UnitBinaryOperator {

  def only = UnitBinaryOperator()
  def all = List(only)

}
