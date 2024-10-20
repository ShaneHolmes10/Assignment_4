package Model;

import java.io.IOException;

public abstract class FileIO {

  protected abstract Image loadImage(String path) throws IOException;

  protected abstract void saveImage(String path) throws IOException;

}
