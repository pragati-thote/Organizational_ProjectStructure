package com.DatabaseConnection;

import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test_DB_Connection {
	
	String url = "jdbc:mysql://localhost:3306/mydb";
    //String dbName = "mydb";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root";
    String password = "root";
		
	    @Test
	    public void testMysqlConnection() throws ClassNotFoundException, SQLException 
	    {
	  	  
	//Load jdbc Driver
	  	  Class.forName("com.mysql.jdbc.Driver");
	  	  System.out.println("Driver Loaded..");
	  	  
	//Establish Connection
	  	  
	  	 // Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root"); 
	  	  
	  	   Connection con=DriverManager.getConnection(url,userName,password);
	  	   System.out.println("MySql Connection Established Successfully..");
	  	  
    //Create Statement 
	  	  Statement smt=con.createStatement();
	  	  System.out.println("Statement Created. \n Ready to Execute Query");
	  	  
	//Execute Query
	  	  ResultSet rs= smt.executeQuery("select * from Bynryans where FirstName='Pragati';");
	  	  System.out.println("Query Executed Successfully....");
	  	  
	 // to fetch the data ---first fetch row 1
	 // Initially curser pointing to the attribute name row.....
	 //to just on next row [1st row of table data use Next()]
	  	  
	  	  System.out.println("Please review following output data return by Executed Query Contains Name and Addresses...");
	  	  int i=1;
	  	  while(rs.next())
	  	  {
	  		
	  		  String FName=rs.getString("FirstName");
	  		  String LName=rs.getString("LastName");
	  		  String Addr=rs.getString("Address");
	  		  System.out.println("Row "+i+"."+FName+" "+LName+ ","+Addr);
	  		  
	  		  i++;
	  	  }
	    }  
  }
