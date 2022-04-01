import ImgFilter.InvertFilter
import Models.Grayscale
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.FunSuite

/*
* Fully tests application of the invert filter.
* */
class InvertFilterTest extends FunSuite {
  test("Invert Filter Test") {
    val grayscaleMock = mock[Grayscale]

    when(grayscaleMock.getGrayValue(0,0)).thenReturn(50)
    when(grayscaleMock.getGrayValue(0,1)).thenReturn(10)
    when(grayscaleMock.getGrayValue(1,0)).thenReturn(0)
    when(grayscaleMock.getGrayValue(1,1)).thenReturn(5)

    when(grayscaleMock.height).thenReturn(2)
    when(grayscaleMock.width).thenReturn(2)

    val filter = new InvertFilter
    val inverted = filter.applyFilter(grayscaleMock)

    assert(inverted.getGrayValue(0,0) == 205)
    assert(inverted.getGrayValue(0,1) == 245)
    assert(inverted.getGrayValue(1,0) == 255)
    assert(inverted.getGrayValue(1,1) == 250)
  }
}
