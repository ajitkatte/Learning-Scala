
object DayOfWeek extends Enumeration
{
  val MONDAY = Value("Monday")
  val TUESDAY = Value("Tuesday")
  val WEDNESDAY = Value("Wednesday")
  val THURSDAY = Value("Thursday")
  val FRIDAY = Value("Friday")
  val SATURDAY = Value("Saturday")
  val SUNDAY = Value("Sunday")
}
def getDayOfWeek(day : DayOfWeek.Value) = day match {
  case DayOfWeek.SUNDAY => println(day + " is Funday!!!")
  case DayOfWeek.FRIDAY => println(day + " is last working day of week!!")
  case DayOfWeek.SATURDAY => println(day + " is weekend!!!")
  case _ => println(day + " boring, working day!!!")
}
getDayOfWeek(DayOfWeek.FRIDAY)
//Matching anything
def processThings(thing : Any) =thing match {
  case (a , b) => printf("These seems to be co-ordinates (%f,%f)",a,b)
  case "Male" => println("Welcome Man!")
  case 10 => println("this is just a number")
}
processThings((10.23,-102.7632))
processThings("Male")
//Matching Lists
def matchAnyList(items : List[Any]) = items match {
  case List(1,2,_*) => println("This numeric list 1,2,3 ...")
  case List("one","two",_*) => println("This is string list one two, three ...")
  case List("red","blue", otherColors @_*) => println("This is color list and other colors are "+otherColors)
}
matchAnyList(List(1,2,3))
matchAnyList(List("one","two","three"))
matchAnyList(List("red","blue","green","orange"))

//Matching types
def processTypes(input : Any) = input match {
  case (a : Double, b: Double) => printf("processing doubles (%f,%f)",a,b)
  case (a : Int, b: Int) => printf("processing integers (%d,%d)",a,b)
  case a : Int if(a > 10) => printf("Processing %d > 10",a)
  case msg : String => println("Processing string "+msg)
}

processTypes((1,2))
processTypes((1.23,2.34))
processTypes(15)
processTypes("Hello World!")