package cl.mez.gatoz
import Combinable.ops.*

/** Get the numeric instance for N. */
private def num[N](using instance: Numeric[N]): Numeric[N] = instance

/* Combinables */

val unitUnitCombinable: Combinable[Unit] =
  Combinable from { (_, _) => () }

val boolIsCombinableWithAnd: Combinable[Boolean] =
  Combinable from { _ && _ }

val boolIsCombinableWithOr: Combinable[Boolean] =
  Combinable from { _ || _ }

def numbersAreCombinableWithPlus[N: Numeric]: Combinable[N] =
  Combinable from num[N].plus

def numbersAreCombinableWithTimes[N: Numeric]: Combinable[N] =
  Combinable from num[N].times

def orderedsAreCombinableWithMax[T: Ordering]: Combinable[T] =
  Combinable from Ordering[T].max

def orderedsAreCombinableWithMin[T: Ordering]: Combinable[T] =
  Combinable from Ordering[T].min

def sequencesAreCombinableWithConcatenation[T]: Combinable[Seq[T]] =
  Combinable from { _ ++ _ }

def optionsOfCombinablesAreCombinable[T: Combinable]: Combinable[Option[T]] =
  Combinable from {
    case (Some(x), Some(y)) => Some(x |+| y)
    case (Some(x), None)    => Some(x)
    case (None,    Some(y)) => Some(y)
    case (None,    None)    => None
  }

def mapsWithCombinableValuesAreCombinableByMergingAndCombining[T, U: Combinable]: Combinable[Map[T, U]] =
  Combinable from { (m1, m2) =>
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
  CombinableFromNothing.from(num[N].zero)(numbersAreCombinableWithPlus[N].combine)
}

def numbersAreCombinableFromNothingWithTimesAndOne[N: Numeric]: CombinableFromNothing[N] = {
  CombinableFromNothing.from(num[N].one)(numbersAreCombinableWithTimes[N].combine)
}


/* Producers */

val optionIsProducer: Producer[Option] =
  new Producer[Option]:
    def post[X, Y](optionX: Option[X], f: X => Y): Option[Y] = optionX match
      case Some(x) => Some(f(x))
      case None    => None

val seqIsProducer: Producer[Seq] =
  new Producer[Seq]:
    def post[X, Y](xs: Seq[X], f: X => Y): Seq[Y] =
      xs.map(f)

def functionIsProducer[T]: Producer[[U] =>> Function[T, U]] =
  new Producer[[U] =>> Function[T, U]]:
    def post[Out, A](producer: Function[T, Out], f: Out => A): Function[T, A] =
      t => f(producer(t))


/* Consumers */

def functionIsConsumer[T]: Consumer[[U] =>> Function[U, T]] =
  new Consumer[[U] =>> Function[U, T]]:
    def pre[B, In](consumer: Function[In, T], f: B => In): Function[B, T] =
      t => consumer(f(t))

