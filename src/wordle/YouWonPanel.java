package wordle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class YouWonPanel extends JPanel implements ActionListener {
	
	final int PANEL_WIDTH = 400;
	final int PANEL_HEIGHT = 600;
	
	Image redBalloon;
	Image brownBalloon;
	Image pinkBalloon;
	Image blueBalloon;
	
	Timer timer;
	int yVelocity = 1;
	
	
	int xRed = 200;
	int yRed = 500;
	int xPink = 70;
	int yPink = 420;
	int xBlue = 0;
	int yBlue = 600;
	
	

	
	YouWonPanel(){
		this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
		this.setBackground(Color.DARK_GRAY);
		
		redBalloon = new ImageIcon("redBalloon.png").getImage();
		pinkBalloon = new ImageIcon("pinkBalloon.png").getImage();
		blueBalloon = new ImageIcon("blueBalloon.png").getImage();
		
		timer = new Timer(10, this);
		timer.start();
		
		
	}
	
	public void paint(Graphics g) {
		
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(redBalloon, xRed, yRed, null);
		g2d.drawImage(pinkBalloon, xPink, yPink, null);
		g2d.drawImage(blueBalloon, xBlue, yBlue, null);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		yRed = yRed - yVelocity;
		yPink = yPink - yVelocity;
		yBlue = yBlue - yVelocity;
		repaint();
		
	}
	
}
