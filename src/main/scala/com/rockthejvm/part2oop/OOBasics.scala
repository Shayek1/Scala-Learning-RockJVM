package com.rockthejvm.part2oop

//import scala.compiletime.ops.any.==

object OOBasics {

  class Person(val name: String, age: Int) { //constructor signature
    //fields
    val allCaps = name.toUpperCase()

    //methods
    def greet(name: String): String =
      s"${this.name} says: Hi, $name"


    //signature differs
    // OVERLOAD
    def greet(): String =
      s"Hi, everyone, my name is $name"

    /** //aux constructor
      def this(name: String) =
        this(name, 0)



      def this() =
        this("Jane Doe") **/

  }


  val aPerson: Person = new Person("Bob", 26)
  val bob = aPerson.name // class parameter != field
  val bobSayHiToDaniel = aPerson.greet("Daniel")
  val bobSaysHi = aPerson.greet()

  //val genericPerson = new Person() // u can use this when you want to use default arguments

  /**
  Exercise 1: imagine we're creating a backend for a book publishing house.
  Create a Novel and a Writer class.

  Writer: first name, surname, year
    - method fullname

  Novel: name, year of release, author
    - authorAge
    - isWrittenBy(author)
    - copy(new year of release) = new instance of Novel
  **/

  class Writer(firstname: String, surname: String, val dob: Int ) {
    def fullname(): String = s"$firstname $surname"
  }

  class Novel( name: String, yearOfRelease: Int, author: Writer ) {
    def authorAge(): Int = yearOfRelease - author.dob
    def isWrittenBy(author:Writer): Boolean = this.author == author
    def copy(newYearOfRelease: Int): Novel = new Novel(this.name, newYearOfRelease, this.author)
  }


  /**
   * Exercise #2: an immutable counter class
   * - constructed with an initial count
   * - increment/decrement => NEW instance of counter
   * - increment(n)/decrement(n) => NEW instance of counter
   * - print()
   */

    class counter(count: Int = 0) {
    def increment: counter = counter(count + 1)
    def decrement: counter = counter(count - 1)
    def increment(n:Int): counter = counter(count + n)
    def decrement(n: Int): counter = counter(count - n)
    def print(): Unit = println(s"The Current count is: $count")





  }



  def main(args: Array[String]): Unit = {
 
    /* exercise 1
    val HarryM = new Writer("Harry", "Meharri", 2000)
    val MeganB = new Writer("Megan", "Beatrice-Smith", 1997)
    val chillingTales = new Novel("The Chilling Tales of Mr H", 2025, HarryM)
    val dangerous = new Novel("Dangerous", 2025, MeganB)
    println(HarryM.fullname())
    println(chillingTales.isWrittenBy(MeganB))
    println(chillingTales.authorAge())
    println(dangerous.copy(2028).authorAge())
    println(chillingTales.copy(2028).authorAge()) */

  }

}
