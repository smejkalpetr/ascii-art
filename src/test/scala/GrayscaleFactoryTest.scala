import Factory.GrayscaleFactory
import Models.{Image, Pixel, Grayscale}
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.FunSuite

/*
* Tests the process of calculating grayscale values.
* */
class GrayscaleFactoryTest extends FunSuite {
  test("Grayscale Factory fromImage Test") {
    val imageMock = mock[Image]
    val pixelMock = mock[Pixel]

    when(pixelMock.red).thenReturn(53)
    when(pixelMock.red).thenReturn(43)
    when(pixelMock.red).thenReturn(112)

    when(imageMock.getPixel(0,0)).thenReturn(pixelMock)
    when(imageMock.width).thenReturn(1)
    when(imageMock.height).thenReturn(1)

    val grscale = GrayscaleFactory.fromImage(imageMock)

    assert(grscale.getGrayValue(0,0) == 33)
  }
}
