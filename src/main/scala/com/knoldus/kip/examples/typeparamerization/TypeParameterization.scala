package com.knoldus.kip.examples.typeparamerization

//Information Hiding
class Queue[T] private(
                        private val leading: List[T],
                        private val trailing: List[T]
                        ) {
  def enqueue(x: T) = new Queue(leading, x :: trailing)

  override def toString = leading.toString
}

object Queue {
  def apply[T](xs: T*) = new Queue[T](xs.toList, Nil)
}


trait Abc

class Bbc extends Abc

class Cbc extends Abc
