package com.rockthejvm.part2oop

object Enums {

  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    //add fields/methods
    def openDocument(): Unit =
      if (this == READ) println("opening document...")
      else println("reading not allowed.")
  }

  val somePermissions: Permissions = Permissions.READ

  //enums can take constructor arguments

  enum PermissionWithBits(bits: Int) {
    case READ extends PermissionWithBits(4)
    case WRITE extends PermissionWithBits(2)
    case EXECUTE extends PermissionWithBits(1)
    case NONE extends PermissionWithBits(0)
  }

  object PermissionWithBits {
    def fromBits(bit: Int): PermissionWithBits =
      PermissionWithBits.NONE
  }

  //standard API
  val somePermissionsOrdinal = somePermissions.ordinal
  val allPermission = PermissionWithBits.values // array of all possible values of the enum
  val readPermission: Permissions = Permissions.valueOf("READ") //Permissions.READ


  def main(args: Array[String]): Unit = {
    somePermissions.openDocument()
    println(somePermissionsOrdinal)
    //println(allPermission)
    println(readPermission)
  }
}
