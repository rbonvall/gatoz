package cl.mez.gatoz

trait AllValues[T] {

  def all: Set[T]

  def allPairs = for {
    p <- all
    q <- all
  } yield (p, q)

  def allTriplets = for {
    p <- all
    q <- all
    r <- all
  } yield (p, q, r)

}
