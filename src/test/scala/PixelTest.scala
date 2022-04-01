import Models.{Image, Pixel, PixelGrid}
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.FunSuite

/*
* Briefly tests functionality of the pixel model.
* */
class PixelTest extends FunSuite {
  test("Pixel Test Correct") {
    val pixel = new Pixel(3, 52, 22)

    assert(pixel.red == 3)
    assert(pixel.green == 52)
    assert(pixel.blue == 22)
  }

  test("Pixel Test Fail") {
    assertThrows[IllegalArgumentException](new Pixel(3, 542, 22))
  }
}
