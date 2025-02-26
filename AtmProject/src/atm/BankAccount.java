package atm;

import java.util.Date;
import java.util.Scanner;

public class BankAccount {
	String name;
	String userName;
	String password;
	private Long accountNo=123456789123L;
	private Long mobileNo=8555879693L;
	Date date;
	float balance = 0;
	int transactions=0;
	String transactionHistory="";
	private int Pin=9693;
	float amount;
	Scanner sc=new Scanner(System.in);
	public void register() {
		System.out.print("Enter Name : ");
		String s1=sc.nextLine();
		name=s1;
		System.out.print("Enter UserName : ");
		String s2=sc.nextLine();
		userName=s2;
		System.out.print("Enter Password : ");
		String pass=sc.nextLine();
		password=pass;
		System.out.print("Enter Accountnumber : ");
		Long acc_num=sc.nextLong();
		acc_num=accountNo;
		System.out.println("Register Successfully."+"\n"+"Please login your account");	
	}
	public void login() {
		boolean value=false;
		System.out.print("Enter your UserName : ");
		String username=sc.nextLine();
		if(username.equals(userName)) {
			System.out.print("Enter Password : ");
			String Password=sc.nextLine();
			if(Password.equals(password)) {
				System.out.println("login Successfull");
				}
			else {
				System.out.println("Entered password is incorrect");
				}
			}	
		else {
			System.out.println("Invalid username");
			}	
		}
	public void withdraw() {
		 if (limitTransactions()) {
		if(pinValidation()) {
			System.out.print("Enter amount : ");
			amount=sc.nextFloat();
			if(amount<=balance) {
				transactions++;
				balance-=amount;
//				limitTransactions();
				System.out.println("Transaction succesfull");
				transactionHistory+="\nDate : "+new Date()+"\n"+"Rs:"+amount+" Debited\n"+"Avl bal : Rs:"+balance+"\n";
			}
			else {
				System.out.println("Insuffeciant Balance");
			}
			balanceCheck();
		}
	}
	}
	public void deposit() {
		 if (limitTransactions()) {
		  if(pinValidation()) {
			System.out.print("Enter amount : ");
			amount=sc.nextFloat();
			if(amount<=100000f) {
				transactions++;
				balance+=amount;
//				limitTransactions();
				System.out.println("Your money has been Successfully Deposited");
				transactionHistory+="\nDate : "+new Date()+"\n"+"Rs:"+amount+" Credited\n"+"Avl bal : Rs:"+balance+"\n";
			}
			else {
				System.out.println("Sorry. The limit is 100000 only");
				}
			balanceCheck();
		}
	}
	}
	public void transfer() {
		 if (limitTransactions()) {
		System.out.print("Enter Account Number : ");
		Long accno=sc.nextLong();
		if(accno.equals(accountNo)) {
			deposit();
		}
		else {
			System.out.print("Enter amount : ");
			amount=sc.nextFloat();
			if(pinValidation()) {
				if(amount<=balance) {
					transactions++;
					balance-=amount;
//					limitTransactions();
					System.out.println("Transaction successfull");
					transactionHistory+="\nDate : "+new Date()+"\n"+"Rs:"+amount+" Debited\n"+"Avl bal : Rs:"+balance+"\n";
				}
				else {
					System.out.println("Insuffeciant balance");
				}
			}
			balanceCheck();
		}
	}
	}
	public void CardLess() {
		 if (limitTransactions()) {
		System.out.print("Enter Mobile No : ");
		Long mobile=sc.nextLong();
		if(mobile.equals(mobileNo)) {
			System.out.print("Enter Account Number : ");
			Long accno=sc.nextLong();
			if(accno.equals(accountNo)) {
				System.out.print("Enter Amount : ");
				float amount=sc.nextFloat();
				if(pinValidation()) {
					if(amount<=100000f) {
						transactions++;
						balance+=amount;
						amount=balance;
//						limitTransactions();
						System.out.println("Transaction successful");
						transactionHistory+="\nDate : "+new Date()+"\n"+"Rs:"+amount+" Credited\n"+"Avl bal : Rs:"+balance+"\n";
				   }
					else {
						System.out.println("Limit is 100000rs only per transaction");
					}
				}
				balanceCheck();
			}
			else {
				System.out.println("Invalid Account Number");
			}
		}
		else {	
			System.out.println("Invalid Mobile Number");
		}
	}
  }
	public void checkBalance() {
		System.out.println("Your current balance is : "+balance);
}
public void transactionHistory() {
	if(transactions==0) {
		System.out.println("No transactions happened");
	}
	else {
		System.out.println(transactionHistory);
	}
}
public void balanceEnquiry() {
	System.out.print("Enter your PIN : ");
	int pin=sc.nextInt();
	if(Pin==pin) {
		System.out.println("Your current balance is : "+balance+"\nTHANK YOU ! VISIST AGAIN");
	}
}
public void setPin() {
	System.out.print("Enter New PIN : ");
	int PIN=sc.nextInt();
	Pin = PIN;
	System.out.println("Your Pin has been succefully changed");
}
	public boolean pinValidation() {
		System.out.print("Enter your PIN : ");
		int pin=sc.nextInt();
		if(pin==Pin) {
			return true;
		}
		else {
			System.out.println("Invalid Pin");
		}
		return false;
	}
	public void balanceCheck() {
		System.out.println("If you want to check your balance? \n Yes \n No");
		String option=sc.next();
		if(option.equalsIgnoreCase("Yes")) {
			checkBalance();	
			AtmMachine.main(null);
		}
		else {
			System.out.println("THANK YOU ! VISIT AGAIN");
			AtmMachine.main(null);
		}
	}
	public boolean limitTransactions() {
		if(transactions>=3) {
			System.out.println("Your Daily limit has been reached!");
			return false;
		}
		return true;
	}
}

