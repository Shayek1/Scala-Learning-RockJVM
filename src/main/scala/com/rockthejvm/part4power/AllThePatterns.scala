package com.rockthejvm.part4power

import com.rockthejvm.practice.{Cons, Empty, LList}

object MySingleton

object AllThePatterns {

  //All the patterns we can use:

  //a. Constants
  val aVal: Any = "Scala" //compiler knows what type the code is
  val consts = aVal match{
    case 32 => "number"
    case "Scala" => "THE Scala"
    case true => "truth"
    case MySingleton => "a singleton object"
  }

  //b. Matching anything
  val matchAnyVar = aVal match{
    case something => s"I have matched anything, it is $something"
  }
  //the _ replaces something
  val matchAny = aVal match{
    case _ => "I can match anything, trust me" //case _ is the default case that matches with anything. Best to keep last
  }


  // c. tuples
  val aTuple = (1,5)
  val matchTuple = aTuple match{
    case (1, aThing) => s"A tuple with 1 and $aThing"
    case (anotherThing, 2) => "A tuple with 2 as its second field"
  }
  //Structures in pattern matching can be nested
  val nestedTuple = (1, (2, 3))
  val nestedTupleMatching = nestedTuple match{
    case(_,(2, n)) => "This is a nested tuple"
  }

  //d. case classes
  val aList: LList[Int] = Cons(1, Cons(2, Empty()))
  val listMatch = aList match{
    case Empty() => "empty list"
    case Cons(head, Cons(_, tail)) => s"a non empty list starting with $head"
  }
  //another case class example: Options!
  val anOpt: Option[Int] = Option(5)
  val matchOpt = anOpt match{
    case None => "empty option"
    case Some(value) => s"non empty, get$value"
  }

  //e. list patterns
  val aStandList = List(1,2,3,42)
  val matchStandList = aStandList match{
    case List(1,_,_,_) => "List with 4 elements, first is 1" //this is for lists that have 1 first and then 3 after elements of whatever value
    case List(1, _*) => "List starting with 1" //_* means more number of args after the first
    case List(1, 2, _) :+ 42 => "list ends in 42" //:+ 42 adds 42 to the end of the list
    case head :: tail => "deconstructed list"
  }

  //f. type specifiers - you can pattern match depending on the type of the value
  val unknown: Any = 2
  val matchType = unknown match{
    case anInt: Int => "I matched and it and I can"
    case aString: String => "Matched String"
    case _: Double => "Oh Baby a Triple!- I mean a Double"
  }

  //g. Binding Names - you can give names to args when pattern matching
  val bindNames = aList match{
    case Cons(head, rest @ Cons(_, tail)) => s"Can use $rest now" //now Cons(_,tail)) can be referred to as rest
  }

  //h. chained patterns
  val multMatch = aList match{
    case Empty() | Cons(0, _) => "an empty list"
  } // the "|" acts like an or case, so if any of them are present that line will be printed out

  //i. if guards
  val elementSpecial = aList match{
    case Cons(_, Cons(specialElement, _)) if specialElement > 10 => "element is big enough"
    //this basically makes the case more specific for matching, the more specific the more higher up in the pattern matching it should be
  }

  //Example: does it make sense?
  val aSimpleInt = 45
  val isEven_bad = aSimpleInt match{
    case n if n % 2 == 0 => true
    case _ => false
  }
  //doesn't make sense as the code is too much for just a boolean check
  val isEven_bad_correst = aSimpleInt % 2 == 0 //this would give a true or false

  /**
   * exercise
   */
  val numbers: List[Int] = List(1,2,3,4)
  val numbersMatch = numbers match{
    case listOfStrings: List[String] => "a list of strings"
    case listOfInts: List[Int] => "a list of numbers"
  }

  /** In this case, the first case would be matched
   * This is due to pattern matching running at runtime
   * during runtime, generic types get erased
   * therefore all of them are just seen as Lists, regardless of type
   */

  def main(args: Array[String]): Unit = {

  }

}
