package com.rockthejvm.part1basics

object CBNvsCBV {
  //cbv - call by value: the arguments are executed before function invocation
  def aFunction(arg: Int): Int = arg + 1
  val aComputation = aFunction(6 +3 ) // so the 6 + 3 would be calculated first then the function is performed.

  // CBN - call by name: arguments are passed literally. Done by putting => in the bracket
  def aByNameFunction(arg: => Int): Int = arg + 1
  val anothCom = aByNameFunction(6 + 3)

  /** Recap:
   * Call by value: value is computed before call, same value used everywhere
   * Call by name:
   */
  def main(args: Array[String]): Unit = {

  }
}
