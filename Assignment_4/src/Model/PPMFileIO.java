package Model;

import java.io.FileNotFoundException;
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
        System.out.println("Invalid PPM file: plain RAW file should begin with P3");
      }
      int width = imageLines.nextInt();
      System.out.println("Width of image: "+width);
      int height = imageLines.nextInt();
      System.out.println("Height of image: "+height);
      int maxValue = imageLines.nextInt();
      System.out.println("Maximum value of a color in this file (usually 255): "+maxValue);

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
    try(OutputStream outputStream = Files.newOutputStream(Paths.get(path))) {
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

      for (int y = 0; y < im.getHeight(); ++y) {
        for (int x = 0; x < im.getWidth(); ++x) {
          outputStream.write(pixels[0][y][x]);
          outputStream.write(pixels[1][y][x]);
          outputStream.write(pixels[2][y][x]);
        }
      }
    } catch (Exception e) {
      // TODO: Figure out what exception to throw.
      throw new IOException("FIGURE OUT WHAT THIS IS.");
    }
  }

  private Scanner readImage(InputStream inputStream) throws IOException {
    // Don't need to try/catch again beacuse the file was already parsed.
    Scanner sc = new Scanner(inputStream);
    StringBuilder builder = new StringBuilder();
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }

    return new Scanner(builder.toString());
  }

}
