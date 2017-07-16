package com.knoldus.kip.examples.implicits


class ImplicitConversion {
  implicit def Str2Doubler(x: String) = x.toDouble
}

trait ImplicitCoversionApplication{
  val converter = new ImplicitConversion
  import converter._

  def calculate(dou: Double) = dou * 2.5

  println(calculate("5"))
}
