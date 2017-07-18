package com.knoldus.kip.examples.typeparamerization

trait SuperQueue{
  def isOk(input: String): Boolean
}

class SuperImpl extends SuperQueue{
  override def isOk(input: String): Boolean = input == "ok"
}

trait UpperQueue extends SuperQueue{

  def isOk(input: String): Boolean

}

trait UpperQueueTrue extends UpperQueue {
  def isOk(input: String): Boolean
}

trait LowestQueue extends UpperQueueTrue{
  def isOk(input: String): Boolean
}

class LowestImpl extends SuperQueue{
  override def isOk(input: String): Boolean = input == "ok"
}

class UpperQueueTrueImpl extends UpperQueueTrue {
  override def isOk(input: String) = input == "ok"
}

class UpperQueueFalseImpl extends UpperQueueTrue {
  override def isOk(input: String) = input == "NotOk"
}

class GreedyQueueImpl extends UpperQueue {
  override def isOk(input: String) = input == "whatever"
}

trait UpperQueueApplication {

  val uqt = new UpperQueueTrueImpl()
  val uqf = new UpperQueueFalseImpl()
  val uqf2: UpperQueue = new UpperQueueFalseImpl()
  val greedy = new GreedyQueueImpl()
  def isUpperQueueReallyOk[T <: UpperQueueTrue](qs: List[T], input: String) = qs.map(_.isOk(input))
//  println(isUpperQueueReallyOk(List(uqt,uqf), "ok")) //Works
//  println(isUpperQueueReallyOk(List(uqt,uqf, greedy), "ok")) //Doesn't work
//  println(isUpperQueueReallyOk(List(uqt,uqf2), "ok")) //Doesn't Works


  val lowest = new LowestImpl
  val superIm = new SuperImpl
  //  def isLowerUpperMixWorks[T >: UpperQueueTrue](qs: List[T], input: String) = qs.map(_.isOk(input)) //Doesn't work
  def isLowerUpperMixWorks[T >: UpperQueueTrue <: UpperQueue](qs: List[T], input: String) = qs.map(_.isOk(input)) //Works
//    println(isLowerUpperMixWorks(List(uqt,uqf), "ok")) //Works
//    println(isLowerUpperMixWorks(List(uqt,uqf, greedy), "ok")) //Works
//      println(isLowerUpperMixWorks(List(superIm))) //Doesn't work
//      println(isLowerUpperMixWorks(List(lowest))) //Doesn't work
}
