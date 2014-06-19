package Week6;


import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;


public class Index2 extends JFrame {

    private JTextArea jtxContent;
    private JButton btnSearch;
    private JLabel textLable;
    private JTextArea resultList;
    JPanel cntrlPanel;
    JScrollPane resScrol;

    public Index2() {
        jtxContent = new JTextArea();


        resultList = new JTextArea("click on search");
        resScrol = new JScrollPane(resultList);
        textLable = new JLabel("Enter the text ");


        Action searchAction = new AbstractAction("Search") {

            public void actionPerformed(ActionEvent e) {
                String source = jtxContent.getText().toUpperCase();
                resultList.setText("");
                for (int i = 0; i < 26; i++) {

                    resultList.append(String.valueOf(getNumOfOccurrences(source, String.valueOf((char) (i + 65)))) + " occurrence(s) found of character " + String.valueOf((char) (i + 65)) + "\n");


                }




            }
        };

        getContentPane().setLayout(new GridLayout(2, 1));
        btnSearch = new JButton(searchAction);

        cntrlPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        cntrlPanel.add(textLable);
        cntrlPanel.add(jtxContent);

        cntrlPanel.add(btnSearch);
        //  cntrlPanel.add(resScrol);



        getContentPane().add(cntrlPanel);
        getContentPane().add(resScrol);
        setBounds(20, 20, 350, 270);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public int getNumOfOccurrences(String source, String search) {
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

    public static void main(String[] args) {
        Index2 index2 = new Index2();

    }
}
