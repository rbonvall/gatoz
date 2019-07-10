package cl.mez.gatoz

import simulacrum._

@typeclass trait Combinable[T] {
  @op("|+|") def combine(x: T, y: T): T
}

object Combinable {

  def whoseCombineFunctionIs[T](f: (T, T) => T): Combinable[T] = new Combinable[T] {
    def combine(x: T, y: T): T = f(x, y)
  }

}

