package com.alvas.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementsDelete {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		PreparedStatement pstmt =  con.prepareStatement("delete from student_details where id = ?");
		
		System.out.println("Enter the Student id you want to delete");
		Scanner scan = new Scanner(System.in);
		int id = scan.nextInt();
		
		pstmt.setInt(1, id);
		
		System.out.println("Values Deleted!!!");
		pstmt.execute();
		
		con.close();
	}
}
