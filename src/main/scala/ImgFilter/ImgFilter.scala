package ImgFilter

import Models.Grayscale

/*
* Interface for image filters.
* */
trait ImgFilter {
  def applyFilter(grayGrid : Grayscale) : Grayscale
}
