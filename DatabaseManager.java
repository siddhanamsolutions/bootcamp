package com.scs.testcd;

import java.sql.*;

public class DatabaseManager {
    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "@";

    public void saveAccount(BankAccount acc) {
        // SQL query with placeholders (?) to prevent SQL Injection
        String sql = "INSERT INTO accounts (name, balance) VALUES (?, ?)";

        // try-with-resources automatically closes the connection
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, "John Doe"); // Setting the first '?'
            pstmt.setDouble(2, acc.getBalance()); // Setting the second '?'
            
            pstmt.executeUpdate();
            System.out.println("Account saved to Database!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void loadAccounts() {
		String sql = "SELECT * FROM accounts";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				String name = rs.getString("name");
				double balance = rs.getDouble("balance");
				System.out.println("Loaded: " + name + " with $" + balance);
			}
		} catch (SQLException e) { e.printStackTrace(); }
	}
}
