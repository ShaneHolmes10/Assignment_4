package Model;

import java.util.HashMap;
import java.util.Map;

public class ImageFactory {
  // Map that maps the extension to the specific class.
  private static final Map<String, Class<? extends AbstractImage>> formatMap = new HashMap<>();

  static{
    formatMap.put("ppm", PPMImage.class);
  }

  public static AbstractImage createImage(String extension)
      throws IllegalArgumentException, InstantiationException, IllegalAccessException {
    Class<? extends AbstractImage> formatClass = formatMap.get(extension.toLowerCase());
    if (formatClass != null) {
      return formatClass.newInstance();
    } else {
      throw new IllegalArgumentException("Extension not valid: " + extension);
    }
  }
}
