package wordle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Gui extends JFrame {
	
	private JPanel jpNorth;
	private JPanel jpCenter;
	private JLabel lblIcon;
	private JButton jbKeyboardPlay;
	protected static String name;
	
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		northRegion();
		centerRegion();
		
		
	}
	
	
	
	public void nameEnterK() {
		name = JOptionPane.showInputDialog("player name: ");
		if(name == null ) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			northRegion();
			centerRegion();
		}
		else if(name.isEmpty() || name.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "please enter a name!");
			nameEnterK();
		}
		else {
			
			KeyboardGui k = new KeyboardGui();
			k.setSize(400,600);
			k.setVisible(true);
			k.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(false);	
			
			
		}
		
		
	}
	
	


	public void northRegion() {
		jpNorth = new JPanel();
		
		jpNorth.setBackground(Color.DARK_GRAY);
		
		
		
		lblIcon = new JLabel(new ImageIcon("logo.png"));
		jpNorth.add(lblIcon);
		
		add(jpNorth,BorderLayout.NORTH);
		
		
		
	}
	
	public void centerRegion() {
		
		jpCenter = new JPanel();
	
		
		

		
		jbKeyboardPlay = new JButton("KEYBOARD");
		jbKeyboardPlay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nameEnterK();
				
			}
		});
		
		
		
		jbKeyboardPlay.setBounds(100, 150, 200, 100);
		
		jbKeyboardPlay.setFocusable(false);


		jbKeyboardPlay.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
		
		jpCenter.setLayout(null);
		jpCenter.setBackground(Color.DARK_GRAY);
		jpCenter.add(jbKeyboardPlay);
		
		add(jpCenter,BorderLayout.CENTER);
		
		
		
		
	}

	

	

}
