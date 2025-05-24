package com.rockthejvm.part2oop

object CaseClasses {


  case class Person(name: String, age: Int)

  val daniel = new Person("Daniel", 99)
  val danielAge = daniel.age

  val danielToString = daniel.toString

  val danielYoung = daniel.copy (age = 33)

  val thePersonSingleton = Person
  val daniel_v2 = Person.apply("Daniel", 99)


  def main(args: Array[String]): Unit = {

  }

}
