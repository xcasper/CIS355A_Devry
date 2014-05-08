package pao;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class PracticeArithmeticOperators 
{
	public static void main(String[] args) 
	{
		String inputNum1, inputNum2; //store users two numbers
		int num1, num2; //converted input numbers from String to int
		int sum, difference, product; //sum: num1 + num2 | difference: num1 - num2 | product: num1 * num2
		double quotient; //quotient: num1 / num2
		
		//get users first number
		inputNum1 = JOptionPane.showInputDialog("Please enter your first whole number: ");
		
		//get users second number
		inputNum2 = JOptionPane.showInputDialog("Please enter your second whole number: ");
		
		//convert numbers from String to int
		num1 = Integer.parseInt(inputNum1);
		num2 = Integer.parseInt(inputNum2);
		
		//set sum, difference, product, quotient based on their formulas using the user inputed numbers
		sum = num1 + num2;
		difference = num1 - num2;
		product = num1 * num2;
		quotient = (double)num1 / num2; //cast to double so that the non multiples do not return 0 
										//(ex: without (double) 4 / 5 was returning 0)
		
		//Create JTextArea so \t formatting works
		JTextArea output = new JTextArea("Operation\tResult\n" +
				num1 + " + " + num2 + " \t " + sum + "\n" +
				num1 + " - " + num2 + " \t " + difference + "\n" +
				num1 + " * " + num2 + " \t " + product + "\n" + 
				num1 + " / " + num2 + " \t " + quotient + "\n");
		
		//output the JTextArea
		JOptionPane.showMessageDialog(null, output, "Output", JOptionPane.PLAIN_MESSAGE);
		
		System.exit(0); //terminate application
	}//end main

}//end PracticeArithmeticOperators
