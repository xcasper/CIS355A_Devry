/***********************************************************************
Program Name: DayGUI.java
Programmer's Name: Craig Gleckman
Program Description: Creates a program that adds all even numbers between 2-100
				to a file, closes the file, and outputs the contents.
				The program then appends the odd numbers to that file, closes
				it, and displays the file contents again.
***********************************************************************/
package Week5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextFileIO {
	private PrintWriter writer;
	
	public TextFileIO() throws FileNotFoundException
	{
		fileWriteEvenNumbers();
		fileDisplayText();
		fileWriteOddNumbers();
		fileDisplayText();
	}
	
	public void fileWriteEvenNumbers()
	{
		try 
		{
			writer = new PrintWriter(new FileWriter(".\\src\\Week5\\numbers.dat"));
		}
		catch(IOException ex)
		{
			
		}
		
		for(int i = 2; i <= 100; i+=2)
		{
			writer.write(i + ", ");
		}
		writer.close();
	}

	public void fileWriteOddNumbers()
	{
		try 
		{
			writer = new PrintWriter(new FileWriter(".\\src\\Week5\\numbers.dat", true));
		}
		catch(IOException ex)
		{
			
		}
		
		for(int i = 1; i <= 99; i+=2)
		{
			if(i != 99)
			{
				writer.write(i + ", ");
			}
			else
			{
				writer.write(i + "");
			}
		}
		writer.close();
	}
	
	public void fileDisplayText()
	{
		Scanner sc = null;
		try 
		{
			sc = new Scanner(new File(".\\src\\Week5\\numbers.dat"));
		} 
		catch (FileNotFoundException e) 
		{
			// TODO: add catch error display
			e.printStackTrace();
		}
		while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(s);
        }
		sc.close();
	}
	public static void main(String[] args)
	{
		try 
		{
			new TextFileIO();
		} 
		catch (FileNotFoundException e) 
		{
			// TODO: Add catch error
			e.printStackTrace();
		}
	}
}