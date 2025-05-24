package com.rockthejvm.part3fp

object MapFlatMapFilterFor {

  // standard list intro

  val aList = List(1,2,3) //[1] -> [2] -> [3] -> Nil
  val firstElement = aList.head
  val restOfElement = aList.tail

  //map
  val anIncrementedList = aList.map(_ + 1) //_ is shorthand not lambda for function1

  //filter
  val onlyOdd = aList.filter(_ % 2 != 0)

  //flatMap
  val toPair = (x:Int) => List(x, x + 1)
  val aFlatMappedList = aList.flatMap(toPair) //[1,2,2,3,3,4]

  //ex - find all possible combination '1a - black'
  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')
  val colours = List("black", "white", "red")

  val comboPairs = numbers.filter(_ % 2 == 0).flatMap(number => chars.flatMap(char => colours.map(colour => s"$number$char - $colour")))

  //for-comprehension - identical to flatMap + map chains
  val comboFor = for{
    number <- numbers if number % 2 == 0
    char <- chars
    colour <- colours
  } yield s"$number$char - $colour"

  //for-comprehensions with Unit
  //if foreach

  /**
   * exercises
   * 1/ LList supports for comprehensions?
   * 2. implement a small collection of AT MOST ONE element - Maybe[A]
   * -map
   * -flatmap
   * -filter
   * */


  def main(args: Array[String]): Unit = {
    numbers.foreach(println)
    for{
      num <- numbers
    }println(num)
    println(comboPairs)
    println(comboFor)

  }
}
