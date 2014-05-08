/***********************************************************************
Program Name: Circle.java
Programmer's Name: Craig Gleckman
Program Description: take a user inputed radius and then produce the
 			diameter, circumference, and area of the circle.
***********************************************************************/
package circ;

import javax.swing.JOptionPane;

public class Circle 
{
	public static void main(String[] args)
	{
		String input = null; // radius input from user
		int radius, diameter; //radius: users input converted to int | diameter: radius * 2
		double circumference, area; // circumference: 2 * radius * PI | area: PI * radius * radius
		
		 //Get User Input for radius
		input = JOptionPane.showInputDialog("Please enter a radius: ");
		
		//inputed radius converted to int 
		radius = Integer.parseInt(input); 
		
		//set diameter, circumference, and area based on their formulas using users input for radius
		diameter = 2 * radius;
		circumference = 2 * Math.PI * radius;
		area = Math.PI * radius * radius;
		
		//Display results
		JOptionPane.showMessageDialog(null, "Diameter " + diameter + 
				"\nCircumference: " + circumference +
				"\nArea: " + area,
				"Results", JOptionPane.PLAIN_MESSAGE);
		
		System.exit(0); //terminate application
	}//end main

}//end Circle class
