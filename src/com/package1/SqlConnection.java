package com.package1;
import java.util.Scanner;
import java.sql.*;

public class SqlConnection {

	public static void Connection(int slno,Registration reg)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/NewRegistration","root","Admin@123");
			Statement stmt=con.createStatement();
			System.out.println("Inserting records");
			String sql="Insert into NewRegistration values('"+slno+"','"+reg.getFullName()+"','"+reg.getPhonenumber()+
					"','"+reg.getEmailId()+"',"+reg.getAge()+",'"+reg.getAddress()+"','"+reg.getPassword()+"');";
			//String sql="Insert into NewRegistration values(1,'Akash','9998887776','abcd',22,'acd_avenue','abcdefg')";
			stmt.executeUpdate(sql);
			System.out.println("Records inserted");
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}
