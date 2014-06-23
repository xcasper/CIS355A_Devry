package Week7;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer frame = new Customer();
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
		btnAddCustomer.setBounds(58, 150, 132, 23);
		contentPane.add(btnAddCustomer);
		
		btnClose = new JButton("Close");
		btnClose.setMnemonic('C');
		btnClose.setBounds(194, 150, 89, 23);
		contentPane.add(btnClose);
		
		btnDeleteFile = new JButton("Delete File");
		btnDeleteFile.setMnemonic('D');
		btnDeleteFile.setBounds(288, 150, 89, 23);
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
        		String filename = "customer.txt";
        		boolean success = false;
        		
        		try
        		{
        			File custOpen = new File(filename);
        			custOpen.createNewFile();
        			
        			if(custOpen.exists())
        			{
        				FileReader custAreaIn = new FileReader(custOpen);
        				txtareaCustError.read(custAreaIn, custOpen.toString());
        				txtareaCustError.setText("The file exists and can be read from. Hit Refresh to see current information.");
        			}
        			else
        			{
        				txtareaCustomerError.setText("File " + filename + "does not exist yet! Will be created when you add a customer!");
        			}
        		}
        	}
        }
    
    }
}
