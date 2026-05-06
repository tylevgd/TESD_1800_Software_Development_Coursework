import java.util.Date;

class Account {
    private int id;
    private double balance;
    private static double annualInterestRate;
    private Date dateCreated;

    Account() {
        this.id = 0;
        this.balance = 0;
        this.dateCreated = new Date();
    }

    Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = new Date();
    }

    int getId() { return id; }
    void setId(int id) { this.id = id; }

    double getBalance() { return balance; }
    void setBalance(double balance) { this.balance = balance; }

    static double getAnnualInterestRate() { return annualInterestRate; }
    static void setAnnualInterestRate(double rate) { annualInterestRate = rate; }

    Date getDateCreated() { return dateCreated; }

    double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }

    void withdraw(double amount) {
        balance -= amount;
    }

    void deposit(double amount) {
        balance += amount;
    }
}

public class TestAccount {
    public static void main(String[] args) {
        Account account = new Account(1122, 20000);
        Account.setAnnualInterestRate(4.5);

        account.withdraw(2500);
        account.deposit(3000);

        System.out.printf("Balance: $%.2f%n", account.getBalance());
        System.out.printf("Monthly Interest: $%.2f%n", account.getMonthlyInterest());
        System.out.println("Date Created: " + account.getDateCreated());
    }
}
