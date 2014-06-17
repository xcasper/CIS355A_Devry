package Week4;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ErrorChecker.ErrorChecker;

public class GradeProgram  extends JFrame
{
		private JFrame mainFrame;
		private JButton btnScore, btnCalculate, btnClear, btnExit;
		private JTextField fldStuName, fldStuID, fldScores;
		private JLabel lblStuName, lblStuID, lblScores;
		private int numScoresEntered;
		private double scores;
		private char letterGrade;
		private boolean errorExist = true;
		private ErrorChecker ec = new ErrorChecker();
		
		
		//Class constructor method
		public GradeProgram()
		{
			//Define objects in constructor
			mainFrame = new JFrame("Grade Program");
			
			//Initialize buttons
			btnScore = new JButton("Score Button");
			btnCalculate = new JButton("Calculate");
			btnClear = new JButton("Clear");
			btnExit= new JButton("Exit");
			
			//Initialize labels
			lblStuName = new JLabel("Enter Student's Name: ");
			lblStuID = new JLabel("Enter Student's ID: ");
			lblScores = new JLabel("Enter Scores: ");
			
			//Initialize Fields
			fldStuName = new JTextField(30);
			fldStuID = new JTextField(30);
			fldScores = new JTextField(30);
			
			//Get a container for the frame
			Container c = mainFrame.getContentPane();
			//Set the layout of the container
			c.setLayout(new FlowLayout());
			
			//Add components to the container
			c.add(lblStuName);
			c.add(fldStuName);
			c.add(lblStuID);
			c.add(fldStuID);
			c.add(lblScores);
			c.add(fldScores);
			c.add(btnScore);
			c.add(btnCalculate);
			c.add(btnClear);
			c.add(btnExit);
			
			//Set the mnemonic for each button
			btnScore.setMnemonic('S');
			btnCalculate.setMnemonic('C');
			btnClear.setMnemonic('R');
			btnExit.setMnemonic('X');
			
			//Set the size of the GUI frame
			mainFrame.setSize(500, 400);
			
			//Make sure you terminate the program when the application is closed
			mainFrame.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					System.exit(0);
				}
			});
			
			//Add action listener to each button
			//calculateButtonHandler is a class that is defined below
			ScoreButtonHandler shandler = new ScoreButtonHandler();
			btnScore.addActionListener(shandler);
			
			//calculateButtonHandler is a class that is defined below
			CalculateButtonHandler chandler = new CalculateButtonHandler();
			btnCalculate.addActionListener(chandler);
			
			//ClearButtonHandler is a class that is defined below
			ClearButtonHandler clrhandler = new ClearButtonHandler();
			btnClear.addActionListener(clrhandler);
			
			//ExitButtonHandler is a class that is defined below
			ExitButtonHandler ehandler = new ExitButtonHandler();
			btnExit.addActionListener(ehandler);
			
			//FocusHandler is a class that is defined below
			FocusHandler fhandler = new FocusHandler();
			fldStuName.addFocusListener(fhandler);
			fldStuID.addFocusListener(fhandler);
			fldScores.addFocusListener(fhandler);
			
			//Set the GUI frame visible
			mainFrame.setVisible(true);
		}//end GradeProgram
		
		/**
		 * This class implements the interface ActionListener
		 * It is a class that will handle the action on the 
		 * Score button. The required method actionPerformed
		 * is created to read the input values of the score field
		 * and save the inputed value in the array
		 * 
		 */
		class ScoreButtonHandler implements ActionListener {
			public void actionPerformed(ActionEvent e){
				String scoreString;
				scoreString = btnScore.getText();
				
				if(!scoreString.equals(""))
				{
					errorExist = ec.DoubleParseChecker(scoreString);
					if(!errorExist)
					{
						double tempNum = Double.parseDouble(scoreString);
						
						errorExist = ec.RangeChecker(tempNum, 0, 100);
						
						if(!errorExist)
						{
							scores += tempNum;
							System.out.println(scores);
						}
					}
				}
				
				else
				{
					fldScores.requestFocus();
					//also try fldScores.setText("");
				}
				
				System.exit(0);
			}//end actionPerformed
		}//end ScoreButtonHandler
		
		/**
		 * This class implements the interface ActionListener
		 * It is a class that will handle the action on the 
		 * Score button. The required method actionPerformed
		 * is created to take the information from all fields
		 * and numbers from the scores array, calculate the average,
		 * and display an output screen with all the information
		 * 
		 */
		class CalculateButtonHandler implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				/*DecimalFormat num = new DecimalFormat(",###.##");
				double width, length, area;
				String instring;
				
				instring = lengthField.getText();
				if(instring.equals(""))
				{
					instring = ("0");
					lengthField.setText("0");
				}
				length = Double.parseDouble(instring);
				
				instring = widthField.getText();
				if(instring.equals(""))
				{
					instring = "0";
					widthField.setText("0");
				}
				width = Double.parseDouble(instring);
				
				area = length * width;
				
				areaField.setText(num.format(area)); */
			}//end actionPerformed
		}//end CalculateButtonHandler
		
		/**
		 * 
		 * This class implements the interface ActionListener
		 * It is a class that will handle the action on the 
		 * Clear button. The required method actionPerformed
		 * is created to erase all information in the fields
		 */
		class ClearButtonHandler implements ActionListener {
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}//end actionPerformed
		}//end ClearButtonHandler
		
		/**
		 * This class implements the interface ActionListener
		 * It is a class that will handle the action on the 
		 * Exit button. The required method actionPerformed
		 * is created to terminate the program.
		 * 
		 */
		class ExitButtonHandler implements ActionListener {
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}//end actionPerformed
		}//end ExitButtonHandler
		
		/**
		 * This class implements the FocusListener interface
		 * and handles the focus of the components
		 * 
		 */
		class FocusHandler implements FocusListener
		{
			public void focusGained(FocusEvent e)
			{
				/*if (e.getSource() == fldStuName || e.getSource() == fldStuID)
				{
				}//end if
				else if(e.getSource() == areaField)
				{
					//calculateButton.requestFocus();
				}//end else if*/
				
			}//end FocusGained
			public void focusLost(FocusEvent e)
			{
				/*if(e.getSource() == widthField)
				{
					calculateButton.requestFocus();
				}//end if */
			}//end FocusLost
		}//end FocusHandler
		
		public static void main(String args[])
		{
			//new GradeProgram();
			//new OfficeAreaCalculator();
		}
}//end Grade Program
