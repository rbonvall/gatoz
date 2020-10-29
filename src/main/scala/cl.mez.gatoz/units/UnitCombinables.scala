package cl.mez.gatoz
package units


object UnitCombinables extends AllValues[Combinable[Unit]] {

  val only: Combinable[Unit] = Combinable.from { (_, _) => () }
  val all: Set[Combinable[Unit]] = Set(only)

  def allAssociativeOperators = UnitBinaryOperator.all.filter(
    _.isAssociative(Units)
  )

  val allAssociativeOperatorsWithNeutralElement = for {
    f <- allAssociativeOperators
    p <- Units.all
    if f.hasNeutralElement(p)(Units)
  } yield (f, p)

}

