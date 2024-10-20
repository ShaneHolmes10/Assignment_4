package Model;


public abstract class ImageEdit {

    public static Image brighten(Image im, int brightenValue) {

      int width = im.getWidth();
      int height = im.getHeight();

      int[][][] pixeldata = new int[3][height][width];

      Color pixelColor;
      for (int y = 0; y < height; ++y) {
        for (int x = 0; x < width; ++x) {

          pixeldata[0][y][x] = Math.max(0, Math.min(im.getRed(x, y) + brightenValue, 255));
          pixeldata[1][y][x] = Math.max(0, Math.min(im.getGreen(x, y) + brightenValue, 255));
          pixeldata[2][y][x] = Math.max(0, Math.min(im.getBlue(x, y) + brightenValue, 255));

        }
      }



      return new ChannelImage(pixeldata);
    }



}
