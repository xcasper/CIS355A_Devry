package Week6;


import java.awt.event.ActionEvent;
import javax.swing.*;


public class IndexTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea jtxContent;
    private JTextField jtxSearch;
    private JButton btnSearch;
    private JLabel textLable;
    private JLabel searchTextLable;
    JPanel cntrlPanel;

    public IndexTest() {
        jtxContent = new JTextArea();
        jtxContent.setBounds(157, 11, 292, 117);
        jtxSearch = new JTextField();
        jtxSearch.setBounds(230, 143, 42, 20);
        textLable = new JLabel("Enter Text To Be Searched:");
        textLable.setBounds(7, 45, 140, 29);
        searchTextLable = new JLabel("Enter a Character:");
        searchTextLable.setBounds(133, 139, 105, 29);

        Action searchAction = new AbstractAction("Search") {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {

            }
        };
        btnSearch = new JButton(searchAction);
        btnSearch.setBounds(143, 179, 129, 29);

        cntrlPanel = new JPanel();
        cntrlPanel.setLayout(null);
        cntrlPanel.add(textLable);
        cntrlPanel.add(jtxContent);
        cntrlPanel.add(searchTextLable);

        cntrlPanel.add(jtxSearch);
        cntrlPanel.add(btnSearch);



        getContentPane().add(cntrlPanel);

        setBounds(20, 20, 476, 266);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public int getNumOfOccurrences(String source, String search) {
        int count = 0;
        int prevIndex = 0, curIndex = 0;
        if (source.length() > 0 && search.length()>0) {
            count=-1;
            while (curIndex >= 0) {
                curIndex = source.indexOf(search, prevIndex);
                prevIndex = curIndex + 1;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Index i = new Index();

    }
}

