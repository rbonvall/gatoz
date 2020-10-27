package cl.mez.gatoz
package roshambos

case class RoshamboBinaryOperator( rr: Roshambo, rp: Roshambo, rs: Roshambo
                                 , pr: Roshambo, pp: Roshambo, ps: Roshambo
                                 , sr: Roshambo, sp: Roshambo, ss: Roshambo
                                 ) extends BinaryOperator[Roshambo] {

  def apply(x: Roshambo, y: Roshambo): Roshambo = {
    (x, y) match {
      case (Rock,     Rock)     => rr
      case (Rock,     Paper)    => rp
      case (Rock,     Scissors) => rs
      case (Paper,    Rock)     => pr
      case (Paper,    Paper)    => pp
      case (Paper,    Scissors) => ps
      case (Scissors, Rock)     => sr
      case (Scissors, Paper)    => sp
      case (Scissors, Scissors) => ss
    }
  }
}

object RoshamboBinaryOperator extends AllValues[RoshamboBinaryOperator] {
  // There are 19683 of these bad boys.
  val all: LazyList[RoshamboBinaryOperator] =
    for {
      r1 <- Roshambo.all
      r2 <- Roshambo.all
      r3 <- Roshambo.all
      r4 <- Roshambo.all
      r5 <- Roshambo.all
      r6 <- Roshambo.all
      r7 <- Roshambo.all
      r8 <- Roshambo.all
      r9 <- Roshambo.all
    } yield RoshamboBinaryOperator(r1, r2, r3, r4, r5, r6, r7, r8, r9)
}

