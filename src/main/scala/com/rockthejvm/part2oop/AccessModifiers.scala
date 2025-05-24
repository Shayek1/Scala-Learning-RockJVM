package com.rockthejvm.part2oop

object AccessModifiers {



  class Person(val name: String) {
    protected def sayHi(): String = s"Hi, my name is $name" //ctrl + space to auto s interpolate
    private def watchNetflix(): String = "I am binge watching"
  }
// protected == restricts the def to only inside class + children classes
// private == can only be used in the parent class  
  class Kid(override val name: String, age: Int) extends Person(name){
    def greetPolitely(): String =
      sayHi() + " and I love to play"
  }
  
  val aPerson = new Person("Alice")
  val aKid = new Kid("Joe", 3)
  
  //complication
  class kidWithParents(override val name: String, age: Int, mumName: String, dadName: String) extends Person(name){
    val mum = new Person(mumName)
    val dad = new Person(dadName)
    
    //def everyoneSayHi(): String = 
     // s"Hi, I'm $name, and here are my parents:" + mum.sayHi() + dad.sayHi() //illegal
  }

  def main(args: Array[String]): Unit = {

   // println(aPerson.sayHi())
  }

}
