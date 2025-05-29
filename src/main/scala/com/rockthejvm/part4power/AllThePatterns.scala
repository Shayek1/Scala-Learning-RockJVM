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



  def main(args: Array[String]): Unit = {

  }

}
