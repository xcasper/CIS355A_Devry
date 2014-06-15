/***********************************************************************
Program Name: Lawyer.java
Programmer's Name: Craig Gleckman
Program Description: Lawyer for CIS355A week3. Prompts the user with a main menu.
				1: Asks the user for client information such as name, phone number, address, etc.
				Also asks the user for the amount of time spent with the lawyer, the hourly rate, 
				and what the client did wrong.
				2: Displays the gathered client information
				3: Not available
				4: Not available
				5: Exit program
***********************************************************************/
package Week3;

import javax.swing.JOptionPane;
import ErrorChecker.ErrorChecker;

public class LawyerGatherInfo 
{
	//Declares and initializes the custom error checker class
	ErrorChecker ec = new ErrorChecker();
	
	//declare global variables
	boolean errorExist = true;
	String clientName, clientAddr, userInput, clientDidWrong;
	int clientID, clientHours, clientMinutes;
	double clientPhNum, clientHourlyRate, clientTotalCost;	
	
	//gets and assigns the required information to the global variables
	public void getClientInformation()
	{
		this.clientName = getClientName();
		this.clientAddr = getClientAddress();
		this.clientPhNum = getClientPhoneNumber();
		this.clientID = getClientID();
		this.clientHours = getClientHoursSpent();
		this.clientMinutes = getClientMinutesSpent();
		this.clientHourlyRate = getHourlyBillingRate();
		this.clientDidWrong = getDidWrong();
		this.clientTotalCost = clientTotalCost();		
		
		verifyClientInformation();//check info and choose save or not
	}//end getClientInformation
	
