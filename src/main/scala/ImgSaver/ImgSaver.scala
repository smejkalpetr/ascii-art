package ImgSaver

import Models.ASCIIGrid

/*
* Interface for different images saver types.
* */
trait ImgSaver {
  def save(grid : ASCIIGrid) : Unit
}
