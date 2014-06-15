/***********************************************************************
Program Name: Menu.java
Programmer's Name: Craig Gleckman
Program Description: Grade class for CIS355A week2. Asks the user for a studnets name, 5 grades, and 
				then determines the average and letter grade associated with that average
***********************************************************************/
package Week2;

import javax.swing.*;

import ErrorChecker.ErrorChecker;

public class Grade
{
	//get student name from user
	public String getStudentName()
	{
		String stuName;
		stuName = JOptionPane.showInputDialog("Please Enter Student's Full Name: ");
		return stuName;
	}//end getStudentName
	
	//get 5 student grades from user
	public int getStudentGrades()
	{
		//declare local variables
		//Any declared values are for place holders or error recognition
		int grade = -1337, counter;
		String gradeInput;
		int accGrades = 0;
		//Create new ErrorChecker object for int and range checking
		ErrorChecker ec = new ErrorChecker();
		boolean errorExist = true; //true = error exists | false = no error
		
		//# of grades always 5 per instructions
		for(counter = 0; counter < 5; counter++)
		{
			do
			{
				//get Input
				gradeInput = JOptionPane.showInputDialog("Please enter grade #" + (counter+1) + ": ");
				errorExist = ec.IntParseChecker(gradeInput);//Check to see if input is Int Parseable
				
				if(!errorExist)
				{
					grade = Integer.parseInt(gradeInput);//convert input to int
					errorExist = ec.RangeChecker(grade, 0, 100);//check to see if input is between 0 and 100
					
					if(!errorExist)
					{
						accGrades += grade;
					}//end if
				}//end if
			}while(errorExist); //end do-while
		}//end for		
		return accGrades;
	}//end getStudentGrades
	
	//# of grades always 5 per instructions
	public double determineStudentGradeAverage(int accGrades)
	{
		//divide accumulated grades by 5(# of grades) to get average
		double avgGrade = accGrades / 5.0;
		return avgGrade;
	}//end getStudentGradeAverage
	
	public char determineLetterGrade(double avgGrade)
	{
		//Default set to N for problem recognition
		char letGrade = 'N';
		
		//Assign letter grade depending on value of avgGrade
		if(avgGrade >= 0 && avgGrade < 70)
		{
			letGrade = 'F';
		}
		else if(avgGrade >= 70 && avgGrade < 80)
		{
			letGrade = 'C';		
		}
		else if(avgGrade >= 80 && avgGrade < 90)
		{
			letGrade = 'B';
		}
		else if(avgGrade >= 90 && avgGrade <= 100)
		{
			letGrade = 'A';
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Epic Fail: Grade Not Between 0 - 100! Grade: " + avgGrade, "Error", JOptionPane.ERROR_MESSAGE);
		}
		return letGrade;
	}	
	
	public void displayOutput(String name, double avgGrade, char letGrade)
	{
		//Display gathered information in the desired format
		JOptionPane.showMessageDialog(null, "Name: " + name + 
				"\nAverage: " + avgGrade +
				"\nLetter Grade: " + letGrade,
				"Results", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void run()
	{
		//Declare local variables and initialize them with returned values
		String stuName = getStudentName();
		int accumulatedGrades = getStudentGrades();
		double averageGrade = determineStudentGradeAverage(accumulatedGrades);
		char letterGrade = determineLetterGrade(averageGrade);
		
		displayOutput(stuName, averageGrade, letterGrade);//outputs in desired format
		
		System.exit(0); //terminate application
	}//end run
}// End of class Grade