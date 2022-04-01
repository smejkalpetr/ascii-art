import java.util.NoSuchElementException

import Controllers.Controller
import jdk.nashorn.internal.objects.Global.println

object Main extends App {
  try {
    val asciiArt = new Controller()
    asciiArt.run(this.args)
  }
  catch {
    case e : Exception => println(e.getMessage)
  }

def f() = throw new NoSuchElementException
  try {
    println(1)
    f()
    println(2)
  } finally {
    println("3")
  }
}