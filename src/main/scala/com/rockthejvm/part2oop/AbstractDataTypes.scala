package com.rockthejvm.part2oop

object AbstractDataTypes {

  abstract class Animal { // class can have members or methods without any implementations
    val creatureType: String
    def eat(): Unit
    //non-abstract methods/fields are allowed
    def preferredMeal: String = "anything" //"accessor methods"
  }

  //abstract classes can't be instantiated
  //val anAnimal = new Animal

  //non-abstract classes must implement the abstract fields/methods
  class Dog extends Animal{
    override val creatureType = "domestic"

    override def eat(): Unit = println("munchin the bone")
    //overriding is legal for everything
    override val preferredMeal: String = "bones" //overriding accessor method with a field
  }

  val aDog: Animal = new Dog

  // traits - datatype that describes a behaviour
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class TRex extends Carnivore{ //Scala 3 - traits can have constructor args
    override def eat(animal:Animal): Unit = print("Me T-Rex, me eat animals" )
  }
  //practical
  //one class inheritance
  //multiple traits inheritance

  trait ColdBlooded
  class Crocodile extends Animal with Carnivore with ColdBlooded{
    override val creatureType: String = "croc"

    override def eat(): Unit = println("Me croc, me crunch")

    override def eat(animal: Animal): Unit = println("croc eating animal")
  }


  def main(args: Array[String]): Unit = {

  }
}
