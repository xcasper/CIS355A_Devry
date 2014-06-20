/***********************************************************************
Program Name: GradeProgram.java
Programmer's Name: Craig Gleckman
Program Description: Creates a GUI program where the user enteres a student's
				name, ID, and scores. After each score you hit the score button
				which adds it to the overall score. The program, upon hitting
				calculate then outputs the student's name, ID, average score,
				and letter grade.
***********************************************************************/

package Week4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ErrorChecker.ErrorChecker;

public class GradeProgram extends JFrame {

	//Declare global private variables
	private JPanel contentPane;
	private JTextField fldStuName;
	private JTextField fldStuID;
	private JTextField fldScores;
	private boolean errorExist;
	private double scores;
	private double amtScoresEntered;
	private String studentName;
	private int studentID;
	private ErrorChecker ec = new ErrorChecker();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GradeProgram frame = new GradeProgram();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GradeProgram() 
	{
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStuName = new JLabel("Enter Student Name:");
		lblStuName.setBounds(10, 35, 129, 14);
		contentPane.add(lblStuName);
		
		fldStuName = new JTextField();
		fldStuName.setBounds(149, 32, 139, 20);
		contentPane.add(fldStuName);
		fldStuName.setColumns(10);
		
		JLabel lblStuID = new JLabel("Enter Student ID:");
		lblStuID.setBounds(10, 73, 109, 14);
		contentPane.add(lblStuID);
		
		fldStuID = new JTextField();
		fldStuID.setBounds(149, 70, 139, 20);
		contentPane.add(fldStuID);
		fldStuID.setColumns(10);
		
		JLabel lblScores = new JLabel("Enter Scores:");
		lblScores.setBounds(10, 111, 106, 14);
		contentPane.add(lblScores);
		
		fldScores = new JTextField();
		fldScores.setBounds(149, 108, 139, 20);
		contentPane.add(fldScores);
		fldScores.setColumns(10);
		
		JButton btnScore = new JButton("Score");
		btnScore.setBounds(129, 139, 89, 23);
		btnScore.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String scoreString;
				scoreString = fldScores.getText();				
				
				if(!scoreString.equals(""))
				{
					errorExist = ec.DoubleParseChecker(scoreString);
					if(!errorExist)
					{
						double tempNum = Double.parseDouble(scoreString);
						
						errorExist = ec.RangeChecker(tempNum, 0, 100);
						if(!errorExist)
						{
							scores += tempNum;
							amtScoresEntered++;
							fldScores.setText("");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Score Must Be Between 0 and 100");
							fldScores.setText("");
							fldScores.requestFocus();
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Score Must Be A Number!", "Error", JOptionPane.ERROR_MESSAGE);
						fldScores.setText("");
						fldScores.requestFocus();
					}
				}
				
				else
				{
					fldScores.setText("");
					fldScores.requestFocus();
					//also try fldScores.setText("");
				}
			}
		});
		contentPane.add(btnScore);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(30, 203, 89, 23);
		btnCalculate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				double averageScore;
				char ltrGrade;
				
				setStudentName();
				setStudentID();
				//Error Exist is global and therefore will be true if problem occurred somewhere.
				if(!errorExist)
				{
					averageScore = scores/amtScoresEntered;
					ltrGrade = determineLetterGrade(averageScore);
					if(ltrGrade != 'Z')
					{
						JOptionPane.showMessageDialog(null,
								"Student Name: " + studentName +
								"\nStudent ID: " + studentID +
								"\nAverage Score: " + averageScore +
								"\nLetter Grade: " + ltrGrade,
								"Results",
								JOptionPane.INFORMATION_MESSAGE);	
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Something Went Wrong With Letter Grade, Please Try Again", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});
		contentPane.add(btnCalculate);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(129, 203, 89, 23);
		btnClear.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				fldStuName.setText("");
				fldStuID.setText("");
				fldScores.setText("");
				scores = 0;
				amtScoresEntered = 0;
				
				//set cursor at student name since its the first field
				fldStuName.requestFocus();
			}
		});
		contentPane.add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(237, 203, 89, 23);
		btnExit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		contentPane.add(btnExit);
	}
	
	public void setStudentName()
	{
		String tempName;
		
		tempName = fldStuName.getText();
		errorExist = ec.NullorEmpty(tempName);
		if(!errorExist)
		{
			studentName = tempName;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Student Name Cannot Be Empty", "Error", JOptionPane.ERROR_MESSAGE);
			fldStuName.requestFocus();
		}
	}
	
	public void setStudentID()
	{
		String tempString;
		int tempID;
		
		tempString = fldStuID.getText();
		errorExist = ec.IntParseChecker(tempString);
		if(!errorExist)
		{
			tempID = Integer.parseInt(tempString);
			if(studentID >= 0)
			{
				studentID = tempID;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Student ID Cannot Be Negative", "Error", JOptionPane.ERROR_MESSAGE);
				fldStuID.requestFocus();
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Student ID Must Be Numeric", "Error", JOptionPane.ERROR_MESSAGE);
			fldStuID.requestFocus();
		}
	}
	
	public char determineLetterGrade(double avgScore)
	{
		if(avgScore < 80)
		{
			return 'F';
		}
		else if(avgScore >= 80 && avgScore <= 89)
		{
			return 'B';
		}
		else if(avgScore >= 90 && avgScore <= 100)
		{
			return 'A';
		}
		else
		{
			return 'Z';
		}
	}
}
