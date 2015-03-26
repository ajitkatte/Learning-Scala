
//Traits and Type conversion
abstract class Writer {
  def write(msg :String)
}
class StringWriter extends Writer{
  var builder = new StringBuilder

  override def write(msg: String) = {
    builder.append(msg)
  }
  override def toString() = builder.toString()
}

trait UpperCaseDecorator extends Writer{
  abstract override def write(msg : String) ={
    super.write(msg.toUpperCase())
  }
}

val strWriter = new StringWriter with UpperCaseDecorator
strWriter.write("Hi, This is decorator pattern")
println("Result =>" + strWriter toString())
//traits
trait Friend {
  val name : String
  def listen = println("Your friend name "+name+" is listening")
}
class Human(val name : String) extends Friend
class Man(override val name : String) extends Human(name)
class Woman(override val name : String) extends Human(name)
class Animal
class Dogs(val name : String) extends Animal with Friend{
  //overriding is optional
  //override def listen = println("Your friend name "+name+" is listening")
}
val john = new Man("John")
john listen
val scarlett = new Woman("Scarlett")
scarlett listen
val comet = new Dogs("Comet")
comet.listen

