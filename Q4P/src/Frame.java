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
	boolean chrome_check = false; 
	boolean gmail_check = false; 


public static void main(String[] arg) {
	Frame f = new Frame();
}

public void paint(Graphics g) {
	super.paintComponent(g);
	bg.paint(g); 
	
	//chrome hitbox
	g.drawRoundRect(145, 285, 40, 40, 10, 10);

	//gmail hitbox
	g.drawRoundRect(140, 230, 48, 30, 10, 10);
	
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
		if((arg0.getX() >= 145 && arg0.getX() <= 180) && (arg0.getY() >= 285 && arg0.getY() <= 345) && desk_check == true) {
			bg.updateToCS(); 
			desk_check = false; 
			chrome_check = true; 
		}

		if((arg0.getX() >= 140 && arg0.getX() <= 188) && (arg0.getY() >= 230 && arg0.getY() <= 280) && desk_check == true) {
			bg.updateToGmail();
			desk_check = false; 
			gmail_check = true; 
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
		// TODO Auto-generated method stub
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