package com.rockthejvm.part3fp

object AnonymousFunctions {

  val doubler: Int => Int = new Function1[Int, Int]{
    override def apply(x: Int): Int = x * 2
  }

  //lambdas = anonymous function instances
  val doublerV2: Int => Int = (x:Int) => x * 2 //identical to doubler
  val adder: (Int, Int) => Int = (x: Int, y: Int) => x + y

  //zero-arg functions
  val justDoSomething: () => Int = () => 45
  val anInvocation = justDoSomething()


  //alt syntax with curly braces
  val stringToInt = {(str: String) =>
    //implementation
    str.toInt
  }

  val stringToInBoring = (str: String) => {
    //code block
  }

  //type inference
  val doublerV3: Int => Int = x => x * 2
  val adderV2: (Int, Int) => Int = (x, y) => x + y

  //shortest lambdas
  val doublerV4: Int => Int = _ * 2 // same as x => x * 2
  val adderV3: (Int, Int) => Int = _ + _ //(x,y) => x + y
  //each underscore is a different argument, you cant reuse them

  /**
   * ex:
   * 1. Replace all FunctionN instantations with lambdas in LList implementation
   * 2. rewrite the special adder from WhatsAFunction using lambdas
   * @param args
   */


  def main(args: Array[String]): Unit = {
    println(justDoSomething) //as if you're printing function0
    println(justDoSomething()) //WILL PRINT 45

  }
}
