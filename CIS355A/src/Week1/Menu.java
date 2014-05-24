/***********************************************************************
Program Name: MainMenu.java
Programmer's Name: Craig Gleckman
Program Description: Allows the user to click a button and opens the corresponding program
***********************************************************************/
package Week1;

//Import the custom classes
import javax.swing.JOptionPane;

public class Menu {
	@SuppressWarnings("static-access")
	public static void main(String[] args){
		//Create a object array to house the possible options the user will have (1 button is created per item in the array)
		Object[] options = {"Escape Sequences", "Circle Calculator", "Arithmetic Operators"};
		
		//Sets the button selection equal to int so that it can be used to call next window.
		//Uses the options array to determine how many buttons are needed. (Each item in the options array gets a button)
		int choice = JOptionPane.showOptionDialog(null,
		    "Please Select Which Program You Would Like To Test:",
		    "CIS 355A WEEK 1",
		    JOptionPane.DEFAULT_OPTION,
		    JOptionPane.QUESTION_MESSAGE,
		    null,
		    options,
		    options[0]);
		
		//Runs the correct program based on button selected during menu.
		switch(choice){
			case 0: 
				ShowEscapeSequences ses = new ShowEscapeSequences();
				ses.run();
				break;
			case 1: 
				Circle circ = new Circle();
				circ.run();
				break;
			case 2: 
				PracticeArithmeticOperators pao = new PracticeArithmeticOperators();
				pao.run();
				break;
			default:
				System.out.println("The option you selected is apparently broken!!! Good Bye!");
				break;		
		}//end switch
	}//end main
}//end MainMenu