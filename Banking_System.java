//banking management system
package mini_project;
import java.util.Scanner;

interface Account {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();  
}

abstract class BankAccount implements Account {
    protected double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {

            balance -= amount;
        }
    

    public double getBalance() {
        return balance;
    }
}

class SavingAccount extends BankAccount {
    private final double interestRate;

    public SavingAccount(double initialBalance, double interestRate) {
        super(initialBalance);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest = balance * interestRate ;
        balance += interest;
        System.out.println("Interest added. New balance: " + balance);
    }
}

class CheckingAccount extends BankAccount {
    private static final double transaction_fee=1.00;
    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }
    
    public void withdraw(double amount) {
        if (balance>=amount+transaction_fee) {
          super.withdraw(amount+transaction_fee);
        }
        else{
            System.out.println("insufficicent fund for withdrawal");
        }
    }
}

public class Banking_System {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SavingAccount s1=new SavingAccount(1000,0.05);
        CheckingAccount c1=new CheckingAccount(500);

        System.out.println("Enter  amount for Saving Account:");
        double initialDeposit = sc.nextDouble();
        s1.deposit(initialDeposit);
        s1.addInterest();

        System.out.println("enter amount to deposit into checking account");
        double checkDeposit=sc.nextDouble();
        c1.deposit(checkDeposit);
        
        

        System.out.println("Enter the amount to withdraw from checking Account:");
        double amountToWithdraw = sc.nextDouble();
        c1.withdraw(amountToWithdraw);

        System.out.println("saving account balance "+s1.getBalance());
        System.out.println("checking account balance "+c1.getBalance());
 
        
        
    }
}


