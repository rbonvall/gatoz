package cl.mez.gatoz.booleans

object Combinables {

  def isAssociative(f: BinaryOperator): Boolean = {
    Booleans.allTriplets.forall { case (p, q, r) =>
      f(f(p, q), r) == f(p, f(q, r))
    }
  }

  def isNeutralElement(f: BinaryOperator, e: Boolean): Boolean = {
    Booleans.all.forall { p =>
      f(e, p) == p && f(p, e) == p
    }
  }

  def allAssociativeOperators = BinaryOperator.all.filter(isAssociative)

  val allAssociativeOperatorsWithNeutralElement = for {
    f <- allAssociativeOperators
    p <- Booleans.all
    if isNeutralElement(f, p)
  } yield (f, p)

}

