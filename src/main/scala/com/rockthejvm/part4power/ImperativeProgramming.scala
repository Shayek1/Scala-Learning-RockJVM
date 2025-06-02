package com.rockthejvm.part4power

object ImperativeProgramming {

  val meaningOfLife = 23 //val - cant be changed after declared

  var aVar = 55 // var - can be changed after declared

  //there is no ++ , must use +=

  aVar += 10 // means aVar = aVar + 10

  //loops
  def loopTest(): Unit = {
    var i = 0
    while (i < 10) {
      println(s"Counter at $i")
      i += 1
    }
  }

   //imperative programming makes debugging hard
   // should not use for no reason, scala is not for that purpose
  /* where I P is useful
  when using performance critical applications
  interactions with java libraries
   */

  def main(args: Array[String]): Unit = {

  }

}
