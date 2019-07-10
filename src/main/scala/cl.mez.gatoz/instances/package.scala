package cl.mez.gatoz
import Combinable.ops._

package object instances {
  /** Get the numeric instance for N. */
  private def num[N](implicit instance: Numeric[N]): Numeric[N] = instance

  /* Combinables */

  val unitUnitCombinable: Combinable[Unit] =
    Combinable whoseCombineFunctionIs { (_, _) => () }

  val boolAndCombinable: Combinable[Boolean] =
    Combinable whoseCombineFunctionIs { _ && _ }

  val boolOrCombinable: Combinable[Boolean] =
    Combinable whoseCombineFunctionIs { _ || _ }

  def numericAddCombinable[N: Numeric]: Combinable[N] =
    Combinable whoseCombineFunctionIs num[N].plus

  def numericMulCombinable[N: Numeric]: Combinable[N] =
    Combinable whoseCombineFunctionIs num[N].times

  def orderingMaxCombinable[T: Ordering]: Combinable[T] =
    Combinable whoseCombineFunctionIs Ordering[T].max

  def orderingMinCombinable[T: Ordering]: Combinable[T] =
    Combinable whoseCombineFunctionIs Ordering[T].min

  def seqConcatCombinable[T]: Combinable[Seq[T]] =
    Combinable whoseCombineFunctionIs { _ ++ _ }

  def optionCombinable[T: Combinable]: Combinable[Option[T]] =
    Combinable whoseCombineFunctionIs {
      case (Some(x), Some(y)) => Some(x |+| y)
      case (Some(x), None)    => Some(x)
      case (None,    Some(y)) => Some(y)
      case (None,    None)    => None
    }

  def mapMergeCombinable[T, U: Combinable]: Combinable[Map[T, U]] =
    Combinable whoseCombineFunctionIs { (m1, m2) =>
      ???
    }

  /* Combinables from nothing */

  def numericAddCombinableFromNothing[N: Numeric]: Combinable[N] = {
    implicit val ev: Combinable[N] = numericAddCombinable[N]
    CombinableFromNothing whoseDefaultValueIs num[N].zero
  }

  def numericMulCombinableFromNothing[N: Numeric]: Combinable[N] = {
    implicit val ev: Combinable[N] = numericMulCombinable[N]
    CombinableFromNothing whoseDefaultValueIs num[N].one
  }

}
