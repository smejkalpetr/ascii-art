package Factory

import java.awt.Color
import java.awt.image.BufferedImage

import Models.{Image, Pixel, PixelGrid}

/*
* This singleton is used to convert BufferedImage at first into Pixel structure
* and then store into Image structure.
* */
object ImgFactory {

  /*
  * Creates grid of Pixels that is further being stored in Image.
  * */
  def fromBufferedImage(buffer : BufferedImage) : Image = {
    val w = buffer.getWidth
    val h = buffer.getHeight

    val grid = Array.ofDim[Pixel](w, h)

    for (x <- 0 until w) {
      for (y <- 0 until h) {
        val color = new Color(buffer.getRGB(x, y))
        val pixel = new Pixel(color.getRed, color.getGreen, color.getBlue)
        grid(x)(y) = pixel
      }
    }

    new Image(new PixelGrid(grid))
  }
}
