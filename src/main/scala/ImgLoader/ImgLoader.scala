package ImgLoader

import Models.Image

/*
* Interface for image loaders.
* */
trait ImgLoader {
  def fromPath(path : String) : Image
}
