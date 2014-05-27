/***********************************************************************
Program Name: ErrorChecker.java
Programmer's Name: Craig Gleckman
Program Description: Error Checking package that will be updated throughout the class
				and separated in order to be reusable and not bog down the programs.
***********************************************************************/
package errorChecker;

import javax.swing.JOptionPane;

public class ErrorChecker 
{
	//Validates that the string can be converted to an integer successfully
	public boolean IntParseChecker(String value)
	{
		//Declare local variables
		boolean errorFlag = false;
		
		try
		{
			int tempNum = 0;
			//attempt to convert the string to an int
			tempNum = Integer.parseInt(value);
		}
		catch(NumberFormatException ne)
		{
			errorFlag = true;
			JOptionPane.showMessageDialog(null, "Error: parse error", "Error", JOptionPane.PLAIN_MESSAGE);
		}	
		//returns if the string was able to be converted to int. True = yes. False = no.
		return errorFlag;
	}//end IntParseChecker
	
	//Check range of a number is between the low and high
	public boolean RangeChecker(int temp, int low, int high)
	{
		//Declare local variables
		boolean errorFlag = false;
		
		//Check to see if the number is between low and high
		if(temp < low || temp > high)
		{
			errorFlag = true;
			JOptionPane.showMessageDialog(null, "Error: Value Not In Range", "Error", JOptionPane.PLAIN_MESSAGE);
		}
		
		//returns if the string was able to be converted to int. True = yes. False = no.
		return errorFlag;
	}//end RangeChecker
}//end ErrorChecker
