package robot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


/**
 * Implementation of the Painter interface that delegates drawing to a
 * java.awt.Graphics object.
 * 
 * @author Michelle Tan
 * 
 */
public class GraphicsPainter implements Painter {
	// Delegate object.
	private Graphics _g;

	/**
	 * Creates a GraphicsPainter object and sets its Graphics delegate.
	 */
	public GraphicsPainter(Graphics g) {
		this._g = g;
	}

	/**
	 * @see robot.Painter.drawRect
	 */
	public void drawRect(int x, int y, int width, int height) {
		_g.drawRect(x, y, width, height);
	}

	/**
	 * @see robot.Painter.drawOval
	 */
	public void drawOval(int x, int y, int width, int height) {
		_g.drawOval(x, y, width, height);
	}

	/**
	 * @see bounce.Painter.drawLine.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_g.drawLine(x1, y1, x2, y2);
	}

	/**
	 * @see robot.Painter.fillRect.
	 */
	@Override
	public void fillRect(int x, int y, int width, int height) {
		_g.fillRect(x, y, width, height);
	}

	/**
	 * @see robot.Painter.getColor.
	 */
	@Override
	public Color getColor() {
		return _g.getColor();
	}

	/**
	 * @see robot.Painter.setColor.
	 */
	@Override
	public void setColor(Color c) {
		_g.setColor(c);
	}

	/**
	 * @see robot.Painter.drawImage.
	 */
	public void drawImage(Image img, int x, int y, int width, int height) {
		_g.drawImage(img, x, y, width, height, null);
	}

	public void translate(int x, int y) {
		_g.translate(x, y);
	}

	public void drawCentredText(String text, Robot robot) {

		java.awt.FontMetrics fm = _g.getFontMetrics();

		// Determine the X coordinate for the text
		int x = robot._x + robot._width/2 - fm.stringWidth(text)/2;

		// Determine the Y coordinate for the text
		int y = robot._y + robot._height/2 + ((fm.getAscent() - fm.getDescent())/2);
		
		// Draw the String
		_g.drawString(text, x, y);
	}
}
