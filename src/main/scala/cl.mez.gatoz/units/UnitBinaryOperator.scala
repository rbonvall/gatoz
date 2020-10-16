package cl.mez.gatoz
package units


case class UnitBinaryOperator() extends BinaryOperator[Unit] {
  def apply(u: Unit, v: Unit): Unit = ()
}

object UnitBinaryOperator {

  def only = UnitBinaryOperator()
  def all = List(only)

}
