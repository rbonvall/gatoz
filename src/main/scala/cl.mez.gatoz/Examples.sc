import cl.mez.gatoz._
import cl.mez.gatoz.Combinable.ops._
import cl.mez.gatoz.instances._

implicit def e1[T: Combinable] = optionCombinable[T]
implicit def e2[T: Combinable] = seqConcatCombinable[T]
implicit val e3 = numericMulCombinable[Int]
implicit val e4 = boolOrCombinable

Option(Option(11)) |+| Option(Option(33))
Option(Option(Seq(11))) |+| Option(Option(Seq(33)))
Option(true) |+| Option(true)


