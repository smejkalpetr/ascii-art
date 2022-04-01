package Factory

import Models.{Grayscale, Image}

import scala.math.floor

/*
* This singleton is used to calculate value of grayscale Ints that are further
* being stored in GrayscaleGrid.
* */
object GrayscaleFactory {
  /*
  * This function counts grayscale value for every pixel that is stored in Image.
  * Then it's stored in GrayscaleGrid
  * */
  def fromImage(img : Image) : Grayscale = {
    val w = img.width
    val h = img.height
    val grayGrid = Array.ofDim[Int](w, h)

    for (x <- 0 until w)
      for (y <- 0 until h) {
        val pixel = img.getPixel(x, y)
        grayGrid(x)(y) = floor((0.3 * pixel.red) + (0.59 * pixel.green) + (0.11 * pixel.blue)).toInt
      }

    new Grayscale(grayGrid)
  }
}
