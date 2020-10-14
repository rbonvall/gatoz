package cl.mez.gatoz

import simulacrum._

@typeclass
trait CombinableFromNothing[T] extends Combinable[T] {
  @op("∅")
  def default: T
}

object CombinableFromNothing {

  def from[T](t: T)(f: (T, T) => T) = new CombinableFromNothing[T] {
    val default: T = t
    def combine(x: T, y: T): T = f(x, y)
  }

  def forType[T: CombinableFromNothing] = implicitly[CombinableFromNothing[T]]

}
