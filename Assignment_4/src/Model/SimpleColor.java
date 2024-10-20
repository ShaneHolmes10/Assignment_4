package Model;

import java.util.Objects;

public class SimpleColor implements InterfaceColor {

  /**
   * This method determines if the color value inputs are illegal.
   *
   */
  private int[] colorValues;

  private void illegalColorValueChecker(int red, int green, int blue) throws IllegalArgumentException {

    if (red < 0 || red > 255) {
      throw new IllegalArgumentException("Illegal red value, must be between 0 and 255");
    }

    if (green < 0 || green > 255) {
      throw new IllegalArgumentException("Illegal green value, must be between 0 and 255");
    }

    if (blue < 0 || blue > 255) {
      throw new IllegalArgumentException("Illegal blue value, must be between 0 and 255");
    }

  }

  /**
   * This method instantiates the class.
   *
   * @param red red color value
   * @param green green color value
   * @param blue blue color value
   * @throws IllegalArgumentException this is thrown if the input values are illegal
   */
  public SimpleColor(int red, int green, int blue) throws IllegalArgumentException {
    colorValues = new int[3];

    setValues(red, green, blue);

  }


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
  @Override
  public void setValues(int red, int green, int blue) throws IllegalArgumentException {
    // Determine if values are illegal
    illegalColorValueChecker(red, green, blue);

    colorValues[0] = red;
    colorValues[1] = green;
    colorValues[2] = blue;

  }

  /**
   * Set the color values for this object using and array.
   * Color values are limited to be between 0 and 255 should
   * throw illegal input exception otherwise. We also wish
   * to throw an error if there are more than 3 colors.
   *
   * @param inputColors array of the input colors
   * @throws IllegalArgumentException if inputs are illegal
   */
  @Override
  public void setValues(int[] inputColors) throws IllegalArgumentException {

    if (inputColors.length != 3) {
      throw new IllegalArgumentException("The input size is illegal. Don't know what to do with this.");
    }

    setValues(inputColors[0], inputColors[1], inputColors[2]);

  }

  /**
   * Set just the red value of this color.
   *
   * @param value input value
   * @throws IllegalArgumentException if inputs are illegal
   */
  @Override
  public void setRed(int value) throws IllegalArgumentException {
    // Determine if values are illegal
    illegalColorValueChecker(value, 0, 0);

    colorValues[0] = value;

  }

  /**
   * Set just the green value of this color.
   *
   * @param value input value
   * @throws IllegalArgumentException if inputs are illegal
   */
  @Override
  public void setGreen(int value) throws IllegalArgumentException {
    // Determine if values are illegal
    illegalColorValueChecker(0, value, 0);

    colorValues[1] = value;

  }

  /**
   * Set just the blue value of this color.
   *
   * @param value input value
   * @throws IllegalArgumentException if inputs are illegal
   */
  @Override
  public void setBlue(int value) throws IllegalArgumentException {
    // Determine if values are illegal
    illegalColorValueChecker(0, 0, value);

    colorValues[2] = value;

  }

  /**
   * Get the rgb value of this color as an array.
   *
   * @return color values
   */
  @Override
  public int[] getValues() {
    return colorValues;
  }

  /**
   * get just the red value of this color.
   *
   * @return red value
   */
  @Override
  public int getRed() {
    return colorValues[0];
  }

  /**
   * get just the green value of this color.
   *
   * @return green value
   */
  @Override
  public int getGreen() {
    return colorValues[1];
  }

  /**
   * get just the blue value of this color.
   *
   * @return blue value
   */
  @Override
  public int getBlue() {
    return colorValues[2];
  }


  @Override
  public InterfaceColor scale(double value) {
    return new SimpleColor((int)(colorValues[0]*value), (int)(colorValues[1]*value), (int)(colorValues[2]*value));
  }

  /**
   * This is a string representation of the color.
   * Int the form (R, G, B).
   *
   * @return string representation
   */
  @Override
  public String toString() {
    StringBuilder returnString = new StringBuilder();

    returnString.append("(");
    returnString.append(this.colorValues[0]);
    returnString.append(", ");
    returnString.append(this.colorValues[1]);
    returnString.append(", ");
    returnString.append(this.colorValues[2]);
    returnString.append(")");

    return returnString.toString();

  }

  /**
   * Determine the equality of the input object to this object.
   *
   * @param o input object
   * @return equality value
   */
  @Override
  public boolean equals(Object o) {

    if (! (o instanceof InterfaceColor)) {
      return false;
    }

    InterfaceColor castObject = (InterfaceColor) o;

    return castObject.getRed() == this.getRed() && castObject.getGreen() == this.getGreen() && castObject.getBlue() == this.getBlue();

  }

  /**
   * Generate the hashcode for this class.
   *
   * @return hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(colorValues[0], colorValues[1], colorValues[2]);
  }



}
