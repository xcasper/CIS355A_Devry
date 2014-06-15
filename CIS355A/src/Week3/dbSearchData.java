package Week3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class dbSearchData 
{
	public void searchClientInformation()
	{
		String dbClientName, dbClientAddr, dbClientPhNum, dbClientID, dbClientHours, dbClientMinutes, dbClientHourlyRate, dbClientDidWrong, dbClientTotalCost, msg = "";
		String searchName;
		searchName = JOptionPane.showInputDialog("Enter Client Name To Search: ");
		
		try 
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			String filename = "C:\\Users\\Craig\\Documents\\GitHub\\CIS355A_Devry\\CIS355A\\bin\\dbLawyer.accdb";                              
			String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=";
			database+= filename.trim() + ";DriverID=22;READONLY=true}";
			
			Connection conn = DriverManager.getConnection(database,"","");
			java.sql.Statement sqlStatement = conn.createStatement();
			
			//process results one row at a time
	        ResultSet result = sqlStatement.executeQuery("SELECT * FROM ClientInformation WHERE clientName = '" + searchName + "' ");
	        //NOTE:  Java reads the ID field as position 1, so always start
	        //pulling the data from position 2
	        if(result.next())
	        {
				dbClientID = result.getString(1);
				dbClientName = result.getString(2);
				dbClientAddr = result.getString(3);
				dbClientPhNum = result.getString(4);
				dbClientHours = result.getString(5);
				dbClientMinutes = result.getString(6);
				dbClientHourlyRate = result.getString(7);
				dbClientDidWrong = result.getString(8);
				dbClientTotalCost = result.getString(9);
	        	
				msg = (msg + "Client ID: " + dbClientID + "\nClient Name: " + dbClientName + "\nClient Address: " + 
						dbClientAddr + "\nClient Phone Number: " + dbClientPhNum + "\nClient Hours Spent: " + dbClientHours +
						"\nClient Minutes Spent: " + dbClientMinutes + "\nClient Hourely Rate: " + dbClientHourlyRate +
						"\nClient Did Wrong: " + dbClientDidWrong + "\nClient Total Cost: " + dbClientTotalCost + "\n\n");
				
				JOptionPane.showMessageDialog(null, msg,"All Information in Database",JOptionPane.INFORMATION_MESSAGE);
	        }
	        else
			{
				JOptionPane.showMessageDialog(null, searchName +" not found in database ","Database request",JOptionPane.INFORMATION_MESSAGE);
			}                                                      
		
			//bufferedWindow.writeIndexStatusLine(Msg);
			sqlStatement.close();
			conn.close();
		}// closes try
		
		catch (Exception ex)
		{
			System.out.print("error" + ex);
			ex.printStackTrace();
		}// closes catch
	}
}
