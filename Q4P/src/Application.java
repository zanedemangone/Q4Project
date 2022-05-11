import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Application {

	private String name; 
	private String gpa; 
	private String pStatement; 
	private String ec; 
	private String dMoney; 
	private String location; 
	private String hs;  

	
	Character a = new Character(); 

	public Application() {
		name = a.getFirstName(); 
		gpa = a.getGpa(); 
		pStatement = ""; 
		ec = ""; 
		dMoney = a.getDonation(); 
		location = ""; 
		hs = ""; 
	}
	
	//public String nextApplication() {
		
		
		
	//}

	public void paint(Graphics g) {



	}

}