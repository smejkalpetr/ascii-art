package ImgSaver

import java.io.{File, FileOutputStream}

import Models.ASCIIGrid

/*
* This class saves the result to a file on a given path.
* */
case class TextSaver() extends ImgSaver {
  var savePath : String = ""

  /*
  * This function iterates through ASCIIGrid and saves each
  * character to a file on savePath using streams.
  * */
  def save(grid : ASCIIGrid) : Unit = {
    val w = grid.getWidth
    val h = grid.getHeight

    val file = new File(savePath)
    val outStream = new FileOutputStream(file, false)

    file.createNewFile()

    for (x <- 0 until w) {
      for (y <- 0 until h) {
        outStream.write(grid.getChar(x, y))
      }
      outStream.write('\n')
    }
    outStream.flush()
    outStream.close()
  }
}
