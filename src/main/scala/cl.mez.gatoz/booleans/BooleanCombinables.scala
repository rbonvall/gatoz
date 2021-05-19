package cl.mez.gatoz
package booleans


object BooleanCombinables {

  def allAssociativeOperators = BooleanBinaryOperator.all.filter(
    _.isAssociative(using Booleans)
  )

  val allAssociativeOperatorsWithNeutralElement = for {
    f <- allAssociativeOperators
    p <- Booleans.all
    if f.hasNeutralElement(p)(using Booleans)
  } yield (f, p)

}

