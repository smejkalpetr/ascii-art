import java.awt.image.BufferedImage

import Factory.ImgFactory
import org.scalatest.FunSuite

/*
* Tests the image factory - not much tests needed because of using the
* BufferedImage library.
* */
class ImgFactoryTest extends FunSuite {
  test("Image Factory Test") {
    val buff = new BufferedImage(12, 32, BufferedImage.TYPE_INT_RGB)
    val img = ImgFactory.fromBufferedImage(buff)

    assert(img.width == 12)
    assert(img.height == 32)
  }
}
