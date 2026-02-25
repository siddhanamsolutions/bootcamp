package com.scs.testcd;

class BankAccount {
    private int accountno;
    private String customerName;
    private double balance; // Private to prevent direct tampering

    // Constructor to initialize the object


    public BankAccount(int accountno, String customerName, double balance) {
        this.accountno = accountno;
        this.customerName = customerName;
        this.balance = balance;
    }

    public int getAccountno() {
        return accountno;
    }

    public void setAccountno(int accountno) {
        this.accountno = accountno;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Method to deposit money (Logic)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(customerName + " deposited: $" + amount);
        }
    }

    // Method to withdraw money (Conditional flow)
    // Updated BankAccount method
	public synchronized void withdraw(double amount) {
		if (amount <= balance) {
			System.out.println(Thread.currentThread().getName() + " is withdrawing...");
			
			// Simulating processing time
			try { Thread.sleep(100); } catch (InterruptedException e) {}

			balance -= amount;
			System.out.println("Withdrawal successful. New Balance: " + balance);
		} else {
			System.out.println("Insufficient funds for " + Thread.currentThread().getName());
		}
	}


    // Getter to see the balance (Read-only access)
    public double getBalance() {
        return balance;
    }
}
