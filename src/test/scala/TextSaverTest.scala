import java.io.FileInputStream
import java.nio.file.Files

import ImgSaver.TextSaver
import Models.ASCIIGrid
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.FunSuite

/*
* Tests saving of an image (in ascii art) into a text file.
* */
class TextSaverTest extends FunSuite {
  test("Text Saver Test") {
    val asciiMock = mock[ASCIIGrid]

    when(asciiMock.getChar(0, 0)).thenReturn(':')
    when(asciiMock.getWidth).thenReturn(2)
    when(asciiMock.getHeight).thenReturn(2)

    val randFile = Files.createTempFile("test", "txt")

    val ts = new TextSaver
    ts.savePath = randFile.toString
    ts.save(asciiMock)

    val in = new FileInputStream(randFile.toString)

    val ch = in.read

    assert(ch == ':')
  }
}
