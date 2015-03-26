
//simple for loop
for (i <- 1 to 10) {
  println(i)
}
//until
for(i <- 0 until 10)
  println(i)
// Two variables in one for loop
for (i <- 1 to 5; j <- 6 to 10){
  println("["+i+","+j+"]")
}

//for loop with condition
val result = for(i <- 1 to 10; if i%2 ==0)
yield i * 2
//for loop curly braces
for{
  i <- 1 to 10
  if i%2 != 0
}
yield i*3


//Scala for loop, List
val numberList = List(1,2,3,4,5,6,7,8)
val resultList = for {
  i <- numberList;
  if i % 2 == 0;
  i < 7
} yield i
//iterator on custom classes
class Person( val firstName : String, val lastName : String)
object Person{
  def apply ( firstName : String, lastName : String) : Person = {
    new Person(firstName,lastName)
  }
}
val friends = List(Person("Ajit","Katte"),Person("Vaibhav","Apte"),Person("Nikhil","Golatkar"))
val lastNames = for (friend <- friends ; lastName = friend.lastName) yield lastName
println( lastNames.mkString(", "))