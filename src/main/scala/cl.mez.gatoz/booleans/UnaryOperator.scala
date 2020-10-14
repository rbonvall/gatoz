package cl.mez.gatoz.booleans

case class UnaryOperator(f: Boolean, t: Boolean) {
  def apply(p: Boolean): Boolean = if (p) t else f
}


object UnaryOperator {

  //                     f(F)   f(T)
  val f0 = UnaryOperator(false, false)
  val f1 = UnaryOperator(false, true )
  val f2 = UnaryOperator(true,  false)
  val f3 = UnaryOperator(true,  true )

  val pessimist = f0
  val identity  = f1
  val not       = f2
  val optimist  = f3

  def all = List(f0, f1, f2, f3)

  def fromFunction(func: Boolean => Boolean) =
    UnaryOperator(f = func(false), t = func(true))

}

