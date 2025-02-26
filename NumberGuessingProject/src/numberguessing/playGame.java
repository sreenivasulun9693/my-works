package numberguessing;
import java.util.Scanner;
public class playGame {
	int MaximumAttempts=5;
	Scanner sc=new Scanner(System.in);
	int secretNumber=1+(int)(100*Math.random());
	int attempts;
	public void playgame() {
	System.out.println("Welcome to Guess Number Game");
	System.out.println("You Will Be Asked TO Guess A Number To Win The Game");
	System.out.println("You have Maximum 5 Attempts Limit");
	for(attempts=0;attempts<MaximumAttempts;attempts++) {
		System.out.print("Enter Guess Number between 1 and 100 : ");
		int guess=sc.nextInt();
		if(secretNumber==guess) {
			System.out.println("OOhhOO!, Your Number is correct. You Win the Game");
			break;
		}
		else if(secretNumber>guess&&attempts!=MaximumAttempts-1) {
			System.out.println("Your guess Number is Lesser");
		}
		else if(secretNumber<guess&&attempts!=MaximumAttempts-1){
			System.out.println("Your Guess Number is Greater");
		}	
	}
	if(attempts==MaximumAttempts) {
		System.out.println("You have exahausted all "+MaximumAttempts+" attempts");
		System.out.println("The secret number was "+secretNumber);
	 }
  }
}