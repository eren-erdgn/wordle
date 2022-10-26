package wordle;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.border.Border;

public class WordTiles extends JPanel implements colorAndPlacment {

	private JLabel[][] letters = new JLabel[7][7];

	public WordTiles() {
		this.setLayout(new GridLayout(6, 5));
		this.setBounds(40, 0, 300, 350);
		Border line = BorderFactory.createLineBorder(Color.BLACK);
		for (int j = 0; j < 6; j++) {
			
		for (int i = 0; i < 5; i++) {
			letters[i][j] = new JLabel("", JLabel.CENTER);
			letters[i][j].setOpaque(true);;
			letters[i][j].setBorder(line);
			this.add(letters[i][j]);
			}
			
		}
		
		
		}
		public void cap(String c,int ix,int jy, Color color) {
			
			letters[ix][jy].setBackground(color);
			
			letters[ix][jy].setText(c);
			
		}
		
		
		
}