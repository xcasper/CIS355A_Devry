package Week7;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
import javax.swing.ButtonGroup;
import java.awt.FlowLayout;

public class SwimCalc extends JFrame implements ActionListener{
	private JTabbedPane jtabbedPane;
	private JPanel general;
	private JPanel pools;
	private JPanel contractors;
	private JPanel customers;
	private JPanel tempCalc;
	private JPanel options;
	private JPanel hotTubs;
	private JComponent date;
	
	JTextField lengthText, widthText, depthText, volumeText;
	 
	public SwimCalc()
	{
	     
	    JPanel customers = new JPanel();
	    customers = createCustomers();
	    setSize(632, 573);
	    setVisible(true);
	     
	    JPanel contractors = new JPanel();
	    contractors = createContractors();
	    setSize(400,250);
	    setVisible(true);
	     	     
	     
	    setTitle( "Pools" );
	    setSize( 300, 200 );
	    setBackground( Color.GRAY);
	 
	    JPanel topPanel = new JPanel();
	    topPanel.setLayout( new BorderLayout() );
	    getContentPane().add( topPanel );
	     
	    createGeneral();
	    createPools();
	    createContractors();
	    createTempCalc();
	    createCustomers();
	    createOptions();
	    createHotTubs();
	 
	    jtabbedPane = new JTabbedPane();
	    jtabbedPane.addTab( "General", general );
	    jtabbedPane.addTab( "Pools", pools );
	    jtabbedPane.addTab( "Contractors", contractors );
	    jtabbedPane.addTab( "Customers", customers );
	    jtabbedPane.addTab( "Temp Calculator", tempCalc );
	    jtabbedPane.addTab( "Options", options );
	    jtabbedPane.addTab("Hot Tubs", hotTubs );
	     
	     
	    topPanel.add(jtabbedPane, BorderLayout.CENTER );
	    }
	
	    public void createGeneral()
	    {
	    	general = new JPanel();
	    	general.setLayout(null);
	    
	    	JLabel dateLabel = new JLabel( "Todays Date" );
	    	dateLabel.setBounds(10, 15, 150, 20);
	    	general.add( dateLabel );
	     
	    	JFormattedTextField date = new JFormattedTextField(
	    	java.util.Calendar.getInstance().getTime());
	    	date.setBounds(150, 15, 150, 20);
	    	date.setEditable(false);
	    	general.add(date);
	     
	    	JButton quit = new JButton("Quit");
	    	quit.setBounds(10, 80, 150, 30);
	    	quit.addActionListener(this);
	    	quit.setBackground(Color.LIGHT_GRAY);
	    	general.add(quit);
	    }
	    
