package ImgFilter

import Models.Grayscale

/*
* This class is used to invert an image, meaning changing its grayscale values.
* */
class InvertFilter extends ImgFilter {

  /*
  * Calculates new grayscale value for each pixel (255-current grayscale) and
  * stores it in a new grayscale grid.
  * */
  def applyFilter(grayGrid : Grayscale) : Grayscale = {
    val newGrid = new Grayscale(Array.ofDim[Int](grayGrid.width, grayGrid.height))
    for (x <- 0 until grayGrid.width) {
      for (y <- 0 until grayGrid.height) {
        newGrid.setGrayValue(x, y, 255 - grayGrid.getGrayValue(x,y))
      }
    }
    newGrid
  }

}
