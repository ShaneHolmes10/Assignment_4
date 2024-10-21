package Controller;

import Model.Image;
import Model.ImageModel;
import java.util.Scanner;

public class CommandController {
  private ImageModel imageModel;

  public CommandController(ImageModel imageModel) {
    this.imageModel = imageModel;
  }

  /**
   * Runs the controller so that way the user/developer can input commands.
   */
  public void run() {
    // Creates new Scanner.
    Scanner userInput = new Scanner(System.in);
    String welcomeString = """
        Welcome to Image Procesor. Below are the list of commands that our processor supports. If you don't enter a command properly, we will notify you.
        
        1. commands: View this list of commands again.
        
        2. exit/quit: Exit this script.
        
        3. load <image-path> <image-name>: Load an image from the specified path and refer it to henceforth in the program by the given image name.
        
        4. save <image-path> <image-name>: Save the image with the given name to the specified path which should include the name of the file.
        
        5. red-component <image-name> <dest-image-name>: Create an image with the red-component of the image with the given name, and refer to it henceforth in the program by the given destination name. Similar commands for green, blue, value, luma, intensity components should be supported. Note that the images for value, luma and intensity will be greyscale images.
        
        6. horizontal-flip <image-name> <dest-image-name>: Flip an image horizontally to create a new image, referred to henceforth by the given destination name.
        
        7. vertical-flip <image-name> <dest-image-name>: Flip an image vertically to create a new image, referred to henceforth by the given destination name.
        
        8. brighten <increment> <image-name> <dest-image-name>: brighten the image by the given increment to create a new image, referred to henceforth by the given destination name. The increment may be positive (brightening) or negative (darkening).
        
        9. rgb-split <image-name> <dest-image-name-red> <dest-image-name-green> <dest-image-name-blue>: split the given image into three images containing its red, green and blue components respectively. These would be the same images that would be individually produced with the red-component, green-component and blue-component commands.
        
        10. rgb-combine <image-name> <red-image> <green-image> <blue-image>: Combine the three images that are individually red, green and blue into a single image that gets its red, green and blue components from the three images respectively.
        
        11. blur <image-name> <dest-image-name>: blur the given image and store the result in another image with the given name.
        
        12. sharpen <image-name> <dest-image-name>: sharpen the given image and store the result in another image with the given name.
        
        13. sepia <image-name> <dest-image-name>: produce a sepia-toned version of the given image and store the result in another image with the given name.
        
        14. run <script-file>: Load and run the script commands in the specified file.
        """;

    System.out.println(welcomeString);

    while (true) {
      System.out.print("> ");
      String command = userInput.nextLine().trim().toLowerCase();

      if (command.equals("command")) {
        System.out.println(welcomeString);
      } else if (command.equals("exit") || command.equals("quit")) {
        System.out.println("Exiting Script.");
        break;
      } else {
        executeCommand(command);
      }
    }

    // TODO: Figure out if necessary.
    // userInput.close();
  }

  private void executeCommand(String command) {
    String[] tokens = command.split(" ");
    String commandToRun = tokens[0].toLowerCase();

    switch (commandToRun) {
      case "load":
        if (tokens.length != 3) {
          System.out.println("Usage: load <image-path> <image-name>");
        } else {
          String imagePath = tokens[1];
          String imageName = tokens[2];
          imageModel.loadImage(imagePath, imageName);
          System.out.println("Loaded image: " + imageName);
        }
        break;

      case "save":
        if (tokens.length != 3) {
          System.out.println("Usage:save <image-path> <image-name>");
        } else {
          String imagePath = tokens[1];
          String imageName = tokens[2];
          imageModel.saveImage(imageName, imagePath);
          System.out.println("Saved image: " + imageName + " to " + imagePath);
        }
        break;

      case "red-component":
        if (tokens.length != 3) {
          System.out.println("Usage:red-component <image-name> <dest-image-name>");
        } else {
          String imagePath = tokens[1];
          String destImageName = tokens[2];
        }
        break;

      case "horizontal-flip":
        if (tokens.length != 3) {
          System.out.println("Usage: horizontal-flip <image-name> <dest-image-name>");
        } else {
          String imagePath = tokens[1];
          String destImageName = tokens[2];
        }
        break;

      case "vertical-flip":
        if (tokens.length != 3) {
          System.out.println("Usage: vertical-flip <image-name> <dest-image-name>");
        } else {
          String imagePath = tokens[1];
          String destImageName = tokens[2];
        }
        break;

      case "brighten":
        if (tokens.length != 4) {
          System.out.println("Usage: brighten <increment> <image-name> <dest-image-name>");
        } else {
          String increment = tokens[1];
          String imageName = tokens[2];
          String destImageName = tokens[3];
        }
        break;

      case "rgb-split":
        if (tokens.length != 5) {
          System.out.println("Usage: rgb-split <image-name> <dest-image-name-red> <dest-image-name-green> <dest-image-name-blue>");
        } else {
          String imageName = tokens[1];
          String destImageNameRed = tokens[2];
          String destImageNameGreen = tokens[3];
          String destImageNameBlue = tokens[4];
        }
        break;

      case "rgb-combine":
        if (tokens.length != 3) {
          System.out.println("Usage: rgb-combine <image-name> <red-image> <green-image> <blue-image>");
        } else {
          String imageName = tokens[1];
          String destImageNameRed = tokens[2];
          String destImageNameGreen = tokens[3];
          String destImageNameBlue = tokens[4];
        }
        break;

      case "blur":
        if (tokens.length != 3) {
          System.out.println("Usage: blur <image-name> <dest-image-name>");
        } else {
          String imageName = tokens[1];
          String destImageName = tokens[2];
        }
        break;

      case "sharpen":
        if (tokens.length != 3) {
          System.out.println("Usage: sharpen <image-name> <dest-image-name>");
        } else {
          String imageName = tokens[1];
          String destImageName = tokens[2];
        }
        break;

      case "sepia":
        if (tokens.length != 3) {
          System.out.println("Usage: sepia <image-name> <dest-image-name>");
        } else {
          String imageName = tokens[1];
          String destImageName = tokens[2];
        }
        break;

      case "run":
        if (tokens.length != 2) {
          System.out.println("Usage: run <script-file>");
        } else {
          String scriptFile = tokens[1];
        }
        break;

      default:
        System.out.println("Unknown Command: " + commandToRun + " type 'commands' to view available commands.");
        break;
    }
  }

  /**
   * Gets Image Width from specified name.
   * @param name Name of the image.
   * @return The width of the image with the specified name.
   */
  public int getImageWidth(String name) {
    return imageModel.getImageWidth(name);
  }

  /**
   * Gets Image Height from specified name.
   * @param name Name of the image.
   * @return The height of the image with the specified name.
   */
  public int getImageHeight(String name) {
    return imageModel.getImageHeight(name);
  }

  /**
   * Gets Image Max Value from specified name.
   * @param name Name of the image.
   * @return The max value of the image with the specified name.
   */
  public int getImageMaxValue(String name) {
    return imageModel.getImageMaxValue(name);
  }

  /**
   * Gets Image Pixel Data from specified name.
   * @param name Name of the image.
   * @return The pixel data of the image with the specified name.
   */
  public int[][][] getImagePixelData(String name) {
    return imageModel.getImagePixelData(name);
  }
}
