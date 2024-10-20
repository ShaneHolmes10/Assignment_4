package Model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PPMFileIOTest {


  @Test
  public void testLoadPPM() {

    Image im = ImageFactory.loadImage("C:\\Users\\Shane Holmes\\OneDrive\\Desktop\\Programming Design Paradigms\\Assignment 4\\Assignment_4\\Assignment_4\\files\\snail.ascii.ppm");

    assertEquals(256, im.getWidth());
    assertEquals(256, im.getHeight());

  }

  @Test
  public void testSavePPM() {
    Image im1 = ImageFactory.loadImage("C:\\Users\\Shane Holmes\\OneDrive\\Desktop\\Programming Design Paradigms\\Assignment 4\\Assignment_4\\Assignment_4\\files\\snail.ascii.ppm");

    ImageFactory.saveImage(im1, "C:\\Users\\Shane Holmes\\OneDrive\\Desktop\\Programming Design Paradigms\\Assignment 4\\Assignment_4\\Assignment_4\\files\\snailSAVED.ascii.ppm");

    Image im2 = ImageFactory.loadImage("C:\\Users\\Shane Holmes\\OneDrive\\Desktop\\Programming Design Paradigms\\Assignment 4\\Assignment_4\\Assignment_4\\files\\snailSAVED.ascii.ppm");

    assertEquals(im1.getPixels(), im2.getPixels());
  }

}