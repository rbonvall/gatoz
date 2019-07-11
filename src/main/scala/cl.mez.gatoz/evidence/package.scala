package cl.mez.gatoz
import Combinable.ops._

package object evidence {
  /** Get the numeric instance for N. */
  private def num[N](implicit instance: Numeric[N]): Numeric[N] = instance

  /* Combinables */

  val unitUnitCombinable: Combinable[Unit] =
    Combinable whoseCombineFunctionIs { (_, _) => () }

  val boolIsCombinableWithAnd: Combinable[Boolean] =
    Combinable whoseCombineFunctionIs { _ && _ }

  val boolIsCombinableWithOr: Combinable[Boolean] =
    Combinable whoseCombineFunctionIs { _ || _ }

  def numbersAreCombinableWithPlus[N: Numeric]: Combinable[N] =
    Combinable whoseCombineFunctionIs num[N].plus

  def numbersAreCombinableWithTimes[N: Numeric]: Combinable[N] =
    Combinable whoseCombineFunctionIs num[N].times

  def orderedsAreCombinableWithMax[T: Ordering]: Combinable[T] =
    Combinable whoseCombineFunctionIs Ordering[T].max

  def orderedsAreCombinableWithMin[T: Ordering]: Combinable[T] =
    Combinable whoseCombineFunctionIs Ordering[T].min

  def sequencesAreCombinableWithConcatenation[T]: Combinable[Seq[T]] =
    Combinable whoseCombineFunctionIs { _ ++ _ }

  def optionsOfCombinablesAreCombinable[T: Combinable]: Combinable[Option[T]] =
    Combinable whoseCombineFunctionIs {
      case (Some(x), Some(y)) => Some(x |+| y)
      case (Some(x), None)    => Some(x)
      case (None,    Some(y)) => Some(y)
      case (None,    None)    => None
    }

  def mapsWithCombinableValuesAreCombinableByMergingAndCombining[T, U: Combinable]: Combinable[Map[T, U]] =
    Combinable whoseCombineFunctionIs { (m1, m2) =>
      ???
    }

  /* Combinables from nothing */

  def numbersAreCombinableFromNothingWithPlusAndZero[N: Numeric]: Combinable[N] = {
    implicit val ev: Combinable[N] = numbersAreCombinableWithPlus[N]
    CombinableFromNothing whoseDefaultValueIs num[N].zero
  }

  def numbersAreCombinableFromNothingWithTimesAndOne[N: Numeric]: Combinable[N] = {
    implicit val ev: Combinable[N] = numbersAreCombinableWithTimes[N]
    CombinableFromNothing whoseDefaultValueIs num[N].one
  }

}
