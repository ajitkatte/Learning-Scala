import java.io.{File, PrintWriter}
import java.util
import java.util.Date






class Marker(val color: String){
  println("Creating Marker")
  override def toString() : String = "Marker color "+color
}
object MarkerFactory {
  private val Markers = Map(
  "red" -> new Marker("red"),
  "blue" -> new Marker("blue"),
  "green" -> new Marker("green")
  )
  def getMarker(color : String)= {
    if(Markers.contains(color))
      Markers(color)
    else
      null
  }
}

println(MarkerFactory getMarker "red")
println(MarkerFactory getMarker "green")
println(MarkerFactory getMarker "blue")
println(MarkerFactory getMarker "red")
println(MarkerFactory getMarker "green")
println(MarkerFactory getMarker "blue")



class Singleton private (val color : String){
println("Creating "+this)
  override def toString() : String = "marker color "+ color
}
object Singleton {
  private val markers = Map(
    "red" -> new Marker("red"),
    "green" -> new Marker("green"),
    "blue" -> new Marker("blue")
  )
  def getMarker(color: String) = if (markers.contains(color)) markers(color) else null
}
var builder = new StringBuilder("hello")
println(builder.getClass)
var list = new util.ArrayList[Any]()
list add "A"
list add 1
println(list)
//OptionType
def commentOnPractice(input : String)={
  if(input == "test")
    Some("good")
  else
    None
}
for(input <- Set("test","hack")){
  val comment = commentOnPractice(input)
  println("input " + input +" comment "
    +comment.getOrElse("Found no comments"))
}
//variance of parameterized type
class Pet(val name : String ){
override def toString() = name
}
class Dog(override val name : String) extends  Pet(name)
def workWithPets[T<:Pet](pets : Array[T])
= println("Playing with pets :"+pets.mkString(","))
val dogs = Array(new Dog("Rover"), new Dog("Comet"))
workWithPets(dogs)
def copyPets[S,D >: Pet](fromPets : Array[S], toPets : Array[D]): Unit ={
}
val pets = new Array[Pet](10)
copyPets(dogs,pets)

//Function values
def totalResultOverRange(number : Int, codeBlock : Int => Int):Int ={
  var result = 0
  for(i <- 1 to number)
    result += codeBlock(i)
  result
}
println(totalResultOverRange(11,i=>i))
println(totalResultOverRange(11,i=> if(i%2==0)1 else 0))
println(totalResultOverRange(11,i=> if(i%2!=0)1 else 0))
def inject (arr : Array[Int], initial : Int, operation:(Int,Int)=>Int):Int={
  var carryOver = initial
  arr.foreach( el => carryOver = operation(carryOver, el))
  carryOver
}
val array = Array(2,5,1,9,5,2)
val sum = inject(array,0, (carryOver, el)=> carryOver+el)
println("Sum of array "+ array.toString+" is "+sum)
val max = inject(array,Int.MinValue,(co,el) => Math.max(co,el))
println("Max form array "+ max)
var summation = (0 /: array){(co,el) => co+el}
println("Summation of array using library: "+summation)
//Resusing function values
class Equipment(val routine : Int => Unit){
  def simulate(input : Int)={
    println("Runing simulation...")
    routine(input)
  }
}
val calculator = {input : Int => println("calc using :"+input)}
val eq1 = new Equipment(calculator)
val eq2 = new Equipment(calculator)
eq1.simulate(4)
eq2.simulate(5)
//Execute around method pattern
class Resource private(){
  println("Starting transaction...")
  private def cleanUp = println("Ending transaction...")
  def op1 = println("Operation 1")
  def op2 = println("Operation 2")
  def op3 = println("Operation 3")
}
object Resource {
  def use(codeBlock : Resource => Unit): Unit ={
    val resource = new Resource
    try
      codeBlock(resource)
    finally
      resource.cleanUp
  }
}
Resource.use{ resource =>
  resource.op1
  resource.op2
  resource.op3
}
//Real example of loan pattern
def writeToFile(fileName : String )(codeBlock : PrintWriter => Unit) ={
  val writer = new PrintWriter(new File(fileName))
  try
    codeBlock(writer)
  finally
    writer.close
}
writeToFile("f:\\test.txt"){writer =>
  writer write "This is Loan pattern"
}
//Paritially applied functions
def log(date : Date, message : String): Unit ={
  println(date+"----"+message)
}
val date = new Date
log(date,"Fo-ViewCall")
log(date,"Fo-JsonCall")

val logWithDateBound = log(new Date,_:String)
logWithDateBound("message1")
logWithDateBound("message2")
//Closures
def loopThrough(number : Int )(closure : Int => Unit)={
  for(i <- 1 to number){
    closure(i)
  }
}
var res = 0
val addIt = {value : Int => res += value}
res = 0
loopThrough(20){addIt}
println("result "+ res)
//Traits and Type conversion
abstract class Writer {
  def write(msg :String)
}
class StringWriter extends Writer{
  var builder = new StringBuilder

  override def write(msg: String) = {
    builder.append(msg)
  }
  override def toString() = builder.toString()
}

trait UpperCaseDecorator extends Writer{
  abstract override def write(msg : String) ={
    super.write(msg.toUpperCase())
  }
}
val strWriter = new StringWriter with UpperCaseDecorator
strWriter.write("Hi, This is decorator pattern")
println("Result =>" + strWriter toString())
//traits
trait Friend {
  val name : String
  def listen = println("Your friend name "+name+" is listening")
}
class Human(val name : String) extends Friend
class Man(override val name : String) extends Human(name)
class Woman(override val name : String) extends Human(name)
class Animal
class Dogs(val name : String) extends Animal with Friend{
  //overriding is optional
  //override def listen = println("Your friend name "+name+" is listening")
}
val jh = new Man("John")
jh listen
val scarlett = new Woman("Scarlett")
scarlett listen
val comet = new Dogs("Comet")
comet.listen

