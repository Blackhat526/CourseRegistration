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
			if(slno==1)
			{
				String database="use newregistration";
				stmt.executeUpdate(database);
				String table="create table Registration(Slno int,FullName varchar(45),PhoneNo varchar(45),"
						+ "Emailid varchar(45),Age int,Address varchar(45),Pass varchar(45))";
				stmt.executeUpdate(table);
			}
			String sql="Insert into Registration values('"+slno+"','"+reg.getFullName()+"','"+reg.getPhonenumber()+
					"','"+reg.getEmailId()+"',"+reg.getAge()+",'"+reg.getAddress()+"','"+reg.getPassword()+"');";
			slno++;
			stmt.executeUpdate(sql);
			System.out.println("Records inserted");
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}
