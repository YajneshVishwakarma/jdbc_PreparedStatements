package com.alvas.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementSelect {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Enter the Student id you want to display");
		Scanner scan = new Scanner(System.in);
		int id = scan.nextInt();		
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		PreparedStatement pstmt =  con.prepareStatement("select * from student_details where id = ?");
		pstmt.setInt(1, id);
		ResultSet res = pstmt.executeQuery();
		
		ResultSetMetaData resmeta = res.getMetaData();
		
		int count = resmeta.getColumnCount();
		
		for(int i = 1; i<=count;i++)
		{
			System.out.print(resmeta.getColumnName(i)+" ");
		}
		System.out.println();
		
		while(res.next())
		{
			System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4));
		}

		pstmt.execute();
		
		con.close();
	}
}
