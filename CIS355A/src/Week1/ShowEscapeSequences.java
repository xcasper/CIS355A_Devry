/***********************************************************************
Program Name: ShowEscapeSequences.java
Programmer's Name: Craig Gleckman
Program Description: using one print statement produce an output that
	spans multiple lines and has a tabbed third line
***********************************************************************/
package Week1;

public class ShowEscapeSequences
{
	public static void main(String[] args)
	{
		run();
	}//end main
	
	public static void run(){
		
		//output the given print message using proper escape sequences
		System.out.print("I really like\nCIS335A\n\t\"Business Application Programming with Lab using JAVA\"");

	}//end run
	
}//end ShowEscapeSequences