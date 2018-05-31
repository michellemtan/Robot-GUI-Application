package robot.forms;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.imageio.ImageIO;
import javax.swing.SwingWorker;

import robot.CustomRobot;
import robot.CarrierRobot;
import robot.RobotModel;
import robot.forms.util.Form;
import robot.forms.util.FormHandler;

/**
 * FormHandler implementation for reading form data and using this to
 * instantiate class CustomRobot.
 * 
 * @author Michelle Tan
 *
 */
public class CustomRobotFormHandler implements FormHandler {

	private RobotModel _model;
	private CarrierRobot _parentOfNewRobot;
	private Form _form;
	private int _width;
	private int _deltaX;
	private int _deltaY;
	private int _height;
	File _imageFile;

	/**
	 * Creates a CustomRobotFormHandler.
	 * 
	 * @param model
	 *            the RobotModel to which the handler should add a newly constructed
	 *            CustomRobot object.
	 * @param parent
	 *            the CarrierRobot object that will serve as the parent for a new
	 *            CustomRobot instance.
	 */
	public CustomRobotFormHandler(RobotModel model, CarrierRobot parent) {
		_model = model;
		_parentOfNewRobot = parent;
	}

	/**
	 * Reads form data that describes an CustomRobot. Based on the data, this
	 * CustomRobotFormHandler creates a new CustomRobot object, adds it to a
	 * RobotModel and to a CarrierRobot within the model.
	 * 
	 * @param form
	 *            the Form that contains the CustomRobot data.
	 */
	@Override
	public void processForm(Form f) {
		try {
			_form = f;
			readData();
			// This creates a new thread and calls doInBackground which will load and scale
			// our image
			SwingWorker<BufferedImage,Void> worker = new RobotWorker();
			worker.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private class RobotWorker extends SwingWorker<BufferedImage,Void> {
		@Override
		protected BufferedImage doInBackground() throws Exception {
			long startTime = System.currentTimeMillis();

			// Load the original image (ImageIO.read() is a blocking call).
			BufferedImage fullImage = null;
			try {
				fullImage = ImageIO.read(_imageFile);
			} catch (IOException e) {
				System.out.println("Error loading image.");
			}

			int fullImageWidth = fullImage.getWidth();
			int fullImageHeight = fullImage.getHeight();

			BufferedImage scaledImage = fullImage;

			// Scale the image if necessary.
			if (fullImageWidth > _width) {
				double scaleFactor = (double) _width / (double) fullImageWidth;
				_height = (int) ((double) fullImageHeight * scaleFactor);

				scaledImage = new BufferedImage(_width, _height, BufferedImage.TYPE_INT_RGB);
				Graphics2D g = scaledImage.createGraphics();
				// Method drawImage() scales an already loaded image. The
				// ImageObserver argument is null because we don't need to monitor
				// the scaling operation.
				g.drawImage(fullImage, 0, 0, _width, _height, null);
			}

			long elapsedTime = System.currentTimeMillis() - startTime;
			System.out.println("Image loading and scaling took " + elapsedTime + "ms.");
			return scaledImage;
		}

		@Override
		protected void done() {

			try {
				// Create the new Robot and add it to the model.
				CustomRobot imageRobot = new CustomRobot(_deltaX, _deltaY, this.get());
				_model.add(imageRobot, _parentOfNewRobot);

			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

	private void readData() {
		// Read field values from the form.
		_imageFile = (File) _form.getFieldValue(File.class, ImageFormElement.IMAGE);
		_width = _form.getFieldValue(Integer.class, RobotFormElement.WIDTH);
		_deltaX = _form.getFieldValue(Integer.class, RobotFormElement.DELTA_X);
		_deltaY = _form.getFieldValue(Integer.class, RobotFormElement.DELTA_Y);
	}
}
