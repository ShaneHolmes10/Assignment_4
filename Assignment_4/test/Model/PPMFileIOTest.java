package Model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PPMFileIOTest {


  @Test
  public void testLoadPPM() {

    Image im = ImageFactory.loadImage("Assignment_4/files/blackbuck.ascii.ppm");

    assertEquals(512, im.getWidth());
    assertEquals(512, im.getHeight());
  }

  @Test
  public void testSavePPM() {
    Image im1 = ImageFactory.loadImage("Assignment_4/files/blackbuck.ascii.ppm");

    ImageFactory.saveImage(im1, "Assignment_4/files/blackbuck2.ascii.ppm");

    Image im2 = ImageFactory.loadImage("Assignment_4/files/blackbuck2.ascii.ppm");

    assertEquals(im1.getWidth(), im2.getWidth());
    assertEquals(im1.getHeight(), im2.getHeight());
    assertEquals(im1.getMaxValue(), im2.getMaxValue());
    assertEquals(im1.getPixels(), im2.getPixels());
  }
}