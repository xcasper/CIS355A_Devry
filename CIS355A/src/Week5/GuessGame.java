//TODO: Organize into Panels
//Panel reference:  http://stackoverflow.com/questions/16270935/how-do-i-get-these-two-buttons-on-the-bottom-of-my-program


package Week5;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ErrorChecker.ErrorChecker;

public class GuessGame extends JFrame 
{
	//Declare local variables
	private JFrame mainFrame;
	private JButton btnSbmtGuess, btnNewGame, btnExitGame;
	private JTextField fldGuess;
	private JLabel lblResult, lblInfo;
	private int numGuess, guessCount;
	private boolean errorExist = true;
	//create and get random number 1-100 for user to guess.
	Random randNum = new Random();//Create new random generator
	int numAnswer = randNum.nextInt(100)+1;//get random number 1-100 for user to guess.
	//Create global customer error checker
	private ErrorChecker ec = new ErrorChecker();
	
	public static void main(String[] args)
	{
		new GuessGame();
	}
	
	public GuessGame()
	{
		generateRandomNumber();
		//Define objects in constructor
		mainFrame = new JFrame("Guessing Game");
		
		//Set default frame background color
		mainFrame.getContentPane().setBackground(Color.WHITE);
		
		//Initialize buttons
		btnSbmtGuess = new JButton("Submit Guess");
		btnNewGame = new JButton("New Game");
		btnExitGame = new JButton("Exit Game");
		
		//Initialize labels
		lblResult = new JLabel("");
		lblInfo = new JLabel("Guess a number between 1 and 100");
		
		//set label default text colors
		lblInfo.setForeground(Color.BLACK);
		lblResult.setForeground(Color.BLACK);
		
		//Initialize Fields
		fldGuess = new JTextField(3);

		//Get a container for the frame
		Container c = mainFrame.getContentPane();
		
		//Set the layout of the container
		c.setLayout(new FlowLayout());
		
		//Add components to the container
		c.add(lblInfo);
		c.add(fldGuess);
		c.add(btnSbmtGuess);
		c.add(lblResult);
		c.add(btnNewGame);
		c.add(btnExitGame);
		
		//Set the mnemonic for each button
		btnSbmtGuess.setMnemonic('G');
		btnNewGame.setMnemonic('N');
		btnExitGame.setMnemonic('X');
		
		//Set the size of the GUI frame
		mainFrame.setSize(250, 150);
		
		//make it so that the game screen size cant be changed
		mainFrame.setResizable(false);
		
		//Make sure you terminate the program when the application is closed
		mainFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		//Add action listener to each button
		//calculateButtonHandler is a class that is defined below
		GuessButtonHandler ghandler = new GuessButtonHandler();
		btnSbmtGuess.addActionListener(ghandler);
		
		NewGameButtonHandler nhandler = new NewGameButtonHandler();
		btnNewGame.addActionListener(nhandler);
		
		ExitGameButtonHandler xhandler = new ExitGameButtonHandler();
		btnExitGame.addActionListener(xhandler);
		
		//FocusHandler is a class that is defined below
		//FocusHandler fhandler = new FocusHandler();
		//fldGuess.addFocusListener(fhandler);
		
		//Set the GUI frame visible
		mainFrame.setVisible(true);
	}//end GuessGame
	
	public void generateRandomNumber()
	{
		//create and get random number 1-100 for user to guess.
		Random randNum = new Random();
		numAnswer = randNum.nextInt(100)+1;
	}
	
	public void compareGuessToAnswer()
	{
		if(numAnswer == numGuess)
		{
			lblInfo.setForeground(Color.BLACK);
			lblResult.setForeground(Color.BLACK);
			mainFrame.getContentPane().setBackground(Color.WHITE);
			lblResult.setText("Your Guess: " + numGuess + " Is Correct!");
			fldGuess.setEditable(false);
		}
		else if(numAnswer < numGuess)
		{
			lblInfo.setForeground(Color.WHITE);
			lblResult.setForeground(Color.WHITE);
			lblResult.setText("Your Guess: " + numGuess + " Is To High");
			mainFrame.getContentPane().setBackground(Color.RED);
			fldGuess.setText("");
			fldGuess.requestFocus();
		}
		else if(numAnswer > numGuess)
		{
			lblInfo.setForeground(Color.WHITE);
			lblResult.setForeground(Color.WHITE);
			lblResult.setText("Your Guess: " + numGuess + " Is To Low");
			mainFrame.getContentPane().setBackground(Color.BLUE);
			fldGuess.setText("");
			fldGuess.requestFocus();
		}
		else
		{
			lblResult.setForeground(Color.GRAY);
			lblResult.setText("An error has occured in guess/answer comparison");
		}
	}
	
	/**
	 * This class implements the interface ActionListener
	 * It is a class that will handle the action on the 
	 * Score button. The required method actionPerformed
	 * is created to read the input values of the score field
	 * and save the inputed value in the array
	 * 
	 */

	class GuessButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String guess = fldGuess.getText();
	
			errorExist = ec.IntParseChecker(guess);
			if(!errorExist)
			{
				int tempVal = Integer.parseInt(guess);
				
				errorExist = ec.RangeChecker(tempVal, 1, 100);
				if(!errorExist)
				{
					numGuess = tempVal;
					compareGuessToAnswer();
				}
				else
				{
					lblResult.setText("Your guess is not between 1 and 100");
					fldGuess.requestFocus();
				}
			}
			else
			{
				lblResult.setText("Invalid Guess");
				fldGuess.requestFocus();
			}

		}
	}
	
	class NewGameButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			generateRandomNumber();
			fldGuess.setEditable(true);
			fldGuess.setText("");
			fldGuess.requestFocus();
		}
	}
	
	class ExitGameButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
		
	/**
	 * This class implements the FocusListener interface
	 * and handles the focus of the components
	 * 
	 */
	/*class FocusHandler implements FocusListener
	{
		public void focusGained(FocusEvent e)
		{
				
		}//end FocusGained
		public void focusLost(FocusEvent e)
		{
				
		}//end FocusLost
	}//end FocusHandler */
}
