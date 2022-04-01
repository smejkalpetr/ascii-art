import Models.{Image, Pixel, PixelGrid}
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.FunSuite

/*
* Tests the Image model and its functions.
* */
class ImageTest extends FunSuite {
  test("Image Test") {
    val pixelGridMock = mock[PixelGrid]
    val pixelMock = mock[Pixel]

    when(pixelMock.red).thenReturn(3)
    when(pixelMock.green).thenReturn(64)
    when(pixelMock.blue).thenReturn(164)

    when(pixelGridMock.getPixel(0, 0)).thenReturn(pixelMock)

    val img = new Image(pixelGridMock)
    val pixel = img.getPixel(0,0)

    assert(pixel == pixelMock)
    assert(pixel.red == 3)
    assert(pixel.green == 64)
    assert(pixel.blue == 164)
  }
}
