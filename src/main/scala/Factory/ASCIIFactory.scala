package Factory

import Models.{ASCIIGrid, Grayscale}

/*
* This singleton does all the calculations/operations needed to get ascii char
* from a grayscale grid.
* */
object ASCIIFactory {

  /*
  * This function maps a grayscale Int to a ascii character. Util function.
  * */
  def grayscaleToChar(x : Int) : Char = {
    require(x >= 0 && x <= 255, "Wrong grayscale value.")

    x match {
      case x if x < 30 => '.'
      case x if x < 60 => ':'
      case x if x < 90 => '-'
      case x if x < 120 => '='
      case x if x < 150 => '+'
      case x if x < 180 => '*'
      case x if x < 210 => '#'
      case x if x < 240 => '%'
      case x if x < 256 => '$'
      case _ => ' '
    }
  }

  /*
  * This function does the conversion between grayscale grid and ascii grid.
  * That means - for each grayscale Int it finds an ascii char and stores it in
  * ASCIIGrid.
  * */
  def fromGray(grayscale : Grayscale): ASCIIGrid = {
    val w = grayscale.width
    val h = grayscale.height

    val grid = Array.ofDim[Char](w, h)

    for (x <- 0 until w)
      for (y <- 0 until h) {
        val r = grayscaleToChar(grayscale.getGrayValue(x,y))
        grid(x)(y) = r
      }

    new ASCIIGrid(grid)
  }
}
