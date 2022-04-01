package Services

import ImgSaver.ImgSaver
import Models.ASCIIGrid

/*
* This class handles saving of an image in all given formats.
* */
class ImgSaveService {

  /*
  * Iterates through the sequence and calls appropriate functions to
  * apply correct savers to the image.
  * */
  def saveService(paths : Seq[ImgSaver], grid : ASCIIGrid): Unit = {
    paths.foreach(x => { x.save(grid) })
  }
}
