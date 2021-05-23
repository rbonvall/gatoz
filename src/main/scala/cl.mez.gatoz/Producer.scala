package cl.mez.gatoz

import scala.language.higherKinds

trait Producer[P[_]]:
  def post[Output, After](producer: P[Output], transform: Output => After): P[After]


object Producer:
  def of[P[_]: Producer] = summon[Producer[P]]


extension [P[_]: Producer, O](p: P[O])
  def post[A](f: O => A) =
    Producer.of[P].post(p, f)
