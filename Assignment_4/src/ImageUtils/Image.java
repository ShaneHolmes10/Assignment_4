package ImageUtils;

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
   *
   * @param x x position of pixel
   * @param y y position of pixel
   * @return rbg color value
   */
  int[] getPixelColor(int x, int y);

  /**
   * This changes the color value of a given pixel.
   *
   * @param x x position of pixel
   * @param y y position of pixel
   * @param r red value of pixel
   * @param g green value of pixel
   * @param b blue value of pixel
   */
  void setPixelColor(int x, int y, int r, int g, int b);

}
