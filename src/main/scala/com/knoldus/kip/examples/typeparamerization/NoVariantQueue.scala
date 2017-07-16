package com.knoldus.kip.examples.typeparamerization

class NoVariantQueue[T](//Non variant , Invariant
                        private val leading: List[T],
                        private val trailing: List[T]
                         ) {
  override def toString = leading.toString
}


trait NoVariantQueueApplication{
  //Non variant when only T
    val dq: NoVariantQueue[Abc] = new NoVariantQueue[Abc](List(new Abc {}), Nil)
    val dq1: NoVariantQueue[Bbc] = new NoVariantQueue[Bbc](List(new Bbc {}), Nil)
    val dqC: NoVariantQueue[Abc] = dq //Works
//    val dqC: NoVariantQueue[Abc] = dq1 //Doesn't works
//    val dqC: NoVariantQueue[Bbc] = dq //Doesn't works
  //
  // Non variant ends

}