package com.rockthejvm.part4power

import scala.util.Random

object PatternMatching {

  //switch case on steroids
  val random = new Random()
  val aValue = random.nextInt(100)

  val description = aValue match{
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => "some other thing"
  }



  def main(args: Array[String]): Unit = {



  }

}
