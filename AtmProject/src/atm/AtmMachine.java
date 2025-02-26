package atm;

import java.util.Scanner;

public class AtmMachine {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		BankAccount unionbank=new BankAccount();
		System.out.println("State Bank of India");
		while(true) {
			System.out.println("  INSERT YOUR CARD");
			System.out.println("  CARDLESS DEPOSIT");
			String option=sc.nextLine();
			switch(option.toUpperCase()) {
				case "CARDLESS DEPOSIT":
					unionbank.CardLess();
					break;
				case "INSERT YOUR CARD":	
					insertCard(unionbank);
					break;
				default:
					System.out.println("Invalid transaction");
					break;
			}
		}
	 }
		public static void insertCard(BankAccount unionbank) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Select your language"+"\n"+"-> English"+"\n"+"-> Telugu");
			String lang=sc.nextLine();
			if(lang.equalsIgnoreCase("English")) {
				while(true) {
					System.out.println("\nAVAILABLE TRANSACTIONS\n");
					System.out.println("     SELECT TRASANCTION\n");
					System.out.println("  DEPOSIT"+"\t"+"  WITHDRAW"+"\n"
				+"  TRANSFER"+"\t"+"  BALANCE ENQUIRY"+"\n"
				+"  PIN CHANGE"+"\t"+"  MINI STATEMENT"+"\n"
				+"  OTHERS");
					String options=sc.nextLine();
				switch(options.toUpperCase()) {
					case "DEPOSIT":
						unionbank.deposit();
						break;
					case "WITHDRAW":
						unionbank.withdraw();
						break;
					case "TRANSFER":
						unionbank.transfer();
						break;
					case "BALANCE ENQUIRY":
						unionbank.balanceEnquiry();
						break;
					case "PIN CHANGE":
						unionbank.setPin();
						break;
					case "MINI STATEMENT":
						unionbank.transactionHistory();
						break;
					case "OTHERS":
						unionbank.deposit();
						break;
					default:
						System.out.println("Invalid Transaction");
						break;
					}
				}	
		  }
   }
}
