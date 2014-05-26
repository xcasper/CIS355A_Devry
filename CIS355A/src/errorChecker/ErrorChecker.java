package errorChecker;

import javax.swing.JOptionPane;

public class ErrorChecker 
{

	public boolean IntParseChecker(String value)
	{
		boolean errorFlag = false;
		int tempNum = 0;
		
		try
		{
			tempNum = Integer.parseInt(value);
		}
		catch(NumberFormatException ne)
		{
			errorFlag = true;
			JOptionPane.showMessageDialog(null, "Error: parse error", "Error", JOptionPane.PLAIN_MESSAGE);
		}	
		return errorFlag;
	}
	
	public boolean RangeChecker(int temp, int low, int high)
	{
		boolean errorFlag = false;
		
		if(temp < low || temp > high)
		{
			errorFlag = true;
		}
		return errorFlag;
	}
}
