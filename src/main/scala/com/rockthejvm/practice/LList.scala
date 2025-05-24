package com.rockthejvm.practice
import scala.annotation.tailrec


abstract class LList[A] {
   def head: A
   def tail: LList[A]
   def isEmpty: Boolean
   def add(element: A): LList[A] = Cons(element, this)

   //concatenation
   infix def ++(anotherList: LList[A]): LList[A]

   def map[B](transformer: A => B): LList[B]
   def filter(predicate: A => Boolean): LList[A]
   def flatMap[B](transformer: A => LList[B]): LList[B]

 }
 case class Empty[A]() extends LList[A] {
  override def head: A = throw new NoSuchElementException
  override def tail: LList[A] = throw new NoSuchElementException
  override def isEmpty: Boolean = true

   override infix def ++(anotherList: LList[A]): LList[A] = anotherList

   override def toString: String = "[]"
   override def map[B](transformer: A => B): LList[B] = Empty()
   override def filter(predicate: A => Boolean): LList[A] = this

   override def flatMap[B](transformer: A => LList[B]): LList[B] = Empty()
 }

case class Cons[A](override val head: A, override val tail: LList[A]) extends LList[A] {
   override def isEmpty: Boolean = false
   override def toString = {
     @tailrec
       def concatenateElements(remainder: LList[A], acc: String): String = {
       if (remainder.isEmpty) acc
       else concatenateElements(remainder.tail, s"$acc, ${remainder.head}")
      }
     s"[${concatenateElements(this, "" )}]"
   }

   override infix def ++(anotherList: LList[A]): LList[A] =
     Cons(head, tail ++ anotherList)

   override def map[B](transformer: A => B): LList[B] = {
     Cons(transformer.apply(head), tail.map(transformer))
   }

   override def filter(predicate: A => Boolean): LList[A] = {
     if (predicate.apply(head)) Cons(head, tail.filter(predicate))
     else tail.filter(predicate)
   }

   override def flatMap[B](transformer: A => LList[B]): LList[B] =
     transformer.apply(head) ++ tail.flatMap(transformer)
 }
/** Exercise: LList extension
 Create a generic trait Predicate[T] with a small method test(T): Boolean
 Create a generic trait Transformer[A, B] with a method transform(A): B
 Extend LList by implementing:
 map(transformer) => LList
 filter(predicate) => LList
 flatMap(transformer from A to LList[B]) => LList[B]
 Also: Create a class EvenPredicate that extends Predicate[Int]
 Create a class StringToIntTransformer that extends Transformer[String, Int]
 Example behavior:
 [1,2,3].map(n * 2) => [2,4,6]
 [1,2,3,4].filter(n % 2 == 0) => [2,4]
 [1,2,3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4] */

/*trait Predicate[T] {
  def test(element: T): Boolean //T => Boolean
}

class EvenPredicate extends Predicate[Int] {
  override def test(element: Int): Boolean = element % 2 == 0
}*/

/*trait Transformer[A, B] {
  def transform(value: A): B
}*/

class Doubler extends Function1[Int, Int] {
  override def apply(value: Int): Int = value * 2
}

class DoublerList extends Function1[Int, LList[Int]]{
  override def apply(value: Int): LList[Int] =
    Cons(value, Cons(value + 1, new Empty[Int]))
}

 object LListTest {
   def main(args: Array[String]): Unit = {
     val empty = Empty[Int]()
     println(empty)

     val first3numbers = Cons(1, Cons(2, Cons(3, empty)))
     val first3numbers_v2 = empty.add(1).add(2).add(3)
     println(first3numbers)
     println(first3numbers_v2)
     println(first3numbers_v2.isEmpty)


     // anonymous class eg: of evenPredicate
//      val evenPredicate = new Function1[Int, Boolean] {
//       override def apply(element: Int): Boolean = element % 2 == 0
//     }

     //anonymous class eg: of Doubler
//     val doubler = new Function1[Int, Int] {
//       override def apply(value: Int): Int = value * 2
//     }
     //map test
     val numbersDoubled = first3numbers.map(value => value * 2)
     println(numbersDoubled)

     //filter test
     val onlyEvenNumbers = first3numbers.filter(element => element % 2 == 0)
     println(onlyEvenNumbers)

     //test concatenation
     val listInBothWays = first3numbers ++ first3numbers_v2
     println(listInBothWays)

     //test flatmap
     val flattenedList = first3numbers.flatMap(new DoublerList)
     println(flattenedList)
   }
 }