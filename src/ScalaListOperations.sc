import scala.annotation.tailrec
import scala.collection.mutable
import scala.io.Source

/* Scala list operations */

val a = 1 to 5 toList
val b = 5 to 10 toList

// ++ operation, returns new list with elements from left hand
// operand followed by elements from right hand operand.
// type of resulted list will be superclass of holded elements

val c = a ++ b
val d = List('a')
val e = c ++ d


// ++: operation, right operand determines the type of the
// resulting collection rather than the left one.
// Mnemonic: the Colon is on the side of the new collection type.

val f = mutable.LinkedList(6,7)
 a ++: f

// +: A copy of the list with an element prepended.
//A mnemonic for +: vs. :+ is: the Colon goes on the Collection side.
//Also, the original list is not modified, so you will want to capture the result.

5 +: f

f :+ 8

// /: applies binary operator or function to all values in traversable or iterator
// from left to right.

val sum = (10 /: f)(_ + _) // is equivalent to f.foldLeft(10)(_ + _)

// :: adds an element at the begining of the list

1::List(2,3)
List(2,3).::(1)

//::: adds the elements of a given list in front of another list i.e. list concatenation

List(1,2):::List(3,4)

// :\ applies binary operator or function tp all values in traversable or iterator
// from right to left.

(f :\ 10) (_ + _)
(f :\ 2) ((e,y) => e + y )

// zip returns a list of pairs with streamed elements,
// zipWithIndex does same but index start with 0
// zip creates list with provided arguments

List(1,2).zip(Stream from 1)
List(1,2).zipWithIndex

val a1 = List("a","b","c","d")
val a2 = List(1,2,3)
a1.zipAll(a2,"missing",4)

//unZip create two traversables from given
val (list1,list2)= List(
  (1, "one"),
  (2, "two"),
  (3, "three")).unzip

// map and flatMap
val l = List(1,2,3,4,5)
l.map(x => x * 2)

//for loop
for(arg <- list1)
  println(arg)

val greet = new Array[String](3)
greet(0) = "Hello"
greet(1) = ","
greet(2) = "World!!!"
for(i <- 0 to 2)
print(greet(i))


list2.sortWith((s,t) => s.charAt(0).toLower > t.charAt(0).toLower)

val tuple1 = (99,"Luftballons")
println(tuple1._1)
println(tuple1._2)

var jetSet = mutable.Set("Boeing","Airbus")
jetSet += ("Lear")
println(jetSet.contains("Cessna"))

//Map in scala

val treasureMap = mutable.Map[Int, String]()
treasureMap += (1 -> "Go to Island")
treasureMap += (2 -> "Find a big X on ground")
treasureMap += (3 -> "Dig.")
println(treasureMap)


//tail recursion in scala
@tailrec
def gcd(a : Int, b : Int) : Int = b match {
  case 0 => a
  case _ => gcd(b, a % b)
}

gcd(81,1764)