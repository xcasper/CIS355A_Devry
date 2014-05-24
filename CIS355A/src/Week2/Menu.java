/***********************************************************************
1Program Name: Menu.java
Programmer's Name: Craig Gleckman
Program Description: Allows the user to click a button and opens the corresponding program
***********************************************************************/
package Week2;
  
//Import the custom classes

  
import java.io.IOException;

import javax.swing.JOptionPane;
  
public class Menu
{
    @SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException
    {
        //Create a object array to house the possible options the user will have (1 button is created per item in the array)
        Object[] options = {"Largest Number", "Palindrome", "Grade"};
          
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
        switch(choice)
        {
            case 0: 
                Largest largest = new Largest();
                largest.run();
                break;
            case 1: 
                Palindrome pal = new Palindrome();
                pal.run();
                break;
            case 2: 
            	Grade grade = new Grade();
                //grade.run();
                break;
            default:
                System.out.println("The option you selected is apparently broken!!! Good Bye!");
                break;      
        }//end switch
    }//end main
}//end MainMenu 