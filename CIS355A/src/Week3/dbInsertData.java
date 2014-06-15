package Week3;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbInsertData {
	
	public boolean writeToDB(int clientID, String clientName, String clientAddress, double clientPhone, int clientHours, int clientMinutes, double clientHourlyRate, String clientDidWrong, double clientTotalCost)
	{
		
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			// set the filename line to a Microsoft Access database you have on your machine
			//This next line specifies the absolute path.  Nothing else would work.
			   
			String filename = "C:\\Users\\Craig\\Documents\\GitHub\\CIS355A_Devry\\CIS355A\\bin\\dbLawyer.accdb";        
			String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=";
			database+= filename.trim() + ";DriverID=22;READONLY=true}";
	 
			//The trim() method returns a copy of the invoking string from which leading and trailing  //whitespace has been removed
			                          
			// Source=jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=C:/Core.mdb"
			//the .accdb is added for 64 bit systems.
			// *.accdb is not needed for 32 bit systems.
	                          
			//Can create the Connection using the line below.  Both specifying the
			//userName, password -- and "","" work).
			//Connection conn = DriverManager.getConnection(url,userName,password);
				 
			// now we can get the connection from the DriverManager
			Connection conn = DriverManager.getConnection(database,"","");
			java.sql.Statement sqlStatement = conn.createStatement();
			
			//Insert statement execution
			//The first set of values contain the field names within the Access database
			//The second set of values are the parameter variables from writeToDB.
			sqlStatement.execute("insert into ClientInformation (clientID, clientName, clientAddress, clientPhoneNumber"
					+ ", clientHoursSpent, clientMinutesSpent, clientHourlyRate, clientDidWrong, clientTotalCost) "
					+ "VALUES ('" + clientID + "','"+ clientName +  "','"+ clientAddress +  "','"+ clientPhone +
					"','"+ clientHours +  "','"+ clientMinutes +  "','"+ clientHourlyRate +  "','"+ clientDidWrong +
					"','"+ clientTotalCost +  "')");
			//
			sqlStatement.close();
			conn.close();
			 
		}// closes try	
		 
		catch (Exception ex)
		{
			System.out.print("error" + ex);
			ex.printStackTrace();
			return true;
		}// closes catch
		
		return false;
	}//end writeToDB()
}//end dbInsertData
