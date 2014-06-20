/***********************************************************************
Program Name: DayGUI.java
Programmer's Name: Craig Gleckman
Program Description: Creates a GUI program that asks the user to enter text
				and tells them how many occurrences of each alphabetical letter
				there are in that text.
***********************************************************************/
package Week6;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Index2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index2 frame = new Index2();
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
	public Index2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 306, 636);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterText = new JLabel("Enter Some Text:");
		lblEnterText.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterText.setBounds(10, 11, 270, 14);
		contentPane.add(lblEnterText);
		
		final JTextArea fldText = new JTextArea();
		fldText.setBounds(31, 36, 229, 66);
		contentPane.add(fldText);
		
		final JTextArea fldOutput = new JTextArea();
		fldOutput.setBounds(71, 147, 142, 439);
		contentPane.add(fldOutput);
		
		JButton btnCountOccurences = new JButton("Count Occurences of Each Letter");
		btnCountOccurences.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String input = fldText.getText().toUpperCase();
				
				for(int i=0; i < 26; i++)
				{
					String letter = String.valueOf((char) (i + 65));
					fldOutput.append(letter + ":	   " + String.valueOf(getNumOfOccurrences(input, letter)) + "\n");
				}
			}
		});
		btnCountOccurences.setBounds(10, 113, 270, 23);
		contentPane.add(btnCountOccurences);
	}
	
	public int getNumOfOccurrences(String source, String search) 
	{
        int count = -1;
        int prevIndex = 0, curIndex = 0;
        if (source.length() > 0) {

            while (curIndex >= 0) {
                curIndex = source.indexOf(search, prevIndex);
                prevIndex = curIndex + 1;
                count++;
            }
        } else {
            count = 0;
        }
        return count;
	}
}
