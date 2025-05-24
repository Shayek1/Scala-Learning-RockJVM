package com.rockthejvm.part2oop

object Objects {
  
  object MySingleton{ // type + the only instance of this type
   val aField = 45
   def aMethod(x: Int) = x + 1
  }
  
  val theSingleton = MySingleton
  val anotherSingleton = MySingleton
  val isSomeSingleton = theSingleton == anotherSingleton // will be true
  //objects can have fields and methods
  val theSingletonField = MySingleton.aField
  val theSingletonMethodCall = MySingleton.aMethod(99)
  
  class Person(name: String) {
    def sayHi(): String = s"Hi, my name is $name"
  }
  
  //companions = class + object with the same name in the same file
  object Person { //companion object
    // can access each other's private fields and methods
    val N_EYES = 2
    def canFly(): Boolean = false
  }
  
  //methods and fields in classes are used for instance dependent functionality
  val mary = new Person("Mary")
  val mary_v2 = new Person("Mary")
  val marysGreeting = mary.sayHi()
  mary == mary
  
  //equality
  //1 - equality of reference - usually defined as ==
  val someMary = mary eq mary_v2 // will be false
  val someSingleton = MySingleton eq MySingleton // true
  //2 - equality of sameness - in Java defined as.equals
  val someMary_v2 = mary equals mary_v2
  val someMary_v3 = mary == mary_v2 // same as equals - will be false
  val someSingleton_v2 = MySingleton == MySingleton // true
  
  //objects can extend classes
  object BigFoot extends Person("Big Foot")

// scala application = object + def main(args: Array[String]): Unit 
  def main(args: Array[String]): Unit = {
    
  }
}
