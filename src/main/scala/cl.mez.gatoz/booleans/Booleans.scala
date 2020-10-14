package cl.mez.gatoz.booleans

object Booleans {

  def all = List(false, true)

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

