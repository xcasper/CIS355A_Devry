package Week3;

import javax.swing.JOptionPane;
import ErrorChecker.ErrorChecker;


public class Lawyer 
{

	public static void main(String[] args)
	{
		mainMenu();
	}
	
	public static void mainMenu()
	{
		//Declares and initializes the custom error checker class
		ErrorChecker ec = new ErrorChecker();
	
		//Declare local variables
		int userChoice = 0;
		String userInput;
		boolean errorExist = true;
			
		//runs until the user chooses 5 which means quit (or until cancel button pressed)
		while(userChoice != 5)
		{
			do
			{
				//Get user input to determine what to run
				userInput = JOptionPane.showInputDialog("Press 1 to Enter Client information \n"
						+ "Press 2 to See All Client information \n"
						+ "Press 3 to Search For a Client by Name \n"
						+ "Press 4 to Update Client Phone Number \n"
						+ "Press 5 to Exit");
				
				//If userInput == null then the cancel button has been pressed
				if(userInput == null)
				{
					System.exit(0);
				}//end if
				
				errorExist = ec.IntParseChecker(userInput);//Check to see if input can be converted to an int
				
				if(!errorExist)
				{
					//Declare localized variable
					int tempNum;
					
					tempNum = Integer.parseInt(userInput);//convert string to int
					
					errorExist = ec.RangeChecker(tempNum, 1, 5);//Check to make sure that input is between 1 and 5
					
					if(!errorExist)
					{
						userChoice = tempNum;
					}//end if
					
				}//end if	
			}while(errorExist);//end do-while
			
			switch(userChoice)
			{
				case 1:
					//gathers all required client information from user
					LawyerGatherInfo gatherInfo = new LawyerGatherInfo();
					gatherInfo.getClientInformation();
					break;
				case 2:
					//Outputs the clients information in desired format
					dbSeeAllData dbSeeAll = new dbSeeAllData();
					dbSeeAll.displayAllClientInformation();
					break;
				case 3:
					//Allows the user to search the DB by Name
					dbSearchData dbSearch = new dbSearchData();
					dbSearch.searchClientInformation();
					break;
				case 4:
					//No instruction to do option  4
					dbUpdateData dbUpdate = new dbUpdateData();
					dbUpdate.updateClientInformation();
					break;
				case 5:
					//Exists the program
					System.exit(0);
					break;
				default:
					//Throws error if it ever runs since no value lower then 1 or greater then 5 should run
					JOptionPane.showMessageDialog(null, "No Valid Selection Was Entered!", "Error", JOptionPane.ERROR_MESSAGE);
					break;
			}//end switch
		}//end while
	}//end mainMenu

}
