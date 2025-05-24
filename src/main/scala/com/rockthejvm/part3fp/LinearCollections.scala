package com.rockthejvm.part3fp

//import scala.collection.immutable.Seq as Int

import scala.util.Random

object LinearCollections {

  // Seq = well-defined ordering + indexing
  def testSeq(): Unit = {
    val aSequence = Seq(4, 3, 2, 1)
    //main API: index an element
    val thirdElement = aSequence.apply(2)
    //map/flatmap/filter/for
    //val
    //other methods
    val reversed = aSequence.reverse
    val concatenation = aSequence ++ Seq(5,6,7)
    val sortedSequence = aSequence.sorted // [1,2,3,4]
    val sum = aSequence.foldLeft(0)(_ + _) //10
    val stringRep = aSequence.mkString("[", ",", "]" )

    println(aSequence)
    println(concatenation)
    println(sortedSequence)
  }

  //lists
  def testLists(): Unit ={
    val aList = List(1,2,3)
    //same API as Seq
    val firstElement = aList.head
    val rest = aList.tail
    //appending and prepending
    val aBiggerList = 0 +: aList :+4
    val prepending = 0 :: aList // :: equivalent to Cons in LList
    //utility methods
    val scalax5 = List.fill(5)("Scala")
  }

  //range
  def testRanges(): Unit = {
    val aRange: Seq[Int] = 1 to 10 // inclusive range
    val aNonInclusiveRange = 1 until 10 // 10 not included
    //same Seq API
    (1 to 10).foreach(_ => println("Scala"))
  }

  //array
  def testArrays(): Unit ={
    val anArray = Array(1,2,3,4,5,6)
    //most Seq API work on Array
    // isn't a sequence tho
    val aSequence: Seq[Int] = anArray.toIndexedSeq //converting arrays to sequences
    //arrays are mutable (can be changed)
    anArray.update(2, 30) //the first number is the index and the second is the new number you want to change with

  }

  //vectors  - fast sequence implementations for a large amount of data
  def testVectors(): Unit ={
    val aVector: Vector[Int] = Vector(1,2,3,4,5,6)
    // same API as seq
  }

  def SmallBenchmark(): Unit = {
    val maxRuns = 1000
    val maxCapacity = 1000000

    def getWriteTime(collection: Seq[Int]): Double = {
      val random = new Random()
      val times = for {
        i <- 1 to maxRuns
      } yield {
        val index = random.nextInt(maxCapacity)
        val element = random.nextInt()

        val currentTime = System.nanoTime()
        val updatedCollection = collection.updated(index, element)
        System.nanoTime() - currentTime
      }


      //compute average
      times.sum * 1.0 / maxRuns // sum is same as foldLeft(0L)(_ + _)
    }

    val numbersList = (1 to maxCapacity).toList
    val numbersVector = (1 to maxCapacity).toVector

    println(getWriteTime(numbersList))
    println(getWriteTime(numbersVector))
  }

  //sets
  def testSets(): Unit ={
    val aSet = Set(1,2,3,4,5,4)
    //equals + hashCode = hash  set
    //main API: test if in the set
    val contains3 = aSet.contains(3) //boolean true
    val contains3V2 = aSet(3) //true
    //adding/removing
    val aBiggerSet = aSet+ 4 //[1,2,3,4,5]
    val aSmallerSet = aSet -4 // [1,2,3,5]
    //concatenation == union
    val anotherSet = Set(4,5,6)
    val muchBiggerSet =aSet.union(anotherSet)

  }


  def main(args: Array[String]): Unit = {
    testSeq()
    SmallBenchmark()
  }

}
