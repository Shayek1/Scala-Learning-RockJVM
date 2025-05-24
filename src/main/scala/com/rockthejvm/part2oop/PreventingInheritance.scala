package com.rockthejvm.part2oop

object PreventingInheritance {
  
  class Person(name: String) {
    final def enjoyLife(): Int = 42
  }
  //final == locks the method so that it cannot be overriden
  class Adult(name: String) extends Person(name){
    //override def enjoyLife() = 999 // cant override final method
  }

  //if you dont want a class to be inherited, put final method in front of the class

  //sealing a type hierarchy - inheritance only permitted inside this file
  sealed class Guitar(nStrings: Int)
  class ElectricGuitar(nStrings: Int) extends Guitar(nStrings)
  class AccousticGuitar extends Guitar(6)
  
  // no modifier = "not encouraging" inheritance
  //not mandatory but good practice
  open class ExtensibleGuitar(nStrings: Int) //open - specifically marked for extension
  
  def main(args: Array[String]): Unit = {
    
  }
}
