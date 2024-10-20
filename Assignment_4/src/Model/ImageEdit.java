package Model;


public abstract class ImageEdit {

    public static Image brighten(Image im, int brightenValue) throws IllegalArgumentException {

      if (brightenValue < 0) {
        throw new IllegalArgumentException("Value cannot be less than 0");
      }

      int width = im.getWidth();
      int height = im.getHeight();

      int[][][] pixeldata = new int[3][height][width];

      InterfaceColor pixelColor;
      for (int y = 0; y < height; ++y) {
        for (int x = 0; x < width; ++x) {

          pixeldata[0][y][x] = Math.max(0, Math.min(im.getRed(x, y) + brightenValue, 255));
          pixeldata[1][y][x] = Math.max(0, Math.min(im.getGreen(x, y) + brightenValue, 255));
          pixeldata[2][y][x] = Math.max(0, Math.min(im.getBlue(x, y) + brightenValue, 255));

        }
      }

      return new ChannelImage(pixeldata);
    }


  public static Image darken(Image im, int darkenValue) throws IllegalArgumentException {

    if (darkenValue < 0) {
      throw new IllegalArgumentException("Value cannot be less than 0");
    }

    int width = im.getWidth();
    int height = im.getHeight();

    int[][][] pixeldata = new int[3][height][width];

    InterfaceColor pixelColor;
    for (int y = 0; y < height; ++y) {
      for (int x = 0; x < width; ++x) {

        pixeldata[0][y][x] = Math.max(0, Math.min(im.getRed(x, y) - darkenValue, 255));
        pixeldata[1][y][x] = Math.max(0, Math.min(im.getGreen(x, y) - darkenValue, 255));
        pixeldata[2][y][x] = Math.max(0, Math.min(im.getBlue(x, y) - darkenValue, 255));

      }
    }

    return new ChannelImage(pixeldata);
  }


  public static Image blur(Image im) {


      // I could make it so that the kernel operation
      // is done more elegantly but I'll keep it this way for now.

      // Also do we want to use color in here? I feel like the overhead from
      // creating a bunch of objects is not a great idea.

      // Set pixel color would be much nicer in here actually, I would really like to
      // to make the Image object mutable at least just for the package.

    double[][] kernel = {
            {0.0625, 0.125, 0.0625},
            {0.125, 0.25, 0.125},
            {0.0625, 0.125, 0.0625}
    };

    int width = im.getWidth();
    int height = im.getHeight();

    int[][][] pixeldata = new int[3][height][width];

    InterfaceColor pixelColor;
    for (int y = 1; y < height - 1; ++y) {
      for (int x = 1; x < width - 1; ++x) {

        // I desperately want Image to be mutable

        im.getPixelColor(x-1, y-1).scale(kernel[0][0]);
        im.getPixelColor(x, y-11).scale(kernel[0][1]);
        im.getPixelColor(x+1, y-1).scale(kernel[0][2]);

        im.getPixelColor(x-1, y).scale(kernel[1][0]);
        im.getPixelColor(x, y).scale(kernel[1][1]);
        im.getPixelColor(x+1, y).scale(kernel[1][2]);

        im.getPixelColor(x-1, y+1).scale(kernel[2][0]);
        im.getPixelColor(x, y+1).scale(kernel[2][1]);
        im.getPixelColor(x+1, y+1).scale(kernel[2][2]);

      }
    }

    return new ChannelImage(pixeldata);
  }




}
