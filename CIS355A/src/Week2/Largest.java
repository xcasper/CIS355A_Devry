package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Largest 
{
	public static void main(String[] args)
	{
		run();
	}
	//Created run method in order to get overall menu to successfully work. Had issues getting it to run with only a main method.
	public static void run()
	{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		int[] num = new int[10];
		int largestNum = 999;
		System.out.println("Welcome to the largest number calculator");
			
		for(int i=0; i < 10; i++)
		{
			System.out.println("Please Enter number " + (i+1) + ": ");
			try
			{
				try 
				{
					input = br.readLine();
				} 
				
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				num[i] = Integer.parseInt(input);
			}
			catch(NumberFormatException nfe)
			{
				System.err.println("Invalid Format!");
			}
		}//end for
		
		for (int i = 0; i < num.length; i++) 
		{
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
		
		System.out.println("The largest number entered was: " + largestNum);
	}//end run
}//end  largest
