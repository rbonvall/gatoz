package cl.mez.gatoz

import ordering.Ordering

trait Order[T] {
  def compare(a: T, b: T): Ordering
}



object Order {

  def from[T](f: (T, T) => Ordering): Order[T] =
    new Order[T] {
      def compare(a: T, b: T): Ordering = f(a, b)
    }

  def of[T: Order] = summon[Order[T]]

}
