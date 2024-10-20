package Model;

public class AbstractImage implements Image{

  public AbstractImage(int[][][] pixelData) throws IllegalArgumentException {}

  @Override
  public int getWidth() {
    return 0;
  }

  @Override
  public int getHeight() {
    return 0;
  }

  @Override
  public int getRed(int x, int y) {
    return 0;
  }

  @Override
  public int getGreen(int x, int y) {
    return 0;
  }

  @Override
  public int getBlue(int x, int y) {
    return 0;
  }

  @Override
  public Color getPixelColor(int x, int y) throws IllegalArgumentException {
    return null;
  }
}
