package ImageUtilities;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class tests the functionality of the color object.
 *
 */
public class SimpleColorUnitTest {

  /**
   * Test Color constructor.
   *
   */
  @Test
  public void testConstructor1() {
    Color c1 = new SimpleColor(0, 0, 0);

    assertEquals("(0, 0, 0)", c1.toString());

  }

  /**
   * Test Color constructor, test negative red.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor2() {
    Color c1 = new SimpleColor(-1, 0, 0);

  }

  /**
   * Test Color constructor, test red above 255.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor3() {
    Color c1 = new SimpleColor(256, 0, 0);

  }

  /**
   * Test Color constructor, test negative green.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor4() {
    Color c1 = new SimpleColor(0, -1, 0);

  }

  /**
   * Test Color constructor, test green above 255.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor5() {
    Color c1 = new SimpleColor(0, 256, 0);

  }

  /**
   * Test Color constructor, test negative blue.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor6() {
    Color c1 = new SimpleColor(0, 0, -1);

  }

  /**
   * Test Color constructor, test blue above 255.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor7() {
    Color c1 = new SimpleColor(0, 0, 256);

  }

  /**
   * Test Color constructor, all value 255.
   *
   */
  @Test
  public void testConstructor8() {
    Color c1 = new SimpleColor(255, 255, 255);

    assertEquals("(255, 255, 255)", c1.toString());

  }







  /**
   * Test that the setValues first override works.
   *
   */
  @Test
  public void testSetValueO11() {

    Color c1 = new SimpleColor(0, 0, 0);

    c1.setValues(4, 5, 6);

    String var = c1.toString();

    assertEquals("(4, 5, 6)", c1.toString());

  }

  /**
   * Test that the setValues first override worked right when red negative.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetValueO12() {

    Color c1 = new SimpleColor(0, 0, 0);

    c1.setValues(-4, 5, 6);

  }

  /**
   * Test that the setValues first override worked right when red above 255.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetValueO13() {

    Color c1 = new SimpleColor(0, 0, 0);

    c1.setValues(267, 5, 6);

  }

  /**
   * Test that the setValues first override worked right when green negative.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetValueO14() {

    Color c1 = new SimpleColor(0, 0, 0);

    c1.setValues(4, -5, 6);

  }

  /**
   * Test that the setValues first override worked green when red above 255.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetValueO15() {

    Color c1 = new SimpleColor(0, 0, 0);

    c1.setValues(4, 265, 6);

  }

  /**
   * Test that the setValues first override worked right when blue negative.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetValueO16() {

    Color c1 = new SimpleColor(0, 0, 0);

    c1.setValues(4, 5, -6);

  }

  /**
   * Test that the setValues first override worked green when blue above 255.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetValueO17() {

    Color c1 = new SimpleColor(0, 0, 0);

    c1.setValues(4, 5, 266);

  }








  /**
   * Test that the setValues second override works.
   *
   */
  @Test
  public void testSetValueO21() {

    Color c1 = new SimpleColor(0, 0, 0);

    int[] v = new int[3];

    v[0] = 4;
    v[1] = 5;
    v[2] = 6;

    c1.setValues(v);

    assertEquals("(4, 5, 6)", c1.toString());

  }

  /**
   * Test that the setValues second override worked right when red negative.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetValueO22() {

    Color c1 = new SimpleColor(0, 0, 0);

    int[] v = new int[3];

    v[0] = -4;
    v[1] = 5;
    v[2] = 6;

    c1.setValues(v);

  }

  /**
   * Test that the setValues second override worked right when red above 255.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetValueO23() {

    Color c1 = new SimpleColor(0, 0, 0);

    int[] v = new int[3];

    v[0] = 267;
    v[1] = 5;
    v[2] = 6;

    c1.setValues(v);

  }

  /**
   * Test that the setValues second override worked right when green negative.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetValueO24() {

    Color c1 = new SimpleColor(0, 0, 0);

    int[] v = new int[3];

    v[0] = 4;
    v[1] = -5;
    v[2] = 6;

    c1.setValues(v);

  }

  /**
   * Test that the setValues second override worked green when red above 255.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetValueO25() {

    Color c1 = new SimpleColor(0, 0, 0);

    int[] v = new int[3];

    v[0] = 4;
    v[1] = 265;
    v[2] = 6;

    c1.setValues(v);

  }

  /**
   * Test that the setValues second override worked right when blue negative.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetValueO26() {

    Color c1 = new SimpleColor(0, 0, 0);

    int[] v = new int[3];

    v[0] = 4;
    v[1] = 5;
    v[2] = -6;

    c1.setValues(v);

  }

  /**
   * Test that the setValues second override worked green when blue above 255.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetValueO27() {

    Color c1 = new SimpleColor(0, 0, 0);

    int[] v = new int[3];

    v[0] = 4;
    v[1] = 5;
    v[2] = 266;

    c1.setValues(v);

  }

  /**
   * Test that the setValues second override can handle small input array.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetValueO28() {

    Color c1 = new SimpleColor(0, 0, 0);

    int[] v = new int[2];

    v[0] = 4;
    v[1] = 5;

    c1.setValues(v);

  }

  /**
   * Test that the setValues second override can handle large input array.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetValueO29() {

    Color c1 = new SimpleColor(0, 0, 0);

    int[] v = new int[4];

    v[0] = 4;
    v[1] = 5;
    v[2] = 6;
    v[3] = 9;

    c1.setValues(v);

  }







  /**
   *  Test set red works for legal values.
   *
   */
  @Test
  public void testSetRed1() {

    Color c1 = new SimpleColor(0, 0, 0);

    c1.setRed(43);

    assertEquals("(43, 0, 0)", c1.toString());

  }

