import java.io.{File, PrintWriter}
import java.util.Date

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

//scala tail recursion - factorial
def tailRecFactorial(number : Int) = {
def innerFactorial(number : Int, accumulator : Int) : Int = number match{
      case 0 => accumulator
      case _ => innerFactorial(number - 1, number*accumulator)
    }
  innerFactorial(number,1)
}


val array = Array(2,5,1,9,5,2)
val sum = inject(array,0, (carryOver, el)=> carryOver+el)
println("Sum of array "+ array.toString+" is "+sum)
val max = inject(array,Int.MinValue,(co,el) => Math.max(co,el))
println("Max form array "+ max)
var summation = (0 /: array){(co,el) => co+el}
println("Summation of array using library: "+summation)

//Reusing function values
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


//Partially applied functions
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
