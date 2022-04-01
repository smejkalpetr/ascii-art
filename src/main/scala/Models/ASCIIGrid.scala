package Models

/*
* This model stores data as a 2D array with ascii chars.
* */
class ASCIIGrid(private val _grid : Array[Array[Char]]) {
  def getWidth : Int = _grid.length
  def getHeight : Int = _grid(0).length

  def getChar(x : Int, y : Int) : Char = {
    _grid(x)(y)
  }
}
