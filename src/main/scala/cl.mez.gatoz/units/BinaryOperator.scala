package cl.mez.gatoz.units

case class BinaryOperator() {
  def apply(u: Unit, v: Unit): Unit = ()
}

object BinaryOperator {

  def only = BinaryOperator()
  def all = List(only)

}
