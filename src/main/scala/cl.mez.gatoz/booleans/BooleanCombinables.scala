package cl.mez.gatoz
package booleans


object BooleanCombinables {
  given AllValues[Boolean] = Booleans

  def allAssociativeOperators =
    BooleanBinaryOperator.all.filter(_.isAssociative)

  val allAssociativeOperatorsWithNeutralElement = for {
    f <- allAssociativeOperators
    p <- Booleans.all
    if f.hasNeutralElement(p)
  } yield (f, p)

}

