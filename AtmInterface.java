import java.util.*;
class Account
{
	Scanner sc = new Scanner(System.in);
	double bal=500;
	int acc,prevTrans,flag=0;
	String name,id;
	Account()
	{
	}
	Account(String n,String i)
	{
		name = n;
		id = i;
	}
	void login()
	{
		System.out.println("Enter your customer ID:");
		String s = sc.nextLine();
		if(s.equals(id))
		{
			System.out.println("\n\t\tLogin successfully\n\t\tWelcome "+name+"!\n");
			menu();
		}
		else
		{
			flag++;
			System.out.println("\tOops! Login unsuccessful\n\tTry Again!");
			if(flag<=2)
			{
				login();
			}
		}
		if(flag==3)
		{
			System.out.println("You have exceeded number of tries!");
			System.exit(0);
		}	
	}
	public void menu()
	{
		int ch;
		do
		{
			System.out.println("Enter your choice: \n1.Transaction history \n2.Withdraw ");
			System.out.println("3.Deposit \n4.Transfer \n5.View balance \n6.Quit");
			ch = sc.nextInt();
			System.out.println();
			switch(ch)
			{
				case 1:		//transaction history
					PrevTrans();
					break;
				case 2:		//withdraw
					System.out.println("Enter amount:");
					int amtW = sc.nextInt();
					if(amtW>bal)
					{
						System.out.println("Insufficient balance!");
						break;
					}
					withdraw(amtW);
					break;
				case 3:		//deposit
					System.out.println("Enter amount:");
					int amtD = sc.nextInt();
					deposit(amtD);
					break;
				case 4:		//transfer
					Account b1 = new Account("vicky","345");
					System.out.println("Transfering amount to "+b1.name);
					System.out.println();
					System.out.println("Enter amount:");
					double amtT = sc.nextDouble();
					if(amtT>bal)
					{
						System.out.println("Insufficient balance check for balance!");
						break;
					}
					transfer(amtT,b1);
					break;
				case 5:		//Balance info
					System.out.println("Your current balance is: Rs."+bal);
					break;
				case 6:		//quit
					System.out.println("\tThank you visit again! \n\tBye!");
					System.exit(0);
				default:
					System.out.println("Enter a valid choice!");
					break;
			}
		}while(ch!=6);
	}
	void withdraw(int amt)
	{
		bal-=amt;
		prevTrans=-amt;
		System.out.println("Amount withdrawn succuessfully!");
	}
	void deposit(int amt)
	{
		bal+=amt;
		prevTrans=amt;
		System.out.println("Amount deposited successfully!");
	}
	void PrevTrans()
	{
		if(prevTrans>0)
			System.out.println("You deposited Rs."+prevTrans);
		else if(prevTrans<0)
			System.out.println("You withdrawn Rs."+(-1*prevTrans));
		else
			System.out.println("You have not done any transaction yet");
	}
	void transfer(double amt,Account b1)
	{
		bal-=amt;
		b1.bal+=amt;
		System.out.println("Your balance is Rs."+bal);
		System.out.println(b1.name+"'s balance is Rs."+b1.bal);
	}
}

class AtmInterface
{
	public static void main(String args[])
	{
		Account b = new Account("robin","1234");
		b.login();
	}
}
