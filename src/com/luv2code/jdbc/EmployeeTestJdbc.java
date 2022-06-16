package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class EmployeeTestJdbc {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/hb_employee_tracker?useSSL=false&serverTimezone=UTC";
		String username = "hbemployee";
		String password = "hbemployee";
		
		try {
			
			System.out.println("Connecting to database: " + url);
			
			Connection connection = DriverManager.getConnection(url, username, password);
			
			System.out.println("Connection successful");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
