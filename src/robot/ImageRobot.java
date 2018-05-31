package robot;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Class to represent a robot based on my dog Image.
 * 
 * @author Michelle Tan
 * 
 */

public class ImageRobot extends Robot {

	Image image;

	/**
	 * Default constructor that creates a ImageRobot instance whose instance
	 * variables are set to default values.
	 */
	public ImageRobot() {
		super();
		loadImage();
	}

	/**
	 * Creates a ImageRobot instance with specified values for instance variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 */
	public ImageRobot(int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY);
		loadImage();
	}

	/**
	 * Creates a ImageRobot instance with specified values for instance variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed (pixels per move call) and direction for horizontal 
	 *        axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical 
	 *        axis.
	 * @param width width in pixels.
	 * @param height height in pixels.
	 */
	public ImageRobot(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x, y, deltaX, deltaY, width, height);
		loadImage();
	}
		
	/**
	 * Creates a ImageRobot instance with specified values for instance variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed (pixels per move call) and direction for horizontal 
	 *        axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical 
	 *        axis.
	 * @param width width in pixels.
	 * @param height height in pixels.
	 * @param text string of text to be displayed
	 */
	public ImageRobot(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x, y, deltaX, deltaY, width, height, text);
		loadImage();
	}

	/**
	 * Paints this ImageRobot object using the supplied Painter object.
	 */
	protected void doPaint(Painter painter) {

			painter.drawImage(image, _x, _y, _width, _height);
	}

	/**
	 * Loads the image for the ImageRobot object.
	 */
	public void loadImage() {
		try {
			File pathToFile = new File("Cookie2.png");
			image = ImageIO.read(pathToFile);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
