class Wallet {
    
    private double balance;


    static double cashbackRate = 0.02; 

    
    public Wallet() {
        balance = 0;
    }


    public double getBalance() {
        return balance;
    }


    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    
    public void transferTo(Wallet receiver, double amount) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Invalid amount");
            }

            if (balance < amount) {
                throw new Exception("Insufficient balance");
            }

            
            balance -= amount;

            
            receiver.balance += amount;

            
            double cashback = amount * cashbackRate;
            balance += cashback;

            System.out.println("Transaction successful!");
            System.out.println("Cashback received: " + cashback);

        } catch (IllegalArgumentException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }
}


public class Main {
    public static void main(String[] args) {

        Wallet w1 = new Wallet();
        Wallet w2 = new Wallet();

        
        w1.deposit(1000);

        
        w1.transferTo(w2, 300);

        
        System.out.println("\nFinal Balances:");
        System.out.println("Wallet 1 Balance: " + w1.getBalance());
        System.out.println("Wallet 2 Balance: " + w2.getBalance());
    }
}