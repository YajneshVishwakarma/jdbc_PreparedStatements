package com.alvas.jdbc;

import java.sql.*;
import java.util.Scanner;

public class PreparedStatementsInsert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		PreparedStatement pstmt =  con.prepareStatement("insert into student_details values(?,?,?,?)");
		
		System.out.println("Enter the Student id, name, mail, phone number");
		Scanner scan = new Scanner(System.in);
		int id = scan.nextInt();
		String name = scan.next();
		String email = scan.next();
		String phone = scan.next();
		
		pstmt.setInt(1, id);
		pstmt.setString(2,name);
		pstmt.setString(3, email);
		pstmt.setString(4, phone);
		
		System.out.println("Values Added!!!");
		pstmt.execute();
		
		
		
		con.close();
	}
}
