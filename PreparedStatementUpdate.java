package com.alvas.jdbc;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementUpdate {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");		

		System.out.println("Enter the value you want to change\n1.name\n2.email\n3.phone");
		Scanner scan = new Scanner(System.in);
		int key =  scan.nextInt();
		PreparedStatement pstmt;

		switch (key) {
		case 1:
			System.out.println("Enter the id");
			int id = scan.nextInt();
			System.out.println("Enter your name");
			String name =  scan.next();			
			pstmt =  con.prepareStatement("update student_details set name = ? where id = ?");
			pstmt.setString(1, name);
			pstmt.setInt(2, id);
			System.out.println("Values Updated!!!");
			pstmt.execute();
			break;
		case 2:
			System.out.println("Enter the id");
			id = scan.nextInt();			
			System.out.println("Enter your email");
			String email =  scan.next();
			pstmt =  con.prepareStatement("update student_details set email = ? where id = ?");
			pstmt.setString(1, email);
			pstmt.setInt(2, id);
			System.out.println("Values Updated!!!");
			pstmt.execute();
			break;
		case 3:
			System.out.println("Enter the id");
			id = scan.nextInt();
			System.out.println("Enter your phone");
			String phone =  scan.next();
			pstmt =  con.prepareStatement("update student_details set phone = ? where id = ?");
			pstmt.setString(1, phone);
			pstmt.setInt(2, id);
			System.out.println("Values Updated!!!");
			pstmt.execute();
			break;
		default:
			break;
		}
		

		
	}
}
