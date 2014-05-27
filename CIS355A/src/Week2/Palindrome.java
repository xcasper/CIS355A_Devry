/***********************************************************************
Program Name: Palindrome.java
Programmer's Name: Craig Gleckman
Program Description: Allows the user to input a 5 digit number and then
			determines if it is a palindrome or not. 
			
	* Palindrome is when the number is the same forwards or backwards.


**Note to professor: No range check because the program is completed without having the user enter 5 numbers 1 at a time
***********************************************************************/
package Week2;

import java.util.Scanner;
import errorChecker.ErrorChecker;

public class Palindrome 
{
	//Created run method in order to get overall menu to successfully work. Had issues getting it to run with only a main method.
	public static void run()
	{	
		Scanner scan = new Scanner(System.in);//Create new scanner object for input
		ErrorChecker ec = new ErrorChecker();//Create new error checking object for int input and range checking
		
		//Declare local variables
		String userInput = null;
		int palNum = -1;
		int[] nums = new int[5];
		boolean errorExist = true;
		
		System.out.println("Welcome to the Palidrome Detector!");
		
		//Loop incase first entry is invalid
		while(errorExist)
		{
			System.out.println("Enter your 5 digit number to be checked: ");
			userInput = scan.nextLine();
		
			//check input to be an int
			errorExist = ec.IntParseChecker(userInput);
			
			if(!errorExist)
			{				
				palNum = Integer.parseInt(userInput);//assigns the input as an integer
			}//end if			
		}//end while
		
		//Runs through and breaks the number into 5 parts
		//Done with minus so that the entered numbers can be put into the array backwards, and thus, keep their order
		for(int i = nums.length; i > 0; i--)
		{
			nums[i-1] = palNum % 10;
			palNum /= 10;
		}//end for
		//Check if the number is a palindrome and output result
		if((nums[0] == nums[4]) && (nums[1] == nums[3]))
		{
			System.out.println("The entered number IS a palidrome!");
		}//end if
		
		else
		{
			System.out.println("The entered number is NOT a palidrome.");
		}//end else
		
		scan.close();//close scanner
	}//end run
}//end Palindrome
