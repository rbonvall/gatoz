package cl.mez.gatoz
package roshambos


/* Our own 3-value type.  All 3-value types are isomorphic to this one. */
sealed trait Roshambo extends Product with Serializable
case object Rock     extends Roshambo
case object Paper    extends Roshambo
case object Scissors extends Roshambo

object Roshambo extends AllValues[Roshambo]:
  val all = Set(Rock, Paper, Scissors)