  /**
   *  Test set red works for legal values for negative value.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetRed2() {

    Color c1 = new SimpleColor(0, 0, 0);

    c1.setRed(-43);

  }

  /**
   *  Test set red works for legal values for value above 255 value.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetRed3() {

    Color c1 = new SimpleColor(0, 0, 0);

    c1.setRed(267);

  }





  /**
   *  Test set green works for legal values.
   *
   */
  @Test
  public void testSetGreen1() {

    Color c1 = new SimpleColor(0, 0, 0);

    c1.setGreen(43);

    assertEquals("(0, 43, 0)", c1.toString());

  }

  /**
   *  Test set green works for legal values for negative value.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetGreen2() {

    Color c1 = new SimpleColor(0, 0, 0);

    c1.setGreen(-43);

  }

  /**
   *  Test set green works for legal values for value above 255 value.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetGreen3() {

    Color c1 = new SimpleColor(0, 0, 0);

    c1.setGreen(267);

  }






  /**
   *  Test set blue works for legal values.
   *
   */
  @Test
  public void testSetBlue1() {

    Color c1 = new SimpleColor(0, 0, 0);

    c1.setBlue(43);

    assertEquals("(0, 0, 43)", c1.toString());

  }

  /**
   *  Test set blue works for legal values for negative value.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetBlue2() {

    Color c1 = new SimpleColor(0, 0, 0);

    c1.setBlue(-43);

  }

  /**
   *  Test set blue works for legal values for value above 255 value.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetBlue3() {

    Color c1 = new SimpleColor(0, 0, 0);

    c1.setBlue(267);

  }


  /**
   * Test that get the values from the color works.
   *
   */
  @Test
  public void testGetValues1() {
    Color c1 = new SimpleColor(4, 5, 6);

    int[] compare = new int[3];

    compare[0] = 4;
    compare[1] = 5;
    compare[2] = 6;

    assertArrayEquals(compare, c1.getValues());

  }









  /**
   * Get the red value.
   *
   */
  @Test
  public void testGetRed1() {
    Color c1 = new SimpleColor(4, 5, 6);

    assertEquals(4, c1.getRed());

  }










  /**
   * Get the green value.
   *
   */
  @Test
  public void testGetGreen1() {
    Color c1 = new SimpleColor(4, 5, 6);

    assertEquals(5, c1.getGreen());
  }






  /**
   * Get the blue value.
   *
   */
  @Test
  public void testGetBlue1() {
    Color c1 = new SimpleColor(4, 5, 6);

    assertEquals(6, c1.getBlue());
  }






  /**
   * Test the to string representation.
   *
   */
  @Test
  public void testToString1() {
    Color c1 = new SimpleColor(43, 54, 66);

    assertEquals("(43, 54, 66)", c1.toString());
  }







  /**
   * Test the equals method when objects are the same.
   *
   */
  @Test
  public void testEquals1() {
    Color c1 = new SimpleColor(43, 54, 66);
    Color c2 = new SimpleColor(43, 54, 66);

    assertTrue(c1.equals(c2));

  }

  /**
   * Test the equals method when objects are the same.
   *
   */
  @Test
  public void testEquals2() {
    Color c1 = new SimpleColor(43, 54, 66);
    Color c2 = new SimpleColor(42, 54, 66);

    assertFalse(c1.equals(c2));

  }





  /**
   * Test when the hashcode is the same.
   *
   */
  @Test
  public void testHashCode1() {
    Color c1 = new SimpleColor(43, 54, 66);
    Color c2 = new SimpleColor(43, 54, 66);

    assertEquals(c1.hashCode(), c2.hashCode());

  }

  /**
   * Test when the hashcode is the same.
   *
   */
  @Test
  public void testHashCode2() {
    Color c1 = new SimpleColor(43, 54, 66);
    Color c2 = new SimpleColor(42, 54, 66);

    assertNotEquals(c1.hashCode(), c2.hashCode());

  }





}