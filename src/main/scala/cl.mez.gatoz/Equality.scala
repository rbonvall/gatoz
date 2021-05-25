package cl.mez.gatoz

trait Equality[T]:
  def eq (a: T, b: T): Boolean


object Equality:

  def from[T](f: (T, T) => Boolean): Equality[T] =
    new Equality[T]:
      def eq(a: T, b: T): Boolean = f(a, b)

  def of[T: Equality] = summon[Equality[T]]


extension [T: Equality](a: T)
  def === (b: T) = Equality.of[T].eq(a, b)
  def !== (b: T) = !Equality.of[T].eq(a, b)
