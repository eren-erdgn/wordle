package wordle;

import javax.swing.JFrame;

public class YouWonFrame extends JFrame {
	
	YouWonPanel panel;
	
	
	YouWonFrame(){
		panel = new YouWonPanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();
		this.setVisible(true);
		
	}
	

}
