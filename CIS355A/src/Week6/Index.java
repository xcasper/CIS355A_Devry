/***********************************************************************
Program Name: DayGUI.java
Programmer's Name: Craig Gleckman
Program Description: Creates a GUI program that asks the user to enter text
				and a character, and then tells the user how many occurrences
				of that character exist.
***********************************************************************/

package Week6;


import java.awt.event.ActionEvent;

import javax.swing.*;

import java.awt.event.ActionListener;

import ErrorChecker.ErrorChecker;

public class Index extends JFrame {

	private static final long serialVersionUID = 1L;
    private JTextField jtxtSearchCharacter;
    private JButton btnSearch;
    private JLabel lblEnterSearchText;
    private JLabel lblEnterCharacter;
    private JLabel lblError;
    private ErrorChecker ec;
    private boolean errorExist;
    JPanel mainPanel;
    private JTextArea jtxtSearchContent;

    public Index() {
        jtxtSearchCharacter = new JTextField();
        jtxtSearchCharacter.setBounds(246, 143, 42, 20);
        lblEnterSearchText = new JLabel("Enter Text To Be Searched:");
        lblEnterSearchText.setBounds(7, 45, 140, 29);
        jtxtSearchContent = new JTextArea();
        jtxtSearchContent.setLineWrap(true);
        jtxtSearchContent.setBounds(157, 11, 279, 117);
        lblEnterCharacter = new JLabel("Enter a Character:");
        lblEnterCharacter.setBounds(133, 139, 105, 29);
        lblError = new JLabel("");
        lblError.setBounds(300, 186, 46, 14);
        

        btnSearch = new JButton();
        btnSearch.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		String tempString = null, searchContent = null, searchCharacter = null;
        		searchContent = jtxtSearchContent.getText();
        		searchCharacter = jtxtSearchCharacter.getText();
        		
        		JOptionPane.showMessageDialog(null, "Number of " + searchCharacter + "'s: " + getNumberOfOccurrences(searchContent, searchCharacter));
        		
        	}
        });
        btnSearch.setText("Search");
        btnSearch.setBounds(143, 179, 129, 29);

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.add(lblEnterSearchText);
        mainPanel.add(lblEnterCharacter);
        mainPanel.add(jtxtSearchCharacter);
        mainPanel.add(btnSearch);
        mainPanel.add(lblError);



        getContentPane().add(mainPanel);
        
        jtxtSearchContent = new JTextArea();
        jtxtSearchContent.setLineWrap(true);
        jtxtSearchContent.setBounds(157, 11, 279, 117);
        mainPanel.add(jtxtSearchContent);

        setBounds(20, 20, 476, 266);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public int getNumberOfOccurrences(String searchText, String searchCharacter) 
    {
        int count = 0;
        int prevIndex = 0, curIndex = 0;
        if (searchText.length() > 0 && searchCharacter.length()>0) {
            count=-1;
            while (curIndex >= 0) {
                curIndex = searchText.indexOf(searchCharacter, prevIndex);
                prevIndex = curIndex + 1;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Index index = new Index();

    }
}

