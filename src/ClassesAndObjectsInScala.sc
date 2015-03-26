
//object or static in java or Singleton
object Car {

  def turn(direction: String) = println("turning " + direction)
}

Car turn "right"
//class with constructors

class Car (val year : Int){
  print("created Car class")
  private var milesDriven : Int = 0;
  def miles() = milesDriven
  def drive(distance : Int): Unit = {
    milesDriven += Math.abs(distance)
  }
}
val car = new Car(2009)
println("Car made in "+car.year)


//
class Person(val firstName : String, val lastName : String){
  private var position : String = _
  println("object created")

  def this(firstName : String, lastName : String, positionHeld : String) ={
    this(firstName, lastName)
    position = positionHeld
  }
  override def toString():String = {
    firstName + " " + lastName + " " + " holds " + position
  }
}

val ajit = new Person("Ajit","Katte","Software Developer")

