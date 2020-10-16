package cl.mez.gatoz.booleans

object Combinables {

  def allAssociativeOperators = BooleanBinaryOperator.all.filter(
    _.isAssociative(Booleans)
  )

  val allAssociativeOperatorsWithNeutralElement = for {
    f <- allAssociativeOperators
    p <- Booleans.all
    if f.hasNeutralElement(p)(Booleans)
  } yield (f, p)

}

