package cl.mez.gatoz

trait Correspondance[T, U]:
  def goesTo   (t: T): U
  def comesFrom(u: U): T


object Correspondance:

  def from[T, U](f: T => U, g: U => T): Correspondance[T, U] = new Correspondance[T, U] {
    def goesTo   (t: T): U = f(t)
    def comesFrom(u: U): T = g(u)
  }

  def between[T, U](using c: Correspondance[T, U]) = c

