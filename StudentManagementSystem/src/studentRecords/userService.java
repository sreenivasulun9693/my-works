package studentRecords;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class userService {
	Scanner sc=new Scanner(System.in);
	
	public void Register() {
		try {
			Connection con=databaseConnection.connect();
			 System.out.println("! User Registration !");
	            System.out.print("Enter Username: ");
	            String userName = sc.nextLine();
	            
	            if(isUserExists(userName)) {
	            	 System.out.println("Username already taken! Please choose a different one.");
	                 return;
	            }
	            System.out.print("Enter Password: ");
	            String password = sc.nextLine();
	            String sql="insert into users (userName,password) values(?,?)";
	            PreparedStatement pst=con.prepareStatement(sql);
	            pst.setString(1, userName);
	            pst.setString(2,password);
	            pst.executeUpdate();
	            System.out.println("Registration successful! You can now log in.");
	            
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean Login() {
		try {
			Connection con=databaseConnection.connect();
			System.out.print("! User Login !");
			System.out.print("Enter username :");
			String userName=sc.nextLine();
			System.out.print(" Enter password :");
			String password=sc.nextLine();
			 String sql = "SELECT * FROM users WHERE userName = ? AND password = ?";
	            PreparedStatement stmt = con.prepareStatement(sql);
	            stmt.setString(1, userName);
	            stmt.setString(2, password);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                System.out.println("Login successful! Welcome " + userName + "!");
	                return true;
	            } else {
	                System.out.println("Incorrect username or password. Try again.");
	                return false;
	            }
		}catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}
	
	public static boolean isUserExists(String userName) {
		try {
		Connection con=databaseConnection.connect();
		String sql="select * from users where userName=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, userName);
		ResultSet rs=st.executeQuery();
		return rs.next();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}