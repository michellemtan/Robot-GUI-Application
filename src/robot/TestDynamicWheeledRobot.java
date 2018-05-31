package robot;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

/**
 * A class that implements test cases aimed at identifying bugs in the 
 * implementations of classes DynamicWheeledRobot.
 * 
 * @author Michelle Tan
 * 
 */

public class TestDynamicWheeledRobot {
	
	private MockPainter _painter;

	@Before
	public void setUp() {
		_painter = new MockPainter();
	}

	/**
	 * Test to perform a bounce movement off the top boundary and to
	 * ensure that the Robot's position and colour after the movement is correct.
	 */
	@Test
	public void testTopBounce() {
		DynamicWheeledRobot robot = new DynamicWheeledRobot(100, 15, 0, -15, Color.cyan);
		robot.paint(_painter);
		robot.move(500, 100);
		robot.paint(_painter);
		robot.move(500, 100);
		robot.paint(_painter);
		assertEquals(
				"(colour java.awt.Color[r=0,g=0,b=0])(rectangle 100,15,25,35)(colour java.awt.Color[r=0,g=0,b=0])(rectangle 100,0,25,35)"
						+ "(colour java.awt.Color[r=0,g=0,b=0])(rectangle 100,15,25,35)",
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the bottom boundary and to
	 * ensure that the Robot's position and colour after the movement is correct.
	 */
	@Test
	public void testBottomBounce() {
		DynamicWheeledRobot robot = new DynamicWheeledRobot(100, 50, 0, 15, Color.cyan);
		robot.paint(_painter);
		robot.move(500, 100);
		robot.paint(_painter);
		robot.move(500, 100);
		robot.paint(_painter);
		assertEquals(
				"(colour java.awt.Color[r=0,g=0,b=0])(rectangle 100,50,25,35)(colour java.awt.Color[r=0,g=0,b=0])(rectangle 100,65,25,35)"
						+ "(colour java.awt.Color[r=0,g=0,b=0])(rectangle 100,50,25,35)",
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the left-most boundary and to
	 * ensure that the Robot's position and colour after the movement is correct.
	 */
	@Test
	public void testLeftBounce() {
		DynamicWheeledRobot robot = new DynamicWheeledRobot(10, 20, -12, 15, Color.cyan);
		robot.paint(_painter);
		robot.move(10000, 10000);
		robot.paint(_painter);
		robot.move(10000, 10000);
		robot.paint(_painter);
		assertEquals(
				"(colour java.awt.Color[r=0,g=0,b=0])(rectangle 10,20,25,35)(colour java.awt.Color[r=0,g=255,b=255])(filled 0,35,25,35)"
						+ "(colour java.awt.Color[r=0,g=255,b=255])(filled 12,50,25,35)",
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the right-most boundary and to
	 * ensure that the Robot's position and colour after the movement is correct.
	 */
	@Test
	public void testRightBounce() {
		DynamicWheeledRobot robot = new DynamicWheeledRobot(100, 20, 12, 15, Color.cyan);
		robot.paint(_painter);
		robot.move(135, 10000);
		robot.paint(_painter);
		robot.move(135, 10000);
		robot.paint(_painter);
		assertEquals(
				"(colour java.awt.Color[r=0,g=0,b=0])(rectangle 100,20,25,35)(colour java.awt.Color[r=0,g=255,b=255])(filled 110,35,25,35)"
						+ "(colour java.awt.Color[r=0,g=255,b=255])(filled 98,50,25,35)",
				_painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the top left corner and to
	 * ensure that the Robot's position and colour after the movement is correct.
	 */
	@Test
	public void testTopLeftBounce() {
		DynamicWheeledRobot robot = new DynamicWheeledRobot(12, 100, -12, 15, Color.cyan);
		robot.paint(_painter);
		robot.move(125, 135);
		robot.paint(_painter);
		robot.move(125, 135);
		robot.paint(_painter);
		assertEquals(
				"(colour java.awt.Color[r=0,g=0,b=0])(rectangle 12,100,25,35)(colour java.awt.Color[r=0,g=255,b=255])(filled 0,100,25,35)(colour java.awt.Color[r=0,g=255,b=255])(filled 12,85,25,35)",
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the top right corner and to
	 * ensure that the Robot's position and colour after the movement is correct.
	 */
	@Test
	public void testTopRightBounce() {
		DynamicWheeledRobot robot = new DynamicWheeledRobot(100, 15, 10, -15, Color.cyan);
		robot.paint(_painter);
		robot.move(125, 135);
		robot.paint(_painter);
		robot.move(125, 135);
		robot.paint(_painter);
		assertEquals(
				"(colour java.awt.Color[r=0,g=0,b=0])(rectangle 100,15,25,35)(colour java.awt.Color[r=0,g=255,b=255])(filled 100,0,25,35)(colour java.awt.Color[r=0,g=255,b=255])(filled 90,15,25,35)",
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the bottom left corner and to
	 * ensure that the Robot's position and colour after the movement is correct.
	 */
	@Test
	public void testBottomLeftBounce() {
		DynamicWheeledRobot robot = new DynamicWheeledRobot(12, 100, -12, 15, Color.cyan);
		robot.paint(_painter);
		robot.move(125, 135);
		robot.paint(_painter);
		robot.move(125, 135);
		robot.paint(_painter);
		assertEquals(
				"(colour java.awt.Color[r=0,g=0,b=0])(rectangle 12,100,25,35)(colour java.awt.Color[r=0,g=255,b=255])(filled 0,100,25,35)(colour java.awt.Color[r=0,g=255,b=255])(filled 12,85,25,35)",
				_painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the bottom right corner and to
	 * ensure that the Robot's position and colour after the movement is correct.
	 */
	@Test
	public void testBottomRightBounce() {
		DynamicWheeledRobot robot = new DynamicWheeledRobot(100, 100, 10, 15, Color.cyan);
		robot.paint(_painter);
		robot.move(125, 135);
		robot.paint(_painter);
		robot.move(125, 135);
		robot.paint(_painter);
		assertEquals(
				"(colour java.awt.Color[r=0,g=0,b=0])(rectangle 100,100,25,35)(colour java.awt.Color[r=0,g=255,b=255])(filled 100,100,25,35)(colour java.awt.Color[r=0,g=255,b=255])(filled 90,85,25,35)",
				_painter.toString());
	}
}
