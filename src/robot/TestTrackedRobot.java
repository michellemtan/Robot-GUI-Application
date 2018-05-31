package robot;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * A class that implements test cases aimed at identifying bugs in the 
 * implementations of the class TrackedRobot.
 * 
 * @author Michelle Tan
 * 
 */

public class TestTrackedRobot {

	private MockPainter _painter;

	@Before
	public void setUp() {
		_painter = new MockPainter();
	}

	/**
	 * Test to ensure that the TrackedRobot has painted itself correctly when it is small
	 * i.e. when it has a width < 40 pixels.
	 */
	@Test
	public void testPaintSmall() {
		TrackedRobot robot = new TrackedRobot(100, 20, 12, 15, 30, 30);
		robot.paint(_painter);
		assertEquals("(line 100,35,115,20)(line 115,20,130,35)(line 130,35,115,50)(line 115,50,100,35)",
				_painter.toString());
	}

	/**
	 * Test to ensure that the TrackedRobot has painted itself correctly when it is
	 * regular-sized  i.e. when it has a width > 40 pixels.
	 */
	@Test
	public void testPaintRegular() {
		TrackedRobot robot = new TrackedRobot(100, 20, 12, 15, 60, 60);
		robot.paint(_painter);
		assertEquals(
				"(line 100,50,120,20)(line 120,20,140,20)(line 140,20,160,50)(line 160,50,140,80)(line 140,80,120,80)(line 120,80,100,50)",
				_painter.toString());
	}
}
