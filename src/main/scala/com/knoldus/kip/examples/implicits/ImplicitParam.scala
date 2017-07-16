package com.knoldus.kip.examples.implicits

class ImplicitParam {

  def add(second: Int)(implicit first: Int) = {
    first + second
  }

  def mul(second: Int)(implicit first: Int) = {
    first * second
  }

  def deduct(second: Int)(implicit first: Int) = {
    first - second
  }


}

trait ImplicitParamApplication {

  implicit val first: Int = 10

  val calculator = new ImplicitParam

  println(calculator.add(5))
  println(calculator.mul(5))
  println(calculator.deduct(5))

}
