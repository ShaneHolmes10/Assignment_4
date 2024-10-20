package Model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImageEditTest {

  @Test
  public void testBrighten1() {

    Image i1 = ImageFactory.loadImage("C:\\Users\\Shane Holmes\\OneDrive\\Desktop\\Programming Design Paradigms\\Assignment 4\\Assignment_4\\Assignment_4\\files\\snail.ascii.ppm");
    Image i2 = ImageEdit.brighten(i1, 50);

    System.out.println(i1.getPixelColor(100, 100));
    System.out.println(i2.getPixelColor(100, 100));


  }

  @Test
  public void testdarken1() {

    Image i1 = ImageFactory.loadImage("C:\\Users\\Shane Holmes\\OneDrive\\Desktop\\Programming Design Paradigms\\Assignment 4\\Assignment_4\\Assignment_4\\files\\snail.ascii.ppm");
    Image i2 = ImageEdit.darken(i1, 50);

    System.out.println(i1.getPixelColor(100, 100));
    System.out.println(i2.getPixelColor(100, 100));


  }

}