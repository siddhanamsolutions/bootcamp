package com.scs.testcd;

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(int accountno, String name, double initialDeposit, double rate) {
        // 'super' calls the constructor of the Parent class (BankAccount)
        super(accountno, name, initialDeposit);
        this.interestRate = rate;
    }

    // New behavior: Apply interest to the current balance
    public void applyInterest() {
        double interest = getBalance() * (interestRate / 100);
        deposit(interest); // Reusing the deposit method from the parent!
        System.out.println("Interest applied: $" + interest);
    }
}
