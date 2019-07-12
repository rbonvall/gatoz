package cl.mez.gatoz

import simulacrum._
import scala.language.higherKinds

@typeclass trait Producer[P[_]] {
  @op(">>") def post[Output, After](producer: P[Output], transform: Output => After): P[After]
}

object Producer {

  /* TODO: figure out the type for the evidence factory. */

}
