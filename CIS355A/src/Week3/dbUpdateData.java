package Week3;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class dbUpdateData 
{
	public void updateClientInformation()
	{
    	String dbClientName, searchName, tempNum, msg;
    	double newPhNum;
    	
    	searchName = JOptionPane.showInputDialog("Enter Client Name To Update: ");//Get Client Name To Change
    	tempNum = JOptionPane.showInputDialog("Enter Client's New Phone Number: ");//Get New Phone Number for Client
    	newPhNum = Double.parseDouble(tempNum);//Convert new number from string to int
    	
    	try 
    	{
    		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    		
    		String filename = "C:\\Users\\Craig\\Documents\\GitHub\\CIS355A_Devry\\CIS355A\\bin\\dbLawyer.accdb";
    		String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=";
    		database+= filename.trim() + ";DriverID=22;READONLY=true}";
    	 
    		Connection conn = DriverManager.getConnection(database,"","");
    	 
    		java.sql.Statement sqlStatement = conn.createStatement();
    		
    		sqlStatement.executeUpdate("UPDATE ClientInformation SET clientPhoneNumber = '" + newPhNum + "' WHERE clientName  = '" + searchName + "' ");

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
