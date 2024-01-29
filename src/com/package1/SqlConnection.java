package com.package1;
import java.util.Scanner;
import java.sql.*;

public class SqlConnection {
	
	public static void Connection(Registration reg)
	{
		int slno=1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/NewRegistration","root","Admin@123");
			Statement stmt=con.createStatement();
			System.out.println("Inserting records");
			
//			if(slno==1 )
//			{
//				//String database="use newregistration";
//				//stmt.executeUpdate(database);
//				String table="create table Registration(Slno int,FullName varchar(45),PhoneNo varchar(45),"
//						+ "Emailid varchar(45),Age int,Address varchar(45),Pass varchar(45),Role varchar(45),ProStu varchar(45))";
//				stmt.executeUpdate(table);
//			}
			if(reg.getRole().equals("User") && reg.getProfStud().equals("Student"))
			{
			String sql="Insert into Registration values('"+slno+"','"+reg.getFullName()+"','"+reg.getPhonenumber()+
					"','"+reg.getEmailId()+"',"+reg.getAge()+",'"+reg.getAddress()+"','"+reg.getPassword()+"','"+reg.getRole()+"','"+reg.getProfStud()+"',"+reg.getId()+");";
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
					"','"+reg.getEmailId()+"',"+reg.getAge()+",'"+reg.getAddress()+"','"+reg.getPassword()+"','"+reg.getRole()+"','"+reg.getProfStud()+"',"+reg.getId()+");";
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
		int CourseSlno=1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/NewRegistration","root","Admin@123");
			Statement stmt=con.createStatement();
			//String table="create table Courses(Slno int,CourseName varchar(45),TimeDuration varchar(45),"
					//+ "Price int,Certificationavl boolean)";
			//stmt.executeUpdate(table);
			String Course="Insert into Courses values('"+CourseSlno+"','"+course.getCourseName()+"','"+course.getTimeDuration()+"','"
			+course.getPrice()+"','"+course.isCertificationavl()+"',"+course.getCourseId()+",'"+course.getHangleBy()+"');";
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
		int slno=1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/NewRegistration","root","Admin@123");
			//PrepareStatement stmt=con.createStatement();
			String query="Select * from courses;";
			PreparedStatement pstmt=con.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery(query);
			while(rs.next()==true)
			{
				//int slno=rs.getInt("Slno");
			    String CourseName=rs.getString("CourseName");
			    String CourseDuration=rs.getString("TimeDuration");
			    String CourseId=rs.getString("courseid");
			    int Price=rs.getInt("Price");
			    String HandledBy=rs.getString("HandledBy");
			    System.out.println(slno+" "+CourseName+" "+CourseDuration+"hrs"+" "+Price+" "+CourseId+" "+HandledBy);
			    slno++;
			}
			System.out.println("<<<<===========================>>>>");
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	public static void EnrollCourse(int CourseId,int StudentId)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/NewRegistration","root","Admin@123");
			Statement stmt=con.createStatement();
			//String createtable="Create table EnrolledCourses(StudentId int,CourseId int,StudentName varchar(45),HandledBy varchar(45),CourseName varchar(45),CourseDuration varchar(45));";
			//PreparedStatement ps= con.prepareStatement(createtable);
			//ps.executeUpdate(createtable);
			String StQuery="Select FullName from registration where UserId="+StudentId+";";
			PreparedStatement ps1 = con.prepareStatement(StQuery);
			ResultSet rs1=ps1.executeQuery(StQuery);
			rs1.next();
			String StudentFullName=rs1.getString("FullName");
			String CourseQuery="Select * from courses where courseid="+CourseId+";";
			PreparedStatement ps2 = con.prepareStatement(CourseQuery);
			ResultSet rs2=ps2.executeQuery(CourseQuery);
			rs2.next();
			String CourseName=rs2.getString("CourseName");
			String CourseDuration = rs2.getString("TimeDuration");
			String HandledBy=rs2.getString("Handledby");
			String Insert="Insert into EnrolledCourses values("+StudentId+","+CourseId+",'"+StudentFullName+"','"+HandledBy+"','"+CourseName+"','"+CourseDuration+"');";
			PreparedStatement ps3=con.prepareStatement(Insert);
			ps3.executeUpdate(Insert);
			System.out.println("You have successfully enrolled for the course.");
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public static void CoursesEnrolled()
	{
		int slno=1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/NewRegistration","root","Admin@123");
			//PrepareStatement stmt=con.createStatement();
			String query="Select * from EnrolledCourses";
			PreparedStatement pstmt=con.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery(query);
			while(rs.next()==true)
			{
				int StudentId=rs.getInt("StudentId");
				int CourseId=rs.getInt("CourseId");
				String StudentName=rs.getString("StudentName");
				String Handledby=rs.getString("HandledBy");
				String CourseName=rs.getString("CourseName");
				String CourseDuration=rs.getString("CourseDuration");
				System.out.println(slno+" "+StudentId+" "+CourseId+" "+StudentName+" "+Handledby+" "
						+CourseName+" "+CourseDuration);
				slno++;
			}
			System.out.println("<<<<===========================>>>>");
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public static void CoursesHandled(String ProfessorName)
	{
		int slno=1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/NewRegistration","root","Admin@123");
			String query="Select * from courses where Handledby='"+ProfessorName+"';";
			PreparedStatement pstmt=con.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery(query);
			while(rs.next()==true)
			{
			    String CourseName=rs.getString("CourseName");
			    String CourseDuration=rs.getString("TimeDuration");
			    String CourseId=rs.getString("courseid");
			    int Price=rs.getInt("Price");
			    //String HandledBy=rs.getString("HandledBy");
			    System.out.println(slno+" "+CourseName+" "+CourseDuration+"hrs"+" "+Price+" "+CourseId);
			    slno++;
			}
			System.out.println("<<<<===========================>>>>");
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public static void DeleteCourse(int courseid)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/NewRegistration","root","Admin@123");
			String deletequery="Delete from Courses where courseid="+courseid+";";
			//Statement stmt=con.createStatement();
			PreparedStatement pstmt=con.prepareStatement(deletequery);
			int rs=pstmt.executeUpdate(deletequery);
			//stmt.executeQuery(deletequery);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public static void UsersAvailable()
	{
		int Slno=1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/NewRegistration","root","Admin@123");
			String query="Select * from Registration";
			PreparedStatement pstmt=con.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery(query);
			while(rs.next()==true)
			{
				//int slno=rs.getInt("Slno");
			    String FullName=rs.getString("FullName");
			    String Emailid=rs.getString("Emailid");
			    String Pass=rs.getString("Pass");
			    int Id=rs.getInt("Userid");
			    //int Price=rs.getInt("Price");
			    System.out.println(Slno+" "+FullName+" "+Emailid+" "+Pass+" "+Id);
			    Slno++;
			}
			System.out.println("<<<<===========================>>>>");
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
 
	public static void DeleteUser(int Userid)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/NewRegistration","root","Admin@123");
			String deletequery="Delete from registration where UserId="+Userid+";";
			//Statement stmt=con.createStatement();
			PreparedStatement ps=con.prepareStatement(deletequery);
			int rs=ps.executeUpdate(deletequery);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public static void ChangePassword(String Emailid,String OldPassword,String NewPassword)
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/NewRegistration","root","Admin@123");
		Statement stmt=con.createStatement();
		String Query1="select exists(select count(*) from registration where Pass='"+OldPassword+"' and Emailid='"+Emailid+"')";
		PreparedStatement ps=con.prepareStatement(Query1);
		ResultSet rs=ps.executeQuery();
		rs.next();
		int count=rs.getInt(1);
		if(count>=1)
		{
			String Query2="update registration set Pass=replace(Pass,'"+OldPassword+"','"+NewPassword+"')";
			stmt.executeUpdate(Query2);
			System.out.println("Password change successfull");
		}
		else
		{
			System.out.println("Either your old Password or the email is incorrect, PLease check");
		}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	public static void ProvideGrades(int scores,String ProfessorName)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/NewRegistration","root","Admin@123");
//			String createquery="create table GradesProvided(StudentId int,CourseId int,StudentName varchar(45),CourseName varchar(45),HandledBy varchar(45),Scores integer not null check (Scores between 0 and 100));";
//			Statement stmt=con.createStatement();
//			stmt.executeUpdate(createquery);
			String query="Select * from EnrolledCourses where HandledBy='"+ProfessorName+"';";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs=ps.executeQuery(query);
			rs.next();
			int StudentId=rs.getInt("StudentId");
			int CourseId=rs.getInt("CourseId");
			String StudentName=rs.getString("StudentName");
			String CourseName=rs.getString("CourseName");
			String HandledBy=rs.getString("HandledBy");
			String Insert="Insert into GradesProvided values("+StudentId+","+CourseId+",'"+StudentName+"','"+CourseName+"','"+
					HandledBy+"',"+scores+");";
			Statement stmt=con.createStatement();
			stmt.executeUpdate(Insert);
			System.out.println("Scores provided Successfully");
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	public static void ViewScores()
	{
		int slno=1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/NewRegistration","root","Admin@123");
			String query="Select * from GradesProvided;";
			PreparedStatement pstmt=con.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery(query);
			while(rs.next()==true)
			{
				int StudentId=rs.getInt("StudentId");
				int CourseId=rs.getInt("CourseId");
				String StudentName=rs.getString("StudentName");
				String CourseName=rs.getString("CourseName");
				String HandledBy=rs.getString("HandledBy");
				int Scores=rs.getInt("Scores");
				System.out.println(slno+" "+StudentId+" "+CourseId+" "+StudentName+" "+CourseName+" "+
				HandledBy+" "+Scores);
				slno++;
			}
			System.out.println("<<<<===========================>>>>");
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public static void Reportcard(int StudentId)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/NewRegistration","root","Admin@123");
			String query="Select * from GradesProvided where StudentId='"+StudentId+"';";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs=ps.executeQuery(query);
			rs.next();
			//{
			//int Studentid=rs.getInt("StudentId");
				int CourseId=rs.getInt("CourseId");
				String StudentName=rs.getString("StudentName");
				String CourseName=rs.getString("CourseName");
				String HandledBy=rs.getString("HandledBy");
				int Scores = rs.getInt("Scores");
			//}
			System.out.println("               "+StudentName);
			System.out.println("Congratulations!!! ");
			System.out.println("on completing the "+CourseName+" course,");
			System.out.println("under the guidence of "+HandledBy);
			System.out.println("with an overall percentage of "+Scores);
			System.out.println("<<<<===========================>>>>");
			System.out.println("***********************************");
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}
