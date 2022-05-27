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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	//CREATE THE OBJECT (STEP 1)
	Background bg = new Background(0,0);
	Application a = new Application(); 
	ApplicationMinigame b = new ApplicationMinigame(); 
	Requirement r = new Requirement(); 
	boolean control = true, parseListPaint = false;
	String[] parseList = r.ParsedList();
	
	//checks which background is showing to make sure that transitions are smooth 
	boolean desk_check = true; 
	boolean gmail_check = false; 
	boolean login_check = false; 
	boolean screen_check = false;
	boolean ao_check = false; 
	boolean rules_check = false;
	boolean r_close_check = false; 
	boolean report_check = false; 
	boolean interview_check = false; 
	boolean yamie_check = false; 
	boolean score_check; 
	boolean mail_check; 
	
	int req = 100; //score quota 
	int req_constant = 100; 
	int YamieTimer = 0; //timer for cutscene


public static void main(String[] arg) {
	Frame f = new Frame();
}

public void paint(Graphics g) {
	super.paintComponent(g);
	bg.paint(g); 
	
	//g.drawRect(185, 180, 1200, 550);
	
	if(yamie_check) {
		YamieTimer++; 	//timer for the length of the gif 
	}
	
	if(YamieTimer == 430) { 
		System.exit(0);	//window closes once the timer allows the gif to fully play 
	}

	if(report_check && b.getGameLength() >= 0) {	//shows the timer on the report screen only when the player is on the report screen 
		b.run();
		a.paint(g);
		g.drawString("You have: " + Integer.toString(b.getGameLength()/45) + " seconds left", 800, 115); 
		g.drawString("Score: " + Integer.toString(b.getPoints()), 100, 700);
	}
	
	if(ao_check) {	//shows the total amount of points gained on the admission offers screen 
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString(Integer.toString(b.getPoints()), 1300, 177);
	}
	
	if(mail_check) {	//displays the email when the player clicks on one
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.drawString(a.getEmail(), 250, 300);
	}
	
	if(!report_check && !mail_check) { //if outside of the application game, reset the game so it is fresh for the next go
		b.setGameLength(2700); 
		a.change();
	}
	
	if(b.getGameLength() == 0) {	//logic for once the session timer hits 0 	
		if(req <= b.getPoints()) {	//good ending: resets to the admission officer screen and you live to see another day 
			bg.updateToAO();
			b.setGameLength(2700); 
			ao_check = true; 
			report_check = false; 
			r = new Requirement();
			parseList = r.ParsedList();
		}
		else {
			endGame();//bad ending if the player fails to meet the requirements
		}
	}
	
	g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
	
	if(parseListPaint && report_check) {
		int count = 0;;
		for(String s : parseList) {	//accesses the attributes needed to be displayed on the student admission report 
			if(s.length() > 30) {	//when an attribute is too long, it draws the rest of the string on a next line 
				int length = s.length();
				while(length > 0) {
					if(length > 43) {
						g.drawString(s.substring(0, 43), 1080, 638 + 12 * count);
						s = s.substring(43);
						length -= 43;
					}else {
						g.drawString(s.substring(0), 1080, 638 + 12 * count);
						length = 0;
					}
					count ++;
				}
			}else {
				g.drawString(s, 1080, 638 + 12 * count);
			}
			count ++;
		}
		g.drawString("Make sure to earn more than " + Integer.toString(req) + " points", 1080, 638 + 12 * (count + 1));	//draws the string that shows the requirement for points 
	}
	
}