	    public void createPools()
	    {
	    	pools = new JPanel();
	    	pools.setLayout(null);
	     
	    	JLabel lengthLabel = new JLabel( "Enter the length of swimming pool(ft):" );
	    	lengthLabel.setBounds(10, 15, 260, 20);
	    	pools.add( lengthLabel );
	     
	    	lengthText = new JTextField();
	    	lengthText.setBounds(260, 15, 150, 20);
	    	pools.add( lengthText );
	     
	    	JLabel widthLabel = new JLabel( "Enter the width of the swimming pool(ft):" );
	    	widthLabel.setBounds(10, 60, 260, 20);
	    	pools.add( widthLabel );
	     
	    	widthText = new JTextField();
	    	widthText.setBounds(260, 60, 150, 20);
	    	pools.add( widthText );
	     
	    	JLabel depthLabel = new JLabel( "Enter the average depth the swimming pool(ft):" );
	    	depthLabel.setBounds(10, 100, 260, 20);
	    	pools.add( depthLabel );
	     
	    	depthText = new JTextField();
	    	depthText.setBounds(260, 100, 150, 20);
	    	pools.add( depthText );
	     
	    	JLabel volumeLabel = new JLabel( "The pool volume is:(ft ^3" );
	    	volumeLabel.setBounds(10, 200, 260, 20);
	    	pools.add( volumeLabel );
	     
	    	volumeText = new JTextField();
	    	volumeText.setBounds(260, 200, 150, 20);
	    	volumeText.setEditable(false);
	    	pools.add( volumeText );
	     
	    	JButton calcVolume = new JButton("Calculate Volume");
	    	calcVolume.setBounds(150, 250, 150, 30);
	    	calcVolume.addActionListener(this);
	    	calcVolume.setBackground(Color.LIGHT_GRAY);
	    	pools.add(calcVolume);
	     
	    	JButton quit = new JButton("Quit");
	    	quit.setBounds(350, 250, 80, 30);
	    	quit.addActionListener(this);
	    	quit.setBackground(Color.LIGHT_GRAY);
	    	pools.add(quit);
	    }
	 
	 
	    //Hot tub tab creation
	    public void createHotTubs()
	    {
	        hotTubs = new JPanel();
	        hotTubs.setLayout(null);
	         	         
	         
	         final JTextArea labelTubStatus = new JTextArea(6,30);
	         final JTextArea textFieldTubResult = new JTextArea(6,30);
	         final JTextArea textFieldTubWidth = new JTextArea(6,30);
	 	 
	        final JRadioButton rdbtnRoundTub = new JRadioButton("RoundTub");
	        rdbtnRoundTub.addActionListener(new ActionListener()
	        {
	 
	        	public void actionPerformed(ActionEvent arg0)
	        	{
	        		textFieldTubWidth.setEditable(false);
	        	}
	     	});
	        
	        rdbtnRoundTub.setSelected(true);
	        rdbtnRoundTub.setBounds(79, 7, 109, 23);
	        hotTubs.add(rdbtnRoundTub);
	 
	        JRadioButton rdbtnOvalTub = new JRadioButton("Oval Tub");
	        rdbtnOvalTub.addActionListener(new ActionListener() 
	        {
	        	public void actionPerformed(ActionEvent arg0) 
	        	{
	        		textFieldTubWidth.setEditable(true);
	        	}
	        });
	        
	        rdbtnOvalTub.setBounds(201, 7, 109, 23);
	        hotTubs.add(rdbtnOvalTub);
	         
	        ButtonGroup radioBtnGroup = new ButtonGroup();
	        radioBtnGroup.add(rdbtnRoundTub);
	        radioBtnGroup.add(rdbtnOvalTub);
	         
	        JButton btnCalculateVlmn = new JButton("Calculate Volume");
	        btnCalculateVlmn.setMnemonic('C');
	         
	        btnCalculateVlmn.addActionListener(new ActionListener()
	        {
	        	
	        	public void actionPerformed(ActionEvent arg0)
	        	{
	        		double width = 0, length = 0, depth = 0, volume = 0;
	        		try
	        		{
	        			if(rdbtnRoundTub.isSelected())
	        			{
	        				volume = Math.PI * Math.pow(length / 2.0, 2) * depth;
	        			}
	        			else
	        			{
	        				volume = Math.PI * Math.pow(length * width, 2) * depth;
	        			}
	 
	        			//double volume = calculate volume;	         
	        			DecimalFormat formatter = new DecimalFormat("#,###,###.###");
	        			textFieldTubResult.setText(""+formatter.format(volume));	         
	        		}
	         
	        		catch(NumberFormatException e)
	        		{
	        			labelTubStatus.setText("Please make sure that all fields are filled and contain valid input!");
	        		}
	        	}
	        });
	        
	        btnCalculateVlmn.setBounds(47, 115, 141, 23);
	        hotTubs.add(btnCalculateVlmn);       
	    }

	    
	    
