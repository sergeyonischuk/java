package shop;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.xml.stream.events.ProcessingInstruction;

public class ShopUI {
	
	Shop shop = new Shop();
	Instrument selectedInstrument;
	
	public ShopUI(Shop shop){
		this.shop = shop;
		
		JFrame j = new JFrame("Instruments shop");
		j.setMinimumSize(new Dimension(800, 600));
		j.setLocation(400, 400);
		
		j.getContentPane().add(CreateSellingPanel());
		
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.pack();
		j.setVisible(true);
	}
	
	JPanel CreateSellingPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		
		JLabel lname = new JLabel("Your name: ");
		JTextField tfName = new JTextField(20);
		
		
		panel.add(lname, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0,0,0,0), 0, 0));
		panel.add(tfName, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0), 0, 0));
		
		
		
		JLabel lInstr = new JLabel("Instrument: ");
		ArrayList<Instrument> inst = shop.getProducts();
		

		
		ButtonGroup prodButtons = new ButtonGroup();
		
		
		JPanel pInstr = new JPanel();
		pInstr.setLayout(new GridLayout(inst.size(), 0));
		pInstr.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		JRadioButton rb;
		for(int i = 0; i < inst.size(); i++){
			rb = new JRadioButton(inst.get(i).getModel() + " - " + inst.get(i).getPrice() + "$", false);
			prodButtons.add(rb);
			pInstr.add(rb);
			rb.setActionCommand(inst.get(i).getModel());
			
		}
		
		
		
		panel.add(lInstr, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0), 0, 0));
		panel.add(pInstr, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0,3,0,0), 0, 0));
		
		
		JLabel LCount = new JLabel("Count: ");
		NumberFormat nf = NumberFormat.getNumberInstance();
		JFormattedTextField ftf = new JFormattedTextField(nf);
		ftf.setValue(1);
		
		panel.add(LCount, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0), 0, 0));
		panel.add(ftf, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0), 0, 0));
		
		JButton buyButton = new JButton("Buy");
		
		buyButton.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Customer cust = new Customer(tfName.getText(), "88005553535", "3@mail.ru");
				int count = Integer.parseInt(ftf.getText());
				//
				
				shop.addRealiz(inst.get(3), cust, inst.get(3).getPrice(), count);
				
			}
		});
	
		
		panel.add(buyButton, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0), 0, 0));
		
		
		
		return panel;
		
	}

}
