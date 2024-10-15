package ImageUtils;

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
public class ChannelImage implements Image {

  private int[][][] pixelData;
  private int width;
  private int height;

  /**
   * This instantiates this image instance to a
   * certain width and height.
   *
   * @param width width of image
   * @param height height of image
   */
  public ChannelImage(int width, int height) {
    pixelData = new int[3][height][width];
    this.width = width;
    this.height = height;

  }

  /**
   * This will give other classes in this package the ability to
   * set all the pixel data for this class.
   *
   * @param pixelData input pixel data
   */
  protected void setImage(int[][][] pixelData) {
    this.pixelData = pixelData;
  }

  /**
   * This will give other classes in this package the ability to
   * get all the pixel data for this class.
   *
   * @return pixel data
   */
  protected int[][][] getImage() {
    return pixelData;
  }

  /**
   * This produces the width of the image.
   *
   * @return width
   */
  @Override
  public int getWidth() {
    return this.width;
  }

  /**
   * This produces the height of the image
   *
   * @return height
   */
  @Override
  public int getHeight() {
    return this.height;
  }

  /**
   * This produces the color of a given pixel in the image.
   *
   * @param x x position of pixel
   * @param y y position of pixel
   * @return rbg color value
   */
  @Override
  public int[] getPixelColor(int x, int y) {
    int[] returnColor = new int[3];

    returnColor[0] = pixelData[0][x][y];
    returnColor[1] = pixelData[1][x][y];
    returnColor[2] = pixelData[2][x][y];

    return returnColor;
  }

  /**
   * This changes the color value of a given pixel.
   *
   * @param x x position of pixel
   * @param y y position of pixel
   * @param r red value of pixel
   * @param g green value of pixel
   * @param b blue value of pixel
   */
  @Override
  public void setPixelColor(int x, int y, int r, int g, int b) {

    pixelData[0][x][y] = r;
    pixelData[1][x][y] = g;
    pixelData[2][x][y] = b;

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
    returnString.append(" x ");
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

    // Check each pixel in the image to determine if they're equal, bacause the
    // last test passed we know they must be the same dimension
    for (int row = 0; row < this.height; row++) {
      for (int col = 0; col < this.width; col++) {

        if (this.getPixelColor(row, col) != castImage.getPixelColor(row, col)) {
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
