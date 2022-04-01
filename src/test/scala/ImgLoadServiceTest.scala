import Services.ImgLoadService
import org.scalatest.FunSuite

/*
* Tests error handling of the load service.
* */
class ImgLoadServiceTest extends FunSuite {
  test("Image Load Service Test Negative") {
    val loadSer = new ImgLoadService

    assertThrows[IllegalArgumentException](loadSer.fromPath("/file.cvs"))
  }
}
