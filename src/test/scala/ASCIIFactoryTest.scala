import Factory.ASCIIFactory
import Models.{ASCIIGrid, Grayscale}
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.FunSuite

/*
* Tests ASCIIFactory class, the conversion and then its function.
* */
class ASCIIFactoryTest extends FunSuite {
  test("Char Convertor Test") {
    assert(ASCIIFactory.grayscaleToChar(24) == '.')
    assert(ASCIIFactory.grayscaleToChar(44) == ':')
    assert(ASCIIFactory.grayscaleToChar(83) == '-')
    assert(ASCIIFactory.grayscaleToChar(111) == '=')
    assert(ASCIIFactory.grayscaleToChar(123) == '+')
    assert(ASCIIFactory.grayscaleToChar(165) == '*')
    assert(ASCIIFactory.grayscaleToChar(190) == '#')
    assert(ASCIIFactory.grayscaleToChar(220) == '%')
    assert(ASCIIFactory.grayscaleToChar(244) == '$')
  }

  test("Grayscale to ASCII Test") {
    val grayscaleMock = mock[Grayscale]

    when(grayscaleMock.getGrayValue(0,0)).thenReturn(123)
    when(grayscaleMock.getGrayValue(0,1)).thenReturn(53)
    when(grayscaleMock.getGrayValue(1,0)).thenReturn(49)
    when(grayscaleMock.getGrayValue(1,1)).thenReturn(111)
    when(grayscaleMock.height).thenReturn(2)
    when(grayscaleMock.width).thenReturn(2)

    val arr = Array.ofDim[Char](2,2)
    arr(0)(0) = '+'
    arr(0)(1) = ':'
    arr(1)(0) = ':'
    arr(1)(1) = '='

    val grid = new ASCIIGrid(arr)

    assert(ASCIIFactory.fromGray(grayscaleMock).getChar(0,0) == '+')
    assert(ASCIIFactory.fromGray(grayscaleMock).getChar(0,1) == ':')
    assert(ASCIIFactory.fromGray(grayscaleMock).getChar(1,0) == ':')
    assert(ASCIIFactory.fromGray(grayscaleMock).getChar(1,1) == '=')
  }
}
