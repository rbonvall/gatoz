package cl.mez.gatoz.units

case class BinaryOperator() extends cl.mez.gatoz.BinaryOperator[Unit] {
  def apply(u: Unit, v: Unit): Unit = ()
}

object BinaryOperator {

  def only = BinaryOperator()
  def all = List(only)

}
