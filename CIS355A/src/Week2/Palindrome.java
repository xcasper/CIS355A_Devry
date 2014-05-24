package Week2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args)
	{
		run();
	}
	//Created run method in order to get overall menu to successfully work. Had issues getting it to run with only a main method.
	public static void run()
	{		
		Scanner scan = new Scanner(System.in);
		int input = 0;
		int[] nums = new int[5];
		boolean palidrome;
		boolean inputErr = true;
		System.out.println("Welcome to the Palidrome Detector!");
		while(inputErr)
		{
			try
			{
				System.out.println("Enter your 5 digit number to be checked: ");
				input = scan.nextInt();
				System.out.println(input);
				inputErr = false;
			}
			catch(InputMismatchException exception)
			{
				System.out.println("Input was not an integer");
				inputErr = true;
			}
		}
		//Done with -- so that the entered numbers can be put into the array backwards, and thus, keep their order
		for(int i = nums.length; i > 0; i--)
		{
			nums[i-1] = input % 10;
			input = input / 10;
		}
		
		if((nums[0] == nums[4]) && (nums[1] == nums[3]))
		{
			palidrome = true;
			System.out.println("The entered number IS a palidrome!");
		}
		else
		{
			palidrome = false;
			System.out.println("The entered number is NOT a palidrome.");
		}
		
	}
}
