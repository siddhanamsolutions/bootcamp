package com.scs.testcd;

import javax.xml.crypto.Data;

public class TestBankingApp {
    public static void main(String[] args) {
        // Creating an Object (Instance of the Class)
        BankAccount myAccount1 = new SavingsAccount(123,"Alex", 500.0,5);
        BankAccount myAccount2 = new SavingsAccount(234,"John", 100.0,5);
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.saveAccount(myAccount1);
        databaseManager.saveAccount(myAccount2);
        System.out.println("Both the accounts created in database...");
    }
}