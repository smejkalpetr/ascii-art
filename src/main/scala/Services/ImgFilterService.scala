package Services

import ImgFilter.ImgFilter
import Models.Grayscale

/*
* This class handles applying all filters to the given image.
* */
class ImgFilterService {

  /*
  * Calls factories that apply each filter that has been given in the sequence.
  * */
  def filterService(filters : Seq[ImgFilter], grayGrid : Grayscale) : Grayscale = {
    var tmpGrayGrid = grayGrid
    filters.foreach(x => { tmpGrayGrid = x.applyFilter(tmpGrayGrid) })
    tmpGrayGrid
  }
}
