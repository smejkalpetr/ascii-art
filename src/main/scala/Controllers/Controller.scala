package Controllers

import Factory.{ASCIIFactory, GrayscaleFactory}
import ImgSaver.{ConsoleSaver, ImgSaver, TextSaver}
import ImgFilter.{ImgFilter, InvertFilter}
import Models.Image
import Services.{ImgFilterService, ImgLoadService, ImgSaveService}

/*
* Handles input and controls flow of the program.
* */
class Controller {
  /*
  * Safely pops element and increments iterator. Util function.
  * */
  private def _popIterator(it : Iterator[String]): String = {
    require(it.hasNext, "Invalid number of arguments.")
    it.next()
  }

  /*
  * Controls the whole flow of the program.
  * */
  def run(inpArg: Seq[String]): Unit = {
    var outputs = Set[ImgSaver]()
    var filters = Set[ImgFilter]()
    var img: Option[Image] = None
    val loadService = new ImgLoadService
    val it = inpArg.iterator

    // checks and recognizes input arguments
    while (it.hasNext) {
      val current = it.next()

      current match {
        case "--image" =>
          val path = _popIterator(it)
          img = Some(loadService.fromPath(path))
        case "--output-file" =>
          val tSaver = new TextSaver
          tSaver.savePath = _popIterator(it)
          outputs += tSaver
        case "--output-console" =>
          outputs += new ConsoleSaver
        case "--invert" =>
          filters += new InvertFilter
        case _ =>
          throw new IllegalArgumentException("Invalid undefined arguments.")
      }
    }
    require(img.nonEmpty, "Image not loaded.")

    // convert image to grayscale grid
    val grayscaleGrid = GrayscaleFactory.fromImage(img.get)

    // apply filters
    val filter = new ImgFilterService
    val grayFiltered = filter.filterService(filters.toSeq, grayscaleGrid)

    // save or print to specified formats
    val save = new ImgSaveService
    save.saveService(outputs.toSeq, ASCIIFactory.fromGray(grayFiltered))
  }
}
