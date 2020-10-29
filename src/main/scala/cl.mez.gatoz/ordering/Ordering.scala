package cl.mez.gatoz
package ordering


sealed trait Ordering extends Product with Serializable
case object Descending extends Ordering
case object Equal      extends Ordering
case object Ascending  extends Ordering


object Ordering extends AllValues[Ordering] {
  val all = Set(Descending, Equal, Ascending)
}
