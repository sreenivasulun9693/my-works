package OnlineVoting;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		votesystem obj=new votesystem();
		Scanner sc=new Scanner(System.in);
		System.out.println("WELCOME TO VOTING SYSTEM!");
		obj.userRegistration();
		if(obj.age<=18) {
			System.out.println("You are not Eligible for Voting\n"+"You will wait untill "+(18-obj.age)+" yrs old.");
			System.exit(0);
		}
		else {
			while(true) {
				System.out.println("Please Select a Party To Vote For :\n"+"YSR\n"+"TDP\n"+"BJP\n"+"CONGRESS\n"+"JANASENA\n"+"UKNOWN");
				obj.party=sc.nextLine();
				switch(obj.party.toUpperCase()) {
				case "YSR":
					System.out.println("");
					break;
				case "TDP":
					System.out.println();
					break;
				case "BJP":
					System.out.println();
					break;
				case "CONGRESS":
					System.out.println();
					break;
				case "JANASENA":
					System.out.println();
					break;
				default:
					System.out.println("Unkown");
					break;
				}
				obj.voteResults(obj.party);
				obj.resultsDisplay();
				System.out.println("THANK YOU "+obj.name+" FOR VOTING TO TOUR PARTY!");
				System.exit(0);
				
			}	
		}	
	}
}
