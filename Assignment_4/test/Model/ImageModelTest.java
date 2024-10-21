package Model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test class for the ImageModel Class.
 */
public class ImageModelTest {
  @Test
  public void testBasicLoadImageModel() {
    ImageModel imageModel = new ImageModel();

    imageModel.loadImage("Assignment_4/files/blackbuck.ascii.ppm", "blackbuckPPM");

    int width  = imageModel.getImageWidth("blackbuckPPM");
    int height = imageModel.getImageHeight("blackbuckPPM");

    assertEquals(512, width);
    assertEquals(512, height);
  }

  @Test
  public void testBasicSaveImageModel() {
    ImageModel imageModel = new ImageModel();

    imageModel.loadImage("Assignment_4/files/blackbuck.ascii.ppm", "blackbuckPPM");

    imageModel.saveImage("blackbuckPPM", "Assignment_4/files/blackbuck2.ascii.ppm");

    imageModel.loadImage("Assignment_4/files/blackbuck2.ascii.ppm", "blackbuck2PPM");

    int imWidth1 = imageModel.getImageWidth("blackbuckPPM");
    int imWidth2 = imageModel.getImageWidth("blackbuck2PPM");

    assertEquals(imWidth1, imWidth2);

    int imHeight1 = imageModel.getImageHeight("blackbuckPPM");
    int imHeight2 = imageModel.getImageHeight("blackbuck2PPM");
    assertEquals(imHeight1, imHeight2);

    int imMaxValue1 = imageModel.getImageMaxValue("blackbuckPPM");
    int imMaxValue2 = imageModel.getImageMaxValue("blackbuck2PPM");
    assertEquals(imMaxValue1, imMaxValue2);

    int[][][] imPixelData1 = imageModel.getImagePixelData("blackbuckPPM");
    int[][][] imPixelData2 = imageModel.getImagePixelData("blackbuck2PPM");
    assertEquals(imPixelData1, imPixelData2);
  }
}
