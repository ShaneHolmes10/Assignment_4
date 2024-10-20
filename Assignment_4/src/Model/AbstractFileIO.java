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
  public Color getPixelColor(int x, int y) throws IllegalArgumentException {
    return null;
  }

}
