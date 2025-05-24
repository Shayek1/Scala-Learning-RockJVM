package com.rockthejvm.part3fp

object WhatsAFunction {

  //FP: functions are "first-class" citizens
  // JVM

  trait MyFunction[A, B] {
    def apply(arg: A): B
  }

  val doubler = new MyFunction[Int, Int] {
    override def apply(arg: Int): Int = arg * 2
  }

  val meaningOfLife = 23
  val meaningDoubled = doubler(meaningOfLife) // doubler.apply(meaningOfLife)

  //function types
  val doublerStandard = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg * 2
  }
  val meaningDoubled_v2 = doublerStandard(meaningOfLife)

  val adder = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  val anAddition = adder(2,67)

  //all functions are instances of FunctionX with apply methods

// ex 1 - a function which takes 2 strings and concatenates them

  val stringConcat = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

// 2
  // yes, predicate[T] equivalent with Function1[T, Boolean] === T => Boolean
  // yes, Transformer[A, B] equivalent with Function1[A, B] === A => B

  //3
  val superAdder = new Function1[Int, Function1[Int, Int]]{
    override def apply(x: Int) = new Function1[Int, Int]{
      override def apply(y: Int): Int = x + y
    }
  }
  //currying
  val adder2 = superAdder(2)
  val anAdditionV2 = adder2(67)
  val anAdditionV3 = superAdder(2)(67)

  //function values not same as methods

  def main(args: Array[String]): Unit = {
    println(doublerStandard(2))
    println(stringConcat("Hi ", "Charlie")) // ex 1

  }
}
