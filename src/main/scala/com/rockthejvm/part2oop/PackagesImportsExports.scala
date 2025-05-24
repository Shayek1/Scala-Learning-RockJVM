package com.rockthejvm.part2oop

val meaningOfLife = 25
def computeMyLife: String = "Scala"

object PackagesImportsExports { // top-level


  //orgainsed into files
  //Folders are called "packages"
  //fully qualified name
  val aList: com.rockthejvm.practice.LList[Int] = ??? // throws NotImplementedError

  //import
  import com.rockthejvm.practice.LList
  val anotherList: LList[Int] = ???

  //importing under an alias
  import java.util.List as JList
  val aJavaList: JList[Int] = ???

  //import everything
  import com.rockthejvm.practice.*
  val aPredicate: Cons[Int] = ???

  // import multiple symbols
  import PhysicsConstants.{SPEED_OF_LIGHT, EARTH_GRAVITY}
  val c = SPEED_OF_LIGHT
  
  //import everything but something
  object PlayingPhysics {
    import PhysicsConstants.{Planck as _, *}
  }
  
  
  import com.rockthejvm.part2oop.* //imports meaning of life and computeMyLife from the top
  
  //default imports that compiler auto imports
  //scala.*, scala.Predef.*, java.Land.*
  
  //exports
  class PhysicsCalculator {
    import PhysicsConstants.*
    def computePhotonEnergy(wavelength: Double): Double =
      Planck / wavelength
  }
  object ScienceApp {
    val physicsCalculator = new PhysicsCalculator
    
    export physicsCalculator.computePhotonEnergy
    
    def computeEquivalentMass(wavelength: Double): Double =
      computePhotonEnergy(wavelength) / (SPEED_OF_LIGHT * SPEED_OF_LIGHT)
  }
  
  def main(args: Array[String]): Unit = {

  }
}

object PhysicsConstants {
  // constants 
  val SPEED_OF_LIGHT = 299792458
  val Planck = 6.62e-34
  val EARTH_GRAVITY = 9.8

}