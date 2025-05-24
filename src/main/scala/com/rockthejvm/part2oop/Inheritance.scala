package com.rockthejvm.part2oop

object Inheritance {

  class animal {
    val creatureType = "wild"
    def eat(): Unit = println("nomnomnom")
  }

  class Cat extends animal {
    def crunch() ={
      eat()
      println("crunch crunch")
    }

  }
  val cat = new Cat

  class Person(val name: String, age: Int ) { //primary constructor
    def this(name:String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name) // must specify the super constructor



  //overriding
  class dog extends animal{
    override val creatureType: String = "domestic"
    override def eat(): Unit = println("Oooh me like the food")

    //popular overridable method
    override def toString: String = "a dog" //overrides dog instance into the string
  }

  //subtype polymorphism - create val/var of a declared type
  val dog: animal = new dog


  //overloading vs overriding
  class crocodile extends animal{
    override val creatureType: String = "very wild"
    override def eat(): Unit = println("I eat what I eat cause I a croc. ")

    //overloading: multiple methods with same name, diff signatures
    //diff signatures: diff args list + diff return type(optional)
    def eat(Animal:animal): Unit = println("I eat this animal cause it food to me.")
    def eat(dog: dog): Unit = println("me eat dog")
    //def eat(): Int = 45 is not a correct overload
  }


  def main(args: Array[String]): Unit = {
    //dog.eat()
    //cat.crunch()
    //println(dog) //same as println(dog.toString)

    val croc = new crocodile
    val dan = new Person("Danny", 47)
    //croc.eat(dog)
  }
}
