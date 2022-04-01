import ImgFilter.{ImgFilter, InvertFilter}
import Models.Grayscale
import Services.ImgFilterService
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.FunSuite

/*
* Tests handling of the filters application.
* */
class ImgFilterServiceTest extends FunSuite {
  test("Image Filter Service Test") {
    val grayMock = mock[Grayscale]

    when(grayMock.width).thenReturn(1)
    when(grayMock.height).thenReturn(1)
    when(grayMock.getGrayValue(0,0)).thenReturn(50)

    var s = Set[ImgFilter]()
    s += new InvertFilter

    val filter = new ImgFilterService
    val grid = filter.filterService(s.toSeq, grayMock)

    assert(grid.getGrayValue(0,0) == 205)
  }

  // other methods, which are not arg handlers are tested in other classes
}
