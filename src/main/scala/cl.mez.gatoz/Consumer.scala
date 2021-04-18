package cl.mez.gatoz

import scala.language.higherKinds

trait Consumer[C[_]]:
  def pre[Before, Input](consumer: C[Input], transform: Before => Input): C[Before]


object Consumer
  /* TODO: figure out the type for the evidence factory. */

