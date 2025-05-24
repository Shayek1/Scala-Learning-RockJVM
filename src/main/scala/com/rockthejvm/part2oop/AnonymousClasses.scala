package com.rockthejvm.part2oop

object AnonymousClasses {

  abstract class Animal {
    def eat(): Unit
  }

  class SomeAnimal extends Animal{
    override def eat(): Unit = println("Me some animal")
  }

  val someAnimal = new SomeAnimal
  val someAnimal2 = new Animal{
    override def eat(): Unit = println("Me da weird animal")
  }


  class Person(name: String) {
    def sayHi(): Unit = println(s"Hi, my name is $name")
  }

  val jim = new Person("Jim"){
    override def sayHi(): Unit = println("MY NAME IS JIMBO BUT CALL ME JIM!")
  }
  def main(args: Array[String]): Unit = {
    
  }
}
