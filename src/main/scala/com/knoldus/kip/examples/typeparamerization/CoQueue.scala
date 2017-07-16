package com.knoldus.kip.examples.typeparamerization

//Covariant
class CoQueue[+T](//covariant
                  private val leading: List[T],
                  private val trailing: List[T]
                   ) {
  override def toString = leading.toString
}


trait CoQueueApplication {
  //Covariant when +T
     val dq: CoQueue[Abc] = new CoQueue[Abc](List(new Abc {}), Nil)
     val dq1: CoQueue[Bbc] = new CoQueue[Bbc](List(new Bbc {}), Nil)
     val dqCSame: CoQueue[Abc] = dq //Works
     val dqCSub: CoQueue[Abc] = dq1 //Works
//     val dqCSuper: CoQueue[Bbc] = dq //Doesn't work
  //
  //covariant ends
}