/***********************************************************************
Program Name: SwimmingPoolCalculator.java
Programmer's Name: Craig Gleckman
Program Description: Creates the main program with 8 tabs that offer 
			different functionality. 
			Tabs: 
				General: Shows the system time and offers an exit button
				
				Options: Allows the user to change the company name (aka window title) 
						for that session
				
				Customers: Allows the user to preview the current customer
						   in the customers file. Also calls the Customer class
						   upon 'add customer' being pressed.
				
				Contractors: Same as Customers except, it is for contractors. 
							 Functionality is the exact same.
				
				Pools: Allows the user to enter a pools length, width, and height.
				 		The program then calculates the volume and gives the user
				 		the result
				
				Hot Tubs: Allows the user to choose between round and hot tubs
							If the tub is round then the width is equal to the height
							If oval the width is seperate. The program then calculates
							the volume depending on tub type and gives the result
							to the user
				
				Temp Calc: Allows the user to enter a number and convert it 
							from fahrenheight to celcius and celcius to fahrenheight
				
				Length Calc: Allows the user to enter a length in millimeters,
							meters, yards, feet, or inches, and then converts that entered number
							to the appropriate value and displays in the empty fields. 
							(ex: millimeters entered, program converts millimeters to meters, 
							yards, feet, and inches)
***********************************************************************/

package Week7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

