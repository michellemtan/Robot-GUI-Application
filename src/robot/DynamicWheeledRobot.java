package robot;

import java.awt.Color;

/**
 * Class to represent a dynamic wheeled robot.
 * 
 * @author Michelle Tan
 * 
 */

public class DynamicWheeledRobot extends Robot{

	private Color _colour;

	/**
	 * Default constructor that creates a DynamicWheeledRobot instance whose instance
	 * variables are set to default values.
	 */
	public DynamicWheeledRobot() {
		super();
	}

	/**
	 * Creates a DynamicWheeledRobot instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 */
	public DynamicWheeledRobot(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);

	}
	
	/**
	 * Creates a DynamicWheeledRobot instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed (pixels per move call) and direction for horizontal 
	 *        axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical 
	 *        axis.
	 * @param width width in pixels.
	 * @param height height in pixels.
	 */
	public DynamicWheeledRobot(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);

	}

	/**
	 * Creates a DynamicWheeledRobot instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 * @param color in the default sRGB space.
	 */
	public DynamicWheeledRobot(int x, int y, int deltaX, int deltaY, Color c) {
		super(x,y,deltaX,deltaY);
		_colour = c;
	}

	/**
	 * Creates a DynamicWheeledRobot instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed (pixels per move call) and direction for horizontal 
	 *        axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical 
	 *        axis.
	 * @param width width in pixels.
	 * @param height height in pixels.
	 * @param color in the default sRGB space.
	 */
	public DynamicWheeledRobot(int x, int y, int deltaX, int deltaY, int width, int height, Color c) {
		super(x,y,deltaX,deltaY,width,height);
		_colour = c;
	}
	
	/**
	 * Creates a DynamicWheeledRobot instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed (pixels per move call) and direction for horizontal 
	 *        axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical 
	 *        axis.
	 * @param width width in pixels.
	 * @param height height in pixels.
	 * @param color in the default sRGB space.
	 * @param text string of text to be displayed
	 */
	public DynamicWheeledRobot(int x, int y, int deltaX, int deltaY, int width, int height, String text, Color c) {
		super(x,y,deltaX,deltaY,width,height, text);
		_colour = c;
	}
	
	public DynamicWheeledRobot(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x,y,deltaX,deltaY,width,height, text);
	}

	/**
	 * Paints this DynamicWheeledRobot object using the supplied Painter object.
	 * This Robot changes its appearance when it hits the walls.
	 */
	protected void doPaint(Painter painter) {

		if (checkFilled()) {
			painter.setColor(_colour);
			painter.fillRect(_x,_y,_width,_height);
		}

		if (!checkFilled()) {
			painter.setColor(Color.black);
			painter.drawRect(_x,_y,_width,_height);
		}
		
		painter.setColor(Color.black);

	}
	
	private boolean checkFilled() {
		//Fill if the robot has touched the side walls
		if (_bouncedSides) {
			return true;
		} else {
			return false;
		}
	}
}
