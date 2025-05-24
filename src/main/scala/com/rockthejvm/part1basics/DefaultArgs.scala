package com.rockthejvm.part1basics

object DefaultArgs {


  def sumUntilTailRec(x: Int, accumulator: Int = 0): Int = {
    if (x <= 0) accumulator
    else sumUntilTailRec(x - 1, accumulator + x)
  }


  val sumUntil100 = sumUntilTailRec(100) // additional argument is passed automatically

  def savePicture(dirPath: String, name: String, format: String, width: Int, height: Int): Unit =
    println("Saving picture in format " + format + " in path " + dirPath)

  /** passing default arguments allows you to have arguments that are auto passed through when printing, so you don't have to fill
  all args in the function.**/
  // if you want to change the arguments, you can do so when typing out the function in main.
  // the comp. reads in order so if you want to change eg: width, you have to state the name of arg like width = ...



  def main(args: Array[String]): Unit = {

   /** def main(args: Array[String]): Unit = {
      // default args are injected
      savePicture("/users/daniel/photos", "myphoto")

      // pass explicit different values for default args
      savePicture("/users/daniel/photos", "myphoto", "png")

      // pass values after the default argument
      savePicture("/users/daniel/photos", "myphoto", width = 800, height = 600)

      // naming arguments allow passing in a different order
      savePicture("/users/daniel/photos", "myphoto", height = 600, width = 800)
    }**/


  }

}
