/***********************************************************************
Program Name: DayGUI.java
Programmer's Name: Craig Gleckman
Program Description: Creates a GUI program that allows you select good or bad.
				Program then outputs that you are having a good, or bad, day.
***********************************************************************/

package Week4;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DayGUI extends JFrame
{
	private JFrame mainFrame;
	private JButton cmdGood;
	private JButton cmdBad;

	public DayGUI() 
	{
		//creates main program frame
		mainFrame = new JFrame("Message");
	
		//creates good and bad buttons
		cmdGood = new JButton("Good");
		cmdBad = new JButton("Bad");
		
		//creates a new container
		Container c = mainFrame.getContentPane();
		c.setLayout(new FlowLayout());
		
		//adds the buttons to the container
		c.add(cmdGood);
		c.add(cmdBad);
		
		//sets Mnemonics for each button
		cmdGood.setMnemonic('G');
		cmdBad.setMnemonic('B');
			
		//sets main frame size
		mainFrame.setSize(300,100);
		
		//Creates a listener for when the user closes the program window
		mainFrame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				//exits the program
				System.exit(0);
			}
		});
		
		//Creates a new handler
		ButtonHandler bhandler = new ButtonHandler();
		
		//adds action listeners for the buttons
		cmdGood.addActionListener(bhandler);
		cmdBad.addActionListener(bhandler);
		
		mainFrame.setVisible(true);
	}

	//Creates button handler class which determines which button was pressed
	//and outputs a result based on that
	class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == cmdGood)
			{
				JOptionPane.showMessageDialog(null, "Today is a good day!",
						"Event Handler Message",
						JOptionPane.INFORMATION_MESSAGE);
			}
			
			if (e.getSource() == cmdBad)
			{
				JOptionPane.showMessageDialog(null, "Today is a bad day!",
						"Event Handler Message",
						JOptionPane.INFORMATION_MESSAGE); 
			}
		}
	}

	
	public static void main(String arg[])
	{
		DayGUI app;
		app = new DayGUI();
	}

}
