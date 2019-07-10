package cl.mez.gatoz

import simulacrum._

@typeclass trait CombinableFromNothing[T] extends Combinable[T] {
  @op("∅") def default: T
}

object CombinableFromNothing {

  def whoseDefaultValueIs[T: Combinable](d: T): CombinableFromNothing[T] = new CombinableFromNothing[T] {
    def combine(a: T, b: T): T = Combinable[T].combine(a, b)
    val default: T = d
  }

}
