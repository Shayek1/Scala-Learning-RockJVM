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
  case class Cat(meowType: String) extends Animal
  
  val anAnimal: Animal = Dog("German Shepherd")
  val animalChecker = anAnimal match{
    case Dog(aBreed) => "This is a dog"
    case Cat(meow) => "This is a Cat"
  }

  /**
   * exercise
   * show(Sum(Number(2), Number(3))) = "2 + 3"
   * show(Sum(Sum(Number(2), Number(3)), Number(4))) = "2 + 3 + 4"
   * show(Prod(Sum(Number(2), Number(3)), Number(4))) = "(2 + 3) * 4"
   * show(Sum(Prod(Number(2), Number(3)), Number(4))) = "2 * 3 + 4
   *
   */

  sealed trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show(expr:Expr): String = expr match{ //compiler first checks if there it is just a number and then a Sum class.
    case Number(n) => s"$n"
    case Sum(a, b) => show(a) + " + " + show(b)
    case Prod(a, b) => {
      def prodPaths(x : Expr) = x match{ // this shows the different pattern cases that can happen after there is a prod class
        case Prod(a,b) => show(x) //first checks if it is in a prod class
        case Number(n) => show(x) //then if just number
        case Sum(a, b) => s"(${show(x)})" //if the numbers are in a sum
      }
      prodPaths(a) + " * " + prodPaths(b)
    }
  }


  def main(args: Array[String]): Unit = {
    println(show(Sum(Number(2), Number(3))))
    println(show(Sum(Sum(Number(2), Number(3)), Number(4))))
    println(show(Prod(Sum(Number(2), Number(3)), Number(4))))
    println(show(Sum(Prod(Number(2), Number(3)), Number(4))))



  }

}
