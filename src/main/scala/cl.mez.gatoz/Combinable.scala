package cl.mez.gatoz

trait Combinable[T] {
  def combine(x: T, y: T): T
}

object Combinable {

  def from[T](f: (T, T) => T): Combinable[T] = new Combinable[T] {
    def combine(x: T, y: T): T = f(x, y)
  }

  def of[T: Combinable] = implicitly[Combinable[T]]

  object ops {
    implicit class CombinableOps[T: Combinable](val x: T) {
      def |+|(y: T) = Combinable.of[T].combine(x, y)
    }
  }

}