public Frame() {
	JFrame f = new JFrame("frame");
	f.setSize(new Dimension(1440, 930));
	f.setBackground(Color.blue);
	f.add(this);
	f.setResizable(false);
	f.setLayout(new GridLayout(1,2));
	f.addMouseListener(this);
	f.addKeyListener(this);
	Timer t = new Timer(16, this);
	t.start();
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);
	}

	public void endGame() {
		bg.updateToGameOver();	//bad ending if the player fails to meet the requirements
		yamie_check = true; 
		report_check = false; 
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		//transition from desk to comp screen 
		
		if(!control) {
			return;
		}
		
		if((arg0.getX() >= 100 && arg0.getX() <= 810) && (arg0.getY() >= 180 && arg0.getY() <= 580) && desk_check) {
			bg.updateToCS();
			desk_check = false; 
			screen_check = true; 
		}

		//transition from comp screen to login page or gmail 
		if((arg0.getX() >= 154 && arg0.getX() <= 224) && (arg0.getY() >= 120 && arg0.getY() <= 200) && screen_check) {
			bg.updateToGmail();
			screen_check = false; 
			gmail_check = true; 
		}
		
		//transition from gmail to single mail
		if((arg0.getX() >= 185 && arg0.getX() <= 1385) && (arg0.getY() >= 180 && arg0.getY() <= 750) && gmail_check){
			bg.updateToMail(); 
			gmail_check = false; 
			mail_check = true; 

		}
		
		//transition from the screen page to the login page 
		if((arg0.getX() >= 154 && arg0.getX() <= 224) && (arg0.getY() >= 240 && arg0.getY() <= 300) && screen_check) {
			bg.updateToLogin();
			screen_check = false; 
			login_check = true; 
		}

		//transition from login page to ao page
		if((arg0.getX() >= 1200 && arg0.getX() <= 1350) && (arg0.getY() >= 100 && arg0.getY() <= 150) && login_check ) {
			bg.updateToAO();
			login_check = false; 
			ao_check = true; 
		}

		//transition from desk to rules 
		if((arg0.getX() >= 1150 && arg0.getX() <= 1330) && (arg0.getY() >= 140 && arg0.getY() <= 440) && desk_check) {
			bg.updateToRules();
			desk_check = false; 
			rules_check = true; 
		}
		
		//updates from the rules to a close up of the rules 
		if((arg0.getX() >= 620 && arg0.getX() <= 1020) && (arg0.getY() >= 100 && arg0.getY() <= 680) && rules_check) {
			bg.updateToRulesCloseUp();
			rules_check = false; 
			r_close_check = true;
		}

		//updates from the admission officer page to the report page 
		if((arg0.getX() >= 60 && arg0.getX() <= 840) && (arg0.getY() >= 260 && arg0.getY() <= 740) && ao_check) {
			bg.updateToReport();
			ao_check = false; 
			report_check = true;
			parseListPaint = true;
			req = b.getPoints() + req_constant; 
			req_constant*=2; 
		}

		//logic for the accept button
		//calculates whether or not the player made the correct decision and updates the score accordingly 
		if((arg0.getX() >= 315 && arg0.getX() <= 651) && (arg0.getY() >= 614 && arg0.getY() <= 814) && report_check) {		
			score_check = r.correctDecision(a.getLocation(), Double.parseDouble(a.getGpa()), (int) Double.parseDouble(a.getdMoney().replaceAll(",", "").substring(1))); 
			b.evaluationMade(score_check, true); 

			a.change();
		}

		//logic for the reject button
		//calculates whether or not the player made the correct decision and updates the score accordingly
		if((arg0.getX() >= 708 && arg0.getX() <= 1044) && (arg0.getY() >= 614 && arg0.getY() <= 814) && report_check) {
			score_check = r.correctDecision(a.getLocation(), Double.parseDouble(a.getGpa()), (int) Double.parseDouble(a.getdMoney().replaceAll(",", "").substring(1))); 
			b.evaluationMade(score_check, false); 

			a.change();
		}
		

	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}
	
	@Override
	public void mouseExited(MouseEvent arg0) {
		 
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {

	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == 27) {	//once the escape key is hit, it will transition to the previous background accordingly
			if (screen_check == true) {
				bg.updateToDesk();
				desk_check = true;
				screen_check = false;
			}

			if (gmail_check == true || login_check == true) {
				bg.updateToCS();
				screen_check = true;
				gmail_check = false;
				login_check = false;
			}

			if (ao_check == true) {
				bg.updateToLogin();
				ao_check = false;
				login_check = true;
			}

			if (rules_check == true) {
				bg.updateToDesk();
				desk_check = true;
				rules_check = false;
			}

			if (r_close_check == true) {
				bg.updateToRules();
				rules_check = true;
				r_close_check = false;
			}
			
			if(mail_check == true) {
				bg.updateToGmail();
				gmail_check = true; 
				mail_check = false; 
				a.change();
			}
		}
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}