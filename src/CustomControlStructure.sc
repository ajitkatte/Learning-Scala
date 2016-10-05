//Custom control structure let you define your own controllers like if..else and do...while

class Dont(codeBlock : => Unit){
  def unless(condition : => Boolean) = if(condition) codeBlock
  def until(codition : => Boolean) = if(!codition) codeBlock
}

def dont(code : => Unit) = new Dont(code)

val condition = true
dont{
  println("This is executed because condition was true")
} unless(condition == true)

var number = 0
val target = 5
def counter() ={
  number += 1
  println(number)
  number
}


dont{
  println(s"Done counting to ${target}")
} until(counter() == target)