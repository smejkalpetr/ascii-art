package Services

import ImgLoader.{ImgLoader, JPGLoader, PNGLoader}
import Models.Image

/*
* This class handles loading of an image.
* */
class ImgLoadService {
  private val _imgLoaders = Map[String, ImgLoader](
    "jpg" -> new JPGLoader,
    "jpeg" -> new JPGLoader,
    "png" -> new PNGLoader
  )

  /*
  * Extracts the path and calls appropriate functions to load an image.
  * */
  def fromPath(path : String) : Image = {
    val extension = path.split("\\.").last.toLowerCase()
    require(_imgLoaders.contains(extension), "Unsupported extension.")
    _imgLoaders(extension).fromPath(path)
  }
}
