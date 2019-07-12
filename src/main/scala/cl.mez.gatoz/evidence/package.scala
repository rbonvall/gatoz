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
      (m1.keySet union m2.keySet)
        .map { key =>
          val newValue =
            if (m1.contains(key) && m2.contains(key)) m1(key) |+| m2(key)
            else if (m1.contains(key))                m1(key)
            else                                      m2(key)
          key -> newValue
        }
        .toMap
    }

  /* Combinables from nothing */

  def numbersAreCombinableFromNothingWithPlusAndZero[N: Numeric]: CombinableFromNothing[N] = {
    implicit val ev: Combinable[N] = numbersAreCombinableWithPlus[N]
    CombinableFromNothing whoseDefaultValueIs num[N].zero
  }

  def numbersAreCombinableFromNothingWithTimesAndOne[N: Numeric]: CombinableFromNothing[N] = {
    implicit val ev: Combinable[N] = numbersAreCombinableWithTimes[N]
    CombinableFromNothing whoseDefaultValueIs num[N].one
  }


  /* Producers */

  val optionIsProducer: Producer[Option] =
    new Producer[Option] {
      def post[X, Y](optionX: Option[X], f: X => Y): Option[Y] = optionX match {
        case Some(x) => Some(f(x))
        case None    => None
      }
    }

  val seqIsProducer: Producer[Seq] =
    new Producer[Seq] {
      def post[X, Y](xs: Seq[X], f: X => Y): Seq[Y] =
        xs.map(f)
    }

  def functionIsProducer[T]: Producer[Function[T, ?]] =
    new Producer[Function[T, ?]] {
      def post[Out, A](producer: Function[T, Out], f: Out => A): Function[T, A] =
        t => f(producer(t))
    }


  /* Consumers */

  def functionIsConsumer[T]: Consumer[Function[?, T]] =
    new Consumer[Function[?, T]] {
      def pre[B, In](consumer: Function[In, T], f: B => In): Function[B, T] =
        t => consumer(f(t))
    }

}
