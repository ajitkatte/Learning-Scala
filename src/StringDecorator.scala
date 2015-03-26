

/**
 * Created by Ajit on 28-02-2015.
 */
object StringDecorator extends App{
  writeStuff(new StringWriter with OffensiveWordFilter with UpperCaseDecorator with LowerCaseDecorator)

  def writeStuff(writer : Writer): Unit ={
    writer.write("Stupid, This is Decorator Pattern!")
    println(writer)
  }
}


abstract class Writer {
  def write(msg : String)
}

class StringWriter extends Writer{
  val target = new StringBuilder

  override def write(msg: String) = {
    target.append(msg)
  }

  override def toString() = target.toString()
}

trait UpperCaseDecorator extends Writer{
  abstract override def write(msg : String) = {
     super.write(msg.toUpperCase())
  }
}

trait OffensiveWordFilter extends Writer{
  abstract override def write(msg : String) = {
    super.write(msg.replaceAll("(?i)stupid","S*****"))
  }
}


trait LowerCaseDecorator extends Writer{
  abstract override def write(msg : String) = {
    super.write(msg.toLowerCase())
  }
}

