package calculator;
import java.util.Scanner;
public class SimpleCalculator {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in); 
		 char  choice=' ';
	        System.out.println("|| Welcome to the Simple Calculator! ||");

	        do {
	           
	            System.out.print("Enter first number: ");
	            double num1 = sc.nextDouble();

	            System.out.print("Enter second number: ");
	            double num2 = sc.nextDouble();

	            
	            System.out.print("Choose operation (+, -, *, /, %): ");
	            char operation = sc.next().charAt(0);

	            double result = 0;

	            
	            switch (operation) {
	                case '+': 
	                	result = num1 + num2; 
	                	break;
	                case '-': 
	                	result = num1 - num2; 
	                	break;
	                case '*': 
	                	result = num1 * num2; 
	                	break;
	                case '/': 
	                    if (num2 != 0) {
	                        result = num1 / num2;
	                    } else {
	                        System.out.println(" Error! Division by zero is not allowed.");
	                        continue; 
	                    }
	                    break;
	                case '%': 
	                	result = num1 % num2; 
	                	break;
	                default:
	                    System.out.println(" Invalid operation! Please enter +, -, *, /, %.");
	                    continue; 
	            }
	            System.out.println(result);

	            System.out.print("Do you want to perform another calculation? (y/n): ");
	              choice = sc.next().charAt(0);

	        } while (choice == 'y' || choice == 'Y'); 

	        System.out.println(" Thank you for using the calculator! Have a great day! ");
	        sc.close(); 
	}
}
