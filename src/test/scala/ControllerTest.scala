import Controllers.Controller
import org.scalatest.FunSuite

/*
* Tests the controller - especially the inp args handling.
* */
class ControllerTest extends FunSuite {
  test("Controller Test Wrong Argument") {
    val cont = new Controller
    var s = Set[String]()
    s += "--void"

    assertThrows[IllegalArgumentException](cont.run(s.toSeq))
  }

  test("Controller Test Wrong Path") {
    val cont = new Controller
    var s = Set[String]()
    s += "--image"

    assertThrows[IllegalArgumentException](cont.run(s.toSeq))
  }




}
