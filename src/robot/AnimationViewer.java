package robot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Simple GUI program to show an animation of robots. Class AnimationViewer is
 * a special kind of GUI component (JPanel), and as such an instance of 
 * AnimationViewer can be added to a JFrame object. A JFrame object is a 
 * window that can be closed, minimized, and maximized. The state of an
 * AnimationViewer object comprises a list of Robots and a Timer object. An
 * AnimationViewer instance subscribes to events that are published by a Timer.
 * In response to receiving an event from the Timer, the AnimationViewer iterates 
 * through a list of Robots requesting that each Robot paints and moves itself.
 * 
 * @author Michelle Tan
 * 
 */
@SuppressWarnings("serial")
public class AnimationViewer extends JPanel implements ActionListener {
	// Frequency in milliseconds for the Timer to generate events.
	private static final int DELAY = 20;

	// Collection of Robots to animate.
	private List<Robot> _robots;

	private Timer _timer = new Timer(DELAY, this);

	/**
	 * Creates an AnimationViewer instance with a list of Robot objects and 
	 * starts the animation.
	 */
	public AnimationViewer() {
		_robots = new ArrayList<Robot>();
	
		// Populate the list of Robots.
		_robots.add(new WheeledRobot(10, 10, 5, 7));
		_robots.add(new FlyingRobot(11, 10, 5, 5));
		_robots.add(new TrackedRobot(100, 20, 5, 3, 30, 30));
		_robots.add(new TrackedRobot(100,100,4,7,50,80));
		_robots.add(new DynamicWheeledRobot(30, 30, 10, 10, 50, 50, Color.cyan));
		_robots.add(new DynamicWheeledRobot(6, 11, 15, 2, 50, 50, Color.pink));
		_robots.add(new DynamicWheeledRobot(7, 20, 12, 4, 20, 10, Color.magenta));
		_robots.add(new DynamicWheeledRobot(9, 30, 10, 15, 100, 80, Color.yellow));
		_robots.add(new DynamicWheeledRobot(50, 20, 3, 5, 10, 30, Color.green));
		_robots.add(new ImageRobot(5, 5, 5, 10, 150, 150));
		
		CarrierRobot _topLevelNest = new CarrierRobot(0, 0, 2, 2, 100, 100);
		CarrierRobot _midLevelNest = new CarrierRobot(0, 0, 2, 2, 50, 50);
		CarrierRobot _bottomLevelNest = new CarrierRobot(5, 5, 2, 2, 10, 10);
		WheeledRobot _simpleRobot = new WheeledRobot(1, 1, 1, 1, 5, 5);
		
		_midLevelNest.add(_bottomLevelNest);
		_midLevelNest.add(_simpleRobot);
		_topLevelNest.add(_midLevelNest);

		_robots.add(_topLevelNest);
		
		Robot michelleRobot = new DynamicWheeledRobot(20, 30, 3, 1, 100, 170, Color.pink);
		michelleRobot.addText("MICHELLE IS AWESOME");
		_robots.add(michelleRobot);
		
		Robot happyRobot = new FlyingRobot(10,10,1,1,150,150);
		happyRobot.addText("I AM HAPPY!!!");
		_robots.add(happyRobot);
		
		// Start the animation.
		_timer.start();
	}

	/**
	 * Called by the Swing framework whenever this AnimationViewer object
	 * should be repainted. This can happen, for example, after an explicit 
	 * repaint() call or after the window that contains this AnimationViewer 
	 * object has been opened, exposed or moved.
	 * 
	 */
	public void paintComponent(Graphics g) {
		// Call inherited implementation to handle background painting.
		super.paintComponent(g);
		
		// Calculate bounds of animation screen area.
		int width = getSize().width;
		int height = getSize().height;
		
		// Create a GraphicsPainter that Robot objects will use for drawing.
		// The GraphicsPainter delegates painting to a basic Graphics object.
		Painter painter = new GraphicsPainter(g);
		
		// Progress the animation.
		for(Robot robot : _robots) {
			robot.paint(painter);
			robot.move(width, height);
		}
	}

	/**
	 * Notifies this AnimationViewer object of an ActionEvent. ActionEvents are
	 * received by the Timer.
	 */
	public void actionPerformed(ActionEvent e) {
		// Request that the AnimationViewer repaints itself. The call to 
		// repaint() will cause the AnimationViewer's paintComponent() method 
		// to be called.
		repaint();
	}
	
	/**
	 * Main program method to create an AnimationViewer object and display this
	 * within a JFrame window.
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Animation viewer");
				frame.add(new AnimationViewer());
		
				// Set window properties.
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}
}
