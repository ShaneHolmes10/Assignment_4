package ImageUtilities;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

/**
 * This interface defines the
 *
 */
public interface Handler {

  /**
   * This loads the image from the given path.
   * It can handle ppm, jpg, png, and bmp.
   *
   * @param path path to the file
   * @return image data in a data object
   */
  static Image loadImage(String path) {
    

  }

  /**
   * This saves the image to the string path.
   * Where the string path contains the name and
   * image type of the file.
   *
   * @param path this is the path that an image
   *             will be saved to
   * @param im this is the image that we will
   *           save to the path
   */
  static void saveImage(String path, Image im) {

  }

  /**
   *
   *
   * @param im
   * @return
   */
  Image flipImage(Image im);

  /**
   *
   * @param im
   * @return
   */
  Image brighten(Image im);

  /**
   *
   * @param im
   * @return
   */
  Image darken(Image im);

  /**
   *
   * @param im
   * @return
   */
  Image split(Image im);

  /**
   *
   * @param im1
   * @param im2
   * @param im3
   * @return
   */
  Image combine(Image im1, Image im2, Image im3);

  /**
   *
   * @param im
   * @return
   */
  Image blur(Image im);

  /**
   *
   * @param im
   * @return
   */
  Image sharpen(Image im);

  /**
   *
   * @param im
   * @return
   */
  Image convertToSepia(Image im);

}
