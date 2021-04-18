package cl.mez.gatoz
package roshambos


/* Our own 3-value type.  All 3-value types are isomorphic to this one. */
enum Roshambo:
  case Rock
  case Paper
  case Scissors

object Roshambo extends AllValues[Roshambo]:
  val all = Set(Rock, Paper, Scissors)

