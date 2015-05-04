import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pickCards extends JFrame{
	
	int[] deck = new int[52];
	ImageIcon[] poker = new ImageIcon[52];	
	//creates cards
	
	private JLabel a;
	private JLabel b;
	private JLabel c;
	private JLabel d;
	
	//the word "Refresh" on the panel
	private JButton jbtRefresh = new JButton("Refresh");
	
	//create two panels
	JPanel panel = new JPanel();
	JPanel panel1 = new JPanel();
	
	public pickFourCards(){

		for(int i = 0 ; i < poker.length ; i ++){
			poker[i] = new ImageIcon((getClass().getResource("image/card/" + (i+1) +".png")));
		}
		//load 52 cards
		
		panel.add(jbtRefresh);
		//add Refresh button
		
		panel1.setLayout(new GridLayout(1,4,1,1));
		//type setting
		
		for(int i = 0; i < deck.length; i++)
			deck[i] = i;
			
		
		for(int i = 0; i < deck.length; i++){
			int index = (int)(Math.random() * deck.length);
			int temp = deck[i];
			deck[i] = deck[index];
			deck[index] = temp;
		}//刷新
		
		a = new JLabel(poker[deck[0]]);
		b = new JLabel(poker[deck[1]]);
		c = new JLabel(poker[deck[2]]);
		d = new JLabel(poker[deck[3]]);
		//將前4張存起來
		
		panel1.add(a);
		panel1.add(b);
		panel1.add(c);
		panel1.add(d);
		
		this.add(panel,BorderLayout.SOUTH);
		this.add(panel1,BorderLayout.CENTER);



		jbtRefresh.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			
			panel1.repaint();
			for(int i = 0; i < deck.length; i++)
				deck[i] = i;
				  
			for(int i = 0; i < deck.length; i++){
				int index = (int)(Math.random() * deck.length);
				int temp = deck[i];
				deck[i] = deck[index];
				deck[index] = temp;
			}	
			
			a.setIcon(poker[deck[0]]);
			b.setIcon(poker[deck[1]]);
			c.setIcon(poker[deck[2]]);
			d.setIcon(poker[deck[3]]);

			}
		});
		
	}
	
	
	
	public static void main(String args[]){
		JFrame frame = new pickFourCards();
		frame.setTitle("Pick Four Cards");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,200);
		frame.setVisible(true);
	}

}

