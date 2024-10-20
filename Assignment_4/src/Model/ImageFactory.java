package Model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ImageFactory {
  private static final Map<String, Class<? extends AbstractFileIO>> formatMap = new HashMap<>();

  static {
    formatMap.put("ppm", PPMFileIO.class);
    // Add other formats here (jpeg, bmp, etc.)
  }

  private static AbstractFileIO createImage(String extension) {
    Class<? extends AbstractFileIO> formatClass = formatMap.get(extension.toLowerCase());
    if (formatClass != null) {
      try {
        // Instead of the deprecated .newInstance(), use this modern approach
        return formatClass.getDeclaredConstructor().newInstance();
      } catch (ReflectiveOperationException e) {
        throw new RuntimeException("Failed to instantiate image reader for format: " + extension, e);
      }
    } else {
      throw new UnsupportedOperationException("Unsupported image format: " + extension);
    }
  }

  private static String extensionExtractor(String path) throws IllegalArgumentException {
    // Find the last dot in the file name
    int dotIndex = path.lastIndexOf('.');

    // If there is no dot or it's the first character, there is no extension
    if (dotIndex > 0 && dotIndex < path.length() - 1) {
      return path.substring(dotIndex + 1);
    }

    throw new IllegalArgumentException("File extension not be found");

  }


  public static Image loadImage(String path) throws IllegalArgumentException {
    String extension = extensionExtractor(path);

    try {
      return createImage(extension).loadImage(path);
    } catch(IOException e) {
      throw new IllegalArgumentException("File not found at path: " + path);
    }
  }

  public static void saveImage(Image im, String path) throws IllegalArgumentException {
    String extension = extensionExtractor(path);

    try {
      createImage(extension).saveImage(im, path);
    } catch(IOException e) {
      // TODO: Fix this error message.
      throw new IllegalArgumentException("File not found at path: " + path);
    }
  }


}