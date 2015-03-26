
//collections
val colors = Set("Red","Green","Blue")
var color = colors
color += "Black"
println(color)
println(colors)
val feeds1 = Set("a.blogspot.com","b.wordpress.com","learningscala.com","typesafe.org","scala-lang.org")
val filteredFeed = feeds1 filter ( _ contains "org")

//Merging sets
val addedFeeds = feeds1 ++ filteredFeed

//Intersection of set
val intersected = feeds1 intersect(filteredFeed)
println(filteredFeed)
println("Merged feeds : "+ addedFeeds)
println("Intersected feeds : "+ intersected)
val urls = feeds1 map ("http://" + _)
println(urls)


val feeds = Map("Ajit" -> "scala-lang.org","Vaibhav" -> "learningscala.com", "Nikhil" -> "a.wordpress.com")
val filteredNames = feeds filterKeys ( _ startsWith "A")
println(filteredNames)


val filterNamesWithDAndBlogs = feeds filter { element =>
  val (key,value) = element
  ((key startsWith "A" )|| key.startsWith("V")) && (value contains "scala")
}
println(filterNamesWithDAndBlogs.size)


try{
  println( "Get Ajit's Feed Using apply(): "+ feeds( "Ajit"))
  print( "Google's Feed: ")
  println(feeds( "Google"))
}
catch {
  case ex : java.util.NoSuchElementException => println("Not found")
}


//implicit classes or Extension methods in c#
implicit class FunnyString (val s : String){
  def decorateWithStars = "***" + s + "***"
}
val s= "Hello"
println (s.decorateWithStars)

