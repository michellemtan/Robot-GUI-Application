package robot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.Color;
import java.awt.color.*;

/**
 * Abstract superclass to represent the general concept of a Robot. This class
 * defines state common to all special kinds of Robot instances and implements a
 * common movement algorithm. Robot subclasses must override method paint() to
 * handle robot-specific painting.
 * 
 * @author Michelle Tan
 * 
 */
public abstract class Robot {
	// === Constants for default values. ===
	protected static final int DEFAULT_X_POS = 0;

	protected static final int DEFAULT_Y_POS = 0;

	protected static final int DEFAULT_DELTA_X = 5;

	protected static final int DEFAULT_DELTA_Y = 5;

	protected static final int DEFAULT_WIDTH = 25;

	protected static final int DEFAULT_HEIGHT = 35;

	protected static final Color DEFAULT_COLOUR = Color.black;

	// ===

	// === Instance variables, accessible by subclasses.
	protected int _x;

	protected int _y;

	protected int _deltaX;

	protected int _deltaY;

	protected int _width;

	protected int _height;

	protected String _text = null;

	protected boolean _bouncedTopBottom = false;

	protected boolean _bouncedSides = false;

	protected boolean _bouncedLeft = false;

	protected boolean _bouncedRight = false;

	protected boolean _bouncedTop = false;

	protected boolean _bouncedBottom = false;

	protected CarrierRobot _parent;

	// ===

	/**
	 * Creates a Robot object with default values for instance variables.
	 */
	public Robot() {
		this(DEFAULT_X_POS, DEFAULT_Y_POS, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	/**
	 * Creates a Robot object with a specified x and y position.
	 */
	public Robot(int x, int y) {
		this(x, y, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	/**
	 * Creates a Robot instance with specified x, y, deltaX and deltaY values. The
	 * Robot object is created with a default width and height.
	 */
	public Robot(int x, int y, int deltaX, int deltaY) {
		this(x, y, deltaX, deltaY, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	/**
	 * Creates a Robot instance with specified x, y, deltaX, deltaY, width and
	 * height values.
	 */
	public Robot(int x, int y, int deltaX, int deltaY, int width, int height) {
		_x = x;
		_y = y;
		_deltaX = deltaX;
		_deltaY = deltaY;
		_width = width;
		_height = height;
	}
	public Robot(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		_x = x;
		_y = y;
		_deltaX = deltaX;
		_deltaY = deltaY;
		_width = width;
		_height = height;
		_text = text;
	}

	/**
	 * Moves this Robot object within the specified bounds. On hitting a boundary
	 * the Robot instance bounces off and back into the two- dimensional world.
	 * 
	 * @param width
	 *            width of two-dimensional world.
	 * @param height
	 *            height of two-dimensional world.
	 */
	public void move(int width, int height) {
		int nextX = _x + _deltaX;
		int nextY = _y + _deltaY;

		// If the robot touches the left
		if (nextX <= 0) {
			nextX = 0;
			_deltaX = -_deltaX;
			_bouncedLeft = true;

			// If the robot touches the right
		} else if (nextX + _width >= width) {
			nextX = width - _width;
			_deltaX = -_deltaX;
			_bouncedRight = true;
		}

		// If the robot touches the top
		if (nextY <= 0) {
			nextY = 0;
			_deltaY = -_deltaY;
			_bouncedTop = true;

			// If the robot touches the bottom
		} else if (nextY + _height >= height) {
			nextY = height - _height;
			_deltaY = -_deltaY;
			_bouncedBottom = true;
		}

		_x = nextX;
		_y = nextY;
		checkBounce();
	}

	/**
	 * Method to be implemented by concrete subclasses to handle subclass specific
	 * painting.
	 * 
	 * @param painter the Painter object used for drawing.
	 * 
	 */
	public final void paint(Painter painter) {
		doPaint(painter);
		paintText(painter);
	}

	/**
	 * Returns this Robot object's x position.
	 */
	public int x() {
		return _x;
	}

	/**
	 * Returns this Robot object's y position.
	 */
	public int y() {
		return _y;
	}

	/**
	 * Returns this Robot object's speed and direction.
	 */
	public int deltaX() {
		return _deltaX;
	}

	/**
	 * Returns this Robot object's speed and direction.
	 */
	public int deltaY() {
		return _deltaY;
	}

	/**
	 * Returns this Robot's width.
	 */
	public int width() {
		return _width;
	}

	/**
	 * Returns this Robot's height.
	 */
	public int height() {
		return _height;
	}

	/**
	 * Returns a String whose value is the fully qualified name of this class of
	 * object. E.g., when called on a WheeledRobot instance, this method will return
	 * "robot.WheeledRobot".
	 */
	public String toString() {
		return getClass().getName();
	}

	private void checkBounce() {

		if (_bouncedLeft || _bouncedRight) {
			_bouncedSides = true;
			_bouncedTopBottom = false;
		}

		if (_bouncedTop || _bouncedBottom) {
			_bouncedSides = false;
		}

		if (_bouncedSides == false) {
			_bouncedRight = false;
			_bouncedLeft = false;
		}

		if (_bouncedTopBottom == false) {
			_bouncedTop = false;
			_bouncedBottom = false;
		}

	}

	public CarrierRobot parent() {
		return _parent;
	}

	public List<Robot> path() {
		List<Robot> pathList = new ArrayList<>();
		
		if (this._parent != null) {
			pathList.addAll(this._parent.path());
		}
		pathList.add(this);
		return pathList;
	}

	public void addText(String text) {
		_text = text;
	}

	protected abstract void doPaint(Painter painter);

	private void paintText(Painter painter) {
		if (_text != null) {
			painter.drawCentredText(_text, this);
		}
	}

	public String text() {
		return _text;
	}

}
