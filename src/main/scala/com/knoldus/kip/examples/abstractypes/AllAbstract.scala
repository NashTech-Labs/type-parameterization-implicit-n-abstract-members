package com.knoldus.kip.examples.abstractypes

trait AllAbstract {

  val i: Int   //Abstract vals
  var r: Int   //Abstract vars
  type T

  def transform(x: T): T

  type Alphabet <: Abcd

  def speak(some: Alphabet): T

  lazy val valVarSum = i + r

}


trait Abcd

case class Xyz(id: Long) extends Abcd

/**
 * Show by generating in idea
 */
class AllImplementation extends AllAbstract{
  override val i: Int = 5
  override var r: Int = 6

  override type T = String
  override def transform(x: String): String = "Transforming ..... " + x

  override type Alphabet = Xyz

  override def speak(some: Xyz): String = "Well its " + some.id
}

trait AllAbstractApplicatioin{
  val allImpl = new AllImplementation
  println(allImpl.transform("Pranjut"))
  println(allImpl.speak(Xyz(50)))
}