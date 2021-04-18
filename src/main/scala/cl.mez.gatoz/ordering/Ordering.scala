package cl.mez.gatoz
package ordering


enum Ordering:
  case Descending
  case Equal
  case Ascending


object Ordering extends AllValues[Ordering]:
  val all = Set(Descending, Equal, Ascending)

