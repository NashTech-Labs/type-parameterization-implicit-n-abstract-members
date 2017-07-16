package com.knoldus.kip.examples.typeparamerization

//Mixture of Covariant and Contravariant
class CoContraQueue[-S, +T] {
  def write(x: S): T = {
    x match {
      case res: T => res
    }
  }
//  def write(x: T): S

}

trait Identifier{
  def id : Long
}

trait ModelIdentifier extends Identifier{
  def id : Long
}

case class Student(id: Long) extends ModelIdentifier


trait CoContraApplication {
//  val coContra = new CoContraQueue[Abc, Bbc] {}
//  println(coContra.write(new Bbc))

//  val coContra = new CoContraQueue[ModelIdentifier, Student] {}
  val coContra = new CoContraQueue[Identifier, Student] {}
  val identifier: Identifier = Student(7L)
  println(coContra.write(Student(5L)))
  println(coContra.write(identifier))


}