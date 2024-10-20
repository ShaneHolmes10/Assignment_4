package Model;

import java.io.IOException;

/**
 * This defines the standard interface we want for images.
 * This interface is composed only of getters to leave the image
 * class itself immutable
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
   * This gives the red component of the pixel at the coordinate.
   *
   * @param x coordinate of pixel
   * @param y coordinate of pixel
   * @return integer value of red
   */
  int getRed(int x, int y);

  /**
   * This gives the gree component of the pixel at the coordinate.
   *
   * @param x coordinate of pixel
   * @param y coordinate of pixel
   * @return integer value of green
   */
  int getGreen(int x, int y);

  /**
   * This gives the blue component of the pixel at the coordinate.
   *
   * @param x coordinate of pixel
   * @param y coordinate of pixel
   * @return integer value of blue
   */
  int getBlue(int x, int y);

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


}
