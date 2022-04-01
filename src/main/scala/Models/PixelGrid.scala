package Models

/*
* This model stores 2D Array (grid) of Pixels.
* */
class PixelGrid(private val _grid : Array[Array[Pixel]]) {
  require(_grid.length > 0 && _grid(0).length > 0, "Wrong grid size -> Picture not read properly.")
  val width : Int = _grid.length
  val height : Int = _grid(0).length

  def getPixel(x : Int, y : Int) : Pixel = _grid(x)(y)
}
