package cl.mez.gatoz.units

object Combinables {

  def isAssociative(f: BinaryOperator): Boolean = {
    Units.allTriplets.forall { case (p, q, r) =>
      f(f(p, q), r) == f(p, f(q, r))
    }
  }

  def isNeutralElement(f: BinaryOperator, e: Unit): Boolean = {
    Units.all.forall { p =>
      f(e, p) == p && f(p, e) == p
    }
  }

  def allAssociativeOperators = BinaryOperator.all.filter(isAssociative)

  val allAssociativeOperatorsWithNeutralElement = for {
    f <- allAssociativeOperators
    p <- Units.all
    if isNeutralElement(f, p)
  } yield (f, p)

}

