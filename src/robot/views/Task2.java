package robot.views;

import javax.swing.event.TreeModelEvent;

import javax.swing.event.TreeModelListener;

import robot.Robot;

import robot.RobotModel;
import robot.RobotModelEvent;
import robot.RobotModelEvent.EventType;
import robot.RobotModelListener;

public class Task2 extends Task1 implements RobotModelListener {

	public Task2(RobotModel model) {
		super(model);
	}

	@Override
	public void update(RobotModelEvent event) {

		// Iterate through all the listeners created

		// The RobotModel object that fires the event
		Object source = event.source();

		// An array of int that specifies the index values of the modified items
		int[] childIndices = new int[] { event.index() };

		// Robot to which the event relates
		Object[] children = new Object[] { event.operand() };

		// A TreePath object that identifies the path to the parent of the modified
		// item(s)
		Object[] path;

		// Parent CarrierRobot of fOperand; for RobotRemoved events this is the former
		// parent of fOperand.
		Robot parent = event.parent();

		// Check for an orphan robot
		if (parent != null) {
			path = parent.path().toArray();
		} else {
			// This is the root
			path = children;
		}

		// Create a new tree event using the values of the RobotModelEvent
		// This "converts" the RobotModelEvent to be compatible with TreeModelListeners
		TreeModelEvent newEvent = new TreeModelEvent(source, path, childIndices, children);

		// Ignore RobotMoved events as the values of their fields have not changed and
		// will
		// not affect their representation
		if (event.eventType() == EventType.RobotAdded) {
			for (TreeModelListener listener : super._listeners) {
				listener.treeNodesInserted(newEvent);
			}
		} else if (event.eventType() == EventType.RobotRemoved) {
			for (TreeModelListener listener : super._listeners) {
				listener.treeNodesRemoved(newEvent);
			}
		}
	}
}
