package Model;

/**
 * This interface serves to define the interface for dealing
 * with color classes.
 *
 */
public interface Color {

  /**
   * Set the color values for this object. Color values
   * are limited to be between 0 and 255 should throw illegal
   * input exception otherwise.
   *
   * @param red red value of color
   * @param green green value of color
   * @param blue blue value of color
   * @throws IllegalArgumentException if inputs are illegal
   */
  void setValues(int red, int green, int blue) throws IllegalArgumentException;

  /**
   * Set the color values for this object using and array.
   * Color values are limited to be between 0 and 255 should
   * throw illegal input exception otherwise. We also wish
   * to throw an error if there are more than 3 colors.
   *
   * @param inputColors array of the input colors
   * @throws IllegalArgumentException if inputs are illegal
   */
  void setValues(int[] inputColors) throws IllegalArgumentException;

  /**
   * Set just the red value of this color.
   *
   * @param value input value
   * @throws IllegalArgumentException if inputs are illegal
   */
  void setRed(int value) throws IllegalArgumentException;

  /**
   * Set just the green value of this color.
   *
   * @param value input value
   * @throws IllegalArgumentException if inputs are illegal
   */
  void setGreen(int value) throws IllegalArgumentException;

  /**
   * Set just the blue value of this color.
   *
   * @param value input value
   * @throws IllegalArgumentException if inputs are illegal
   */
  void setBlue(int value) throws IllegalArgumentException;


  /**
   * Get the rgb value of this color as an array.
   *
   * @return color values
   */
  int[] getValues();

  /**
   * get just the red value of this color.
   *
   * @return red value
   */
  int getRed();

  /**
   * get just the green value of this color.
   *
   * @return green value
   */
  int getGreen();

  /**
   * get just the blue value of this color.
   *
   * @return blue value
   */
  int getBlue();


}
