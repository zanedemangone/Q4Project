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

	//attributes an application has
	private String name; 
	private String lastName; 
	private String gpa; 
	private String pStatement; 
	private String ec; 
	private String dMoney; 
	private String location;
	private String donation;
	
	//the applicants
	private Character c = new Character();
	//public ArrayList<Character> character = new ArrayList<Character>();
	//public int characterSelect;

	public Application() {
		/*
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
		*/
		modify();
		
	}
	
	public void change() {
		c= new Character();
		modify();
		//int notNum = characterSelect;
		//while(characterSelect == notNum) {
		//	characterSelect = (int)(Math.random()*character.size());
		//}
		//characterSelect = (int)(Math.random()*character.size());
		//name = character.get(characterSelect).getFirstName(); 
		//lastName = character.get(characterSelect).getLastName(); 
		//gpa = character.get(characterSelect).getGpa(); 
		//pStatement = character.get(characterSelect).getPersonalStatement(); 
		//ec = character.get(characterSelect).getExtracurricular(); 
		//dMoney = character.get(characterSelect).getDonation(); 
		//location = character.get(characterSelect).getLocation(); 
		//donation = character.get(characterSelect).getDonated(); 
	}

	public void modify() {
		name = c.getFirstName();
		lastName = c.getLastName(); 
		gpa = c.getGpa(); 
		pStatement = c.getPersonalStatement(); 
		ec = c.getExtracurricular(); 
		dMoney = c.getDonation(); 
		location = c.getLocation(); 
		donation = c.getDonated(); 
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
	
	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getGpa() {
		return gpa;
	}

	public String getpStatement() {
		return pStatement;
	}

	public String getEc() {
		return ec;
	}

	public String getdMoney() {
		return dMoney;
	}

	public String getLocation() {
		return location;
	}

	public String getDonation() {
		return donation;
	}

	public Character getC() {
		return c;
	}
}