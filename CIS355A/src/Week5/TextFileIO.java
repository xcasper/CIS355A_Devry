package Week5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextFileIO {
	private PrintWriter writer;
	
	public TextFileIO() throws FileNotFoundException
	{
		try 
		{
			writer = new PrintWriter(new FileWriter("C:\\Users\\Craig\\Documents\\GitHub\\CIS355A_Devry\\CIS355A\\src\\Week5\\numbers.dat"));
		}
		catch(IOException ex)
		{
			
		}
		
		for(int i = 2; i <= 100; i+=2)
		{
			if(i != 100)
			{
				writer.write(i + ", ");
			}
			else
			{
				writer.write(i + "\n");
			}
		}
		writer.close();
		
		Scanner sc = new Scanner(new File("C:\\Users\\Craig\\Documents\\GitHub\\CIS355A_Devry\\CIS355A\\src\\Week5\\numbers.dat"));
		
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
