package Week3;

import javax.swing.JOptionPane;
import errorChecker.ErrorChecker;

public class Lawyer {
	
	public 
	public void run()
	{
		ErrorChecker ec = new ErrorChecker();
		boolean errorExist = true;
		String userInput = null;
		int userChoice = 0;
		
		while(userChoice != 5)
		{
			do
			{
				userInput = JOptionPane.showInputDialog("Press 1 to enter Client information \n"
						+ "Press 2 to see Client information \n"
						+ "Press 3 to search for Client by ID \n"
						+ "Press 4 to Update Address \n"
						+ "Press 5 to Exit");
				
				errorExist = ec.IntParseChecker(userInput);
				
				if(!errorExist)
				{
					int tempNum;
					tempNum = Integer.parseInt(userInput);
					errorExist = ec.RangeChecker(userChoice, 1, 5);
					
					if(!errorExist)
					{
						userChoice = tempNum;
					}//end if
					
				}//end if	
			}while(errorExist);//end do-while\
			
			switch(userChoice)
			{
				case 1:
					getClientInformation();
					break;
				case 2:
					
				case 3:
				case 4:
				case 5:
			}//end switch
		}//end while
	}//end run
}//end Lawyer
