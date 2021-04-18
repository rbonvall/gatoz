package cl.mez.gatoz

trait UnaryOperator[T]:
  def apply(a: T): T


object UnaryOperator:

  def of[T](f: T => T): UnaryOperator[T] =
    new UnaryOperator[T] {
      def apply(a: T) = f(a)
    }

