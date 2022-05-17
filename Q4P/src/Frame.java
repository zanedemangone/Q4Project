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
	
	boolean score_check; 


public static void main(String[] arg) {
	Frame f = new Frame();
}

public void paint(Graphics g) {
	super.paintComponent(g);
	bg.paint(g); 

	if(report_check == true && b.gameLength >= 0) {
		b.run();
		a.paint(g);
		g.drawString("You have: " + Integer.toString(b.gameLength/45) + " seconds left", 800, 115); 
	}else {
		bg.updateToAO();
		b.gameLength = 2700; 
		ao_check = true; 
		report_check = false; 
	}
	
	if(report_check == true && ao_check == true) {
		g.drawString(Integer.toString(b.points), 1200, 400);
	}
	
	if(b.gameLength == 0) {
		b.gameExit(); 
	}
	
	g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
	if(parseListPaint && report_check == true) {
		int count = 0;;
		for(String s : parseList) {
			if(s.length() > 30) {
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


	@Override
	public void mouseClicked(MouseEvent arg0) {
		//transition from desk to comp screen 
		
		if(control == false) {
			return;
		}
		
		if((arg0.getX() >= 100 && arg0.getX() <= 810) && (arg0.getY() >= 180 && arg0.getY() <= 580) && desk_check == true) {
			bg.updateToCS();
			desk_check = false; 
			screen_check = true; 
		}

		//transition from comp screen to login page or gmail 
		if((arg0.getX() >= 154 && arg0.getX() <= 224) && (arg0.getY() >= 120 && arg0.getY() <= 200) && screen_check == true) {
			bg.updateToGmail();
			screen_check = false; 
			gmail_check = true; 
		}

		if((arg0.getX() >= 154 && arg0.getX() <= 224) && (arg0.getY() >= 240 && arg0.getY() <= 300) && screen_check == true) {
			bg.updateToLogin();
			screen_check = false; 
			login_check = true; 
		}

		//transition from login page to ao page
		if((arg0.getX() >= 1200 && arg0.getX() <= 1350) && (arg0.getY() >= 100 && arg0.getY() <= 150) && login_check == true) {
			bg.updateToAO();
			login_check = false; 
			ao_check = true; 
		}

		//transition from desk to rules 
		if((arg0.getX() >= 1150 && arg0.getX() <= 1330) && (arg0.getY() >= 140 && arg0.getY() <= 440) && desk_check == true) {
			bg.updateToRules();
			desk_check = false; 
			rules_check = true; 
		}

		if((arg0.getX() >= 620 && arg0.getX() <= 1020) && (arg0.getY() >= 100 && arg0.getY() <= 680) && rules_check == true) {
			bg.updateToRulesCloseUp();
			rules_check = false; 
			r_close_check = true;
		}

		if((arg0.getX() >= 60 && arg0.getX() <= 840) && (arg0.getY() >= 260 && arg0.getY() <= 740) && ao_check == true) {
			bg.updateToReport();
			ao_check = false; 
			report_check = true;
			parseListPaint = true;
		}

		if((arg0.getX() >= 315 && arg0.getX() <= 651) && (arg0.getY() >= 614 && arg0.getY() <= 814) && report_check == true) {
			a.change();
			score_check = r.correctDecision(a.location, Double.parseDouble(a.gpa), (int) Double.parseDouble(a.dMoney.replaceAll(",", "").substring(1))); 
			b.evaluationMade(score_check); 
			System.out.println("Accept");
			b.evaluationMade(r.correctDecision(a.character.get(a.characterSelect))); 
		}

		if((arg0.getX() >= 708 && arg0.getX() <= 1044) && (arg0.getY() >= 614 && arg0.getY() <= 814) && report_check == true) {
			//score for reject goes here 
			a.change();
			score_check = r.correctDecision(a.location, Double.parseDouble(a.gpa), (int) Double.parseDouble(a.dMoney.replaceAll(",", "").substring(1))); 
			b.evaluationMade(score_check); 
			System.out.println("Reject");
			b.evaluationMade(r.correctDecision(a.character.get(a.characterSelect))); 
		}
		
		if(b.gameLength == 0) {
			bg.updateToAO();
			ao_check = true; 
			report_check = false; 
		}
		
		if(interview_check == true){
			bg.studentBG(a.faceNum());
			bg.updateToZoom();
			
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
		System.out.println(arg0.getX() + "," + arg0.getY());
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
		if (arg0.getKeyCode() == 27) {
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

			if (report_check == true) {
				bg.updateToAO();
				ao_check = true;
				report_check = false;
			}
		}
		System.out.println(arg0.getKeyCode());
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