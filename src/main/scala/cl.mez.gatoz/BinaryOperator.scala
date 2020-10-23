package cl.mez.gatoz

trait BinaryOperator[T] extends ((T, T) => T) {
  def apply(a: T, b: T): T

  def isAssociative(implicit ts: AllValues[T]): Boolean = {
    ts.allTriplets.forall { case (p, q, r) =>
      apply(apply(p, q), r) == apply(p, apply(q, r))
    }
  }

  def hasNeutralElement(e: T)(implicit ts: AllValues[T]): Boolean = {
    ts.all.forall { p =>
      apply(e, p) == p && apply(p, e) == p
    }
  }

}

object BinaryOperator {

  def of[T](f: (T, T) => T): BinaryOperator[T] =
    new BinaryOperator[T] {
      def apply(a: T, b: T) = f(a, b)
    }

}
