package shop;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Window extends JPanel{
	
	static int x = 50;
	
	public Window(){
		JFrame f = new JFrame("LOH");
		f.setLocation(300, 300);
		f.setMinimumSize(new Dimension(800, 600));
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		f.getContentPane().add(this);
		
		f.pack();
		f.setVisible(true);
		
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		
		g.setColor(Color.PINK);
		g.fillRect(0, 0, 800, 600);
		
		g.setColor(Color.CYAN);
		g.draw3DRect(100, 100, 60, 60, true);
		
		g.setColor(Color.YELLOW);
		g.setFont(new Font(Font.DIALOG, Font.BOLD, 33));
		g.drawString("SPARTAAAAAAAAAAAA", 200, 200);
		
		g.setColor(Color.BLACK);
		g.fillRect(x, 30, 40, 40);
	}
	


	public static void main(String[] args) throws InterruptedException {
		Window w = new Window();
		Thread.sleep(5000);
		System.out.println("HELLO LOH");
		x = 130;
		
		w.repaint();

	}

}
