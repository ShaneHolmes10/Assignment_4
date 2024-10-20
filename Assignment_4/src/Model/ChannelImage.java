package Model;

import java.util.Arrays;
import java.util.Objects;

/**
 * This is a representation of an image that uses
 * a channel based representation of an image. With
 * this representation each color channel is its own
 * image. This form is standard for many image processing
 * tools and should make certain operations easier to perform.
 *
 */
public class ChannelImage extends AbstractImage {

  private int[][][] pixelData;
  private int width;
  private int height;
  private int maxValue = 255;

  /**
   * This method provides a check to evaluate if the input pixel position
   * is out of bounds.
   *
   * @param x x position of the pixel
   * @param y y position of the pixel
   * @throws IllegalArgumentException throw if any of the values are illegal
   */
  private void illegalPositionChecker(int x, int y) throws IllegalArgumentException {

    if (x < 0 || x > width-1) {
      throw new IllegalArgumentException("x is out of bounds");
    }

    if (y < 0 || y > height-1) {
      throw new IllegalArgumentException("y is out of bounds");
    }

  }

  /**
   * This instantiates this image instance to a
   * certain width and height.
   *
   * @param pixelData color information
   */
  public ChannelImage(int[][][] pixelData) {

    if (pixelData.length != 3) {
      throw new IllegalArgumentException("Must have 3 channels");
    }

    this.pixelData = pixelData;

    this.width = pixelData[0][0].length;
    this.height = pixelData[0].length;
  }


  /**
   * This produces the width of the image.
   *
   * @return width
   */
  // @Override
  public int getWidth() {
    return this.width;
  }

  /**
   * This produces the height of the image
   *
   * @return height
   */
  // @Override
  public int getHeight() {
    return this.height;
  }

  public int getMaxValue() { return this.maxValue; }

  public void setMaxValue(int maxValue) {
    this.maxValue = maxValue;
  }

  @Override
  public int getRed(int x, int y) {
    return pixelData[0][y][x];
  }

  @Override
  public int getGreen(int x, int y) {
    return pixelData[1][y][x];
  }

  @Override
  public int getBlue(int x, int y) {
    return pixelData[2][y][x];
  }


  /**
   * This produces the color of a given pixel in the image.
   *
   * @param x x position of pixel
   * @param y y position of pixel
   * @return rbg color value
   */
  @Override
  public InterfaceColor getPixelColor(int x, int y) throws IllegalArgumentException {

    // Check legality of the pixel coordinate
    illegalPositionChecker(x, y);

    return new SimpleColor(pixelData[0][y][x], pixelData[1][y][x], pixelData[2][y][x]);
  }




  @Override
  public int[][][] getPixels() {
    return pixelData;
  }


  /**
   *  This is a string representation of this class,
   *  it simply indicated the dimensions of the image.
   *
   * @return string representation
   */
  @Override
  public String toString() {
    StringBuilder returnString = new StringBuilder();

    returnString.append("Image: ");
    returnString.append(width);
    returnString.append("x");
    returnString.append(height);

    return returnString.toString();

  }

  /**
   * This determines if the input object is equal to this
   * object. It's written such that classes that implement from
   * the image interface and are not necessarily of this type
   * can still be equal to this object.
   *
   * @param o input object
   * @return value of equality
   */
  @Override
  public boolean equals(Object o) {

    // If the object instance is not an Image then return false
    if (! (o instanceof ChannelImage) ) {
      return false;
    }

    // Cast object to image
    Image castImage = (Image) o;

    // Determine if the two images are the same size
    if (this.width != castImage.getWidth() || this.height != castImage.getHeight()) {
      return false;
    }

    // Check each pixel in the image to determine if they're equal, because the
    // last test passed we know they must be the same dimension
    for (int row = 0; row < this.height; row++) {

      for (int col = 0; col < this.width; col++) {

        if ( ! this.getPixelColor(col, row).equals(castImage.getPixelColor(col, row))) {
          return false;
        }

      }
    }

    return true;

  }

  /**
   * Generate a unique hash code for this image object.
   *
   * @return hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(width, height, Arrays.deepHashCode(pixelData));
  }
}