	    public JPanel createContractors()
	    {
	    	// contractor variables
	    	JTextField contName;
	    	JTextField contCity;
	    	JTextField contState;
	    	JTextField contZip;
	    	JTextField contPhone;
	    	JTextField contAdd;
	    	final JTextArea contArea = new JTextArea(6, 30);
	    	final JTextArea contMessage;
	    	JTextArea contAddMessage;
	    	JButton addContractor = new JButton("Add Contractor");
	 
	    	addContractor.setMnemonic('a');
	     
	    	// Contractor Panel
	    	JPanel contPanel = new JPanel();
	    	contArea.setText("Select Add Contractor to add contractor. Select Refresh to refresh this pane.");
	    	contArea.setForeground(Color.BLACK);
	    	contArea.setLineWrap(true);
	    	contArea.setWrapStyleWord(true);
	    	JButton contRefButton = new JButton("Refresh");
	    	contMessage = new JTextArea(2, 30);
	    	contMessage.setLineWrap(true);
	    	contMessage.setWrapStyleWord(true);
	     
	    	addContractor.addActionListener(new ActionListener()
	    	{
	    		public void actionPerformed(ActionEvent e)
	    		{ // action if button is used
	    			new Contractor("Contractor");
	    		}// end actionPerformed()//end action performed
	    	}); // end performed action
	     
	    	contPanel.add(contArea);
	    	contPanel.add(addContractor);
	    	contPanel.add(contRefButton);
	    	contPanel.add(contMessage);
	    	contRefButton.setMnemonic('R');
	     
	    	contRefButton.addActionListener(new ActionListener()
	    	{
	        	public void actionPerformed(ActionEvent e)
	        	{
	        		contMessage.setText("");
	        		try
	        		{
	            		File contOpen = new File("contractor.txt");
	            		FileReader contAreaIn = new FileReader(contOpen);
	            		contArea.read(contAreaIn, contOpen.toString());
	            		contMessage.setText("The file exists and can be read from.");
	        		}
	        		catch (IOException e3)
	        		{
	            		contMessage.setText("The file could not be read. " + e3.getMessage());
	        		}	
	        	}
	    	});
	     
	    return contPanel;
	    }
	 
	    class Contractor extends JFrame
	    {
	    	private String[] states = { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE",
	            "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME",
	            "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
	            "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD",
	            "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" };
	    	
	    	private JComboBox StateList = new JComboBox(states);
	    	private JTextField NameText = new JTextField(25);
	    	private JTextField AddressText = new JTextField(25);
	    	private JTextField CityText = new JTextField(25);
	    	private JTextField ZipText = new JTextField(9);
	    	private JTextField PhoneText = new JTextField(10);
	    	private JTextField PopMessageText = new JTextField(30);
	    	private static final long serialVersionUID = 1L;
	 
	    	private AddContButtonHandler addContHandler = new AddContButtonHandler();
	 
	    public Contractor(String who)
	    {
	        popUpWindow(who);
	    }
	    
