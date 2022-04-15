import Controllers.Controller

object Main extends App {
  try {
    val asciiArt = new Controller()
    asciiArt.run(this.args)
  }
  catch {
    case e : Exception => println(e.getMessage)
  }
}