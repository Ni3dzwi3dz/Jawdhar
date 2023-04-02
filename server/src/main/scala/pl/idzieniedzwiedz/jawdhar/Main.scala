package pl.idzieniedzwiedz.pl.jawdhar

import cats.effect.{IO, IOApp}

object Main extends IOApp.Simple:
  val run = JawdharServer.run[IO]

  val aNumber = 3
  val three: 3 = 3

  def passNumber(n: Int) = println(n)
  passNumber(aNumber)
  passNumber(three)

