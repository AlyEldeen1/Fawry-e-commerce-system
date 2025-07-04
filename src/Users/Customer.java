package Users;

public class Customer {
    private final String name ;
    private double balance;

    public Customer(String name ,double balance) {
        this.balance = balance;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }
    public boolean charge(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            System.out.println(" Insufficient balance- Available: " + balance + " Required: " + amount);
            return false;
        }
    }

    public void printBalance() {
        System.out.println(" Current balance: " + balance);
    }
}
