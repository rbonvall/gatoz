package cl.mez.gatoz
package units


case class UnitUnaryOperator() extends UnaryOperator[Unit] {
  def apply(u: Unit): Unit = u
}


object UnitUnaryOperator extends AllValues[UnitUnaryOperator] {

  val only = UnitUnaryOperator()
  def all = List(only)

}

