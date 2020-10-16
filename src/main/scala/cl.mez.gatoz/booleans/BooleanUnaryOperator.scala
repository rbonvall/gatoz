package cl.mez.gatoz.booleans

case class BooleanUnaryOperator(f: Boolean, t: Boolean) {
  def apply(p: Boolean): Boolean = if (p) t else f
}


object BooleanUnaryOperator {

  //                            f(F)   f(T)
  val f0 = BooleanUnaryOperator(false, false)
  val f1 = BooleanUnaryOperator(false, true )
  val f2 = BooleanUnaryOperator(true,  false)
  val f3 = BooleanUnaryOperator(true,  true )

  val pessimist = f0
  val identity  = f1
  val not       = f2
  val optimist  = f3

  def all = List(f0, f1, f2, f3)

  def fromFunction(func: Boolean => Boolean) =
    BooleanUnaryOperator(f = func(false), t = func(true))

}

