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
	private JButton btnCustomerExit;
	private JButton btnCustomerAdd;
	private JButton btnCustomerRefresh;
	private JTextArea txtareaCustomerError;
	private JComboBox boxTempMeasurement;
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
		setTitle("Enter Company Name In Options");
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 337, 349);
		getContentPane().setLayout(null);
		
		jtabbedPane = new JTabbedPane(JTabbedPane.TOP);
		jtabbedPane.setBounds(0, 0, 331, 320);
		getContentPane().add(jtabbedPane);
		
		createGeneralTab();
		
		createOptionsTab();
		
		createCustomersTab();
		
		
		
		jpContractors = new JPanel();
		jtabbedPane.addTab("Contractors", null, jpContractors, null);
		
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
		
		jpLengthCalc = new JPanel();
		jtabbedPane.addTab("Length Calc", null, jpLengthCalc, null);
	}
	
	class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == btnGeneralExit)
			{
				System.exit(0);
			}
			
			if(e.getSource() == btnOptionExit)
			{
				System.exit(0);
			}
			
			if(e.getSource() == btnSetNewName)
			{
				setTitle(fldCompanyName.getText());
				fldCompanyName.setText(fldCompanyName.getText());
			}
			
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
			
			if(e.getSource() == btnPoolExit)
			{
				System.exit(0);
			}
			
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
			
			if(e.getSource() == btnTubExit)
			{
				System.exit(0);
			}
			
			if(e.getSource() == rdbtnRoundTub)
			{
				fldTubWidth.setEditable(false);
				lblTubError.setText("Width Will Be Set To The Same Value As Length");
			}
			
			if(e.getSource() == rdbtnOvalTub)
			{
				fldTubWidth.setEditable(true);
				lblTubError.setText("");
			}
			
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
			
			if(e.getSource() == btnTempExit)
			{
				System.exit(0);
			}
			
			if(e.getSource() == btnCustomerAdd)
			{
				Customer cust = new Customer();
				cust.run();
			}
			
			if(e.getSource() == btnCustomerExit)
			{
				System.exit(0);
			}
			
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
		txtareaCustomerInfo.setLineWrap(true);
		txtareaCustomerInfo.setText("Select Add Customer to add customers. Select Refresh to refresh this pane.");
		txtareaCustomerInfo.setBounds(10, 23, 306, 160);
		jpCustomers.add(txtareaCustomerInfo);
	
		btnCustomerExit = new JButton("Exit");
		btnCustomerExit.setMnemonic('X');
		btnCustomerExit.addActionListener(btnHandler);
		btnCustomerExit.setBounds(10, 194, 89, 23);
		jpCustomers.add(btnCustomerExit);
		
		btnCustomerAdd = new JButton("Add Customer");
		btnCustomerAdd.setMnemonic('A');
		btnCustomerAdd.addActionListener(btnHandler);
		btnCustomerAdd.setBounds(109, 194, 109, 23);
		jpCustomers.add(btnCustomerAdd);
		
		btnCustomerRefresh = new JButton("Refresh");
		btnCustomerRefresh.setMnemonic('R');
		btnCustomerRefresh.addActionListener(btnHandler);
		btnCustomerRefresh.setBounds(227, 194, 89, 23);
		jpCustomers.add(btnCustomerRefresh);
		
		txtareaCustomerError = new JTextArea();
		txtareaCustomerError.setLineWrap(true);
		txtareaCustomerError.setBounds(10, 228, 306, 37);
		jpCustomers.add(txtareaCustomerError);
		
		String filename = "customers.txt";
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
}