import ErrorChecker.ErrorChecker;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class SwimmingPoolCalculator extends JFrame {
	private ErrorChecker ec = new ErrorChecker();
	private ButtonHandler btnHandler = new ButtonHandler();
	private boolean errorExist;
	private JTabbedPane jtabbedPane;
	private JPanel jpGeneral;
	private JPanel jpPools;
	private JPanel jpContractors;
	private JPanel jpCustomers;
	private JPanel jpTempCalc;
	private JPanel jpLengthCalc;
	private JPanel jpOptions;
	private JPanel jpHotTubs;
	private JButton btnGeneralExit;
	private JLabel lblChangeCompanyName;
	private JTextField fldCompanyName;
	private JButton btnSetNewName;
	private JButton btnOptionExit;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField fldPoolLength;
	private JTextField fldPoolWidth;
	private JTextField fldPoolDepth;
	private JButton btnPoolCalculateVolume;
	private JButton btnPoolExit;
	private JLabel lblThePoolsVolume;
	private JTextField fldPoolVolume;
	private JLabel lblPoolError;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField fldTubLength;
	private JTextField fldTubWidth;
	private JTextField fldTubDepth;
	private JRadioButtonMenuItem rdbtnRoundTub;
	private JRadioButtonMenuItem rdbtnOvalTub;
	private JButton btnTubCalculateVolume;
	private JButton btnTubExit;
	private JLabel lblTheTubsVolume;
	private JTextField fldTubVolume;
	private JLabel lblTubError;
	private JLabel lblNewLabel_6;
	private JTextField fldTempTemp;
	private JLabel lblResult;
	private JTextField fldTempResult;
	private JLabel lblTempMeasurement;
	private JButton btnTempConvert;
	private JButton btnTempExit;
	private JLabel lblTempError;
	private JTextArea txtareaCustomerInfo;
	private JTextArea txtareaContractorInfo;
	private JButton btnCustomerExit;
	private JButton btnContractorsExit;
	private JButton btnCustomerAdd;
	private JButton btnContractorsAdd;
	private JButton btnCustomerRefresh;
	private JButton btnContractorsRefresh;
	private JTextArea txtareaCustomerError;
	private JTextArea txtareaContractorError;
	private JComboBox boxTempMeasurement;
	private JTextField txtMillimeteres;
	private JTextField txtMeters;
	private JTextField txtYards;
	private JTextField txtFeet;
	private JTextField txtInches;
	private JTextField fldMillimeters;
	private JTextField fldMeters;
	private JTextField fldYards;
	private JTextField fldFeet;
	private JTextField fldInches;
	private JButton btnLengthConvert;
	private JButton btnLengthExit;
	private JButton btnLengthClear;
	//private JComponent jcDate;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwimmingPoolCalculator frame = new SwimmingPoolCalculator();
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
	public SwimmingPoolCalculator() {
		//Sets window title
		setTitle("Enter Company Name In Options");
		//main window settings
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 337, 349);
		getContentPane().setLayout(null);
		//create main frame/tab
		jtabbedPane = new JTabbedPane(JTabbedPane.TOP);
		jtabbedPane.setBounds(0, 0, 331, 320);
		getContentPane().add(jtabbedPane);
		
		//Generate all tabs
		createGeneralTab();
		createOptionsTab();
		createCustomersTab();
		createContractorsTab();
		createPoolsTab();
		createHotTubsTab();
		createTempCalcTab();
		createLengthCalcTab();
	}
	
	//handles all button presses within the main SwimmingPoolCalculator
	class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//General tab exit button
			if(e.getSource() == btnGeneralExit)
			{
				System.exit(0);
			}
			
			//Option tab exit button
			if(e.getSource() == btnOptionExit)
			{
				System.exit(0);
			}
			
			//Option tab set new name button
			if(e.getSource() == btnSetNewName)
			{
				setTitle(fldCompanyName.getText());
				fldCompanyName.setText(fldCompanyName.getText());
			}
			
			//Customer tab add customer button
			if(e.getSource() == btnCustomerAdd)
			{
				Customer cust = new Customer();
				cust.run();
			}
			
			//Customer tab exit button
			if(e.getSource() == btnCustomerExit)
			{
				System.exit(0);
			}
			
			//Customer tab refresh button
			if(e.getSource() == btnCustomerRefresh)
			{
				Scanner sc = null;
				try 
				{
					sc = new Scanner(new File(".\\src\\Week7\\customers.txt"));
				} 
				catch (FileNotFoundException ex) 
				{
					txtareaCustomerError.setText("Customer's file does not exist. It will be created when you add a customer");
					ex.printStackTrace();
				}
				txtareaCustomerInfo.setText("");
				while (sc.hasNext()) {
		            String info = sc.nextLine();
		            txtareaCustomerInfo.setText(txtareaCustomerInfo.getText() + info + "\n");
		        }
				sc.close();
			}
			
			//Contract tab add contractror button
			if(e.getSource() == btnContractorsAdd)
			{
				Contractor contractor = new Contractor();
				contractor.run();
			}
			
			//Contractor tab exit button
			if(e.getSource() == btnContractorsExit)
			{
				System.exit(0);
			}
			
			//contractor tab refresh button
			if(e.getSource() == btnContractorsRefresh)
			{
				Scanner sc = null;
				try 
				{
					sc = new Scanner(new File(".\\src\\Week7\\contractors.txt"));
				} 
				catch (FileNotFoundException ex) 
				{
					txtareaContractorError.setText("Contractor's file does not exist. It will be created when you add a Contractor");
					ex.printStackTrace();
				}
				txtareaContractorInfo.setText("");
				while (sc.hasNext()) {
		            String info = sc.nextLine();
		            txtareaContractorInfo.setText(txtareaContractorInfo.getText() + info + "\n");
		        }
				sc.close();
			}
			
			//Pool tab calculate button
			if(e.getSource() == btnPoolCalculateVolume)
			{
				double length = 0, width = 0, depth = 0, volume = 0;
				String tempVal;
				
				lblPoolError.setText("");
				
				tempVal = fldPoolLength.getText();
				errorExist = ec.NullorEmpty(tempVal);
				if(!errorExist)
				{
					errorExist = ec.DoubleParseChecker(tempVal);
					if(!errorExist)
					{
						fldPoolLength.setBackground(Color.WHITE);
						length = Double.parseDouble(tempVal);
					}
					else
					{
						fldPoolLength.setBackground(Color.YELLOW);
						lblPoolError.setText("Length Must Be A Number");
					}
				}
				else
				{
					fldPoolLength.setBackground(Color.YELLOW);
					lblPoolError.setText("Pool Length Cannot Be Empty");
				}
				

				tempVal = fldPoolWidth.getText();
				errorExist = ec.NullorEmpty(tempVal);
				if(!errorExist)
				{
					errorExist = ec.DoubleParseChecker(tempVal);
					if(!errorExist)
					{
						fldPoolWidth.setBackground(Color.WHITE);
						width = Double.parseDouble(tempVal);
					}
					else
					{
						fldPoolWidth.setBackground(Color.YELLOW);
						lblPoolError.setText("Width Must Be A Number");
					}
				}
				else
				{
					fldPoolWidth.setBackground(Color.YELLOW);
					lblPoolError.setText("Pool Width Cannot Be Empty");
				}
				
				
				tempVal = fldPoolDepth.getText();
				errorExist = ec.NullorEmpty(tempVal);
				if(!errorExist)
				{
					errorExist = ec.DoubleParseChecker(tempVal);
					if(!errorExist)
					{
						fldPoolDepth.setBackground(Color.WHITE);
						depth = Double.parseDouble(tempVal);
					}
					else
					{
						fldPoolDepth.setBackground(Color.YELLOW);
						lblPoolError.setText("Depth Must Be A Number");
					}
				}
				else
				{
					fldPoolDepth.setBackground(Color.YELLOW);
					lblPoolError.setText("Pool Depth Cannot Be Empty");
				}
				
				if(lblPoolError.getText().isEmpty())
				{
					volume = length * width * depth;
					fldPoolVolume.setText(String.valueOf(volume));
				}
			}//end if (PoolCalculateButton)
			
			//Pool tab exit button
			if(e.getSource() == btnPoolExit)
			{
				System.exit(0);
			}
			
			//Hot Tub tab calculate button
			if(e.getSource() == btnTubCalculateVolume)
			{
				double length = 0, width = 0, depth = 0, volume = 0;
				String tempVal;
				
				if(rdbtnRoundTub.isSelected())
				{
					fldTubWidth.setText(fldTubLength.getText());
					lblTubError.setText("Tub's Width Set To Length");
				}
				else
				{
					lblTubError.setText("");
				}
				
				tempVal = fldTubLength.getText();
				errorExist = ec.NullorEmpty(tempVal);
				if(!errorExist)
				{
					errorExist = ec.DoubleParseChecker(tempVal);
					if(!errorExist)
					{
						fldTubLength.setBackground(Color.WHITE);
						length = Double.parseDouble(tempVal);
					}
					else
					{
						fldTubLength.setBackground(Color.YELLOW);
						lblTubError.setText("Length Must Be A Number");
					}
				}
				else
				{
					fldTubLength.setBackground(Color.YELLOW);
					lblTubError.setText("Tub Length Cannot Be Empty");
				}

				tempVal = fldTubWidth.getText();
				errorExist = ec.NullorEmpty(tempVal);
				if(!errorExist)
				{
					errorExist = ec.DoubleParseChecker(tempVal);
					if(!errorExist)
					{
						fldTubWidth.setBackground(Color.WHITE);
						width = Double.parseDouble(tempVal);
					}
					else
					{
						fldTubWidth.setBackground(Color.YELLOW);
						
						if(rdbtnOvalTub.isSelected())
						{
							lblTubError.setText("Width Must Be A Number");
						}
					}
				}
				else
				{
					fldTubWidth.setBackground(Color.YELLOW);
					if(rdbtnOvalTub.isSelected())
					{
						lblTubError.setText("Tub Width Cannot Be Empty");
					}
				}
				
				
				
				tempVal = fldTubDepth.getText();
				errorExist = ec.NullorEmpty(tempVal);
				if(!errorExist)
				{
					errorExist = ec.DoubleParseChecker(tempVal);
					if(!errorExist)
					{
						fldTubDepth.setBackground(Color.WHITE);
						depth = Double.parseDouble(tempVal);
					}
					else
					{
						fldTubDepth.setBackground(Color.YELLOW);
						lblPoolError.setText("Depth Must Be A Number");
					}
				}
				else
				{
					fldTubDepth.setBackground(Color.YELLOW);
					lblTubError.setText("Please Fill Out All Fields");
				}
				
				if(lblTubError.getText().isEmpty() || lblTubError.getText().equals("Tub's Width Set To Length"))
				{
					if(rdbtnRoundTub.isSelected())
					{
						volume = Math.PI * Math.pow(length / 2.0, 2) * depth;
					}
					else
					{
						volume = (4/3 *Math.PI) * length * width * depth;
					}
        			DecimalFormat formatter = new DecimalFormat("#,###,###.##");
        			fldTubVolume.setText(""+formatter.format(volume));
				}
			}
			
			//Hot Tub tab exit button
			if(e.getSource() == btnTubExit)
			{
				System.exit(0);
			}
			
			//Hot Tub tab radio button 'round tub' button
			if(e.getSource() == rdbtnRoundTub)
			{
				fldTubWidth.setEditable(false);
				lblTubError.setText("Width Will Be Set To The Same Value As Length");
			}
			
			//Hot Tub tab radio button 'oval tub' button
			if(e.getSource() == rdbtnOvalTub)
			{
				fldTubWidth.setEditable(true);
				lblTubError.setText("");
			}
			
			//Temp Calc tab measurement type (f - fahrenheit | c - celcius) 
			if(e.getSource() == boxTempMeasurement)
			{
				if(boxTempMeasurement.getSelectedItem().equals("F"))
				{
					lblTempMeasurement.setText("C");
				}
				else
				{
					lblTempMeasurement.setText("F");
				}
			}
			
			//Temp Calc tab convert button
			if(e.getSource() == btnTempConvert)
			{
				double temperature = 0;
				String tempVal;
				
				fldTempTemp.setBackground(Color.WHITE);
				lblTempError.setText("");
				
				tempVal = fldTempTemp.getText();
				errorExist = ec.NullorEmpty(tempVal);
				if(!errorExist)
				{
					errorExist = ec.DoubleParseChecker(tempVal);
					if(!errorExist)
					{
						temperature = Double.parseDouble(tempVal);
					}
					else
					{
						fldTubDepth.setBackground(Color.YELLOW);
						lblPoolError.setText("Temperature Must Be A Number");
					}	
				}
				
				else
				{
					fldTempTemp.setText("0");
					lblTempError.setText("Value Set To Zero");
					fldTempTemp.setBackground(Color.YELLOW);
					temperature = 0.0;
				}
				
				if(lblTempError.getText().isEmpty() || lblTempError.getText().equals("Value Set To Zero"))
				{
					double result;
					if(boxTempMeasurement.getSelectedItem().equals("F"))
					{
						result = (((temperature - 32) * 5) / 9);
					}
					else
					{
						result = (((temperature * 9) / 5) + 32);
					}
					fldTempResult.setText(String.valueOf(result));
				}
					
			}
			
			//Temp Calc tab exit button
			if(e.getSource() == btnTempExit)
			{
				System.exit(0);
			}
			
			//Length Calc tab convert button
			if(e.getSource() == btnLengthConvert)
			{
				String tempVal;
				String fieldEntered;
				DecimalFormat formatter = new DecimalFormat("#,###,###.####");
				
				tempVal = fldMillimeters.getText();
				errorExist = ec.NullorEmpty(tempVal);
				if(!errorExist)
				{	
					System.out.println("Millimeters ran");
					System.out.println(tempVal);
					errorExist = ec.DoubleParseChecker(tempVal);
					if(!errorExist)
					{
						//All conversions from: http://www.metric-conversions.org/length/
						double millimeters, meters, yards, feet, inches;
						
						millimeters = Double.parseDouble(tempVal);
						
						//convert millimeters to meters
						meters = millimeters/1000.00;
						fldMeters.setText(""+formatter.format(meters));

						
						//convert millimeters to yards
						yards = millimeters * 0.0010936;
						fldYards.setText(""+formatter.format(yards));
						
						//convert millimeters to feet
						feet = millimeters *  0.0032808;
						fldFeet.setText(""+formatter.format(feet));
						
						//convert millimeters to inches
						inches = millimeters * 0.039370;
						fldInches.setText(""+formatter.format(inches));
					}
				}
				else
				{	
					tempVal = fldMeters.getText();
					errorExist = ec.NullorEmpty(tempVal);
					if(!errorExist)
					{
						System.out.println("Meters ran");
						errorExist = ec.DoubleParseChecker(tempVal);
						if(!errorExist)
						{
							//All conversions from: http://www.metric-conversions.org/length/
							double millimeters, meters, yards, feet, inches;
							
							meters = Double.parseDouble(tempVal);
							
							//convert meters to millimeters
							millimeters = meters / .001;
							fldMillimeters.setText(""+formatter.format(millimeters));
							
							//convert meters to yards
							yards = meters * 1.0936;
							fldYards.setText(""+formatter.format(yards));
							
							//convert meters to feet
							feet = meters * 3.2808;
							fldFeet.setText(""+formatter.format(feet));
							
							//convert meters to inches
							inches = meters * 39.370;
							fldInches.setText(""+formatter.format(inches));
						}
						else
						{
							
						}
					}
					else
					{	
						tempVal = fldYards.getText();
						errorExist = ec.NullorEmpty(tempVal);
						if(!errorExist)
						{
							System.out.println("Yards ran");
							errorExist = ec.DoubleParseChecker(tempVal);
							if(!errorExist)
							{
								//All conversions from: http://www.metric-conversions.org/length/
								double millimeters, meters, yards, feet, inches;
								
								yards = Double.parseDouble(tempVal);
								
								//convert yards to millimeters
								millimeters = yards / 0.0010936;
								fldMillimeters.setText(""+formatter.format(millimeters));
								
								//convert yards to meters
								meters = yards / 1.0936;
								fldMeters.setText(""+formatter.format(meters));
								
								//convert yard to feet
								feet = yards * 3.00;
								fldFeet.setText(""+formatter.format(yards));
								
								//convert yards to inches
								inches = yards * 36.00;
								fldInches.setText(""+formatter.format(inches));
							}
						}
						else
						{
							tempVal = fldFeet.getText();
							errorExist = ec.NullorEmpty(tempVal);
							if(!errorExist)
							{
								System.out.println("Feet ran");
								errorExist = ec.DoubleParseChecker(tempVal);
								if(!errorExist)
								{
									//All conversions from: http://www.metric-conversions.org/length/
									double millimeters, meters, yards, feet, inches;
									
									feet = Double.parseDouble(tempVal);
									
									//convert feet to millimeters
									millimeters = feet / 0.0032808;
									fldMillimeters.setText(""+formatter.format(millimeters));
									
									//convert feet to meters
									meters = feet / 3.2808;
									fldMeters.setText(""+formatter.format(meters));
									
									//convert feet to yards
									yards = feet * 0.33333;
									fldYards.setText(""+formatter.format(yards));
									
									//convert feet to inches
									inches = feet * 12.00;
									fldInches.setText(""+formatter.format(inches));
								}
							}
							else
							{
								tempVal = fldInches.getText();
								errorExist = ec.NullorEmpty(tempVal);
								if(!errorExist)
								{
									System.out.println("Inches ran");
									errorExist = ec.DoubleParseChecker(tempVal);
									if(!errorExist)
									{
										//All conversions from: http://www.metric-conversions.org/length/
										double millimeters, meters, yards, feet, inches;
										
										inches = Double.parseDouble(tempVal);
										
										//convert inches to millimeters
										millimeters = inches / 0.039370;
										fldMillimeters.setText(""+formatter.format(millimeters));
										
										//convert inches to meters
										meters = inches / 39.370;
										fldMeters.setText(""+formatter.format(meters));
										
										//convert inches to yards
										yards = inches * 0.027778;
										fldYards.setText(""+formatter.format(yards));
										
										//convert inches to feet
										feet = inches * 0.083333;
										fldFeet.setText(""+formatter.format(feet));
									}
								}
							}
						}
					}
				}

			}
			
			//Length Calc tab exit button
			if(e.getSource() == btnLengthExit)
			{
				System.exit(0);
			}
			
			//Length Calc tab clear button
			if(e.getSource() == btnLengthClear)
			{
				fldMillimeters.setText("");
				fldMeters.setText("");
				fldYards.setText("");
				fldFeet.setText("");
				fldInches.setText("");
			}
		}//end ActionPerformed
	}//end ButtonHandler
	
	public void createGeneralTab()
	{
		//Create new Panel
		jpGeneral = new JPanel();
		jtabbedPane.addTab("General", null, jpGeneral, null);
		jpGeneral.setLayout(null);
		
		//Create new label for the date
		JLabel lblTodaysDate = new JLabel("Today's Date:");
		lblTodaysDate.setBounds(10, 11, 97, 26);
		jpGeneral.add(lblTodaysDate);
		
		//determine date and set it to label
		JFormattedTextField ftfDate = new JFormattedTextField(
				java.util.Calendar.getInstance().getTime());
		ftfDate.setBounds(104, 14, 97, 20);
		ftfDate.setEditable(false);
		jpGeneral.add(ftfDate);
		
		//Create exit button and add action listener
		btnGeneralExit = new JButton("Exit");
		btnGeneralExit.setMnemonic('X');
		btnGeneralExit.addActionListener(btnHandler);
		btnGeneralExit.setBounds(211, 13, 58, 23);
		jpGeneral.add(btnGeneralExit);
		
	}
	
	public void createOptionsTab()
	{
		jpOptions = new JPanel();
		jtabbedPane.addTab("Options", null, jpOptions, null);
		jpOptions.setLayout(null);
		
		lblChangeCompanyName = new JLabel("Change Company Name:");
		lblChangeCompanyName.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangeCompanyName.setBounds(10, 11, 306, 20);
		jpOptions.add(lblChangeCompanyName);
		
		fldCompanyName = new JTextField();
		fldCompanyName.setBounds(42, 42, 237, 20);
		jpOptions.add(fldCompanyName);
		fldCompanyName.setColumns(10);
		
		btnSetNewName = new JButton("Set New Name");
		btnSetNewName.setMnemonic('S');
		btnSetNewName.addActionListener(btnHandler);
		btnSetNewName.setBounds(68, 73, 120, 23);
		jpOptions.add(btnSetNewName);
		
		btnOptionExit = new JButton("Exit");
		btnOptionExit.setMnemonic('X');
		btnOptionExit.setBounds(194, 73, 69, 23);
		btnOptionExit.addActionListener(btnHandler);
		jpOptions.add(btnOptionExit);
	}
	
	public void createCustomersTab()
	{
		jpCustomers = new JPanel();
		jtabbedPane.addTab("Customers", null, jpCustomers, null);
		jpCustomers.setLayout(null);
		
		txtareaCustomerInfo = new JTextArea();
		txtareaCustomerInfo.setEditable(false);
		txtareaCustomerInfo.setLineWrap(true);
		txtareaCustomerInfo.setText("Select Add Customer to add customers. Select Refresh to refresh this pane.");
		txtareaCustomerInfo.setBounds(10, 23, 306, 160);
		jpCustomers.add(txtareaCustomerInfo);
	
		btnCustomerExit = new JButton("Exit");
		btnCustomerExit.setMnemonic('X');
		btnCustomerExit.addActionListener(btnHandler);
		btnCustomerExit.setBounds(10, 194, 78, 23);
		jpCustomers.add(btnCustomerExit);
		
		btnCustomerAdd = new JButton("Add Customer");
		btnCustomerAdd.setMnemonic('A');
		btnCustomerAdd.addActionListener(btnHandler);
		btnCustomerAdd.setBounds(100, 194, 118, 23);
		jpCustomers.add(btnCustomerAdd);
		
		btnCustomerRefresh = new JButton("Refresh");
		btnCustomerRefresh.setMnemonic('R');
		btnCustomerRefresh.addActionListener(btnHandler);
		btnCustomerRefresh.setBounds(227, 194, 89, 23);
		jpCustomers.add(btnCustomerRefresh);
		
		txtareaCustomerError = new JTextArea();
		txtareaCustomerError.setEditable(false);
		txtareaCustomerError.setLineWrap(true);
		txtareaCustomerError.setBounds(10, 228, 306, 37);
		jpCustomers.add(txtareaCustomerError);
		
		String filename = ".\\src\\Week7\\contractors.txt";
		File custFile = new File(filename);
		if(custFile.exists())
		{
			txtareaCustomerError.setText("The file exists and can be read from. Hit Refresh to see current information.");
		}
		else
		{
			txtareaCustomerError.setText("File " + filename + " does not exist yet! Will be created when you add a customer!");
		}
	}
	
	public void createContractorsTab()
	{
		jpContractors = new JPanel();
		jtabbedPane.addTab("Contractors", null, jpContractors, null);
		jpContractors.setLayout(null);
		
		txtareaContractorInfo = new JTextArea();
		txtareaContractorInfo.setEditable(false);
		txtareaContractorInfo.setLineWrap(true);
		txtareaContractorInfo.setText("Select Add Contractor to add contractors. Select Refresh to refresh this pane.");
		txtareaContractorInfo.setBounds(10, 23, 306, 160);
		jpContractors.add(txtareaContractorInfo);
	
		btnContractorsExit = new JButton("Exit");
		btnContractorsExit.setMnemonic('X');
		btnContractorsExit.addActionListener(btnHandler);
		btnContractorsExit.setBounds(10, 194, 72, 23);
		jpContractors.add(btnContractorsExit);
		
		btnContractorsAdd = new JButton("Add Contractor");
		btnContractorsAdd.setMnemonic('A');
		btnContractorsAdd.addActionListener(btnHandler);
		btnContractorsAdd.setBounds(92, 194, 133, 23);
		jpContractors.add(btnContractorsAdd);
		
		btnContractorsRefresh = new JButton("Refresh");
		btnContractorsRefresh.setMnemonic('R');
		btnContractorsRefresh.addActionListener(btnHandler);
		btnContractorsRefresh.setBounds(227, 194, 89, 23);
		jpContractors.add(btnContractorsRefresh);
		
		txtareaContractorError = new JTextArea();
		txtareaContractorError.setEditable(false);
		txtareaContractorError.setLineWrap(true);
		txtareaContractorError.setBounds(10, 228, 306, 37);
		jpContractors.add(txtareaContractorError);
		
		String filename = ".\\src\\Week7\\contractors.txt";
		File conFile = new File(filename);
		if(conFile.exists())
		{
			txtareaContractorError.setText("The file exists and can be read from. Hit Refresh to see current information.");
		}
		else
		{
			txtareaContractorError.setText("File " + filename + " does not exist yet! Will be created when you add a contractor!");
		}
	}
	
	public void createPoolsTab()
	{
		jpPools = new JPanel();
		jtabbedPane.addTab("Pools", null, jpPools, null);
		jpPools.setLayout(null);
		
		lblNewLabel = new JLabel("Enter The Pool's Length(ft):");
		lblNewLabel.setBounds(10, 27, 169, 14);
		jpPools.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Enter The Pool's Width(ft):");
		lblNewLabel_1.setBounds(10, 52, 148, 14);
		jpPools.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Enter The Pool's Depth(ft):");
		lblNewLabel_2.setBounds(10, 77, 148, 14);
		jpPools.add(lblNewLabel_2);
		
		fldPoolLength = new JTextField();
		fldPoolLength.setBounds(168, 24, 126, 20);
		jpPools.add(fldPoolLength);
		fldPoolLength.setColumns(10);
		
		fldPoolWidth = new JTextField();
		fldPoolWidth.setBounds(168, 49, 126, 20);
		jpPools.add(fldPoolWidth);
		fldPoolWidth.setColumns(10);
		
		fldPoolDepth = new JTextField();
		fldPoolDepth.setBounds(168, 74, 126, 20);
		jpPools.add(fldPoolDepth);
		fldPoolDepth.setColumns(10);
		
		btnPoolCalculateVolume = new JButton("Calculate Volume");
		btnPoolCalculateVolume.setMnemonic('C');
		btnPoolCalculateVolume.addActionListener(btnHandler);
		btnPoolCalculateVolume.setBounds(37, 102, 142, 23);
		jpPools.add(btnPoolCalculateVolume);
		
		btnPoolExit = new JButton("Exit");
		btnPoolExit.setMnemonic('X');
		btnPoolExit.addActionListener(btnHandler);
		btnPoolExit.setBounds(189, 102, 63, 23);
		jpPools.add(btnPoolExit);
		
		lblThePoolsVolume = new JLabel("The Pool's Volume Is (ft^3):");
		lblThePoolsVolume.setBounds(10, 136, 156, 14);
		jpPools.add(lblThePoolsVolume);
		
		fldPoolVolume = new JTextField();
		fldPoolVolume.setEditable(false);
		fldPoolVolume.setBounds(168, 133, 126, 20);
		jpPools.add(fldPoolVolume);
		fldPoolVolume.setColumns(10);
		
		lblPoolError = new JLabel("");
		lblPoolError.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoolError.setBounds(10, 161, 306, 14);
		jpPools.add(lblPoolError);
	}
	
	public void createHotTubsTab()
	{
		jpHotTubs = new JPanel();
		jtabbedPane.addTab("Hot Tubs", null, jpHotTubs, null);
		jpHotTubs.setLayout(null);
		
		rdbtnRoundTub = new JRadioButtonMenuItem("Round Tub");
		rdbtnRoundTub.setSelected(true);
		rdbtnRoundTub.addActionListener(btnHandler);
		rdbtnRoundTub.setBounds(45, 11, 125, 22);
		jpHotTubs.add(rdbtnRoundTub);
		
		rdbtnOvalTub = new JRadioButtonMenuItem("Oval Tub");
		rdbtnOvalTub.addActionListener(btnHandler);
		rdbtnOvalTub.setBounds(177, 11, 125, 22);
		jpHotTubs.add(rdbtnOvalTub);
		
		 ButtonGroup radioBtnGroup = new ButtonGroup();
	     radioBtnGroup.add(rdbtnRoundTub);
	     radioBtnGroup.add(rdbtnOvalTub);
	     
	     lblNewLabel_3 = new JLabel("Enter The Tub's Length(ft):");
	     lblNewLabel_3.setBounds(10, 44, 160, 14);
	     jpHotTubs.add(lblNewLabel_3);
	     
	     lblNewLabel_4 = new JLabel("Enter The Tub's Width(ft):");
	     lblNewLabel_4.setBounds(10, 69, 160, 14);
	     jpHotTubs.add(lblNewLabel_4);
	     
	     lblNewLabel_5 = new JLabel("Enter The Tub's Depth(ft):");
	     lblNewLabel_5.setBounds(10, 93, 160, 14);
	     jpHotTubs.add(lblNewLabel_5);
	     
	     fldTubLength = new JTextField();
	     fldTubLength.setBounds(164, 41, 138, 20);
	     jpHotTubs.add(fldTubLength);
	     fldTubLength.setColumns(10);
	     
	     fldTubWidth = new JTextField();
	     fldTubWidth.setEditable(false);
	     fldTubWidth.setBounds(164, 66, 138, 20);
	     jpHotTubs.add(fldTubWidth);
	     fldTubWidth.setColumns(10);
	     
	     fldTubDepth = new JTextField();
	     fldTubDepth.setBounds(164, 90, 138, 20);
	     jpHotTubs.add(fldTubDepth);
	     fldTubDepth.setColumns(10);
	     
	     btnTubCalculateVolume = new JButton("Calculate Volume");
	     btnTubCalculateVolume.setMnemonic('C');
	     btnTubCalculateVolume.addActionListener(btnHandler);
	     btnTubCalculateVolume.setBounds(32, 118, 154, 23);
	     jpHotTubs.add(btnTubCalculateVolume);
	     
	     btnTubExit = new JButton("Exit");
	     btnTubExit.setMnemonic('X');
	     btnTubExit.addActionListener(btnHandler);
	     btnTubExit.setBounds(195, 118, 89, 23);
	     jpHotTubs.add(btnTubExit);
	     
	     lblTheTubsVolume = new JLabel("The Tub's Volume is (ft^3):");
	     lblTheTubsVolume.setBounds(10, 152, 160, 14);
	     jpHotTubs.add(lblTheTubsVolume);
	     
	     fldTubVolume = new JTextField();
	     fldTubVolume.setEditable(false);
	     fldTubVolume.setBounds(164, 149, 138, 20);
	     jpHotTubs.add(fldTubVolume);
	     fldTubVolume.setColumns(10);
	     
	     lblTubError = new JLabel("Width Will Be Set To The Same Value As Length");
	     lblTubError.setHorizontalAlignment(SwingConstants.CENTER);
	     lblTubError.setBounds(10, 177, 292, 14);
	     jpHotTubs.add(lblTubError);
	}
	
	public void createTempCalcTab()
	{
		jpTempCalc = new JPanel();
		jtabbedPane.addTab("Temp Calc", null, jpTempCalc, null);
		jpTempCalc.setLayout(null);
		
		lblNewLabel_6 = new JLabel("Enter Temperature:");
		lblNewLabel_6.setBounds(10, 25, 121, 14);
		jpTempCalc.add(lblNewLabel_6);
		
		fldTempTemp = new JTextField();
		fldTempTemp.setBounds(137, 22, 123, 20);
		jpTempCalc.add(fldTempTemp);
		fldTempTemp.setColumns(10);
		
		//Create array of available options for combo box
		String[] temps = {"F", "C"};
		boxTempMeasurement = new JComboBox(temps);
		boxTempMeasurement.setModel(new DefaultComboBoxModel(new String[] {"C", "F"}));
		boxTempMeasurement.setSelectedIndex(0);
		boxTempMeasurement.addActionListener(btnHandler);
		boxTempMeasurement.setBounds(270, 22, 46, 20);
		jpTempCalc.add(boxTempMeasurement);
		
		lblResult = new JLabel("Result:");
		lblResult.setBounds(10, 63, 46, 14);
		jpTempCalc.add(lblResult);
		
		fldTempResult = new JTextField();
		fldTempResult.setBounds(66, 60, 209, 20);
		jpTempCalc.add(fldTempResult);
		fldTempResult.setColumns(10);
		
		lblTempMeasurement = new JLabel("F");
		lblTempMeasurement.setBounds(280, 63, 20, 14);
		jpTempCalc.add(lblTempMeasurement);
		
		btnTempConvert = new JButton("Convert");
		btnTempConvert.setMnemonic('C');
		btnTempConvert.addActionListener(btnHandler);
		btnTempConvert.setBounds(76, 91, 89, 23);
		jpTempCalc.add(btnTempConvert);
		
		btnTempExit = new JButton("Exit");
		btnTempExit.setMnemonic('X');
		btnTempExit.addActionListener(btnHandler);
		btnTempExit.setBounds(175, 91, 89, 23);
		jpTempCalc.add(btnTempExit);
		
		lblTempError = new JLabel("");
		lblTempError.setHorizontalAlignment(SwingConstants.CENTER);
		lblTempError.setBounds(10, 125, 306, 14);
		jpTempCalc.add(lblTempError);
	}
	
	public void createLengthCalcTab()
	{
		jpLengthCalc = new JPanel();
		jtabbedPane.addTab("Length Calc", null, jpLengthCalc, null);
		jpLengthCalc.setLayout(null);
		
		txtMillimeteres = new JTextField();
		txtMillimeteres.setHorizontalAlignment(SwingConstants.CENTER);
		txtMillimeteres.setEditable(false);
		txtMillimeteres.setText("Millimeters");
		txtMillimeteres.setBounds(10, 11, 66, 20);
		jpLengthCalc.add(txtMillimeteres);
		txtMillimeteres.setColumns(10);
		
		txtMeters = new JTextField();
		txtMeters.setHorizontalAlignment(SwingConstants.CENTER);
		txtMeters.setEditable(false);
		txtMeters.setText("Meters");
		txtMeters.setBounds(86, 11, 49, 20);
		jpLengthCalc.add(txtMeters);
		txtMeters.setColumns(10);
		
		txtYards = new JTextField();
		txtYards.setHorizontalAlignment(SwingConstants.CENTER);
		txtYards.setEditable(false);
		txtYards.setText("Yards");
		txtYards.setBounds(145, 11, 53, 20);
		jpLengthCalc.add(txtYards);
		txtYards.setColumns(10);
		
		txtFeet = new JTextField();
		txtFeet.setHorizontalAlignment(SwingConstants.CENTER);
		txtFeet.setEditable(false);
		txtFeet.setText("Feet");
		txtFeet.setBounds(208, 11, 49, 20);
		jpLengthCalc.add(txtFeet);
		txtFeet.setColumns(10);
		
		txtInches = new JTextField();
		txtInches.setHorizontalAlignment(SwingConstants.CENTER);
		txtInches.setEditable(false);
		txtInches.setText("Inches");
		txtInches.setBounds(267, 11, 49, 20);
		jpLengthCalc.add(txtInches);
		txtInches.setColumns(10);
		
		fldMillimeters = new JTextField();
		fldMillimeters.setHorizontalAlignment(SwingConstants.CENTER);
		fldMillimeters.setColumns(10);
		fldMillimeters.setBounds(10, 42, 66, 20);
		jpLengthCalc.add(fldMillimeters);
		
		fldMeters = new JTextField();
		fldMeters.setHorizontalAlignment(SwingConstants.CENTER);
		fldMeters.setColumns(10);
		fldMeters.setBounds(86, 42, 49, 20);
		jpLengthCalc.add(fldMeters);
		
		fldYards = new JTextField();
		fldYards.setHorizontalAlignment(SwingConstants.CENTER);
		fldYards.setColumns(10);
		fldYards.setBounds(145, 42, 53, 20);
		jpLengthCalc.add(fldYards);
		
		fldFeet = new JTextField();
		fldFeet.setHorizontalAlignment(SwingConstants.CENTER);
		fldFeet.setColumns(10);
		fldFeet.setBounds(208, 42, 49, 20);
		jpLengthCalc.add(fldFeet);
		
		fldInches = new JTextField();
		fldInches.setHorizontalAlignment(SwingConstants.CENTER);
		fldInches.setColumns(10);
		fldInches.setBounds(265, 42, 51, 20);
		jpLengthCalc.add(fldInches);
		
		btnLengthConvert = new JButton("Convert");
		btnLengthConvert.setMnemonic('C');
		btnLengthConvert.setBounds(20, 73, 104, 23);
		btnLengthConvert.addActionListener(btnHandler);
		jpLengthCalc.add(btnLengthConvert);
		
		btnLengthExit = new JButton("Exit");
		btnLengthExit.setMnemonic('X');
		btnLengthExit.setBounds(134, 73, 66, 23);
		btnLengthExit.addActionListener(btnHandler);
		jpLengthCalc.add(btnLengthExit);
		
		btnLengthClear = new JButton("Clear");
		btnLengthClear.setMnemonic('L');
		btnLengthClear.setBounds(208, 73, 96, 23);
		btnLengthClear.addActionListener(btnHandler);
		jpLengthCalc.add(btnLengthClear);
	}
}

