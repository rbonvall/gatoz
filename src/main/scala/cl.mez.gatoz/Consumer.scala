package cl.mez.gatoz

import simulacrum._
import scala.language.higherKinds

@typeclass
trait Consumer[C[_]] {
  @op("<<")
  def pre[Before, Input](consumer: C[Input], transform: Before => Input): C[Before]
}

object Consumer {

  /* TODO: figure out the type for the evidence factory. */

}
