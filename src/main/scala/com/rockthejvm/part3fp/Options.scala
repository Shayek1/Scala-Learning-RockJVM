package com.rockthejvm.part3fp

object Options {

  //options - "collections" with at most 1 val
  val anOption: Option[Int] = Option(42)
  val anEmptyOption: Option[Int] = Option.empty


  val aPresentValue: Option[Int] = Some(4)
  val anEmptyOptionV2: Option[Int] = None

  //why options?: work with unsafe API
  def unsafeMethod(): String = null

  //defensive style
  val stringLength = {
    val potentialString = unsafeMethod()
    if(potentialString == null) -1
    else potentialString.length
  }

  //option-style - no need for null checks
  val stringLengthOption = Option(unsafeMethod()).map(_.length)

  def main(args: Array[String]): Unit = {

  }
  
}
