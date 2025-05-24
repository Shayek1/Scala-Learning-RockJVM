package com.rockthejvm.part2oop

import scala.language.postfixOps
  object MethodNotation {



    class Person( val name: String, val age: Int, val favouriteMovie: String) {
      infix def likes(movie: String): Boolean =
        movie == favouriteMovie

      infix def +(person: Person): String =
        s"${this.name} is hanging out with ${person.name}"


      // prefix position
      // unary ops: + - ~ !
        // unary ops must not have any brackets or args
      def unary_- : String =
        s"${this.name}'s alter ego'"

      //postfix position - doesn't need arguments or anything - discouraged
      def isAlive: Boolean = true

      //apply() is special, doesnt need infix to use it like writing a sentence.
      def apply(): String =
        s"Hi, my name is $name and my favourite move is $favouriteMovie!"

      // Exercises
      // 1. a + operator on the Person class that returns a person with a nickname
      //    mary + "the rockstar" => new Person("Mary the rockstar", ... , ...)

      // 2. a UNARY + operator that increases the person's age
      //    +mary => new Person(_, age + 1, _)

      // 3. an apply method with an int argument
      //    mary.apply(2) => "Mary watched Inception 2 times"


      //1.
      infix def +(nickname: String): Person = {
        new Person(s"$name $nickname", age, favouriteMovie)
        //println(s"${this.name} $nickname")
      }

        //2.
      infix def unary_+ : Person = new Person(name, age + 1 , favouriteMovie)

        //3.
        def apply(x: Int): String = s"$name watched $favouriteMovie $x times."

    }

    val joseph = new Person("Joseph Joestar", 54, "Shawshank Redemption")
    val jojo = new Person("Johnathan Joestar", 54, "Jaws")





    def main(args: Array[String]): Unit = {
      //println(jojo.likes("Jaws"))
      //infix notation - no need to add . and can write like a sentence - for methods with only ONE argument
      //println(jojo likes "Jaws") //identical to jojo.likes etc

      //operator = plain method with that name
      //println(jojo ++ joseph)
      //println(-jojo)
      //println(jojo isAlive)

      //1.
      val jojoNick = jojo + "the Great"
      println(jojoNick.name)

      //2.
      println((+jojo).age)
      /** remember to put the unary and person in brackets together
       so the .age recognises the new age and not the old one */

      //3.
      println(jojo apply(3))
    }
  }
