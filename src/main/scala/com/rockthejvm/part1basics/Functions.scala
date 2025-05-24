package com.rockthejvm.part1basics

object Functions {
  
  //Function – reusable piece of code that you can invoke with some arguments and returns a result
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  } // one expression

  //function Invocation
  val aFunctionInvocation = aFunction("Scala", 9999999)

  //two styles of functions with no argument
  def aNoArgFunction(): Int = 45
  def aParameterlessFunction: Int = 87

  //functions can be recursive (meaning a function can invoke/call itself in its definition)

  def stringConcatenation(str: String, n: Int): String = {
    if (n == 0) " "
    else if (n == 1) str
    else str + stringConcatenation(str, n -1)
  }

  val scalax3 = stringConcatenation("Scala", 3)
  // when loops needed, use RECURSION

  //"void" functions - functions that provide side effects without returning any meaningful value
  def aVoidFunction(aString: String): Unit = //unit is needed for void functions
    println(aString)

  def computeDoubleStringWithSideEffect(aString: String): String = {
    aVoidFunction(aString) // Unit
    aString + aString // the meaningful value
  } //avoid running side effects, they are discouraging

  def aBigFunction(n: Int): Int = {
    //small, auxiliary functions inside
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n + 1)
  }

  /**
   * Exercises:
   * 1. A greeting function (name, age) => "Hi my name is $name, and I am $age years old."
   * 2. Factorial function n => 1 * 2 * 3 * ... * n
   * 3. Fibonacci function
   *  fib(1) = 1
   *  fib(2) = 1
   *  fib(3) = 1 + 1
   *  fib(n) = fib(n-1) + fib(n-2)
   *
   * 4. Tests if a number is prime
   **/
  //1.
  def greetingFunction(name: String, age: Int): String = {

    "Hi my name is " + name + " and I am " + age + " years old."
  }


  //2.

  def factorialFunction(n: Int): Int ={
    if (n <= 0) 0
    else if (n == 1) 1
    else n * factorialFunction(n - 1)
  }

  //3.
  def fibonacci(n: Int): Int = {
    if (n <= 0) 0
    else if (n <= 2 ) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

   //4. Test if a number is prime
  // a prime is a number with factors of only itself and 1

  def prime(n: Int): Boolean = {
    def primeUntil(p: Int): Boolean = {
      if (p <= 1) true
      else n % p != 0 && primeUntil(p - 1)
    }

    primeUntil(n / 2)
  }

  def main(args: Array[String]): Unit = {
    //println(greetingFunction("Bob", 78)) //1 answer
    //println(factorialFunction(5)) //2 answer
    //println(fibonacci(7)) //3 answer
    println(prime(68)) //4 answer
  }
}
