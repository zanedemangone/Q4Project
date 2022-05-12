import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;
import java.math.*;

public class sbg {

	//add location attributes
	private Image img; 	
	private AffineTransform tx;
	private int rand; 

	public sbg(int x, int y) {

		img = getImage("./imgs/sbg1.png"); //load the image for Tree
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y); 				//initialize the location of the image
									//use your variables
	}


	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;


		//call update to update the actual y picture location
		update();




		g2.drawImage(img, tx, null);



	}
	/* update the picture variable location */

	public void update() {
		rand = (int) (Math.random() * 11); 
		if(rand == 0) {
			
		}
	}

	public void random() {

	}


	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(4.0, 3.8);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Background.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
}