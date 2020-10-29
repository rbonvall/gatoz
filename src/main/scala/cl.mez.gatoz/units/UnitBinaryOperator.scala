package cl.mez.gatoz
package units


case class UnitBinaryOperator() extends BinaryOperator[Unit] {
  def apply(u: Unit, v: Unit): Unit = ()
}

object UnitBinaryOperator extends AllValues[UnitBinaryOperator] {

  def only = UnitBinaryOperator()
  def all = Set(only)

}
