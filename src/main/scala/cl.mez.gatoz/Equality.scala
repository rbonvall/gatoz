package cl.mez.gatoz

trait Equality[T] {

  def eq (a: T, b: T): Boolean
  def neq(a: T, b: T): Boolean = !eq(a, b)

}

object Equality {

  def from[T](f: (T, T) => Boolean): Equality[T] =
    new Equality[T] {
      def eq(a: T, b: T): Boolean = f(a, b)

    }

  def of[T: Equality] = implicitly[Equality[T]]

}
