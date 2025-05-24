package com.rockthejvm.part1basics

import scala.annotation.tailrec

object Recursion {

  //Recursion is basically repetition

  def sumUntilTail(n: Int): Int = {
    def sumUntilTailRec(x: Int, accumulator: Int): Int = {
      if (x <= 0) accumulator
      else sumUntilTailRec(x -1, accumulator + x)
    }

    sumUntilTailRec(n, 0)
  }
    // need two numbers, it will calc the sum of the numbers between
  def sumNumBet(a: Int, b: Int): Int = {
    if (a > b) 0
    else a + sumNumBet(a + 1, b)
  }

  /** sb(5,9) = 5 + sb(6,9)
   * sb(6,9) = 6 + sb(7,9)
   * sb(7,9) = 7 + sb(8,9)
   * sb(8,9) = 8 + sb(9,9)
   * db(9,9) = 9 + sb(10,9)
   * db(10,9) = 0
   */
  def sumNumbersBetween(a: Int, b: Int): Int = {
    def sumNBTail(current: Int, counter: Int): Int =
      if (current > b) counter
      else  sumNBTail(current + 1, current + counter)

    sumNBTail(a,0)

  }


  /**
   * Exercises
   * 1. Concatenate a string n times
   * 2. Fibonacci function, tail recursive
   * 3. Is Prime function tail recursive or not?
   */

  //1.

  def stringConcatenate(m: String, n: Int): String ={
    def stringTail(remain: Int, o: String): String =
      if (remain <= 0) o
      //else if (n >= 0) o
      else stringTail( remain - 1, o + m)

    stringTail(n , "")



  }

  //2. Fibonacci function, tail recursive

  //  def fibonacci(n: Int): Int = {
  //    if (n <= 0) 0
  //    else if (n <= 2 ) 1
  //    else fibonacci(n - 1) + fibonacci(n - 2)
  //  }


   def fibonacciTail(a: Int): Int = {
     def fiboTailRec(b: Int, last: Int, previous: Int): Int ={
       if (b >= a) last
       else fiboTailRec(b + 1, last + previous, last  )


     }
     if (a <= 2) 1
     else fiboTailRec(2, 1, 1)
   }



  def main(args: Array[String]): Unit = {
    //println(sumUntilTail(5))
    //println(sumNumBet(5,9))
    //println(sumNumbersBetween(5,9))
    //println(stringConcatenate("hello", 5))
    println(fibonacciTail(5))


  }

}


