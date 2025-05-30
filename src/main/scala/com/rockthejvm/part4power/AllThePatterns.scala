package com.rockthejvm.part4power

object MySingleton

object AllThePatterns {

  //All the patterns we can use:

  //Constants
  val aVal: Any = "Scala" //compiler knows what type the code is
  val consts = aVal match{
    case 32 => "number"
    case "Scala" => "THE Scala"
    case true => "truth"
    case MySingleton => "a singleton object"
  }

  //Matching anything
  val matchAnyVar = aVal match{
    case something => s"I have matched anything, it is $something"
  }
  //the _ replaces something
  val matchAny = aVal match{
    case _ => "I can match anything, trust me" //case _ is the default case that matches with anything. Best to keep last
  }


  // tuples
  val aTuple = (1,5)
  val matchTuple = aTuple match{
    case (1, aThing) => s"A tuple with 1 and $aThing"
    case (anotherThing, 2) => "A tuple with 2 as its second field"
  }

  def main(args: Array[String]): Unit = {

  }

}
