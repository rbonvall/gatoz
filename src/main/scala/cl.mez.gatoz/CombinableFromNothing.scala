package cl.mez.gatoz

trait CombinableFromNothing[T] extends Combinable[T]:
  def default: T


object CombinableFromNothing:

  def from[T](t: T)(f: (T, T) => T) = new CombinableFromNothing[T] {
    val default: T = t
    def combine(x: T, y: T): T = f(x, y)
  }

  def of[T: CombinableFromNothing] = summon[CombinableFromNothing[T]]

