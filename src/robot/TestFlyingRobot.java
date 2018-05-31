package robot;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A class that implements test cases aimed at identifying bugs in the 
 * implementations of the class FlyingRobot.
 * 
 * @author Michelle Tan
 * 
 */

public class TestFlyingRobot {

	private MockPainter _painter;

	@Before
	public void setUp() {
		_painter = new MockPainter();
	}

	/**
	 * Test to ensure that the FlyingRobot has painted itself correctly.
	 */
	@Test
	public void testPaint() {
		FlyingRobot robot = new FlyingRobot(100, 20, 12, 15);
		robot.paint(_painter);
		assertEquals("(oval 100,20,25,35)", _painter.toString());
	}
}