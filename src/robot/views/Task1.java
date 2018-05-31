package robot.views;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import robot.CarrierRobot;
import robot.Robot;
import robot.RobotModel;
import robot.RobotModelListener;

/**
 * TreeModelAdapter
 */
public class Task1 implements TreeModel {

	private RobotModel _adaptee;
	protected List<TreeModelListener> _listeners = new ArrayList<TreeModelListener>();

	public Task1(RobotModel model) {
		_adaptee = model;
	}

	/**
	 * getRoot returns the root CarrierRobot of the RobotModel
	 */
	@Override
	public Object getRoot() {
		return _adaptee.root();
	}

	/**
	 * getChild returns a reference to a particular child Robot object. The
	 * arguments supplied to getChild() are a reference to a CarrierRobot and the
	 * index position within the CarrierRobot's collection of children that
	 * identifies the child Robot sought. If the index is valid for the parent (that
	 * is index >= 0 && index < getChildCount(parent)), then the Robot object at the
	 * index should be returned.
	 */
	@Override
	public Object getChild(Object parent, int index) {

		if (parent instanceof CarrierRobot) {
			try {
			return ((CarrierRobot) parent).robotAt(index);
			} catch (IndexOutOfBoundsException e) {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * getChildCount returns the number of children of parent. Returns 0 if the node
	 * is a leaf or if it has no children.
	 */
	@Override
	public int getChildCount(Object parent) {
		int count = 0;

		if (parent instanceof CarrierRobot) {
			CarrierRobot p = (CarrierRobot) parent;
			count = p.robotCount();
		}
		return count;
	}

	/**
	 * getIndexOfChild returns the index of child in parent. If either parent or
	 * child is null, returns -1. If either parent or child don't belong to this
	 * tree model, returns -1.
	 */
	@Override
	public int getIndexOfChild(Object parent, Object child) {
		int index = -1;

		if (parent == null) {
			return index;
		} else if (child == null) {
			return index;
		} else if (!(parent instanceof CarrierRobot)) {
			return index;
		} else if (_adaptee.add((Robot) child, (CarrierRobot) parent)) {
			return index;
		} else {
			CarrierRobot p = (CarrierRobot) parent;
			index = p.indexOf((Robot) child);
			return index;
		}
	}

	/**
	 * isLeaf returns true if robot is a leaf.
	 */
	@Override
	public boolean isLeaf(Object node) {

		boolean robotIsLeaf = true;

		if (node instanceof CarrierRobot) {
			robotIsLeaf = false;
		}

		return robotIsLeaf;
	}

	@Override
	public void addTreeModelListener(TreeModelListener listener) {
		_listeners.add(listener);
	}

	@Override
	public void removeTreeModelListener(TreeModelListener listener) {
		_listeners.remove(listener);
	}

	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
		// TODO Auto-generated method stub
	}
}
