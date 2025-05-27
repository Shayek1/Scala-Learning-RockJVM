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
    case _ => s"some other value $aValue "
  } //expression that returns a string
//if there's no match, u get match error

  //can decompose values - pattern matching only on cases classes
  case class Person(name: String, age:Int)
  val al = Person("Al", 65)

  //patterns match in sequence
  val greet = al match{
    case Person(n, a) if a < 18 => s"hi i'm $n and i'm $a years old" //if statement here is a guard
    case Person(n, a) => s"hello my name is $n"
    case _ => "who am i?"
  }

  //on a sealed hierarchy
  sealed class Animal
  case class Dog(breed:String) extends Animal


  def main(args: Array[String]): Unit = {



  }

}
