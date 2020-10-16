package cl.mez.gatoz.units

case class UnaryOperator() {
  def apply(u: Unit): Unit = u
}


object UnaryOperator {

  val only = UnaryOperator()
  def all = List(only)

}

