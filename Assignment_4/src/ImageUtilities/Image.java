package ImageUtilities;

/**
 * This defines the standard interface we want for images.
 *
 */
public interface Image {

  /**
   * This produces the width of the image.
   *
   * @return width
   */
  int getWidth();

  /**
   * This produces the height of the image
   *
   * @return height
   */
  int getHeight();

  /**
   * This produces the color of a given pixel in the image.
   * If we try to get a color out of bounds then we will
   * need to throw an illegal error exception.
   *
   * @param x x position of pixel
   * @param y y position of pixel
   * @return rbg color value
   * @throws IllegalArgumentException if illegal inputs are given
   */
  Color getPixelColor(int x, int y) throws IllegalArgumentException;

  /**
   * This changes the color value of a given pixel.
   * If we try to get a color out of bounds then we will
   * need to throw an illegal error exception.
   *
   * @param x x position of pixel
   * @param y y position of pixel
   * @param color color of pixel
   * @throws IllegalArgumentException if illegal inputs are given
   */
  void setPixelColor(int x, int y, Color color) throws IllegalArgumentException;

}
