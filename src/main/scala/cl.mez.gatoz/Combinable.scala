package cl.mez.gatoz

import simulacrum._

@typeclass
trait Combinable[T] {
  @op("|+|")
  def combine(x: T, y: T): T
}

object Combinable {

  def from[T](f: (T, T) => T): Combinable[T] = new Combinable[T] {
    def combine(x: T, y: T): T = f(x, y)
  }

  def forType[T: Combinable] = implicitly[Combinable[T]]

}

