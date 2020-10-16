package cl.mez.gatoz.units

case class UnitUnaryOperator() {
  def apply(u: Unit): Unit = u
}


object UnitUnaryOperator {

  val only = UnitUnaryOperator()
  def all = List(only)

}

