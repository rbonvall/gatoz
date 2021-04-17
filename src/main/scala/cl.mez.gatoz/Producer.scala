package cl.mez.gatoz

import scala.language.higherKinds

trait Producer[P[_]] {
  def post[Output, After](producer: P[Output], transform: Output => After): P[After]
}

object Producer {

  /* TODO: figure out the type for the evidence factory. */

}
