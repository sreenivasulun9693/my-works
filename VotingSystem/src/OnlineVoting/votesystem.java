package OnlineVoting;
import java.util.Scanner;
public class votesystem {
	 int age;
	 String name;
	 String party;
	int YSRCount,TDPCount,BJPCount,JANASENACount,CONGRESSCount,UKNOWNCount=0;
	Scanner sc=new Scanner(System.in);
	public void userRegistration() {
		System.out.print("Enter Your Name : ");
		name=sc.next().toUpperCase();
		System.out.print("Enter Your PhoneNumber : ");
		Long phone=sc.nextLong();
		System.out.print("Enter Your Age : ");
		age=sc.nextInt();
	}
	public void voteResults(String party) {
		if(party.equalsIgnoreCase("YSR")) {
			YSRCount++;
		}
		else if(party.equalsIgnoreCase("TDP")) {
			TDPCount++;
		}
		else if(party.equalsIgnoreCase("BJP")) {
			BJPCount++;
		}
		else if(party.equalsIgnoreCase("CONGRESS")) {
			CONGRESSCount++;
		}
		else if(party.equalsIgnoreCase("JANASENA")) {
			JANASENACount++;
		}
		else {
			UKNOWNCount++;
		}
	}
	public void resultsDisplay() {
		System.out.println("Final Results ");
		System.out.println("YSR Party : "+YSRCount);
		System.out.println("TDP Party : "+TDPCount);
		System.out.println("BJP Party : "+BJPCount);
		System.out.println("CONGRESS Party : "+CONGRESSCount);
		System.out.println("JANASENA Party : "+JANASENACount);
		System.out.println("UKNOWN Party : "+UKNOWNCount);	
	}
}
