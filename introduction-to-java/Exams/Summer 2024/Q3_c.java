//Import the AWT and Swing libraries
import java.awt.*;
import javax.swing.*;

class Q3_c {
	public static void main(String[] args) {
		//Create the JFrame with an appropriate title
		JFrame win = new JFrame("My First Rectangle");
		//Set the size and location of the JFrame
		win.setSize(300, 200);
		win.setLocation(100, 100);
		//Make the JFrame visible
		win.setVisible(true);
		
		//Get the Graphics object of the content pane of the JFrame, which will allow us to draw on the frame
		Graphics g = win.getContentPane().getGraphics();
		
		g.setColor(Color.BLUE);
		
		//Draw a rectangle at position (50, 50) with width 100 and height 30
		g.drawRect(50, 50, 100, 30);
	}
}