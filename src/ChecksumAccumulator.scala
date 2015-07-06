import scala.collection.mutable

/**
 * Created by ajit on 13/6/15.
 */
class CheckSumAccumlator{
  private var sum = 0
  def add(b : Byte) { sum += b }
  def checksum() : Int = return ~(sum & 0xFF) + 1
}

//Singleton or object in scala
object CheckSumAccumlator {
  private val cache = mutable.Map[String, Int]()
  def calculate(s : String) : Int = {
    if(cache.contains(s))
      cache(s)
    else
    {
      val acc = new CheckSumAccumlator
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      return cs
    }
  }
}

