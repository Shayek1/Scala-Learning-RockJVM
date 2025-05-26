package com.rockthejvm.part3fp

import scala.util.Try
import scala.util.Success
import scala.util.Failure

object HandlingFailure {

  //Try - it is a type used to represent a computation that may fail or succeed
  val aTry: Try[Int] = Try(45)
  val failTry: Try[Int] = Try(throw new RuntimeException) //will not give an error

  val aTestOfTry: Try[Int] = Try(45/5)

  //alternate ways of try: Success and Failure are the two types of try
  val aTryV2: Try[Int] = Success(45)
  val failTryV2: Try[Int] = Failure(new RuntimeException())

  //how to check if it is a success or failure
  val checkSuccess = aTestOfTry.isSuccess
  val checkFail = aTestOfTry.isFailure

  //try can have map, flatMap, filter
  val flatMapTry = aTestOfTry.flatMap(mofl => Try(s"My meaning of life is $mofl"))
  val incerementTry = aTestOfTry.map(_ + 5)
  val filterTry = aTestOfTry.filter(_ % 5 == 0)

  //orElse
  val aChain = failTry.orElse(aTry)

  //Reason: use when an unsafe API or operation might throw an exception
  def unsafemethod(): String = throw new RuntimeException("No string for you my friend")

  //defensive method - try catch finally
  val stringLengthDef  = try {
    val aString = unsafemethod()
    aString.length
  } catch{
    case oops: RuntimeException => -1
  } // this code tries to get the length of unsafemethod but will return -1 if code throws runtime exception

  // pure functional try
  val stringLengthPure = Try(unsafemethod()).map(_.length).getOrElse(-1)

  //Designing an API
  def bettterUnsafeMethod(): Try[String] = Failure(new RuntimeException("No string for you my friend"))
  def betterBackupMethod(): Try[String] = Success("Scala")
  val stringLengthPureV2 = bettterUnsafeMethod().map(_.length)
  val aSafeChain = betterUnsafeMethod().orElse(betterBackupMethod())

  def main(args: Array[String]): Unit = {
    println(aTestOfTry)
    println(checkSuccess)
    println(checkFail)






  }
}