	    // Customer and Contractor Pop Up Window
	    public void popUpWindow(final String who) 
	    {
	        // add components to contractor Pop up window	 
	        final JFrame popWindow;
	        popWindow = new JFrame(who);
	        popWindow.setSize(425, 350);
	        popWindow.setLocation(100, 100);
	        popWindow.setVisible(true);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	 
	        Container c = new Container();
	 
	        popWindow.getContentPane().add(c);
	 
	        c.setLayout(new FlowLayout());
	 
	        JPanel one = new JPanel();
	        JPanel two = new JPanel();
	        JPanel three = new JPanel();
	        JPanel four = new JPanel();
	        JPanel five = new JPanel();
	        JPanel six = new JPanel();
	 
	        one.add(new JLabel(who + " Name "));
	        one.add(NameText);
	        two.add(new JLabel("Address "));
	        two.add(AddressText);
	        three.add(new JLabel("City "));
	        three.add(CityText);
	        four.add(new JLabel("State "));
	        StateList.setSelectedIndex(0);
	        four.add(StateList);
	        four.add(new JLabel("ZIP"));
	        four.add(ZipText);
	        four.add(new JLabel("Phone"));
	        four.add(PhoneText);
	        JButton addwho = new JButton("Add " + who);
	        addwho.setMnemonic('A');
	        JButton close = new JButton("Close");
	        close.setMnemonic('C');
	        JButton deleteFile = new JButton("Delete File");
	        deleteFile.setMnemonic('D');
	        five.add(addwho);
	        five.add(close);
	        five.add(deleteFile);
	        PopMessageText.setEditable(false);
	        PopMessageText.setHorizontalAlignment(JTextField.CENTER);
	        
	        // message.setOpaque(false);
	        six.add(PopMessageText);
	        c.add(one);
	        c.add(two);
	        c.add(three);
	        c.add(four);
	        c.add(five);
	        c.add(six);
	         
	        deleteFile.setToolTipText("Delete File");
	        addwho.setToolTipText("Add "+ who);
	        close.setToolTipText("Close");
	 
	        if (who == "Contractor")
	            addwho.addActionListener(addContHandler); // registers listener
	         
	        close.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
				{
	                NameText.setText("");
	                AddressText.setText("");
	                CityText.setText("");
	                ZipText.setText("");
	                PhoneText.setText("");
	                PopMessageText.setText("");
	                popWindow.dispose();
	            }
	        });
	 
