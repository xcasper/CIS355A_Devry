package Week7;

import java.awt.BorderLayout;
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

public class Customer extends JFrame {

	private JPanel contentPane;
	private JTextField fldCustName;
	private JTextField fldCustAddr;
	private JTextField fldCustCity;
	private JTextField fldCustZip;
	private JTextField fldCustPhone;
	private JLabel lblNewLabel, lblNewLabel_5, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4;
	private JComboBox comboStates;
	private JButton btnAddCustomer, btnClose, btnDeleteFile;
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
			Customer frame = new Customer();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Customer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Customer Name:");
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
		
		fldCustName = new JTextField();
		fldCustName.setBounds(113, 8, 311, 20);
		contentPane.add(fldCustName);
		fldCustName.setColumns(10);
		
		fldCustAddr = new JTextField();
		fldCustAddr.setBounds(71, 37, 353, 20);
		contentPane.add(fldCustAddr);
		fldCustAddr.setColumns(10);
		
		fldCustCity = new JTextField();
		fldCustCity.setBounds(48, 74, 376, 20);
		contentPane.add(fldCustCity);
		fldCustCity.setColumns(10);
		
		fldCustZip = new JTextField();
		fldCustZip.setBounds(95, 113, 86, 20);
		contentPane.add(fldCustZip);
		fldCustZip.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Phone:");
		lblNewLabel_4.setBounds(191, 116, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		fldCustPhone = new JTextField();
		fldCustPhone.setBounds(247, 113, 147, 20);
		contentPane.add(fldCustPhone);
		fldCustPhone.setColumns(10);
		
		btnAddCustomer = new JButton("Add Customer");
		btnAddCustomer.setMnemonic('C');
		btnAddCustomer.addActionListener(btnHandler);
		btnAddCustomer.setBounds(58, 150, 132, 23);
		contentPane.add(btnAddCustomer);
		
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
	
	class ButtonHandler implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
        	if(e.getSource() == btnAddCustomer)
        	{        		
        		txtareaCustError.setText("");
        		String filename = "customer.txt";
        		String custInfo = null;
        		File customerFile = new File(filename);
        		
        		String custName = null, custAddr = null, custCity = null, custState = null, custZip = null, custPhone = null, tempVal;
        		
        		tempVal = fldCustName.getText();
        		errorExist = ec.NullorEmpty(tempVal);
        		if(!errorExist)
        		{
        			custName = tempVal;
        		}
        		else
        		{
        			txtareaCustError.setText("Name Cannot Be Empty");
        		}
        		
        		tempVal = fldCustAddr.getText();
        		errorExist = ec.NullorEmpty(tempVal);
        		if(!errorExist)
        		{
        			custAddr = tempVal;
        		}
        		else
        		{
        			txtareaCustError.setText("Address Cannot Be Empty");
        		}
        		
        		tempVal = fldCustCity.getText();
        		errorExist = ec.NullorEmpty(tempVal);
        		if(!errorExist)
        		{
        			custCity = tempVal;
        		}
        		else
        		{
        			txtareaCustError.setText("City Cannot Be Empty");
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
        		
        		tempVal = fldCustZip.getText();
        		errorExist = ec.NullorEmpty(tempVal);
        		if(!errorExist)
        		{
        			custZip = tempVal;
        		}
        		else
        		{
        			txtareaCustError.setText("Zip Cannot Be Empty");
        		}
        		
        		tempVal = fldCustPhone.getText();
        		errorExist = ec.NullorEmpty(tempVal);
        		if(!errorExist)
        		{
        			custPhone = tempVal;
        		}
        		else
        		{
        			txtareaCustError.setText("Phone Cannot Be Empty");
        		}
        		
        		if(txtareaCustError.getText().isEmpty())
        		{
	        		if(!customerFile.exists())
	        		{
	        			try 
	        			{
	        				writer = new PrintWriter(new FileWriter(".\\src\\Week7\\customers.txt"));
	        				writer.println("Name: " + custName);
	        				writer.println("Address: " + custAddr);
	        				writer.println("City: " + custCity);
	        				writer.println("State: " + custState);
	        				writer.println("Zip: " + custZip);
	        				writer.println("Phone: " + custPhone);
	        				txtareaCustError.setText("Customer Added");
	        			}
	        			catch(IOException ex)
	        			{
	        				txtareaCustError.setText("Adding Customer Failed. Please Try again.");
	        			}
	        		}
	        		else
	        		{
	        			try 
	        			{
	        				System.out.println("exists ran");
	        				writer = new PrintWriter(new FileWriter(".\\src\\Week7\\customers.txt", true));
	        				writer.println("Name: " + custName);
	        				writer.println("Address: " + custAddr);
	        				writer.println("City: " + custCity);
	        				writer.println("State: " + custState);
	        				writer.println("Zip: " + custZip);
	        				writer.println("Phone: " + custPhone);
	        				txtareaCustError.setText("Customer Appened To File");
	        			}
	        			catch(IOException ex)
	        			{
	        				txtareaCustError.setText("Writer write failed3");
	        			}
	        		}
        		}
        		writer.close();
        	}
        	
        	if(e.getSource() == btnClose)
        	{
        		fldCustName.setText("");
        		fldCustAddr.setText("");
        		fldCustCity.setText("");
        		comboStates.setSelectedIndex(0);
        		fldCustZip.setText("");
        		fldCustPhone.setText("");
        		dispose();
        	}
        	
        	if(e.getSource() == btnDeleteFile)
        	{
        		File file = new File(".\\src\\Week7\\customers.txt");
        		
        		boolean wasDeleted = file.delete();
        		
        		if(wasDeleted)
        		{
        			txtareaCustError.setText("Customer File Was Deleted Successfully");
        		}
        		else
        		{
        			txtareaCustError.setText("Error Deleting Customer File. File may not exist, or there may be permission issues.");
        		}

        		
        	}
        }
    
    }
}
