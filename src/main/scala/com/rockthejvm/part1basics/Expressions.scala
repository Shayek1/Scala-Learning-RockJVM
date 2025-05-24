package com.rockthejvm.part1basics

object Expressions {

  //expressions are structures that can be evaluated to a value
  val meaningOfLife = 40 + 2

  //mathematical expressions: +, -, *, /, bitwise |, &, <<, >>, >>>
  val mathExpression = 2 + 3 * 4

  //comparison expressions: <, <=, >, >=, ==, !=
  val equalityTest = 1 == 2

  //boolean expressions: ! (negation), || (logical or), && (logical and)
  val nonEqualityTest  = !equalityTest

  //instructions vs expressions
  //expressions are evaluated, instructions are executed
  //we think in terms of expressions

  //ifs are expressions
  val aCondition = true
  val anIfExpression = if (aCondition) 45 else 99

  //code blocks - codeblocks will always print out the last line
  val aCodeBlock = {
    // local values
    val localValue = 78
    localValue + 2
    localValue + 54
  }

  //everything is an expression

  /**
   * Exercise:
   * Without running the code, what do you think these values will print out?
   */

  // 1
  val someValue = {
    2 < 3
  }

  // 2
  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }

  // 3
  val yetAnotherValue = println("Scala")


  def main(args: Array[String]): Unit = {

    println(someValue) // true
    println(someOtherValue) // 42
    println(yetAnotherValue) // It will print Scala, ()
  }
}