	        deleteFile.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {
	                PopMessageText.setText("");
	                if (who == "Contractor") 
	                {
	                    File file = new File("Contractor.txt");
	                    boolean contFileDeleted = file.delete();
	                    
	                    if (contFileDeleted) 
	                    {
	                        PopMessageText
	                                .setText("Contractor file has been deleted");
	                    } 
	                    else 
	                    {
	                        PopMessageText
	                                .setText("There was an erron in deleting file");
	                    }
	                }
	            }
	        });
	    } // end Pop up window
	    
	    // Class handler to add contractor information to a file
	    class AddContButtonHandler implements ActionListener 
	    {
	        public void actionPerformed(ActionEvent addContHandler) 
	        {
	            int StateIndex;
	            
	            try 
	            {
	                File file = new File("Contractor.txt");
	 
	                boolean success = file.createNewFile();
	 
	                if (success) 
					{
	                    PopMessageText
	                            .setText("Contractor.txt file created file added");
	                } 
	                else if (file.canWrite()) 
	                {
	                    PopMessageText
	                            .setText("Writing data to Contractor.txt, file added");
	                } 
	                else 
	                {
	                    PopMessageText.setText("Cannot create file: Contractor.txt");
	                }
	                try 
					{
	                    FileWriter fileW = new FileWriter("Contractor.txt", true);
	                    fileW.write(NameText.getText());
	                    fileW.write(",");
	                    fileW.write(AddressText.getText());
	                    fileW.write(",");
	                    fileW.write(CityText.getText());
	                    fileW.write(",");
	                    StateIndex = StateList.getSelectedIndex();
	                    fileW.write(states[StateIndex]);
	                    fileW.write(",");
	                    fileW.write(ZipText.getText());
	                    fileW.write(",");
	                    fileW.write(PhoneText.getText());
	                    fileW.write("\r\n");
	                    fileW.close();
	                    PopMessageText.setText("A new Contractor has been added!");
	 
	                    FileReader fileR = new FileReader("Contractor.txt");
	                    BufferedReader buffIn = new BufferedReader(fileR);
	 
	                    String textData = buffIn.readLine();
	                    buffIn.close();
	               }	 
	               catch (IOException e1) 
	               {
	                    JOptionPane.showMessageDialog(null, e1.getMessage(),
	                            "ERROR", 2); // Will display error message if unable
	                                            // to write to file
	               }
	                NameText.setText("");
	                AddressText.setText("");
	                CityText.setText("");
	                ZipText.setText("");
	                PhoneText.setText("");
	            } 
	            catch (IOException e1) 
	            {
	            	
	            }
 	 
	        }
	    }
	}
	    
	public JPanel createCustomers()
	{
		JTextField custName;
		JTextField custCity;
		JTextField custState;
		JTextField custZip;
		JTextField custPhone;
		JTextField custAdd;
		final JTextArea custArea = new JTextArea(6, 30);
		final JTextArea custMessage;
		JTextArea custAddMessage;
		JButton addCustomer = new JButton("Add Customer");
	 
		addCustomer.setMnemonic('a');
	
		// Customer Panel
		JPanel custPanel = new JPanel();
		custArea.setText("Select Add Customer to add customer. Select Refresh to refresh this pane.");
		custArea.setForeground(Color.BLACK);
		custArea.setLineWrap(true);
		custArea.setWrapStyleWord(true);
		JButton custRefButton = new JButton("Refresh");
		custMessage = new JTextArea(2, 30);
		custMessage.setLineWrap(true);
		custMessage.setWrapStyleWord(true);
	 
		addCustomer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ // action if button is used
				new Customer("Customer");
			}// end actionPerformed()//end action performed
		}); // end performed action
	 
		custPanel.add(custArea);
		custPanel.add(addCustomer);	 
		custPanel.add(custRefButton);
		custPanel.add(custMessage);
		custRefButton.setMnemonic('R');
	 
		custRefButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				custMessage.setText("");
				try
				{
					File custOpen = new File("customer.txt");
					FileReader custAreaIn = new FileReader(custOpen);
					custArea.read(custAreaIn, custOpen.toString());
					custMessage.setText("The file exists and can be read from.");
				}
	    		catch (IOException e3)
	    		{
	        		custMessage.setText("The file could not be read. " + e3.getMessage());
	    		}
	    	}
		});
	 
		return custPanel;
	}
	 
	class Customer extends JFrame
	{
	    private String[] states = { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE",
	            "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME",
	            "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
	            "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD",
	            "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" };
	    private JComboBox StateList = new JComboBox(states);
	    private JTextField NameText = new JTextField(25);
	    private JTextField AddressText = new JTextField(25);
	    private JTextField CityText = new JTextField(25);
	    private JTextField ZipText = new JTextField(9);
	    private JTextField PhoneText = new JTextField(10);
	    private JTextField PopMessageText = new JTextField(30);
	    private static final long serialVersionUID = 1L;
	 
	    private AddCustButtonHandler addCusHandler = new AddCustButtonHandler();
	 
	    public Customer(String who)
	    {
	        popUpWindow(who);
	    }
	    
	    // Customer and Contractor Pop Up Window
	    public void popUpWindow(final String who) 
	    {
	        // add components to contractor Pop up window	 
	        final JFrame popWindow;
	        popWindow = new JFrame(who);
	        popWindow.setSize(425, 350);
	        popWindow.setLocation(100, 100);
	        popWindow.setVisible(true);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	 
	        Container c = new Container();
	 
	        popWindow.getContentPane().add(c);
	 
	        c.setLayout(new FlowLayout());
	 
	        JPanel one = new JPanel();
	        JPanel two = new JPanel();
	        JPanel three = new JPanel();
	        JPanel four = new JPanel();
	        JPanel five = new JPanel();
	        JPanel six = new JPanel();
	 
	        one.add(new JLabel(who + " Name "));
	        one.add(NameText);
	        two.add(new JLabel("Address "));
	        two.add(AddressText);
	        three.add(new JLabel("City "));
	        three.add(CityText);
	        four.add(new JLabel("State "));
	        StateList.setSelectedIndex(0);
	        four.add(StateList);
	        four.add(new JLabel("ZIP"));
	        four.add(ZipText);
	        four.add(new JLabel("Phone"));
	        four.add(PhoneText);
	        JButton addwho = new JButton("Add " + who);
	        addwho.setMnemonic('A');
	        JButton close = new JButton("Close");
	        close.setMnemonic('C');
	        JButton deleteFile = new JButton("Delete File");
	        deleteFile.setMnemonic('D');
	        five.add(addwho);
	        five.add(close);
	        five.add(deleteFile);
	        PopMessageText.setEditable(false);
	        PopMessageText.setHorizontalAlignment(JTextField.CENTER);
	        // message.setOpaque(false);
	        six.add(PopMessageText);
	        c.add(one);
	        c.add(two);
	        c.add(three);
	        c.add(four);
	        c.add(five);
	        c.add(six);
	         
	        deleteFile.setToolTipText("Delete File");
	        addwho.setToolTipText("Add "+ who);
	        close.setToolTipText("Close");
	 
	        if (who == "Customer")
	            addwho.addActionListener(addCusHandler); // registers listener
	         
	        close.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {
	                NameText.setText("");
	                AddressText.setText("");
	                CityText.setText("");
	                ZipText.setText("");
	                PhoneText.setText("");
	                PopMessageText.setText("");
	                popWindow.dispose();
	            }
	        });
	 
	        deleteFile.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {
	                PopMessageText.setText("");
	                if (who == "Customer") 
	                {
	                    File file = new File("Customer.txt");
	                    boolean cusFileDeleted = file.delete();
	                    
	                    if (cusFileDeleted) 
	                    {
	                        PopMessageText
	                                .setText("Customer file has been deleted");
	                    } 
	                    else 
	                    {
	                        PopMessageText
	                                .setText("There was an erron in deleting file");
	                    }
	                }
	            }
	        });
	    } // end Pop up window
	     
	    // Class handler to add customer information to a file
	    class AddCustButtonHandler implements ActionListener 
	    {
	        public void actionPerformed(ActionEvent addCusHandler) 
	        {
	            int StateIndex;
	            
	            try 
	            {
	                File file = new File("Customer.txt");
	 
	                boolean success = file.createNewFile();
	 
	                if (success) 
	                {
	                    PopMessageText
	                            .setText("Customer.txt file created file added");
	                } 
	                else if (file.canWrite()) 
	                {
	                    PopMessageText
	                            .setText("Writing data to Customer.txt, file added");
	                } 
	                else 
	                {
	                    PopMessageText.setText("Cannot create file: Customer.txt");
	                }
	                try 
	                {
	                    FileWriter fileW = new FileWriter("Customer.txt", true);
	                    fileW.write(NameText.getText());
	                    fileW.write(",");
	                    fileW.write(AddressText.getText());
	                    fileW.write(",");
	                    fileW.write(CityText.getText());
	                    fileW.write(",");
	                    StateIndex = StateList.getSelectedIndex();
	                    fileW.write(states[StateIndex]);
	                    fileW.write(",");
	                    fileW.write(ZipText.getText());
	                    fileW.write(",");
	                    fileW.write(PhoneText.getText());
	                    fileW.write("\r\n");
	                    fileW.close();
	                    PopMessageText.setText("A new Customer has been added!");
	 
	                    FileReader fileR = new FileReader("Customer.txt");
	                    BufferedReader buffIn = new BufferedReader(fileR);
	 
	                    String textData = buffIn.readLine();
	                    buffIn.close();
	                }
	 
	                catch (IOException e1) 
	                {
	                    JOptionPane.showMessageDialog(null, e1.getMessage(),
	                            "ERROR", 2); // Will display error message if unable
	                                            // to write to file
	                }
	                
	                NameText.setText("");
	                AddressText.setText("");
	                CityText.setText("");
	                ZipText.setText("");
	                PhoneText.setText("");
	            } 
	            catch (IOException e1) 
	            {
	            	
	            }
	 
	        }
	    }
	 
	}
	 
	public void createTempCalc()
	{
	    tempCalc = new JPanel();
	    tempCalc.setLayout( null );
	    JLabel tempLabel = new JLabel( "Enter temperature:" );
	    tempLabel.setBounds( 10, 15, 260, 20 );
	    tempCalc.add( tempLabel );
	 
	    JTextField temp = new JTextField();
	    temp.setBounds( 260, 15, 150, 20 );
	    tempCalc.add( temp );
	 
	    JLabel resultsLabel = new JLabel( "Calculated Temp:" );
	    resultsLabel.setBounds( 10, 60, 260, 20 );
	    tempCalc.add( resultsLabel );
	 
	    JTextField results = new JTextField();
	    results.setBounds( 260, 60, 150, 20 );
	    results.setEditable(false);
	    tempCalc.add( results );
	 
	    JButton calcVol = new JButton("Calculate Volume");
	    calcVol.setBounds(100,115,150,30);
	    calcVol.addActionListener(this);
	    calcVol.setBackground(Color.LIGHT_GRAY);
	    tempCalc.add(calcVol);
	 
	    JButton quit = new JButton("Quit");
	    quit.setBounds(250,115,80,30);
	    quit.addActionListener(this);
	    quit.setBackground(Color.LIGHT_GRAY);
	    tempCalc.add(quit);
	    }
	     
	 
	public void createOptions()
	{
		options = new JPanel();
		options.setLayout( null );
		JLabel labelOptions = new JLabel( "Change Company Name:" );
		labelOptions.setBounds( 150, 50, 150, 20 );
		options.add( labelOptions );
	 
		JTextField newTitle = new JTextField();
		newTitle.setBounds( 150, 70, 150, 20 );
		options.add( newTitle );

		JButton newName = new JButton("Set New Name");
		newName.setBounds(100,115,150,30);
		newName.addActionListener(this);
		newName.setBackground(Color.LIGHT_GRAY);
		options.add(newName);
	 
		JButton quit = new JButton("Quit");
		quit.setBounds(250,115,80,30);
		quit.addActionListener(this);
		quit.setBackground(Color.LIGHT_GRAY);
		options.add(quit);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		JButton button = (JButton)event.getSource();
		String buttonLabel = button.getText();
		
		if ("Quit".equalsIgnoreCase(buttonLabel))
		{
			Exit_pressed(); return;
		}
		if ("Set New Name".equalsIgnoreCase(buttonLabel)){
			New_Name(); return;
		}
		if ("Calculate Volume".equalsIgnoreCase(buttonLabel)){
			Calculate_Volume(); return;
		}
		if ("Customers".equalsIgnoreCase(buttonLabel)){
			Customers(); return;
		}
		if ("Calculate Volume".equalsIgnoreCase(buttonLabel)){
			Calculate_Volume(); return;
		}
		if ("Options".equalsIgnoreCase(buttonLabel)){
			Options(); return;
		}
	     
	}
	 
	 
	private void Exit_pressed()
	{
	System.exit(0);
	}
	
	private void New_Name()
	{
	System.exit(0);
	}
	
	private void Calculate_Volume()
	{
		String lengthString, widthString, depthString;
		int length = 0;
		int width = 0;
		int depth = 0;
	 
		lengthString = lengthText.getText();
		widthString = widthText.getText();
		depthString = depthText.getText();
		if ( lengthString.length() < 1 || widthString.length() < 1 || depthString.length() < 1 )
		{
			volumeText.setText( "Error! Must enter in all three numbers!!" ); return;
		}
		
		length = Integer.parseInt(lengthString );
		width = Integer.parseInt(widthString );
		depth = Integer.parseInt(depthString);
		
		if ( length != 0 || width != 0 || depth != 0 )
		{
			volumeText.setText((length * width * depth) + "" );
		} 
		else
		{
			volumeText.setText( "Error! Must Enter in all three numbers!!" ); return;
		}
	}
	
	private void Customers()
	{
		
	}
	
	private void Options()
	{
		
	}
	
	public static void main(String[] args)
	{
		JFrame frame = new SwimCalc();
		frame.setSize(500, 400);
		frame.setVisible(true); 
	}
}
