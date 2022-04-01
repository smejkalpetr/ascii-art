package ImgSaver

import Models.ASCIIGrid

/*
* This class prints result to the console.
* */
case class ConsoleSaver() extends ImgSaver {

  /*
  * Iterates through every char in ASCIIGrid and prints it to the console.
  * */
  def save(grid : ASCIIGrid) : Unit = {
    val w = grid.getWidth
    val h = grid.getHeight

    for (x <- 0 until w) {
      for (y <- 0 until h) {
        print(grid.getChar(x, y))
      }
      print('\n')
    }
  }
}
