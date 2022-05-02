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
	
	//checks which background is showing to make sure that transitions are smooth 
	boolean desk_check = true; 
	boolean gmail_check = false; 
	boolean login_check = false; 
	boolean screen_check = false;
	boolean ao_check = false; 
	boolean rules_check = false;
	boolean r_close_check = false; 


public static void main(String[] arg) {
	Frame f = new Frame();
}

public void paint(Graphics g) {
	super.paintComponent(g);
	bg.paint(g); 
	
	//screen hitbox
	g.drawRect(100, 180, 710, 360);

	//chrome/login hitbox 
	g.drawRoundRect(154, 120, 70, 50, 20, 20);

	//gmail hitbox
	g.drawRoundRect(156, 210, 65, 65, 20, 20);

	//login hitbox
	g.drawRoundRect(1200, 75, 150, 42, 20, 20);

	//rules hitbox 
	g.drawRoundRect(1150, 140, 180, 300, 20, 20);

	//rules close up hitbox
	g.drawRoundRect(1000, 200, 300, 500, 20, 20);
	
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
		// TODO Auto-generated method stub
		if(arg0.getKeyCode() == 27) {
			if(screen_check == true) {
				bg.updateToDesk();
				desk_check = true; 
				screen_check = false; 
			}
			if(gmail_check == true || login_check == true) {
				bg.updateToCS();
				screen_check = true; 
				gmail_check = false; 
				login_check = false; 
			}

			if(ao_check == true) {
				bg.updateToLogin();
				ao_check = false; 
				login_check = true; 
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