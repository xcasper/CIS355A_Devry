package Week7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import ErrorChecker.ErrorChecker;


public class Contractor extends JFrame {

	private JPanel contentPane;
	private JTextField fldConName;
	private JTextField fldConAddr;
	private JTextField fldConCity;
	private JTextField fldConZip;
	private JTextField fldConPhone;
	private JLabel lblNewLabel, lblNewLabel_5, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4;
	private JComboBox comboStates;
	private JButton btnAddContractor, btnClose, btnDeleteFile;
	private JTextArea txtareaCustError;
	private PrintWriter writer;
	private ButtonHandler btnHandler = new ButtonHandler();
	private ErrorChecker ec = new ErrorChecker();
	private boolean errorExist;

	/**
	 * Create the frame.
	 */
	public void run() {
		try {
			Contractor frame = new Contractor();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Contractor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Contractor Name:");
		lblNewLabel.setBounds(10, 11, 115, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_5 = new JLabel("Address:");
		lblNewLabel_5.setBounds(10, 40, 84, 14);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_2 = new JLabel("City:");
		lblNewLabel_2.setBounds(10, 77, 84, 14);
		contentPane.add(lblNewLabel_2);
		
		String[] states = { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE",
	            "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME",
	            "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
	            "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD",
	            "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" };
		comboStates = new JComboBox(states);
		comboStates.setBounds(10, 113, 46, 20);
		contentPane.add(comboStates);
		
		lblNewLabel_3 = new JLabel("Zip:");
		lblNewLabel_3.setBounds(66, 116, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		fldConName = new JTextField();
		fldConName.setBounds(113, 8, 311, 20);
		contentPane.add(fldConName);
		fldConName.setColumns(10);
		
		fldConAddr = new JTextField();
		fldConAddr.setBounds(71, 37, 353, 20);
		contentPane.add(fldConAddr);
		fldConAddr.setColumns(10);
		
		fldConCity = new JTextField();
		fldConCity.setBounds(48, 74, 376, 20);
		contentPane.add(fldConCity);
		fldConCity.setColumns(10);
		
		fldConZip = new JTextField();
		fldConZip.setBounds(95, 113, 86, 20);
		contentPane.add(fldConZip);
		fldConZip.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Phone:");
		lblNewLabel_4.setBounds(191, 116, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		fldConPhone = new JTextField();
		fldConPhone.setBounds(247, 113, 147, 20);
		contentPane.add(fldConPhone);
		fldConPhone.setColumns(10);
		
		btnAddContractor = new JButton("Add Contractor");
		btnAddContractor.setMnemonic('C');
		btnAddContractor.addActionListener(btnHandler);
		btnAddContractor.setBounds(58, 150, 132, 23);
		contentPane.add(btnAddContractor);
		
		btnClose = new JButton("Close");
		btnClose.setMnemonic('C');
		btnClose.addActionListener(btnHandler);
		btnClose.setBounds(194, 150, 89, 23);
		contentPane.add(btnClose);
		
		btnDeleteFile = new JButton("Delete File");
		btnDeleteFile.setMnemonic('D');
		btnDeleteFile.addActionListener(btnHandler);
		btnDeleteFile.setBounds(288, 150, 106, 23);
		contentPane.add(btnDeleteFile);
		
		txtareaCustError = new JTextArea();
		txtareaCustError.setLineWrap(true);
		txtareaCustError.setBounds(48, 187, 346, 28);
		contentPane.add(txtareaCustError);
		
		
	}
	
	//Handles all button presses for the Contractor class
	class ButtonHandler implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
        	//Handles add contractor button pressed
        	if(e.getSource() == btnAddContractor)
        	{        		
        		txtareaCustError.setText("");
        		String filename = "contractor.txt";
        		String custInfo = null;
        		File contractorFile = new File(filename);
        		
        		String custName = null, custAddr = null, custCity = null, custState = null, custZip = null, custPhone = null, tempVal;
        		
        		tempVal = fldConName.getText();
        		errorExist = ec.NullorEmpty(tempVal);
        		if(!errorExist)
        		{
        			custName = tempVal;
        		}
        		else
        		{
        			txtareaCustError.setText("Name Cannot Be Empty");
        			fldConName.setBackground(Color.YELLOW);
        		}
        		
        		tempVal = fldConAddr.getText();
        		errorExist = ec.NullorEmpty(tempVal);
        		if(!errorExist)
        		{
        			custAddr = tempVal;
        		}
        		else
        		{
        			txtareaCustError.setText("Address Cannot Be Empty");
        			fldConAddr.setBackground(Color.YELLOW);
        		}
        		
        		tempVal = fldConCity.getText();
        		errorExist = ec.NullorEmpty(tempVal);
        		if(!errorExist)
        		{
        			custCity = tempVal;
        		}
        		else
        		{
        			txtareaCustError.setText("City Cannot Be Empty");
        			fldConCity.setBackground(Color.YELLOW);
        		}
        		
        		tempVal = (String)comboStates.getSelectedItem();
        		errorExist = ec.NullorEmpty(tempVal);
        		if(!errorExist)
        		{
        			custState = tempVal;
        		}
        		else
        		{
        			txtareaCustError.setText("State Cannot Be Empty");
        			
        		}
        		
        		tempVal = fldConZip.getText();
        		errorExist = ec.NullorEmpty(tempVal);
        		if(!errorExist)
        		{
        			custZip = tempVal;
        		}
        		else
        		{
        			txtareaCustError.setText("Zip Cannot Be Empty");
        			fldConZip.setBackground(Color.YELLOW);
        		}
        		
        		tempVal = fldConPhone.getText();
        		errorExist = ec.NullorEmpty(tempVal);
        		if(!errorExist)
        		{
        			custPhone = tempVal;
        		}
        		else
        		{
        			txtareaCustError.setText("Phone Cannot Be Empty");
        			fldConPhone.setBackground(Color.YELLOW);
        		}
        		
        		if(txtareaCustError.getText().isEmpty())
        		{
	        		if(!contractorFile.exists())
	        		{
	        			try 
	        			{
	        				writer = new PrintWriter(new FileWriter(".\\src\\Week7\\contractors.txt"));
	        				writer.println("Name: " + custName);
	        				writer.println("Address: " + custAddr);
	        				writer.println("City: " + custCity);
	        				writer.println("State: " + custState);
	        				writer.println("Zip: " + custZip);
	        				writer.println("Phone: " + custPhone);
	        				txtareaCustError.setText("contractor Added");
	        			}
	        			catch(IOException ex)
	        			{
	        				txtareaCustError.setText("Adding Contractor Failed. Please Try again.");
	        			}
	        			writer.close();
	        		}
	        		else
	        		{
	        			try 
	        			{
	        				System.out.println("exists ran");
	        				writer = new PrintWriter(new FileWriter(".\\src\\Week7\\contractors.txt", true));
	        				writer.println("Name: " + custName);
	        				writer.println("Address: " + custAddr);
	        				writer.println("City: " + custCity);
	        				writer.println("State: " + custState);
	        				writer.println("Zip: " + custZip);
	        				writer.println("Phone: " + custPhone);
	        				txtareaCustError.setText("contractor Appened To File");
	        			}
	        			catch(IOException ex)
	        			{
	        				txtareaCustError.setText("Writer write failed3");
	        			}
	        			writer.close();
	        		}
        		}
        	}
        	
        	//Handles close button pressed
        	if(e.getSource() == btnClose)
        	{
        		fldConName.setText("");
        		fldConAddr.setText("");
        		fldConCity.setText("");
        		comboStates.setSelectedIndex(0);
        		fldConZip.setText("");
        		fldConPhone.setText("");
        		dispose();
        	}
        	
        	//Handles delete file button pressed
        	if(e.getSource() == btnDeleteFile)
        	{
        		File file = new File(".\\src\\Week7\\contractors.txt");
        		
        		boolean wasDeleted = file.delete();
        		
        		if(wasDeleted)
        		{
        			txtareaCustError.setText("contractor File Was Deleted Successfully");
        		}
        		else
        		{
        			txtareaCustError.setText("Error Deleting contractor File. File may not exist, or there may be permission issues.");
        		}

        		
        	}
        }
    
    }
}
