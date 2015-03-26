

//factorial using scala
def factorial(number : Int) : BigInt = number match {
  case 0 => 1
  case _ => number * factorial( number-1)
}
factorial(5)


// foldLeft and map
val values = List(2,3,4,5)
val result = values.map(_*2)
val newResult = values.foldLeft(Int.MinValue){Math.max}
