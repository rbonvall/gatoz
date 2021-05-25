package cl.mez.gatoz

import scala.language.higherKinds

trait Consumer[C[_]]:
  def pre[Before, Input](consumer: C[Input], transform: Before => Input): C[Before]


object Consumer:
  def of[C[_]: Consumer] = summon[Consumer[C]]


extension [C[_]: Consumer, I](c: C[I])
  def pre[B](f: B => I) =
    Consumer.of[C].pre(c, f)
