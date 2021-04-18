package cl.mez.gatoz
package roshambos

case class RoshamboBinaryOperator( rr: Roshambo, rp: Roshambo, rs: Roshambo
                                 , pr: Roshambo, pp: Roshambo, ps: Roshambo
                                 , sr: Roshambo, sp: Roshambo, ss: Roshambo
                                 ) extends BinaryOperator[Roshambo]:

  def apply(x: Roshambo, y: Roshambo): Roshambo =
    (x, y) match
      case (Roshambo.Rock,     Roshambo.Rock)     => rr
      case (Roshambo.Rock,     Roshambo.Paper)    => rp
      case (Roshambo.Rock,     Roshambo.Scissors) => rs
      case (Roshambo.Paper,    Roshambo.Rock)     => pr
      case (Roshambo.Paper,    Roshambo.Paper)    => pp
      case (Roshambo.Paper,    Roshambo.Scissors) => ps
      case (Roshambo.Scissors, Roshambo.Rock)     => sr
      case (Roshambo.Scissors, Roshambo.Paper)    => sp
      case (Roshambo.Scissors, Roshambo.Scissors) => ss


object RoshamboBinaryOperator extends AllValues[RoshamboBinaryOperator]:
  // There are 19683 of these bad boys.
  lazy val all: Set[RoshamboBinaryOperator] =
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

