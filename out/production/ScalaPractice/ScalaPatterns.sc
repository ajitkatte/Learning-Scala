
// Factory method pattern

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


// Singleton pattern

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
  def getMarker(color: String) = if (markers.contains(color))
    markers(color)
  else
    null
}
