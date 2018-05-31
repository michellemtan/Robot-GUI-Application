package robot;

import java.util.ArrayList;
import java.util.List;

public class CarrierRobot extends Robot {

	private int _numberOfRobots;
	private List<Robot> _childRobots = new ArrayList<Robot>();

	public CarrierRobot() {
		super();
		_numberOfRobots = 0;
	}

	public CarrierRobot(int x, int y) {
		super(x, y);
		_numberOfRobots = 0;
	}

	public CarrierRobot(int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY);
		_numberOfRobots = 0;
	}

	public CarrierRobot(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x, y, deltaX, deltaY, width, height);
		_numberOfRobots = 0;
	}

	public CarrierRobot(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x, y, deltaX, deltaY, width, height, text);
		_numberOfRobots = 0;
	}

	@Override
	public void move(int width, int height) {
		super.move(width, height);
		for (Robot robot : _childRobots) {
			robot.move(_width, _height);
		}

	}

	@Override
	protected void doPaint(Painter painter) {
		painter.drawRect(_x, _y, _width, _height);

		for (Robot robot : _childRobots) {
			painter.translate(robot.parent()._x, robot.parent()._y);
			robot.paint(painter);
			painter.translate(-(robot.parent()._x), -robot.parent()._y);
		}

	}

	void add(Robot robot) throws IllegalArgumentException {

		if (_childRobots.contains(robot)) {
			throw new IllegalArgumentException("This robot is already inside this carrier robot");
		}

		if (robot.parent() != null) {
			throw new IllegalArgumentException("This robot already is inside another carrier robot");
		}

		if (!robotWillFit(robot)) {
			throw new IllegalArgumentException("This robot will not fit within the carrier robot");
		}

		robot._parent = this;
		_childRobots.add(robot);
		_numberOfRobots++;
	}

	void remove(Robot robot) {

		if (!_childRobots.contains(robot)) {
			throw new IllegalArgumentException();
		}

		robot._parent = null;
		_childRobots.remove(robot);
		_numberOfRobots--;
	}

	public Robot robotAt(int index) throws IndexOutOfBoundsException {
		return _childRobots.get(index);
	}

	public int robotCount() {
		return _numberOfRobots;
	}

	public int indexOf(Robot robot) {

		int index = -1;

		if (_childRobots.contains(robot)) {
			index = _childRobots.indexOf(robot);
		}

		return index;
	}

	public boolean contains(Robot robot) {
		return _childRobots.contains(robot);
	}

	private boolean robotWillFit(Robot robot) {
		if ((robot._x + robot._width > this._width) || (robot._y + robot._height > this._height)) {
			return false;
		}
		return true;
	}
}
