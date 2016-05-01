package shop;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ShopUI {
	
	private Shop shop;
	
	public ShopUI(Shop shop){
		this.shop = shop;
		
		JFrame f = new JFrame();
		f.setMinimumSize(new Dimension(800, 600));
		f.setLocation(400, 400);
		
		f.getContentPane().add(createSellingPannel());
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
			
		
	}
	
	private JPanel createSellingPannel(){
		
		JPanel panel = new JPanel();
		JLabel lName = new JLabel("Your name");
		JTextField tfName = new JTextField();
		panel.add(lName);
		panel.add(tfName);
		return panel;
		
	}
	

}
