package cl.mez.gatoz

import simulacrum._

@typeclass trait Combinable[T] {
  @op("|+|") def combine(x: T, y: T): T
}

