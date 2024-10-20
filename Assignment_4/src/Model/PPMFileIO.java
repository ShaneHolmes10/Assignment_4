package Model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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


    } catch (Exception e) {
      throw new FileNotFoundException("File Path not Valid: " + path);
    }

    return returnImage;

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


  @Override
  protected void saveImage(String path) throws IOException {

  }


}
