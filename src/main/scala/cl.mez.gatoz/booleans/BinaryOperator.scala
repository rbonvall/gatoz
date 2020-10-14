package cl.mez.gatoz.booleans

case class BinaryOperator( ff: Boolean
                         , ft: Boolean
                         , tf: Boolean
                         , tt: Boolean
                         ) {

  def apply(p: Boolean, q: Boolean): Boolean = {
    if      (p && q) tt
    else if (p)      tf
    else if (q)      ft
    else             ff
  }

}

object BinaryOperator {

  //                      F x F  F x T  T x F  T x T
  val f0 = BinaryOperator(false, false, false, false)
  val f1 = BinaryOperator(false, false, false, true )
  val f2 = BinaryOperator(false, false, true,  false)
  val f3 = BinaryOperator(false, false, true,  true )
  val f4 = BinaryOperator(false, true,  false, false)
  val f5 = BinaryOperator(false, true,  false, true )
  val f6 = BinaryOperator(false, true,  true,  false)
  val f7 = BinaryOperator(false, true,  true,  true )
  val f8 = BinaryOperator(true,  false, false, false)
  val f9 = BinaryOperator(true,  false, false, true )
  val fA = BinaryOperator(true,  false, true,  false)
  val fB = BinaryOperator(true,  false, true,  true )
  val fC = BinaryOperator(true,  true,  false, false)
  val fD = BinaryOperator(true,  true,  false, true )
  val fE = BinaryOperator(true,  true,  true,  false)
  val fF = BinaryOperator(true,  true,  true,  true )

  val pessimist  = f0
  val and        = f1
  val notImplies = f2
  val first      = f3
  val notImplied = f4
  val second     = f5
  val xor        = f6
  val or         = f7
  val nor        = f8
  val equal      = f9
  val notSecond  = fA
  val implied    = fB
  val notFirst   = fC
  val implies    = fD
  val nand       = fE
  val optimist   = fF

  def all = List(f0, f1, f2, f3,
                 f4, f5, f6, f7,
                 f8, f9, fA, fB,
                 fC, fD, fE, fF)

  def fromFunction(f: (Boolean, Boolean) => Boolean) =
    BinaryOperator( ff = f(false, false)
                  , ft = f(false, true )
                  , tf = f(true,  false)
                  , tt = f(true,  true ))

}
