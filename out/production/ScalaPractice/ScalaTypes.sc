import java.util

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
//variance of parametrized type
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
