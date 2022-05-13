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
	private String lastName; 
	private String gpa; 
	private String pStatement; 
	private String ec; 
	private String dMoney; 
	private String location;
	private String donation; 
	private int faceNum; 
	
	Character a = new Character(); 
	Color c;

	public Application() {
		name = a.getFirstName(); 
		lastName = a.getLastName(); 
		gpa = a.getGpa(); 
		pStatement = a.getPersonalStatement(); 
		ec = a.getExtracurricular(); 
		dMoney = a.getDonation(); 
		location = a.getLocation(); 
		donation = a.getDonated(); 
		faceNum = a.getFaceNum(); 
	}
	
	public int faceNum(){
		return faceNum;
		 
	}

	public void paint(Graphics g) {
		c = new Color(128, 217, 255); 
		g.setColor(c);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 40)); 
		
		//name 
		g.drawString(name +" "+lastName , 500, 187);
		
		//gpa 
		g.drawString(gpa, 465, 323);
		
		//pStatement
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.drawString(pStatement, 120, 535);
		
		//ec
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.drawString(ec, 1020, 240);
		
		//dMoney
		g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
		g.drawString(dMoney, 852, 330);
		
		//location
		g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		g.drawString(location, 570, 256); 
		
		//item donated 
		g.drawString(donation, 640, 386);
	}

}