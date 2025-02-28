package studentRecords;

import java.util.Scanner;

public class Contoller {

		public static void start(Scanner scanner) {
			 while (true) {
		            System.out.println("\n Student Management System");
		            System.out.println("1. Add Student");
		            System.out.println("2. View Students");
		            System.out.println("3. Update Student");
		            System.out.println("4. Delete Student");
		            System.out.println("5. Search Student");
		            System.out.println("6. Exit");
		            System.out.print("Enter choice: ");
		            
		            int choice = scanner.nextInt();
		            scanner.nextLine();  

		            switch (choice) {
		                case 1:
		                    System.out.print("Enter name: ");
		                    String name = scanner.nextLine();
		                    System.out.print("Enter age: ");
		                    int age = scanner.nextInt();
		                    scanner.nextLine();  // Consume newline
		                    System.out.print("Enter grade: ");
		                    String grade = scanner.nextLine();
		                    student newStudent = new student(name, age, grade);
		                    studentOperations.add(newStudent);
		                    break;

		                case 2:
		                    studentOperations.viewStudents();
		                    break;

		                case 3:
		                    System.out.print("Enter student ID to update: ");
		                    int idToUpdate = scanner.nextInt();
		                    scanner.nextLine();
		                    System.out.print("Enter new name: ");
		                    String newName = scanner.nextLine();
		                    System.out.print("Enter new age: ");
		                    int newAge = scanner.nextInt();
		                    scanner.nextLine();
		                    System.out.print("Enter new grade: ");
		                    String newGrade = scanner.nextLine();
		                    student updatedStudent = new student(idToUpdate, newName, newAge, newGrade);
		                    studentOperations.updateStudents(updatedStudent);
		                    break;

		                case 4:
		                    System.out.print("Enter student ID to delete: ");
		                    int idToDelete = scanner.nextInt();
		                    studentOperations.deleteStudents(idToDelete);
		                    break;
		                case 5:
		                	 System.out.print("Enter student name, ID, or grade to search: ");
		                	 String searchedKeyword=scanner.nextLine();
		                	 studentOperations.searchStudent(searchedKeyword);
		                	 break;
		                case 6:
		                    System.out.println(" Exiting... Thank you!");
		                    scanner.close();
		                    System.exit(0);

		                default:
		                    System.out.println(" Invalid choice! Try again.");
		            }
		}
		}
	public static void main(String[] args) {
		userService users=new userService();
		Scanner scanner = new Scanner(System.in);
		System.out.println("! STUDENT MANAGEMENT SYSTEM !");
		while(true) {
			System.out.println("1.Register \n2.Login");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter choice :");
			int option=sc.nextInt();
			switch(option) {
			case 1:
				users.Register();
				break;
			case 2:
				if(users.Login()) {
					start(sc);
           	}  
				break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
			}
		}
		
       
        }
    }
