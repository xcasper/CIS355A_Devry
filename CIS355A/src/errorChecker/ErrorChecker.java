/***********************************************************************
Program Name: ErrorChecker.java
Programmer's Name: Craig Gleckman
Program Description: Error Checking package that will be updated throughout the class
				and separated in order to be reusable and not bog down the programs.
***********************************************************************/
package ErrorChecker;

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
			JOptionPane.showMessageDialog(null, "Error: Int parse error", "Error", JOptionPane.ERROR_MESSAGE);
		}	
		//returns if the string was able to be converted to int. True = yes. False = no.
		return errorFlag;
	}//end IntParseChecker
	
	public boolean DoubleParseChecker(String value)
	{
		//Declare local variables
		boolean errorFlag = false;
		
		try
		{
			double tempNum = 0;
			//attempt to convert the string to an int
			tempNum = Double.parseDouble(value);
		}
		catch(NumberFormatException ne)
		{
			errorFlag = true;
			JOptionPane.showMessageDialog(null, "Error: Double parse error", "Error", JOptionPane.ERROR_MESSAGE);
		}	
		
		//returns if the string was able to be converted to int. True = yes. False = no.
		return errorFlag;
	}//end DoubleParseChecker
	
	//Check range of a number is between the low and high
	public boolean RangeChecker(int comparisonNum, int low, int high)
	{
		//Declare local variables
		boolean errorFlag = false;
		
		//Check to see if the number is between low and high
		if(comparisonNum < low || comparisonNum > high)
		{
			errorFlag = true;
			System.out.println("RangeChecker ran. errorFlag = " + errorFlag);
			JOptionPane.showMessageDialog(null, "Error: Value Not In Range", "Error", JOptionPane.ERROR_MESSAGE);
		}//end if
		
		//returns if the string was able to be converted to int. True = yes. False = no.
		return errorFlag;
	}//end RangeChecker
	
	public boolean RangeChecker(double comparisonNum, double low, double high)
	{
		//Declare local variables
		boolean errorFlag = false;
		
		//Check to see if the number is between low and high
		if(comparisonNum < low || comparisonNum > high)
		{
			errorFlag = true;
			JOptionPane.showMessageDialog(null, "Error: Value Not In Range", "Error", JOptionPane.ERROR_MESSAGE);
		}//end if
		
		//returns if the number was between the low and high. True = yes. False = no.
		return errorFlag;
	}//end RangeChecker
	
	public boolean HighLowRangeChecker(int temp, int num, boolean checkMin, boolean checkMax)
	{
		//Declare local variables
		boolean errorFlag = false;
		
		if(checkMin == true && checkMax == true)
		{
			errorFlag = true;
			JOptionPane.showMessageDialog(null, "Error: You cannot check Min and Max in HighLowRangeChecker\n"
					+ "Please use RangeChecker(int, int, int)", "Error", JOptionPane.ERROR_MESSAGE);
		}//end if
		else if(checkMin == true)
		{
			//Check to see if the number is below the low
			if(temp < num)
			{
				errorFlag = true;
				JOptionPane.showMessageDialog(null, "Error: Value Not In Range", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}//end else if
		
		else if(checkMax == true)
		{
			//Check to see if the number is above the high
			if(temp > num)
			{
				errorFlag = true;
				JOptionPane.showMessageDialog(null, "Error: Value Not In Range", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}//end else if
		else
		{
			errorFlag = true;
			JOptionPane.showMessageDialog(null, "Error: Unforseen ERROR in RangeChecker", "Error", JOptionPane.ERROR_MESSAGE);
		}//end else
		
		//returns if the number was below the low or above the high. True = yes. False = no.
		return errorFlag;
	}//end HighLowRangeChecker
	
	public boolean HighLowRangeChecker(double temp, double num, boolean checkMin, boolean checkMax)
	{
		//Declare local variables
		boolean errorFlag = false;
		
		if(checkMin == true && checkMax == true)
		{
			errorFlag = true;
			JOptionPane.showMessageDialog(null, "Error: You cannot check Min and Max in HighLowRangeChecker\n"
					+ "Please use RangeChecker(int, int, int)", "Error", JOptionPane.ERROR_MESSAGE);
		}//end if
		else if(checkMin == true)
		{
			//Check to see if the number is below the low
			if(temp < num)
			{
				errorFlag = true;
				JOptionPane.showMessageDialog(null, "Error: Value Not In Range", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}//end else if
		else if(checkMax == true)
		{
			//Check to see if the number is above the high
			if(temp > num)
			{
				errorFlag = true;
				JOptionPane.showMessageDialog(null, "Error: Value Not In Range", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}//end else if
		else
		{
			errorFlag = true;
			JOptionPane.showMessageDialog(null, "Error: Unforseen ERROR in RangeChecker", "Error", JOptionPane.ERROR_MESSAGE);
		}//end else
		
		//returns if the number was below the low or above the high. True = yes. False = no.
		return errorFlag;
	}//end HighLowRangeChecker
	
	
	//Checks for whitespace only (such as if someone put only spaces.
	//checks if the field is null(such as if the user doesnt enter anything)
	public boolean NullorEmpty(String value)
	{
		//Declare local variables
		boolean errorFlag = false;
		
		if(value == null || value.trim().length() == 0)
		{
			errorFlag = true;
			JOptionPane.showMessageDialog(null, "Error: Input is NULL or Empty", "Error", JOptionPane.ERROR_MESSAGE);
		}//end if
		
		//Returns whether or not the string was empty, or had white spaces, or not. True = yes. False = no.
		return errorFlag;
	}//end NullorWhiteSpaceChecker
}//end ErrorChecker
