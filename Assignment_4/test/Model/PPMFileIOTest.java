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



}