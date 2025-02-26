package studentRecords; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class databaseConnection {
    
    static final String URL ="jdbc:mysql://localhost:3306/studentDB";
    static final String USER = "root";
    static final String PASSWORD = "root"; 

   public static Connection connect() { 
	   try {
		   return DriverManager.getConnection(URL,USER,PASSWORD);
	   }
	   catch(SQLException e) {
		   System.out.println("Conncetion failed!");
		   e.printStackTrace();
	   }
	return null;
   }
}
