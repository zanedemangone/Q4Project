import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Background{
	
	// location attributes
	private Image img; 	
	private Image img2; 
	private AffineTransform tx;
	private int faceNum; 
	
	public Background(int x, int y) {
		img = getImage("./imgs/desk_bg.png"); //load the image for Tree
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
		
	}
	
	//update to various backgrounds
	public void updateToGmail() {
		img = getImage("/imgs/gmail_bg.png"); 

	}

	public void updateToDesk() {
		// TODO Auto-generated method stub

		img = getImage("/imgs/desk_bg.png"); 
		
	}
	
	public void updateToCS() {
		img = getImage("/imgs/cs_bg.png"); 
	}
	
	public void updateToAO() {
		img = getImage("/imgs/ao_bg.png"); 
	}

	public void updateToLogin() {
		img = getImage("/imgs/login_bg.png"); 
	}

	public void updateToZoom() {
		img = getImage("/imgs/zoom_main_ui_bg.png"); 
	}

	public void updateToRules() {
		img = getImage("/imgs/rules.gif"); 
	}

	public void updateToRulesCloseUp() {
		img = getImage("/imgs/r_closeUp.png"); 
	}

	public void updateToReport() {
		img = getImage("/imgs/report.png"); 
	}
	
	public void updateToGameOver() {
		img = getImage("/imgs/abs_final.gif"); 
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