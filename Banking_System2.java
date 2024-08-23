package mini_project;
import java.util.Scanner;
 interface Account
  {
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
         class Banking_System2{
         public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Choose account type (checking/savings): ");
        String accountType = scanner.nextLine();

        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        if (accountType.equalsIgnoreCase("savings")) {
            System.out.print("Enter interest rate (e.g., 0.05 for 5%): ");
            double interestRate = scanner.nextDouble();
            account = new SavingAccount(initialBalance, interestRate);
        } else if (accountType.equalsIgnoreCase("checking")) {
            account = new CheckingAccount(initialBalance);
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("Choose an operation: ");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Add Interest (Savings Only)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit successful. New balance: " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    System.out.println("Withdrawal successful. New balance: " + account.getBalance());
                    break;
                case 3:
                    System.out.println("Current balance: " + account.getBalance());
                    break;
                case 4:
                    if (account instanceof SavingAccount) {
                        ((SavingAccount) account).addInterest();
                        System.out.println("Interest added. New balance: " + account.getBalance());
                    } else {
                        System.out.println("This operation is only available for savings accounts.");
                    }
                    break;
                case 5:
                    exit = true;
                    System.out.println("Thank you for using our banking system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}





        

        
    

