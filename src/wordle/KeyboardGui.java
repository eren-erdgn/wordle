package wordle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.util.Locale;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.Timer;


public class KeyboardGui extends JFrame implements MouseListener {
	private JPanel jpNorth;
	private JPanel jpCenter;
	

	private static int a=0;
	private static int b=0;
	private static int c=0;
	private static int score = 6;
	private static int fiveGreenCount = 0;
	private int second, minute;
	
	
	
	
	
	
	private JLabel counterLabel;
	private Timer timer;
	private String ddSecond, ddMinute;
	private DecimalFormat dFormat;
	private JTextField txtGuess;
	private JButton enterButton;
	
	
	public KeyboardGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		northRegion();
		centerRegion();
		
	}
	

	public void northRegion() {
		jpNorth = new JPanel();
		
		jpNorth.setBackground(Color.DARK_GRAY);
		
		counterLabel = new JLabel("");
		counterLabel.setFont(new Font("Helvetica Neue", Font.BOLD,40));
		counterLabel.setText("00:00");
		counterLabel.setForeground(Color.WHITE);
		second =0;
		minute =0;
		dFormat = new DecimalFormat("00");
		countTime();
		timer.start();
		
		jpNorth.add(counterLabel);
		add(jpNorth,BorderLayout.NORTH);
		
		
		
	}
	
	
	public void countTime() {
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				second++;
				ddSecond = dFormat.format(second);
				ddMinute = dFormat.format(minute);
				counterLabel.setText(ddMinute + ":" + ddSecond);
				if(second==60) {
					second = 0;
					minute++;
					ddSecond = dFormat.format(second);
					ddMinute = dFormat.format(minute);	
					counterLabel.setText(ddMinute + ":" + ddSecond);
				}
				if(minute==0 && second==0) {
					timer.stop();
				}
				
			}
		});
				}
	
	
	
public void centerRegion() {
		
		jpCenter = new JPanel();
		
		

		jpCenter.setBackground(Color.DARK_GRAY);
		

		
		
		
		WordTiles wt = new WordTiles();
		
		jpCenter.add(wt);
	
		
	
		
		txtGuess = new JTextField("");
		txtGuess.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		txtGuess.setBounds(15, 395, 200, 50);
		
		enterButton= new JButton("GUESS!");
		enterButton.setFont(new Font("Helvetica Neue", Font.BOLD,15));
		enterButton.setBounds(230, 400, 140, 40);
		enterButton.addMouseListener(this);
		
		jpCenter.setLayout(null);
		
		jpCenter.add(txtGuess);
		jpCenter.add(enterButton);
		
		add(jpCenter,BorderLayout.CENTER);
		Words w = new Words();
		String str =w.WordChooser();
		System.out.println(str);
		
		Locale trlocale = new Locale("tr-TR");
		
		enterButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String guess = txtGuess.getText().toUpperCase(trlocale);
				if(guess.length() !=5 ) {
					
						JOptionPane.showMessageDialog(null, "try 5 letter");
						
					}
				else {
					char[] chGuess = new char[guess.length()];
					for (int i = 0; i < guess.length(); i++) {
						chGuess[i] = guess.charAt(i);
					}
						
						
					char[] ch = new char[str.length()];
					for (int k = 0; k < str.length(); k++) {
				            ch[k] = str.charAt(k);
				     }
						
						for (int j = 0; j < 5; j++) {
							
							
							if(chGuess[j]== ch[j]) {
								System.out.println("nice");
								String s = Character.toString(chGuess[j]);
								fiveGreenCount++;
								
									wt.cap(s,j,a,Color.GREEN);
									if(fiveGreenCount==5) {
										timer.stop();
										score = score - a;
										
										YouWonFrame ywf = new YouWonFrame();
										ywf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
										ywf.setSize(400,600);
										ywf.setVisible(true);
										
										JOptionPane.showMessageDialog(null, "you won!" + "\n"+"your score:"+score + "\n" + "time:"+ ddMinute + ":" + ddSecond);
										try {
											writeFile();
										} catch (IOException e1) {
											e1.printStackTrace();
										}
										System.exit(0);
										
									}	
								}
							
							
							else if(chGuess[j]!= ch[j]) {
								fiveGreenCount=0;
								
								String s = Character.toString(chGuess[j]);
								wt.cap(s,j,b,Color.DARK_GRAY);
							}
							
							
							for(int t=0; t<5; t++) {
								 if(chGuess[j]!= ch[j] && chGuess[j]==ch[t] ) {
									 
									 fiveGreenCount=0;
									 
										String s = Character.toString(chGuess[j]);
										wt.cap(s,j,c,Color.YELLOW);
								}
								 
								 
								 
								 }
							
							
						}
						
						
						
						a++;
						b++;
						c++;
						
						if(a==6 && fiveGreenCount!=5) {
							timer.stop();
							JOptionPane.showMessageDialog(null, "you lose! word is : " + str);
							System.exit(0);
						}
					
					
						
						
						
			        
					
					
				}
				
				
			}
			
		});
		
		
		
		
		
		
		
	}


public void writeFile() throws IOException{
	
	RandomAccessFile raf = new RandomAccessFile(new File("Statistics.txt"), "rw");
	raf.seek(raf.length());
	raf.writeBytes(Gui.name + "\t" +"your score:"+score + "\t" + "time:"+ ddMinute + ":" + ddSecond);
	raf.writeBytes("\n");
	raf.close();
}

@Override
public void mouseClicked(MouseEvent e) {
if(e.getSource() == enterButton) {
	txtGuess.setText("");
}
}


@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}






}
