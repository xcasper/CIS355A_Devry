/***********************************************************************
Program Name: Largest.java
Programmer's Name: Craig Gleckman
Program Description: Asks the user to input 10 seperate numbers between 0 and 100.
				Then determines the largest number from them and outputs it.
***********************************************************************/
package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import errorChecker.ErrorChecker;

public class Largest 
{
	//Created run method in order to get overall menu to successfully work. Had issues getting it to run with only a main method.
	public static void run()
	{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//Create the reader for user input
		ErrorChecker ec = new ErrorChecker();//Create new error checking object for int input and range checking
		
		//Declare local variables
		String userInput = null;
		int[] num = new int[10];
		int largestNum = 999;
		boolean errorExist = true;
		
		//Introduction
		System.out.println("Welcome to the largest number calculator");
			
		//get 10 numbers, validate, and then save them to array per instructions
		for(int i=0; i < 10; i++)
		{
			do
			{
				//ask for user input
				System.out.println("Please Enter 5 digit Number " + (i+1) + ": ");
			
				try 
				{
					//gets user input from console
					userInput = br.readLine();
				}
				catch (IOException e) 
				{
					e.printStackTrace();
				}
				
				//check for integer error
				errorExist = ec.IntParseChecker(userInput);

				if(!errorExist)
				{
					int tempNum;//for storing number if int but not range checked
					
					tempNum = Integer.parseInt(userInput);//assigns the input as an integer
					errorExist = ec.RangeChecker(tempNum, 0, 100);//checks to make sure number is between 0 and 100
					
					if(!errorExist)
					{
						num[i] = tempNum;//assigns validated input to the array of numbers
					}//end if
				}//end if				
			}while(errorExist);//end do-while
		}//end for
		
		//Check all numbers against each other to find largest number
		for (int i = 0; i < num.length; i++) 
		{
			//if first pass, just assign the first value of the array to largestNum
			if(i==0 || largestNum == 999)
			{
				largestNum = num[i];
			}//end if
			else
			{
				if(largestNum < num[i])
				{
					largestNum = num[i];
				}//end if
			}//end else
		}//end for
		
		//output largest number
		System.out.println("The largest number entered was: " + largestNum);
	}//end run
}//end  largest
