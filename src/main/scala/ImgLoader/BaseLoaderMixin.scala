package ImgLoader

import java.io.File

import Factory.ImgFactory
import Models.Image
import javax.imageio.ImageIO

/*
* Implements loading, using imageIO library.
* */
trait BaseLoaderMixin extends ImgLoader {

  /*
  * Reads data from an image and creates a BufferedImage structure, where
  * data are being stored.
  * */
  override def fromPath(path: String): Image = {
    val img = ImageIO.read(new File(path))
    ImgFactory.fromBufferedImage(img)
  }
}
