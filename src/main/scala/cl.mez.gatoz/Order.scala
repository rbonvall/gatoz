package cl.mez.gatoz

import ordering.Ordering
import simulacrum._

@typeclass
trait Order[T] {
  @op("<?>")
  def compare(a: T, b: T): Ordering
}



object Order {

  def from[T](f: (T, T) => Ordering): Order[T] =
    new Order[T] {
      def compare(a: T, b: T): Ordering = f(a, b)
    }

  def of[T: Order] = implicitly[Order[T]]

}
