package com.package1;
import java.util.Scanner;
import java.sql.*;

public class SqlConnection {

	static int slno=1;
	static int CourseSlno=1;
	public static void Connection(Registration reg)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/NewRegistration","root","Admin@123");
			Statement stmt=con.createStatement();
			System.out.println("Inserting records");
			
			if(slno==1 )
			{
				//String database="use newregistration";
				//stmt.executeUpdate(database);
//				String table="create table Registration(Slno int,FullName varchar(45),PhoneNo varchar(45),"
//						+ "Emailid varchar(45),Age int,Address varchar(45),Pass varchar(45),Role varchar(45),ProStu varchar(45))";
//				stmt.executeUpdate(table);
			}
			if(reg.getRole().equals("User") && reg.getProfStud().equals("Student"))
			{
			String sql="Insert into Registration values('"+slno+"','"+reg.getFullName()+"','"+reg.getPhonenumber()+
					"','"+reg.getEmailId()+"',"+reg.getAge()+",'"+reg.getAddress()+"','"+reg.getPassword()+"','"+reg.getRole()+"','"+reg.getProfStud()+"');";
			slno++;
			stmt.executeUpdate(sql);
			System.out.println("Records inserted");
			}
			else
			{
				SqlConnection con1 = new SqlConnection();
				boolean res1=con1.AdminTableRegistration(slno,reg);
			}
			
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public static boolean AdminLoginConfirmation(String Email,String Pass)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/NewRegistration","root","Admin@123");
			Statement stmt=con.createStatement();
			String sql="Select * from Admin where Emailid=? and Pass=? and Role='Admin'";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,Email);
			pstmt.setString(2,Pass);
			ResultSet res = pstmt.executeQuery();
			if(res.next()==false)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return false;
	}
	
	public static boolean AdminTableRegistration(int slno,Registration reg)
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/NewRegistration","root","Admin@123");
			Statement stmt=con.createStatement();
//			String table="create table Admin(Slno int,FullName varchar(45),PhoneNo varchar(45),"
//					+ "Emailid varchar(45),Age int,Address varchar(45),Pass varchar(45),Role varchar(45),ProStu varchar(45))";
//			stmt.executeUpdate(table);
			String update="Insert into Admin values('"+slno+"','"+reg.getFullName()+"','"+reg.getPhonenumber()+
					"','"+reg.getEmailId()+"',"+reg.getAge()+",'"+reg.getAddress()+"','"+reg.getPassword()+"','"+reg.getRole()+"','"+reg.getProfStud()+"');";
			slno++;
			stmt.executeUpdate(update);
			System.out.println("Admin Records inserted");
			return true;
		
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return false;
	}
	
	public static boolean UserLoginConfirmation(String Email,String Pass)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/NewRegistration","root","Admin@123");
			Statement stmt=con.createStatement();
			String sql="Select * from Registration where Emailid=? and Pass=? and Role='User'";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,Email);
			pstmt.setString(2,Pass);
			ResultSet res = pstmt.executeQuery();
			if(res.next()==false)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return false;
	}
 
	public static boolean StudentLoginConfirmation(String Email,String Pass)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/NewRegistration","root","Admin@123");
			Statement stmt=con.createStatement();
			String sql="Select * from Registration where Emailid=? and Pass=? and Role='User' and ProStu='Student'";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,Email);
			pstmt.setString(2,Pass);
			ResultSet res = pstmt.executeQuery();
			if(res.next()==false)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return false;
	}
	
	public static boolean ProfessorLoginConfirmation(String Email,String Pass)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/NewRegistration","root","Admin@123");
			Statement stmt=con.createStatement();
			String sql="Select * from Admin where Emailid=? and Pass=? and Role='Admin' and ProStu='Professor'";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,Email);
			pstmt.setString(2,Pass);
			ResultSet res = pstmt.executeQuery();
			if(res.next()==false)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return false;
	}

	public static boolean CourseRegistration(courses course)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/NewRegistration","root","Admin@123");
			Statement stmt=con.createStatement();
			//String table="create table Courses(Slno int,CourseName varchar(45),TimeDuration varchar(45),"
					//+ "Price int,Certificationavl boolean)";
			//stmt.executeUpdate(table);
			String Course="Insert into Courses values('"+CourseSlno+"','"+course.getCourseName()+"','"+course.getTimeDuration()+"','"
			+course.getPrice()+"','"+course.isCertificationavl()+"')";
			stmt.executeUpdate(Course);
			return true;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return false;
	}

	public static void CoursesAvailable()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/NewRegistration","root","Admin@123");
			//PrepareStatement stmt=con.createStatement();
			String query="Select * from courses;";
			PreparedStatement pstmt=con.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery(query);
			while(rs.next()==true)
			{
				int slno=rs.getInt("Slno");
			    String CourseName=rs.getString("CourseName");
			    String CourseDuration=rs.getString("TimeDuration");
			    int Price=rs.getInt("Price");
			    System.out.println(slno+" "+CourseName+" "+CourseDuration+"hrs"+" "+Price);
			}
			System.out.println("<<<<===========================>>>>");
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	public static void UsersAvailable()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/NewRegistration","root","Admin@123");
			String query="Select * from Registration";
			PreparedStatement pstmt=con.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery(query);
			while(rs.next()==true)
			{
				int slno=rs.getInt("Slno");
			    String FullName=rs.getString("FullName");
			    String Emailid=rs.getString("Emailid");
			    String Pass=rs.getString("Pass");
			    //int Price=rs.getInt("Price");
			    System.out.println(slno+" "+FullName+" "+Emailid+" "+Pass);
			}
			System.out.println("<<<<===========================>>>>");
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}
