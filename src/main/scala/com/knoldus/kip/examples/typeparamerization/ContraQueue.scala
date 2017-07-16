package com.knoldus.kip.examples.typeparamerization

//Contravariant
class ContraQueue[-T] {
  def write(x: T) = println(x)

  def write = println("wrote")
}


trait ContraQueueApplication {
  //Contravariant when -T
    val contraQueueA: ContraQueue[Abc] = new ContraQueue[Abc]
    val contraQueueB: ContraQueue[Bbc] = new ContraQueue[Bbc]
    val contraCSame: ContraQueue[Abc] = contraQueueA //Works
//    val contraCSub: ContraQueue[Abc] = contraQueueB //Doesn't work
    val contraCSuper: ContraQueue[Bbc] = contraQueueA //Works
  //
  // Contravariance ends
}