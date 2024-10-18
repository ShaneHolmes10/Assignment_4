package Model;

import java.io.IOException;

public abstract class AbstractImage implements Image {
  protected int width;
  protected int height;
  protected int[][][] pixelData;

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  protected abstract void loadImage(String path) throws IOException;

  @Override
  public int[][][] getPixelData(String path) throws IOException {
    loadImage(path);
    return pixelData;
  }

  @Override
  public Color getPixelColor(int x, int y) throws IllegalArgumentException {
    return null;
  }

  @Override
  public void setPixelColor(int x, int y, Color color) throws IllegalArgumentException {

  }
}
