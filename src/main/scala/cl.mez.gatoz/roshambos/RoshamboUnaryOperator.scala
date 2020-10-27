package cl.mez.gatoz
package roshambos

case class RoshamboUnaryOperator(r: Roshambo, p: Roshambo, s: Roshambo) extends UnaryOperator[Roshambo] {
  def apply(x: Roshambo): Roshambo =
    x match {
      case Rock     => r
      case Paper    => p
      case Scissors => s
    }
}

object RoshamboUnaryOperator extends AllValues[RoshamboUnaryOperator] {

  def all: LazyList[RoshamboUnaryOperator] =
    for {
      fr <- Roshambo.all
      fp <- Roshambo.all
      fs <- Roshambo.all
    } yield RoshamboUnaryOperator(fr, fp, fs)

}
