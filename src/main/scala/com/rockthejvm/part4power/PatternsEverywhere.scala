package com.rockthejvm.part4power

object PatternsEverywhere {

  // big idea 1
  val potentialFail = try{
    //our code in here
  }catch{ //they are matches
    case e: RuntimeException => "runtime exception"
    case npe: NullPointerException => "npe"
    case _=> "some other exception"
  }

  //big idea 2
  val aList = List(1, 2, 3, 4)
  val evenNumbers = for { //based of pattern matching too
    n <- aList if n % 2 == 0
  } yield 10 * n

  val tuples = List((1, 2), (3, 4))
  val filterTuples = for {
    (first, second) <- tuples if first < 3
  } yield second * 100

  // big idea 3: new syntax
  val aTuple = (1, 2, 3)
  val (a, b, c) = aTuple


  val head :: tail = tuples


  def main(args: Array[String]): Unit = {

  }

}
