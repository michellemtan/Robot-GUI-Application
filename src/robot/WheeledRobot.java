package robot;

/**
 * Class to represent a simple wheeled robot.
 * 
 * @author Michelle Tan
 * 
 */
public class WheeledRobot extends Robot {
	/**
	 * Default constructor that creates a WheeledRobot instance whose instance
	 * variables are set to default values.
	 */
	public WheeledRobot() {
		super();
	}
	
	/**
	 * Creates a WheeledRobot instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 */
	public WheeledRobot(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}
	
	/**
	 * Creates a WheeledRobot instance with specified values for instance 
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
	public WheeledRobot(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}
	
	/**
	 * Creates a WheeledRobot instance with specified values for instance 
	 * variables.
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
	public WheeledRobot(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x,y,deltaX,deltaY,width,height, text);
	}
	
	/**
	 * Paints this WheeledRobot object using the supplied Painter object.
	 */
	protected void doPaint(Painter painter) {
		painter.drawRect(_x,_y,_width,_height);
	}
}
