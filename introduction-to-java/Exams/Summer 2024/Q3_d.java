//Import the AWT and Swing libraries
import java.awt.*;
import javax.swing.*;

public class Q3_d {
	public static void main(String[] args) {
		//Create the JFrame with an appropriate title
		JFrame win = new JFrame("My First Rectangle");
		//Set the size and location of the JFrame
		win.setSize(300, 200);
		win.setLocation(100, 100);
		//Make the JFrame visible
		win.setVisible(true);
		
		//Get the Graphics object of the content pane of the JFrame, which will allow us to draw on the frame
		Container pane = win.getContentPane();
		
		Graphics g = pane.getGraphics();
		
		g.setColor(Color.RED);

		// g.drawRect(50, 50, 100, 30);
		g.fillRect(50, 50, 100, 30);

		System.out.println("Hi");
	}
}