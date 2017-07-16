package com.knoldus.kip.examples.typeparamerization

//Lower bound.
class LowerQueue[+T](//covariant
                     private val leading: List[T],
                     private val trailing: List[T]
                      ) {
  override def toString = leading.toString

  def enqueue[U >: T](x: U) = new LowerQueue[U](leading, x :: trailing)
}


trait LowerQueueApplication{
  //Lower bound
  val lowerQueueA: LowerQueue[Bbc] = new LowerQueue[Bbc](List(new Bbc {}), Nil)
  val enquedB: LowerQueue[Abc] = lowerQueueA.enqueue(new Cbc {})
  //
  //Lower bound endes
}