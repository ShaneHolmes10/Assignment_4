package Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import Controller.CommandController;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

/**
 * Test class for the CommandController Class.
 */
public class CommandControllerTest {

  @Test
  public void testBasicLoadingCommandController() {
    CommandController cc = new CommandController(new ImageModel());

    // "Capture" output from the console.
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    String simulatedInput = "load Assignment_4/files/blackbuck.ascii.ppm blackbuck\nquit\n";
    System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

    cc.run();

    String output = outputStream.toString();
    assertTrue(output.contains("> Loaded image: blackbuck"));
  }

  @Test
  public void testBasicLoadingAndPropertiesCommandController() {
    CommandController cc = new CommandController(new ImageModel());

    String simulatedInput = "load Assignment_4/files/blackbuck.ascii.ppm blackbuck\nquit\n";
    System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

    cc.run();

    int width = cc.getImageWidth("blackbuck");
    int height = cc.getImageHeight("blackbuck");
    int maxValue = cc.getImageMaxValue("blackbuck");
    // int[][][] pixelData = cc.getImagePixelData("blackbuck");

    assertEquals(512, width);
    assertEquals(512, height);
    assertEquals(255, maxValue);
  }

}
