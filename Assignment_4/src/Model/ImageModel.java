package Model;

import java.util.HashMap;
import java.util.Map;

/**
 * The ImageModel class manages the collection of Image Objects.
 * It interacts with the ImageFactory to create, load, and save images.
 */
public class ImageModel {
  private final Map<String, Image> images;

  public ImageModel() {
    this.images = new HashMap<>();
  }

  /**
   * Loads an Image from the ImageFactory
   * @param path Path to Image to Load.
   * @param name Name to store the Image under.
   * @throws IllegalArgumentException If the file format is unsupported or the file is not found.
   */
  public void loadImage(String path, String name) throws IllegalArgumentException {
    try {
      Image image = ImageFactory.loadImage(path);
      images.put(name, image);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Error Loading Image: " + e.getMessage());
    }
  }

  /**
   * Save an image with the specified name to the path.
   * @param path Path where the image should be saved.
   * @param name Name of the image that's stored to save.
   * @throws IllegalArgumentException If the image alias is not foudn or if there's an error saving the image.
   */
  public void saveImage(String name, String path) throws IllegalArgumentException {
    Image image = images.get(name);
    if (image != null) {
      try {
        ImageFactory.saveImage(image, path);
      } catch (IllegalArgumentException e) {
        throw new IllegalArgumentException("Error Saving Image: " + e.getMessage());
      }
    } else {
      throw new IllegalArgumentException("Image with name: " + name + " does not exist/was not found.");
    }
  }

  /**
   * Gets and image from the specified name.
   * @param name The name of the stored image.
   * @return Image object that was stored under the specified name.
   * @throws IllegalArgumentException If the Image is not found with the provided name.
   */
  public Image getImage(String name) throws IllegalArgumentException {
    Image image = images.get(name);
    if (image != null) {
      return image;
    } else {
      throw new IllegalArgumentException("Image with name: " + name + " does not exist/was not found.");
    }
  }

  /**
   * Checks if an image with the specified name exists.
   * @param name The name that the stored image is under.
   * @return True if the image exists, false if it doesn't.
   */
  public boolean hasImage(String name) {
    return images.containsKey(name);
  }

  /**
   * Gets the width of the image with the specified name.
   * @param name The name of the stored image.
   * @return Width of the image with the specified name.
   */
  public int getImageWidth(String name) {
    Image image = getImage(name);
    return image.getWidth();
  }

  /**
   * Gets the height of the image with the specified name.
   * @param name The name of the stored image.
   * @return Width of the image with the specified name.
   */
  public int getImageHeight(String name) {
    Image image = getImage(name);
    return image.getHeight();
  }


  /**
   * Gets the max value of the image with the specified name.
   * @param name The name of the stored image.
   * @return Max Value of the image with the specified name.
   */
  public int getImageMaxValue(String name) {
    Image image = getImage(name);
    return image.getMaxValue();
  }

  /**
   * Gets the height of the image with the specified name.
   * @param name The name of the stored image.
   * @return The pixel data of the image with the specified name.
   */
  public int[][][] getImagePixelData(String name) {
    Image image = getImage(name);
    return image.getPixels();
  }

  // TODO: Implement a removeImage() function?
}
