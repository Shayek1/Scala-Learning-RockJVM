package com.rockthejvm.part3fp

object TuplesMaps {

  //tuples - finite ordered "lists" / group of values under the same "bug" value
  val aTuple = (2, "tuple") // Tuple2[Int, String]
  val firstField = aTuple._1
  val aCopiedTuple = aTuple.copy(_1 = 54)


  //tuples of 2 elements
  val aTupleV2 = 2 -> "tuple" // same as line 5

  //maps: keys -> values, can take tuples as args

  val aMap = Map()
  val phonebook: Map[String, Int] = Map(
    "jim" -> 555,
    "Daniel" -> 789,
    "Jane" -> 123
  ).withDefaultValue(-1)

  //core APIs
  //can check if a key is in the map
  val phonebookhasDaniel = phonebook.contains("Daniel")

  //map -> linear collection
  val linearPhonebookV2 = phonebook.toList // toSeq, toVector, toArray, toSet

  //map, flatMap, filter
  //val aProcessPhone

  def main(args: Array[String]): Unit = {

  }
}
