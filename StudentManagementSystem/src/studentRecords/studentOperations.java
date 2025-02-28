package studentRecords;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class studentOperations {
	
	public static void add(student student) {
		 
		if (!validation(student.getName(), student.getAge(), student.getGrade())) {
            return;
        }
		String query="insert into students (name,age,grade) values(?,?,?)";
		try {
			Connection con=databaseConnection.connect();
			PreparedStatement pst=con.prepareStatement(query);
			
			pst.setString(1, student.getName());
			pst.setInt(2, student.getAge());
			pst.setString(3, student.getGrade());
			
			pst.executeUpdate();
			System.out.println("Student add Successfully!");
		}catch(SQLException e) {
			System.out.println("Error in student insertion!");
			e.printStackTrace();
		}	
	}
	
	public static void viewStudents() {
		String query="select * from students";
		try {
			Connection con=databaseConnection.connect();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			System.out.println("List of Students!");
			System.out.println("-----------------------");
			while(rs.next()) {
				System.out.println("ID :"+rs.getInt("id")+"\nName :"+rs.getString("name")+"\nAge :"+rs.getInt("age")+"\ngrade :"+rs.getString("grade"));
				System.out.println("-----------------------");
			}
			
		}catch(SQLException e) {
			System.out.println("Error viewing students!");
			e.printStackTrace();
		}
	}
	public static void updateStudents(student student) {
		String query = "UPDATE students SET name=?, age=?, grade=? WHERE id=?";
		try {
			Connection con=databaseConnection.connect();
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, student.getName());
			pst.setInt(2, student.getAge());
			pst.setString(3, student.getGrade());
			pst.setInt(4, student.getStudent_ID());
			int rows=pst.executeUpdate();
			if(rows>0)
				System.out.println("Update successfully!");
		
		}catch(SQLException e) {
			System.out.println("Error updating students!");
			e.printStackTrace();
		}
	}
	public static void deleteStudents(int id) {
		String query="delete from students where id=?";
		try {
			Connection con=databaseConnection.connect();
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1, id);
			int rows=pst.executeUpdate();
			if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("No student found with ID: " + id);
            }
		}catch(SQLException e) {
			System.out.println("Error deleting student!");
			e.printStackTrace();
		}
	}
	public static void searchStudent(String keyword) {
	    String query = "SELECT * FROM students WHERE name LIKE ? OR age = ? OR grade = BINARY ? OR id = ?";
		try {
			Connection con=databaseConnection.connect();
			PreparedStatement pst=con.prepareStatement(query);
			  pst.setString(1, "%" + keyword + "%"); 
		      

		        try {
		            int num = Integer.parseInt(keyword); // Convert to integer if possible
		            pst.setInt(2, num);  // Set age as number
		            pst.setInt(4, num);  // Set ID as number
		        } catch (NumberFormatException e) {
		            pst.setInt(2, -1); // Assign impossible age if not a number
		            pst.setInt(4, -1); // Assign impossible ID if not a number
		        }
		        pst.setString(3, keyword);
			
			ResultSet rs=pst.executeQuery();
			System.out.println("-----------------------");
			boolean found=false;
			while(rs.next()) {
				found=true;
				System.out.println("ID :"+rs.getInt("id")+"\nName :"+rs.getString("name")+"\nAge :"+rs.getInt("age")+"\ngrade :"+rs.getString("grade"));
				System.out.println("-----------------------");
			}if(!found)
				System.out.println("No student found for: " + keyword);
		}catch(SQLException e) {
			System.out.println("Error searching student!");
			e.printStackTrace();
		}
	}
	public static boolean validation(String name,int age ,String grade) {
		if(name==null||name.trim().isEmpty()) {
			System.out.println("Error: Name cannot be empty!");
			return false;
		}
		
		try {
			if(age<=0) {
				System.out.println("Error: Age must be positive!");
				return false;
			}
		}catch(NumberFormatException e) {
			System.out.println("Error: Age must be number!");
			
		}
		if(!grade.matches("[A-D]|F")) {
			System.out.println("Error: Grade must be A, B, C, D of F!");
			return false;
		}
		return true;
	}
}
