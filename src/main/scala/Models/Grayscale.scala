package Models

/*
* This model stores a 2D array (grid) of Int values, that represent
* grayscale value of each pixel.
* */
class Grayscale(private val _grid : Array[Array[Int]]) {
  val width : Int = _grid.length
  val height : Int = _grid(0).length

  def getGrayValue(x : Int, y : Int) : Int = {
    _grid(x)(y)
  }

  def setGrayValue(x : Int, y : Int, v : Int) : Unit = {
    _grid(x)(y) = v
  }
}
