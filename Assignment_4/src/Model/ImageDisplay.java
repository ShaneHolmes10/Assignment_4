package Model;

import javax.swing.*;
import java.awt.*;


/**
 * This is a super temporary solution to do a quick check to see if the functions
 * look correct.
 *
 */
public class ImageDisplay extends JPanel {
  private int[][][] image; // Assuming the image is in int[3][height][width]

  public ImageDisplay(int[][][] image) {
    this.image = image;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    int height = image[0].length;
    int width = image[0][0].length;

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        // Get the RGB values from the image array
        int r = image[0][y][x]; // Red channel
        int gValue = image[1][y][x]; // Green channel
        int b = image[2][y][x]; // Blue channel

        // Create the color from the RGB values
        Color color = new Color(r, gValue, b);
        g.setColor(color);
        g.fillRect(x, y, 1, 1); // Draw a pixel
      }
    }
  }


  public static void imShow(Image i1, String name) {
    int width = i1.getWidth();
    int height = i1.getHeight();
    int [][][] imageArray = i1.getPixels();

    // Create the frame to display the image
    JFrame frame = new JFrame(name);
    ImageDisplay imageDisplay = new ImageDisplay(imageArray);
    frame.add(imageDisplay);
    frame.setSize(width, height);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }


  public static void main(String[] args) {

    Image imageInput = ImageFactory.loadImage("C:\\Users\\Shane Holmes\\OneDrive\\Desktop\\Programming Design Paradigms\\Assignment 4\\Assignment_4\\Assignment_4\\files\\snail.ascii.ppm");
    int height = imageInput.getHeight();
    int width = imageInput.getWidth();

    imShow(imageInput, "normal");

    Image i1 = ImageEdit.brighten(imageInput, 50);

    imShow(i1, "bright");

    Image i2 = ImageEdit.darken(imageInput, 50);

    imShow(i2, "dark");

  }
}

