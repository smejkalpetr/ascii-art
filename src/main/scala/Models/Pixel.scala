package Models

/*
* A model to hold rgb values of a pixel.
* */
class Pixel(val red : Int, val green : Int, val blue : Int) {
  require(red >= 0 && red <= 255 && green >= 0 && green <= 255 && blue >= 0 && blue <= 255, "Invalid Pixel Value.")
}
