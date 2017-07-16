package com.knoldus.kip.examples.typeparamerization

trait UpperQueue{

  def isOk(input: String): Boolean

}

trait UpperQueueTrue extends UpperQueue {
  def isOk(input: String): Boolean
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


  //  def isLowerUpperMixWorks[T >: UpperQueueTrue](qs: List[T], input: String) = qs.map(_.isOk(input)) //Doesn't work
  def isLowerUpperMixWorks[T >: UpperQueueTrue <: UpperQueue](qs: List[T], input: String) = qs.map(_.isOk(input)) //Works
//    println(isLowerUpperMixWorks(List(uqt,uqf), "ok")) //Works
//    println(isLowerUpperMixWorks(List(uqt,uqf, greedy), "ok")) //Works

}