	//allow user to double check information and decide to save it to the DB or not
	public void verifyClientInformation()
	{
		//used to determine save (0 = yes, 1 = no, -999 = error)
		int answer = -999;
		
		answer = determineSaveClientInformation();
		
		if(answer == 0)
		{
			this.errorExist = saveClientInformation();
			if(!this.errorExist)
			{
				JOptionPane.showMessageDialog(null, "The Client Information Has Been Saved", "Saved!", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Error: Save Failed! - See System Administrator", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(answer == 1)
		{
			JOptionPane.showMessageDialog(null, "The Client Information Has NOT Been Saved", "Not Saved!", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(answer == -999)
		{
			JOptionPane.showMessageDialog(null, "Error: No Option Selected - Information NOT saved", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else
		{		
			JOptionPane.showMessageDialog(null, "Critical Error Occured In Save Selection - Information NOT saved", "Critical Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}//end verifyClientInformation
	
	public boolean saveClientInformation()
	{
		dbInsertData dbInsert = new dbInsertData();
		this.errorExist = dbInsert.writeToDB(this.clientID, this.clientName, this.clientAddr, this.clientPhNum, this.clientHours, this.clientMinutes, this.clientHourlyRate, this.clientDidWrong, this.clientTotalCost);
		if(!this.errorExist)
		{
			return false;
		}
		return true;		
	}//end saveClientInformation
	
	//Prompts user for a client name and then returns the client's name
	public String getClientName()
	{
		//Declare local variables
		String name = null;
		
		do
		{			
			this.userInput = JOptionPane.showInputDialog("Enter Client's Name");//get user input
			
			//If userInput == null then the cancel button has been pressed
			if(this.userInput == null)
			{
				System.exit(0);
			}//end if
			
			this.errorExist = this.ec.NullorEmpty(this.userInput);//check to see if there was actually input in the input box
			if(!this.errorExist)
			{
				name = this.userInput;//No error, safe to assign
			}//end if
		}while(this.errorExist);//end do-while
		
		return name; 
	}//end getClientName
	
	//Prompts user for a client address and then returns the client's address
	public String getClientAddress()
	{
		//Declare local variables
		String addr = null;
		
		do
		{
			this.userInput = JOptionPane.showInputDialog("Enter Client's Address");//get user input
			
			//If userInput == null then the cancel button has been pressed
			if(this.userInput == null)
			{
				System.exit(0);
			}//end if
			
			this.errorExist = this.ec.NullorEmpty(this.userInput);//check to see if there was actually input in the input box	
			if(!this.errorExist)
			{
				addr = this.userInput;//No error, safe to assign
			}//end if
		}while(this.errorExist);//end do-while
		
		return addr;
	}//end getClientAddress
	
	//Prompts user for a client phone number and then returns the client's phone number
	public double getClientPhoneNumber()
	{
		//Declare local variables
		double number = 0;
		
		do
		{
			this.userInput = JOptionPane.showInputDialog("Enter Client's Phone Number (no '-' or spaces please)");//get user input
			
			//If userInput == null then the cancel button has been pressed
			if(this.userInput == null)
			{
				System.exit(0);
			}//end if
		
			this.errorExist = this.ec.NullorEmpty(userInput);//check to see if there was actually input in the input box		
			if(!this.errorExist)
			{
				this.errorExist = this.ec.DoubleParseChecker(this.userInput);//Check to see if input can be safely converted to an double
				if(!this.errorExist)
				{
					number = Double.parseDouble(this.userInput);//No error, safe to assign
				}//end if
			}//end if
		}while(this.errorExist);//end do-while
		
		return number;
	}//end getClientPhoneNumber
	
	//Prompts user for a clientID # and then returns the client's ID #
	public int getClientID()
	{
		//Declare local variables
		int id = 0;
		
		do
		{
			this.userInput = JOptionPane.showInputDialog("Enter Client's ID (Numbers only please)");//get user input
			
			//If userInput == null then the cancel button has been pressed
			if(this.userInput == null)
			{
				System.exit(0);
			}//end if
			
			this.errorExist = this.ec.NullorEmpty(this.userInput);//check to see if there was actually input in the input box
			if(!this.errorExist)
			{
				this.errorExist = this.ec.IntParseChecker(this.userInput);//Check to see if input can be safely converted to an int
				if(!this.errorExist)
				{
					id = Integer.parseInt(this.userInput);//No error, safe to assign
				}//end if
			}//end if
		}while(this.errorExist);//end do-while
		
		return id;
	}//end getClientID
	
	//Prompts user for a amount of time the lawyer spent with the client and then returns the client's hours spent
	public int getClientHoursSpent()
	{
		//Declare local variables
		int hours = -1;
		
		do
		{
			this.userInput = JOptionPane.showInputDialog("Enter Number of Hours Spent with Lawyer");//get user input
			
			//If userInput == null then the cancel button has been pressed
			if(this.userInput == null)
			{
				System.exit(0);
			}//end if
						
			this.errorExist = this.ec.NullorEmpty(this.userInput);//check to see if there was actually input in the input box
			if(!this.errorExist)
			{
				this.errorExist = this.ec.IntParseChecker(this.userInput);//Check to see if input can be safely converted to an int
				if(!this.errorExist)
				{
					//Declare localized variable
					int tempHours;
					
					//use local variable incase next check fails
					tempHours = Integer.parseInt(this.userInput);//convert string to int
					
					this.errorExist = this.ec.HighLowRangeChecker(tempHours, 0, true, false);//Check to make sure that hours entered is not less than zero
					if(!this.errorExist)
					{
						hours = tempHours;//No errors, safe to assign
					}//end if
				}//end if
			}//end if
		}while(this.errorExist);//end do-while
		
		return hours;
	}//end getClientHoursSpent4
	
	//Prompts user for an amount of minutes the lawyer may have spent with the client (between a 0 and 59) 
	//and then returns the minute spent amount.
	public int getClientMinutesSpent()
	{
		//Declare local variables
		int minutes = -1;
		
		do
		{
			this.userInput = JOptionPane.showInputDialog("Enter Number of Minutes Spent with Lawyer");//get user input
			
			//If userInput == null then the cancel button has been pressed
			if(this.userInput == null)
			{
				System.exit(0);
			}//end if
			
			this.errorExist = this.ec.NullorEmpty(this.userInput);//check to see if there was actually input in the input box
			if(!this.errorExist)
			{
				this.errorExist = this.ec.IntParseChecker(this.userInput);//Check to see if input can be safely converted to an int
				if(!this.errorExist)
				{
					//Declare localized variable
					int tempMins;
					
					//use local variable incase next check fails
					tempMins = Integer.parseInt(this.userInput);//convert string to int
					
					this.errorExist = this.ec.RangeChecker(tempMins, 0, 59);//Check to make sure that minutes entered is between 0 and 59
					if(!this.errorExist)
					{
						minutes = tempMins;//No errors, safe to assign
					}//end if
				}//end if
			}//end if
		}while(this.errorExist);//end do-while
		
		return minutes;
	}//end getClientMinutesSpent
	
	//Prompts user for the hourly billing rate the client will be charged and then returns the billing rate
	public double getHourlyBillingRate()
	{
		//Declare local variables
		double hBillRate = 0;
		
		do
		{			
			this.userInput = JOptionPane.showInputDialog("Enter Hourly Billing Rate");//get user input
			
			//If userInput == null then the cancel button has been pressed
			if(this.userInput == null)
			{
				System.exit(0);
			}//end if
			
			this.errorExist = this.ec.NullorEmpty(this.userInput);//check to see if there was actually input in the input box
			if(!this.errorExist)
			{
				this.errorExist = this.ec.DoubleParseChecker(this.userInput);//Check to see if input can be converted to an double
				if(!this.errorExist)
				{
					//Declare localized variable
					double tempNum;
					
					//Use local variable incase next check fails
					tempNum = Double.parseDouble(userInput);//convert string to double
					
					this.errorExist = this.ec.HighLowRangeChecker(tempNum, 1.0, true, false);//check to make sure that inputed value is not less then 1
					if(!this.errorExist)
					{
						hBillRate = tempNum;//No error, safe to assign
					}//end if
				}//end if
			}//end if
		}while(this.errorExist);//end do-while
		
		return hBillRate;
	}//end getHourlyBillingRate
	
	//Gives the user a drop down menu of offenses and lets the user pick 1. Then returns the wrong doing selected
	public String getDidWrong()
	{
		//Declare local variables
		String wrong = null;
		String[] possibleWrongs = {"Select an Answer", "Divorce", "Robbery", "Murder", "Injured At Work", "Other"};
		
		do
		{
			this.userInput = (String)JOptionPane.showInputDialog(null, "What Did You Do Wrong?", "We wanted to know", JOptionPane.QUESTION_MESSAGE, null, possibleWrongs, possibleWrongs[0]);//get user selection
			
			//If userInput == null then the cancel button has been pressed
			if(this.userInput == null)
			{
				System.exit(0);
			}//end if
			
			//Check to make sure that the initial "Select an Answer" is not still selected
			if(this.userInput == possibleWrongs[0])
			{
				this.errorExist = true;
				JOptionPane.showMessageDialog(null, "Error: You Did Not Select a Wrong Doing", "Error", JOptionPane.ERROR_MESSAGE);//output error message
			}//end if
			else
			{
				this.errorExist = false;
				wrong = this.userInput;//No error, safe to assign
			}//end if
		}while(this.errorExist);//end do-while
		
		return wrong;
	}//end getDidWrong
	
	//Determines the total amount the client will be charged and then returns it
	public double clientTotalCost()
	{
		//Declare local variable
		double totalCost;
		
		totalCost = this.clientHourlyRate * (this.clientHours + (this.clientMinutes / 60.00));//formula to determine total cost
		System.out.println(totalCost);
		System.out.println(this.clientHourlyRate);
		
		return totalCost;
	}//end ClientTotalCost
	
	//Outputs all of the clients information
	public int determineSaveClientInformation()
	{
		//
		int yesno;
		//Information output in desired format
		yesno = JOptionPane.showConfirmDialog(null, "Would You Like To Save The Following Information To The Database?" + 
				"\n\nClient Name: " + this.clientName + 
				"\nClient Address: " + this.clientAddr +
				"\nClient ID: " + this.clientID +
				"\nHours Spent: " + this.clientHours +
				"\nMinutes Spent: " + this.clientMinutes +
				"\nBilling Rate: $" + this.clientHourlyRate +
				"\nTotal Cost: $" + this.clientTotalCost +
				"\nWhat You Did Wrong? " + this.clientDidWrong,
				"Save?", JOptionPane.YES_NO_OPTION);
		
		return yesno;
	}//end DisplayClientInformation
	
	//Prompts the user with the main menu and runs based off their selection
	/*public void run()
	{
		//Declare local variables
		int userChoice = 0;
		
		//runs until the user chooses 5 which means quit (or until cancel button pressed)
		while(userChoice != 5)
		{
			do
			{
				//Get user input to determine what to run
				this.userInput = JOptionPane.showInputDialog("Press 1 to enter Client information \n"
						+ "Press 2 to see Client information \n"
						+ "Press 3 to search for Client by ID \n"
						+ "Press 4 to Update Address \n"
						+ "Press 5 to Exit");
				
				//If userInput == null then the cancel button has been pressed
				if(this.userInput == null)
				{
					System.exit(0);
				}//end if
				
				this.errorExist = this.ec.IntParseChecker(this.userInput);//Check to see if input can be converted to an int
				
				if(!this.errorExist)
				{
					//Declare localized variable
					int tempNum;
					
					tempNum = Integer.parseInt(this.userInput);//convert string to int
					
					this.errorExist = this.ec.RangeChecker(tempNum, 1, 5);//Check to make sure that input is between 1 and 5
					
					if(!this.errorExist)
					{
						userChoice = tempNum;
					}//end if
					
				}//end if	
			}while(this.errorExist);//end do-while
			
			switch(userChoice)
			{
				case 1:
					//gathers all required client information from user
					getClientInformation();
					break;
				case 2:
					//Outputs the clients information in desired format
					DisplayClientInformation();
					break;
				case 3:
					//No instruction to do option 3
					JOptionPane.showMessageDialog(null, "Option 3 is currently disabled.");
					break;
				case 4:
					//No instruction to do option  4
					JOptionPane.showMessageDialog(null, "Option 4 is currently disabled.");
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
	}//end run */
}//end Lawyer