package Week3;

import javax.swing.JOptionPane;
import errorChecker.ErrorChecker;

public class Lawyer {
	public void run()
	{
		ErrorChecker ec = new ErrorChecker();
		JOptionPane.showInputDialog("Press 1 to enter Client information \n"
				+ "Press 2 to see Client information \n"
				+ "Press 3 to search for Client by ID \n"
				+ "Press 4 to Update Address \n"
				+ "Press 5 to Exit");
	}
}
