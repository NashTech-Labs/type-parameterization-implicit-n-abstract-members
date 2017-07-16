package com.knoldus.kip.examples.implicits

object ImplicitClass {

  implicit class Converter(x: Int){
    def greaterThan(y: Int) = x > y
  }

  implicit class IntWithTimes(x: Int) {
    def times[A](f: => A): Unit = {
      def loop(current: Int): Unit =
        if(current > 0) {
          f
          loop(current - 1)
        }
      loop(x)
    }
  }

  implicit class AverageCalculator(x: HighestMark) {
    def average(y: LowestMark) = AverageMark((x.mark + y.mark)/2)
  }
}

case class HighestMark(mark: Double)
case class LowestMark(mark: Double)
case class AverageMark(mark: Double)


trait ImplicitClassApplication {
  import ImplicitClass._

  println(5 greaterThan 6)
  println(5 greaterThan 2)

  5 times println("Hi")

  val high = HighestMark(55.5)
  val low = LowestMark(5.5)

  val result = high average low
  println(result)
}
