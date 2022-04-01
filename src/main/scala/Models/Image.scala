package Models

/*
* This model stores PixelGrid structure and some additional
* info about the Image.
* */
class Image(private val _grid : PixelGrid) {
  val width : Int = _grid.width
  val height : Int = _grid.height

  def getPixel(x : Int, y : Int) : Pixel = _grid.getPixel(x,y)
}
