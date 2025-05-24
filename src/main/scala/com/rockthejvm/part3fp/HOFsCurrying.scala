package com.rockthejvm.part3fp



object HOFsCurrying {

  //HOFs
  val aHof: (Int, (Int => Int)) => Int = (x, func) => x + 1
  val anotherHof: Int => (Int => Int) = x => (y => y + 2 * x)

  //quick exercise
  val superfunction: (Int, (String, Int => Boolean) => Int) => Int => Int = (x, func) => y => x + y

  //examples: map, flatMap, filter

  //more examples

  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))
  }


  val plusOne = (x: Int) => x + 1
  val tenThousand = nTimes(plusOne, 10000, 0)

  def nTimesV2(f: Int => Int, n: Int): Int => Int =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesV2(f, n-1)(f(x))

  val plusTenThousand = nTimesV2(plusOne, 1000)
  val tenThousandV2 = plusTenThousand(0)


  def main(args: Array[String]): Unit = {

    println(tenThousand)
  }

}
