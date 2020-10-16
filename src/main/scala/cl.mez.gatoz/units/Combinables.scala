package cl.mez.gatoz.units

object Combinables {

  def allAssociativeOperators = UnitBinaryOperator.all.filter(
    _.isAssociative(Units)
  )

  val allAssociativeOperatorsWithNeutralElement = for {
    f <- allAssociativeOperators
    p <- Units.all
    if f.hasNeutralElement(p)(Units)
  } yield (f, p)

}

