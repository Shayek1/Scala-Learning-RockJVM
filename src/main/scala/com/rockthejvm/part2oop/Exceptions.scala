package com.rockthejvm.part2oop

object Exceptions {
  //special instances that can crash your application
  val aString: String = null
  //aString.length crashes with a NPE

  //1- How to throw your exceptions yourself and 2- how to recover from errors
  //1
  val aWeirdValue: Int = throw new NullPointerException // returns nothing

  //type throwable
  //  Error, e.g. SOError, OOMerror
  //  Exception (error in logic) e.g. NPException, NSEException

  def getInt(withExceptions: Boolean): Int = {
    if (withExceptions) throw new RuntimeException("No int for youuu")
    else 32

  }

  val potentialFail = try { //will wrap code
    //code that might fail
    getInt(true)
  } catch {
    //place most specific exceptions first
    case e: RuntimeException => 54
    case e: NullPointerException => 35
  } finally {
    // will reserve a piece of code that will be executed no matter what
    //closing resources
    //All Unit
  }

  //can define your own exceptions
  class MyException extends RuntimeException{
    override def getMessage: String = "MY EXCEPTION"
  }

  val myException = new MyException
  val throwingMyException = throw myException


  def main(args: Array[String]): Unit = {

  }

}
