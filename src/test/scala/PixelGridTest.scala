import Models.{Pixel, PixelGrid}
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.FunSuite

/*
* Tests the pixel model and its functions.
* */
class PixelGridTest extends FunSuite{
  test("Pixel Grid Test") {
    val pixelMock = mock[Pixel]

    when(pixelMock.red).thenReturn(3)
    when(pixelMock.green).thenReturn(64)
    when(pixelMock.blue).thenReturn(164)

    val gridArr = Array.ofDim[Pixel](1,1)
    gridArr(0)(0) = pixelMock

    val grid = new PixelGrid(gridArr)
    assert(grid.getPixel(0,0).red == 3)
    assert(grid.getPixel(0,0).green == 64)
    assert(grid.getPixel(0,0).blue == 164)
  }
}
