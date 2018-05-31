package robot;

import java.awt.Color;
import java.awt.Image;

/** 
 * Interface to represent a type that offers primitive drawing methods.
 * 
 * @author Michelle Tan
 * 
 */
public interface Painter {
	/**
	 * Draws a rectangle. Parameters x and y specify the top left corner of the
	 * rectangle. Parameters width and height specify its width and height.
	 */
	public void drawRect(int x, int y, int width, int height);
	
	/**
	 * Draws an oval. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void drawOval(int x, int y, int width, int height);
	
	/**
	 * Draws a line. Parameters x1 and y1 specify the starting point of the 
	 * line, parameters x2 and y2 the ending point.
	 */
	public void drawLine(int x1, int y1, int x2, int y2);
	
	/**
	 * Fills a rectangle with the current colour. Parameters x and y specify the top left corner of the
	 * rectangle. Parameters width and height specify its width and height.
	 */
	public void fillRect(int x, int y, int width, int height);
	
	/**
	 * Gets the colour of the shape.
	 */
	public Color getColor();
	
	/**
	 * Sets the colour of the shape based on the parameter c.
	 */
	public void setColor(Color c);
	
	/**
	 * Draws an image.  Parameters x and y specify the top left corner of the
	 * image. Parameters width and height specify its width and height.
	 */
	public void drawImage(Image img, int x, int y, int width, int height);
	
	public void translate(int x, int y);
	
	public void drawCentredText(String text, Robot robot);
			
}
