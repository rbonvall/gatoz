package cl.mez.gatoz
package ordering


case class OrderingUnaryOperator( d: Ordering
                                , e: Ordering
                                , a: Ordering
                                ) extends UnaryOperator[Ordering]:

  def apply(o: Ordering): Ordering = o match {
    case Descending => d
    case Equal      => e
    case Ascending  => a
  }


object OrderingUnaryOperator:
  private val D = Descending
  private val E = Equal
  private val A = Ascending

  val fDDD = OrderingUnaryOperator(D, D, D)
  val fDDE = OrderingUnaryOperator(D, D, E)
  val fDDA = OrderingUnaryOperator(D, D, A)
  val fDED = OrderingUnaryOperator(D, E, D)
  val fDEE = OrderingUnaryOperator(D, E, E)
  val fDEA = OrderingUnaryOperator(D, E, A)
  val fDAD = OrderingUnaryOperator(D, A, D)
  val fDAE = OrderingUnaryOperator(D, A, E)
  val fDAA = OrderingUnaryOperator(D, A, A)

  val fEDD = OrderingUnaryOperator(E, D, D)
  val fEDE = OrderingUnaryOperator(E, D, E)
  val fEDA = OrderingUnaryOperator(E, D, A)
  val fEED = OrderingUnaryOperator(E, E, D)
  val fEEE = OrderingUnaryOperator(E, E, E)
  val fEEA = OrderingUnaryOperator(E, E, A)
  val fEAD = OrderingUnaryOperator(E, A, D)
  val fEAE = OrderingUnaryOperator(E, A, E)
  val fEAA = OrderingUnaryOperator(E, A, A)

  val fADD = OrderingUnaryOperator(A, D, D)
  val fADE = OrderingUnaryOperator(A, D, E)
  val fADA = OrderingUnaryOperator(A, D, A)
  val fAED = OrderingUnaryOperator(A, E, D)
  val fAEE = OrderingUnaryOperator(A, E, E)
  val fAEA = OrderingUnaryOperator(A, E, A)
  val fAAD = OrderingUnaryOperator(A, A, D)
  val fAAE = OrderingUnaryOperator(A, A, E)
  val fAAA = OrderingUnaryOperator(A, A, A)

  def all = Set[OrderingUnaryOperator](
    fDDD, fDDE, fDDA,
    fDED, fDEE, fDEA,
    fDAD, fDAE, fDAA,

    fEDD, fEDE, fEDA,
    fEED, fEEE, fEEA,
    fEAD, fEAE, fEAA,

    fADD, fADE, fADA,
    fAED, fAEE, fAEA,
    fAAD, fAAE, fAAA
  )

  def fromFunction(func: Ordering => Ordering) =
    OrderingUnaryOperator( d = func(Descending)
                         , e = func(Equal)
                         , a = func(Ascending))

