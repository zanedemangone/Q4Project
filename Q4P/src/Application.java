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

	public String name; 
	public String lastName; 
	public String gpa; 
	public String pStatement; 
	public String ec; 
	public String dMoney; 
	public String location;
	public String donation; 
	public int faceNum; 
	
	public ArrayList<Character> character = new ArrayList<Character>();
	public int characterSelect;

	public Application() {
		for(int i = 0; i < 100; i ++) {
			character.add(new Character());
		}
		characterSelect = (int)(Math.random()*character.size());
		name = character.get(characterSelect).getFirstName(); 
		lastName = character.get(characterSelect).getLastName(); 
		gpa = character.get(characterSelect).getGpa(); 
		pStatement = character.get(characterSelect).getPersonalStatement(); 
		ec = character.get(characterSelect).getExtracurricular(); 
		dMoney = character.get(characterSelect).getDonation(); 
		location = character.get(characterSelect).getLocation(); 
		donation = character.get(characterSelect).getDonated(); 
		faceNum = character.get(characterSelect).getFaceNum(); 
	}
	
	public int faceNum(){
		return faceNum; 
	}
	
	public void change() {
		int notNum = characterSelect;
		while(characterSelect == notNum) {
			characterSelect = (int)(Math.random()*character.size());
		}
		characterSelect = (int)(Math.random()*character.size());
		name = character.get(characterSelect).getFirstName(); 
		lastName = character.get(characterSelect).getLastName(); 
		gpa = character.get(characterSelect).getGpa(); 
		pStatement = character.get(characterSelect).getPersonalStatement(); 
		ec = character.get(characterSelect).getExtracurricular(); 
		dMoney = character.get(characterSelect).getDonation(); 
		location = character.get(characterSelect).getLocation(); 
		donation = character.get(characterSelect).getDonated(); 
		faceNum = character.get(characterSelect).getFaceNum(); 
	}

	public void paint(Graphics g) { 
		g.setColor(Color.BLACK);
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
		//g.drawString(ec, 1020, 240);
		if(ec.length() < 34) {
			g.drawString(ec, 1020, 240);
		}else {
			g.drawString(ec.substring(0, 34), 1020, 240);
			g.drawString(ec.substring(34), 1020, 260); 
		}
		
		//item donated 
		g.drawString(donation, 640, 386);
		
		//dMoney
		g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
		g.drawString(dMoney, 852, 330);
		
		//location
		g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		g.drawString(location, 570, 256); 

	}

}