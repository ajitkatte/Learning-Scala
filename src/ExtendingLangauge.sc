def logTiming[T](codeBlock: => T) = {
  val startedAt = System.nanoTime
  val returnValue = codeBlock
  val timeTaken = System.nanoTime - startedAt
  println(s"Executed in: ${timeTaken / 1000000.0 } milliseconds.")
  returnValue
}

val unsortedNumbers = 100 until 0 by -1 toList

val sortedNumbers = logTiming{
  unsortedNumbers.sortWith((a, b) => a < b) //can be replaced with unsortedNumbers.sortWith(_ < _)
}

println(sortedNumbers)