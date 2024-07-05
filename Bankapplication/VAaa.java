package basicss;
import java.util.*;
public class VAaa {
	public static void main(String[] args) 
	{
		BankAccount Account;
		StoreUser User=new StoreUser();
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("\t\t\t\t\t\tENTER THE BELOW DETAILS FOR ACCESS YOUR BANK ACCOUNT(MUST BE IN CAPITAL LETTERS)");
			System.out.print("CUSTOMER NAME:");
			String Name=sc.nextLine();
			boolean y=false;
				for (int i=0;i<User.user.length;i++)
				{
					if(Name.equals(User.user[i][0]))
					{
							y=true;
							System.out.print("CUSTOMER ID:");
							String CustomerID=sc.nextLine();
							if(CustomerID.equals(User.user[i][1]))
							{
							    Account=new BankAccount(Name,CustomerID);
							    Account.Main(User,i);
							    break;
							}
							else
							{
								System.out.println("\t\t\t\t\t\t\t\t\t\tINCORRECT CUSTOMER ID!");
							}	
					}
				}

			if(!y)
			{
				System.out.print("YOUR ARE A NEW USER!!\nEnter CUSTOMER ID TO CREATE ACCOUNT : ");
				String CustomerID=sc.nextLine();
				User.addUser(Name, CustomerID);
			}
		}
	}
}
class BankAccount
{
	double Balance;
	double PreviousTransaction;
	String CustomerName;
	String CustomerID;
    BankAccount(String CustomerName, String CustomerID) 
	{
		this.CustomerName = CustomerName;
		this.CustomerID = CustomerID;
	}
	void Deposit(double amount,StoreUser User,int i)
	{
		if(amount>0)
		{
			Balance+=amount;
			User.user[i][2]=Double.toString(Balance);
			User.user[i][3]=Double.toString(amount);
			User.user[i][4]="D";
			
		}
	}
	void Withdraw(double amount1,StoreUser User,int i)
	{
		Balance=Double.parseDouble(User.user[i][2]);
		if( amount1!=0 && Balance>=amount1)
		{
			Balance-=amount1;
			User.user[i][2]=Double.toString(Balance);
			User.user[i][3]=Double.toString(amount1);
			User.user[i][4]="W";
			
		}
		else if(Balance<amount1)
		{
			System.out.println("INSUFFICIENT BANK BALANCE");
		}
	}
	void getPreviousTransaction(StoreUser User, int i)
	{
		if(User.user[i][4].equals("O"))
		{
			System.out.println("\tNO PREVIOUS TRANSACTIONS ARE OCCURED");
			
		}
		else if(User.user[i][4].equals("W"))
		{
			System.out.println("\tWithdrawn: "+User.user[i][3]);
		}
		else if(User.user[i][4].equals("D"))
		{
			System.out.println("\tDeposited:"+User.user[i][3]);
		}
	}
	void Main(StoreUser User, int i)
	{
		Scanner sc=new Scanner(System.in);
		int option;
		System.out.println("WELCOME "+CustomerName);
		System.out.println("YOUR CUSTOMER ID: "+CustomerID);
		do
		{ 
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("WELCOME TO OUR BANKING SERVICES");
			System.out.println("\t1)CHECK BALANCE");
			System.out.println("\t2)DEPOSIT MONEY");
			System.out.println("\t3)WITHDRAW MONEY");
			System.out.println("\t4)PREVIOUS TRANSACTION");
			System.out.println("\t5)EXIT");
			System.out.print("\tCHOOSE AN OPTION : ");
			option=sc.nextInt();
			switch(option)
			{
			case 1:
				System.out.println("YOUR ACCOUNT BALANCE:"+User.user[i][2]);
				break;
			case 2:
				System.out.print("ENTER AMOUNT TO DEPOSIT INTO YOUR BANK ACCOUNT : ");
				double amount=sc.nextDouble();
				Deposit(amount,User,i);
				break;
			case 3:
				System.out.print("ENTER AMOUNT TO WITHDRAW FROM YOUR BANK ACCOUNT : ");
				double amount1=sc.nextDouble();
				Withdraw(amount1,User,i);
				break;
			case 4:
				System.out.println("PREVIOUS TRANSACTION :");
				getPreviousTransaction(User,i);
				break;
			case 5:
				System.out.println();
				break;
		    default:
					System.out.println("CHOOSE CORRECT OPTION TO PROCEED");
					break;
			}
		}while(option!=5);
		System.out.println("   "+"\t\t\t\t\t\t\t\t\tTHANK YOUR FOR USING OUR BANKING SERVICES");
		System.out.println();
		System.out.print("\t\t\t\t\t\t\t\t\t\t\t");
		System.out.println("  *****");
		System.out.println();
	}
}
class StoreUser
{
	int i=3;
	String user[][]=new String[50][5];
	{
		user[0][0]="SATYA";
		user[0][1]="22B95A0419";
		user[0][2]="0";
		user[0][3]="0";
		user[0][4]="O";
		
		user[1][0]="TIRUMALA RAO";
		user[1][1]="22B95A0423";
		user[1][2]="0";
		user[1][3]="0";
		user[1][4]="O";
		
		user[2][0]="SAI TEJA";
		user[2][1]="21B91A04P1";
		user[2][2]="0";
		user[2][3]="0";
		user[2][4]="O";	
	}
	void addUser(String name,String id){
		this.user[i][0]=name;
		this.user[i][1]=id;
		this.user[i][2]="0";
		this.user[i][3]="0";
		this.user[i][4]="O";
		this.i++;		
	}
}