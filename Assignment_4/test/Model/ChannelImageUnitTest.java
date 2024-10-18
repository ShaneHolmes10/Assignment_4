package Model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This class tests the functionality of the image class.
 *
 */
public class ChannelImageUnitTest {


  /**
   *  Test if the constructor works.
   *
   */
  @Test
  public void testConstructor1() {
    Image i1 = new ChannelImage(600, 400);

    assertEquals("Image: 600x400", i1.toString());

  }





  /**
   * Test that get width works.
   *
   */
  @Test
  public void testGetWidth1() {
    Image i1 = new ChannelImage(600, 400);

    assertEquals(600, i1.getWidth());
  }





  /**
   * Test that get height works.
   *
   */
  @Test
  public void testGetHeight1() {
    Image i1 = new ChannelImage(600, 400);

    assertEquals(400, i1.getHeight());
  }





  /**
   * Test that we can get the pixel color.
   *
   */
  @Test
  public void testGetPixelColor1() {
    Image i1 = new ChannelImage(600, 400);

    Color compare = new SimpleColor(0,0,0);

    assertEquals(compare, i1.getPixelColor(0, 0));
  }

  /**
   * Test that we can get the pixel color, but a negative position is chosen.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetPixelColor2() {
    Image i1 = new ChannelImage(600, 400);

    Color compare = new SimpleColor(0,0,0);

    assertEquals(compare, i1.getPixelColor(-1, -1));
  }

  /**
   * Test that we can get the pixel color, but an out-of-bounds position is chosen.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetPixelColor3() {
    Image i1 = new ChannelImage(600, 400);

    Color compare = new SimpleColor(0,0,0);

    assertEquals(compare, i1.getPixelColor(700, 200));
  }

  /**
   * Test that we can get the pixel color, but where we get the pixel at
   * the extreme ends of the picture.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetPixelColor4() {
    Image i1 = new ChannelImage(600, 400);

    Color compare = new SimpleColor(0,0,0);

    assertEquals(compare, i1.getPixelColor(600, 400));
  }









  /**
   * Test that we can set the value of an individual pixel.
   *
   */
  @Test
  public void testSetPixelColor1() {
    Image i1 = new ChannelImage(600, 400);

    i1.setPixelColor(0, 0, new SimpleColor(255, 255, 255));

    Color compare = new SimpleColor(255,255,255);

    assertEquals(compare, i1.getPixelColor(0, 0));
  }

  /**
   * Test that we can set the value of an individual pixel,
   * but try to set a negative position.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetPixelColor2() {
    Image i1 = new ChannelImage(600, 400);

    i1.setPixelColor(-1, -1, new SimpleColor(255, 255, 255));

    Color compare = new SimpleColor(255,255,255);

  }

  /**
   * Test that we can set the value of an individual pixel,
   * but with and out-of-bounds position.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetPixelColor3() {
    Image i1 = new ChannelImage(600, 400);

    i1.setPixelColor(700, 200, new SimpleColor(255, 255, 255));

    Color compare = new SimpleColor(255,255,255);

  }


  /**
   * This tests the string representation of an image.
   *
   */
  @Test
  public void testToString1() {
    Image i1 = new ChannelImage(600, 400);

    assertEquals("Image: 600x400", i1.toString());

  }


  /**
   * This tests if two images are equal to one another,
   * where the two images are the same.
   *
   */
  @Test
  public void testEquals1() {
    Image i1 = new ChannelImage(1, 40);
    Image i2 = new ChannelImage(1, 40);

    boolean var = i1.equals(i2);

    assertTrue(var);

  }

  /**
   * This tests if two images are equal to one another,
   * where the two images are not the same, because of
   * dimension.
   *
   */
  @Test
  public void testEquals2() {
    Image i1 = new ChannelImage(600, 400);
    Image i2 = new ChannelImage(700, 400);

    assertFalse(i1.equals(i2));

  }

  /**
   * This tests if two images are equal to one another,
   * where the two images are not the same because of
   * one color being off.
   *
   */
  @Test
  public void testEquals3() {
    Image i1 = new ChannelImage(600, 400);
    Image i2 = new ChannelImage(600, 400);

    i1.setPixelColor(0, 0, new SimpleColor(45, 78, 255));

    assertFalse(i1.equals(i2));

  }

  /**
   * This tests if two images are equal to one another,
   * where the two images are not the same, with two
   * colors.
   *
   */
  @Test
  public void testEquals4() {
    Image i1 = new ChannelImage(600, 400);
    Image i2 = new ChannelImage(600, 400);

    i1.setPixelColor(0, 0, new SimpleColor(45, 78, 255));
    i2.setPixelColor(0, 0, new SimpleColor(45, 78, 255));

    assertTrue(i1.equals(i2));

  }







  @Test
  public void testHashCode1() {

  }





}