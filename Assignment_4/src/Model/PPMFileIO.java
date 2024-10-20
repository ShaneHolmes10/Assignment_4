package Model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class PPMFileIO extends AbstractFileIO {

  @Override
  protected Image loadImage(String path) throws IOException {
    Image returnImage;

    try (InputStream inputStream = Files.newInputStream(Paths.get(path))) {
      String token;
      // TODO: Make this nicer and neater.
      Scanner imageLines = readImage(inputStream);
      token = imageLines.next();

      if (!token.equals("P3")) {
        throw new IllegalArgumentException("Invalid PPM file: plain RAW file should begin with P3");
      }

      int width = imageLines.nextInt();
      int height = imageLines.nextInt();
      int maxValue = imageLines.nextInt();

      if (width <= 0 || height <= 0) {
        throw new IllegalArgumentException("Invalid image dimensions in PPM file. Width: " + width + " Height: " + height);
      }

      if (maxValue <= 0) {
        throw new IllegalArgumentException("Max Value needs to be > 0: " + maxValue);
      }

      int[][][] pixelData = new int[3][height][width];

      for (int y = 0; y < height; ++y) {
        for (int x = 0; x < width; ++x) {
          int r = imageLines.nextInt();
          int g = imageLines.nextInt();
          int b = imageLines.nextInt();

          pixelData[0][y][x] = r;
          pixelData[1][y][x] = g;
          pixelData[2][y][x] = b;
        }
      }

      returnImage = new ChannelImage(pixelData);
      returnImage.setMaxValue(maxValue);

    } catch (Exception e) {
      throw new FileNotFoundException("File Path not Valid: " + path);
    }

    return returnImage;

  }

  @Override
  protected void saveImage(Image im, String path) throws IOException {
    try(OutputStream outputStream = new FileOutputStream(path)) {
      int width = im.getWidth();
      int height = im.getHeight();
      int[][][] pixels = im.getPixels();
      String header = new StringBuilder("P3\n")
          .append(im.getWidth())
          .append(" ")
          .append(im.getHeight())
          .append("\n")
          .append(im.getMaxValue())
          .append("\n")
          .toString();

      outputStream.write(header.getBytes());

      StringBuilder pixelData = new StringBuilder();

      for (int y = 0; y < height; ++y) {
        for (int x = 0; x < width; ++x) {
          int red = pixels[0][y][x];
          int green = pixels[1][y][x];
          int blue = pixels[2][y][x] ;

          // Write RGB values
          pixelData.append(red).append(" ")
                .append(green).append(" ")
                .append(blue).append(" ");
        }
      }

      outputStream.write(pixelData.toString().getBytes());
    }
  }

  private Scanner readImage(InputStream inputStream) throws IOException {
    Scanner sc = new Scanner(inputStream);
    StringBuilder builder = new StringBuilder();
    while (sc.hasNextLine()) {
      String s = sc.nextLine().split("#")[0].trim();  // Remove inline comments
      if (!s.isEmpty()) {
        builder.append(s).append(System.lineSeparator());
      }
    }
    return new Scanner(builder.toString());
  }
}
