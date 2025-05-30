package com.rockthejvm.part3fp

import scala.util.Random
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
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException("No string for you my friend"))
  def betterBackupMethod(): Try[String] = Success("Scala")
  val stringLengthPureV2 = betterUnsafeMethod().map(_.length)
  val aSafeChain = betterUnsafeMethod().orElse(betterBackupMethod())

  /**
   * Exercise
   * 1. obtain a connection
   * 2. then fetch the url
   * then print the resulting HTML
   */


  val host = "localhost"
  val port = "8081"
  val myDesiredURL = "rockthejvm.com/home"

  class Connection {
    val random = new Random()

    def get(url:String): String = {
      if (random.nextBoolean()) "<html>Sucess</html>"
      else throw new RuntimeException("Cannot fetch page right now")
    }
  }

  object HttpService {
    val random = new Random()

    def getConnection(host:String, port:String): Connection =
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Cannot access host/port combination.")
  }

  //Attempt:
  val grabConnect = Try(HttpService.getConnection(host, port))
  val grabHtml = grabConnect.flatMap(conn => Try(conn.get(myDesiredURL)))
  val attemptAnswer = grabHtml.fold(e => s"<html>${e.getMessage}</html>", s => s)
  

  def main(args: Array[String]): Unit = {
    println(aTestOfTry)
    println(checkSuccess)
    println(checkFail)
    println(attemptAnswer)






  }
}
