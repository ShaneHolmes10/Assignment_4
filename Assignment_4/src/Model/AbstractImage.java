package Model;

public abstract class AbstractImage implements Image{

  @Override
  public abstract int getWidth();

  @Override
  public abstract int getHeight();

  @Override
  public abstract int getRed(int x, int y);

  @Override
  public abstract int getGreen(int x, int y);

  @Override
  public abstract int getBlue(int x, int y);

  @Override
  public abstract InterfaceColor getPixelColor(int x, int y) throws IllegalArgumentException;

  @Override
  public abstract int[][][] getPixels();

}
