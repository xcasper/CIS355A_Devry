package Week3;

import javax.swing.JOptionPane;

import errorChecker.ErrorChecker;

public class Lawyer 
{
	ErrorChecker ec = new ErrorChecker();
	boolean errorExist = true;
	String clientName, clientAddr, userInput, clientDidWrong;
	double clientPhNum;
	int clientID, clientHours, clientMinutes;
	double clientHourlyRate, clientTotalCost;	
	
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
		this.clientTotalCost = ClientTotalCost();
	}
	
	public String getClientName()
	{
		String name = null;
		
		do
		{			
			this.userInput = JOptionPane.showInputDialog("Enter Client's Name");
			
			if(this.userInput == null)
			{
				System.exit(0);
			}
			
			this.errorExist = this.ec.NullorEmpty(this.userInput);		
			if(!this.errorExist)
			{
				name = this.userInput;
			}
		}while(errorExist);
		return name; 
	}
	
	public String getClientAddress()
	{
		String addr = null;
		
		do
		{
			this.userInput = JOptionPane.showInputDialog("Enter Client's Address");
			
			if(this.userInput == null)
			{
				System.exit(0);
			}
			
			this.errorExist = this.ec.NullorEmpty(this.userInput);		
			if(!this.errorExist)
			{
				addr = this.userInput;
			}
		}while(errorExist);
		return addr;
	}
	
	public double getClientPhoneNumber()
	{
		double number = 0;
		
		do
		{
		this.userInput = JOptionPane.showInputDialog("Enter Client's Phone Number (no '-' or spaces please)");
		
		if(this.userInput == null)
		{
			System.exit(0);
		}
		
		this.errorExist = this.ec.NullorEmpty(userInput);		
		if(!this.errorExist)
		{
			this.errorExist = this.ec.DoubleParseChecker(this.userInput);
			if(!this.errorExist)
			{
				number = Double.parseDouble(this.userInput);
			}
		}
		}while(errorExist);
		return number;
	}
	
	public int getClientID()
	{
		int id = 0;
		
		do
		{
			this.userInput = JOptionPane.showInputDialog("Enter Client's ID (Numbers only please)");
			
			if(this.userInput == null)
			{
				System.exit(0);
			}
			
			this.errorExist = this.ec.NullorEmpty(this.userInput);
			if(!this.errorExist)
			{
				this.errorExist = this.ec.IntParseChecker(this.userInput);
				if(!this.errorExist)
				{
					id = Integer.parseInt(this.userInput);
				}
			}
		}while(errorExist);
		return id;
	}
	
	public int getClientHoursSpent()
	{
		int hours = -1;
		
		do
		{
			this.userInput = JOptionPane.showInputDialog("Enter Number of Hours Spent with Lawyer");
			
			if(this.userInput == null)
			{
				System.exit(0);
			}
						
			this.errorExist = this.ec.NullorEmpty(this.userInput);
			if(!this.errorExist)
			{
				this.errorExist = this.ec.IntParseChecker(this.userInput);
				if(!this.errorExist)
				{
					int tempHours;
					
					tempHours = Integer.parseInt(this.userInput);
					
					this.errorExist = this.ec.HighLowRangeChecker(tempHours, 0, true, false);
					if(!this.errorExist)
					{
						hours = tempHours;
					}
				}
			}
		}while(errorExist);
		return hours;
	}
	
	public int getClientMinutesSpent()
	{
		int minutes = -1;
		
		do
		{
			this.userInput = JOptionPane.showInputDialog("Enter Number of Minutes Spent with Lawyer");
			
			if(this.userInput == null)
			{
				System.exit(0);
			}
			
			this.errorExist = this.ec.NullorEmpty(this.userInput);
			if(!this.errorExist)
			{
				this.errorExist = this.ec.IntParseChecker(this.userInput);
				if(!this.errorExist)
				{
					int tempMins;
					
					tempMins = Integer.parseInt(this.userInput);
					
					this.errorExist = this.ec.HighLowRangeChecker(tempMins, 59, false, true);
					if(!this.errorExist)
					{
						minutes = tempMins;
					}
				}
			}
		}while(errorExist);
		return minutes;
	}
	
	public double getHourlyBillingRate()
	{
		double hBillRate = 0;
		
		do
		{			
			this.userInput = JOptionPane.showInputDialog("Enter Hourly Billing Rate");
	
			if(this.userInput == null)
			{
				System.exit(0);
			}
			
			this.errorExist = this.ec.NullorEmpty(this.userInput);
			if(!this.errorExist)
			{
				this.errorExist = this.ec.DoubleParseChecker(this.userInput);
				if(!this.errorExist)
				{
					double tempNum;
					tempNum = Double.parseDouble(userInput);
					
					this.errorExist = this.ec.HighLowRangeChecker(tempNum, 1.0, true, false);
					if(!this.errorExist)
					{
						hBillRate = tempNum;
					}
				}
			}
		}while(this.errorExist);
		return hBillRate;
	}
	
	public String getDidWrong()
	{
		String wrong = null;
		String[] possibleWrongs = {"Select an Answer", "Divorce", "Robbery", "Murder", "Injured At Work", "Other"};
		
		do
		{
			this.userInput = (String)JOptionPane.showInputDialog(null, "What Did You Do Wrong?", "We wanted to know", JOptionPane.QUESTION_MESSAGE, null, possibleWrongs, possibleWrongs[0]);
			
			if(this.userInput == null)
			{
				System.exit(0);
			}
			
			if(this.userInput == possibleWrongs[0])
			{
				this.errorExist = true;
				JOptionPane.showMessageDialog(null, "Error: You Did Not Select a Wrong Doing", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				this.errorExist = false;
				wrong = this.userInput;
			}
		}while(this.errorExist);
		
		return wrong;
	}
	
	public double ClientTotalCost()
	{
		double totalCost;
		totalCost = this.clientHourlyRate * (this.clientHours + (this.clientMinutes / 60));
		return totalCost;
	}
	
	public void DisplayClientInformation()
	{
		//Display gathered information in the desired format
		JOptionPane.showMessageDialog(null, "Client Name: " + this.clientName + 
				"\nClient Address: " + this.clientAddr +
				"\nClient ID: " + this.clientID +
				"\nBilling Rate: $" + this.clientHourlyRate +
				"\nTotal Cost: $" + this.clientTotalCost +
				"\nWhat You Did Wrong? " + this.clientDidWrong,
				"Results", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void run()
	{
		int userChoice = 0;
		
		while(userChoice != 5)
		{
			do
			{
				this.userInput = JOptionPane.showInputDialog("Press 1 to enter Client information \n"
						+ "Press 2 to see Client information \n"
						+ "Press 3 to search for Client by ID \n"
						+ "Press 4 to Update Address \n"
						+ "Press 5 to Exit");
				
				if(this.userInput == null)
				{
					System.exit(0);
				}
				
				this.errorExist = this.ec.IntParseChecker(this.userInput);
				
				if(!this.errorExist)
				{
					int tempNum;
					tempNum = Integer.parseInt(this.userInput);
					this.errorExist = this.ec.RangeChecker(tempNum, 1, 5);
					
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
					JOptionPane.showMessageDialog(null, "No Valid Selection Was Entered!", "Error", JOptionPane.ERROR_MESSAGE);
					break;
			}//end switch
		}//end while
	}//end run
}//end Lawyer