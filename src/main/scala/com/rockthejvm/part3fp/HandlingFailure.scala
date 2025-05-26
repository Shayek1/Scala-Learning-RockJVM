package com.rockthejvm.part3fp

import scala.util.Try
import scala.util.Success
import scala.util.Failure

object HandlingFailure {

  //Try - it is a type used to represent a computation that may fail or succeed
  val aTry: Try[Int] = Try(45)
  val failTry: Try[Int] = Try(throw new RuntimeException) //will not give an error

  val aTestOfTry: Try[Int] = Try(45/6)

  //alternate ways of try: Success and Failure are the two types of try
  val aTryV2: Try[Int] = Success(45)
  val failTryV2: Try[Int] = Failure(new RuntimeException())

  //how to check if it is a success or failure
  val checkSuccess = aTestOfTry.isSuccess
  val checkFail = aTestOfTry.isFailure

  //try can have map, flatMap, filter





  def main(args: Array[String]): Unit = {
    println(aTestOfTry)
    println(checkSuccess)
    println(checkFail)






  }
}
