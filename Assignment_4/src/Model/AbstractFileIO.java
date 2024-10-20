package Model;

import java.io.IOException;

public abstract class AbstractFileIO {

  protected abstract Image loadImage(String path) throws IOException;

  protected abstract void saveImage(Image im, String path) throws IOException;

}
