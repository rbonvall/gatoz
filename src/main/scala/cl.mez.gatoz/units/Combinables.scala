package cl.mez.gatoz.units

object Combinables {

  def allAssociativeOperators = BinaryOperator.all.filter(
    _.isAssociative(Units)
  )

  val allAssociativeOperatorsWithNeutralElement = for {
    f <- allAssociativeOperators
    p <- Units.all
    if f.hasNeutralElement(p)(Units)
  } yield (f, p)

}

