package com.package1;
import java.util.Scanner;

import com.sun.tools.javac.Main;

public class Login {
	
	   static boolean Alreadylogedin=false;
       public static void AdminLogin() //throws Exception
       {
    	   try {
    		   Scanner scan= new Scanner(System.in);
    		   System.out.println("Enter the EmailId: ");
    		   String emialid=scan.next();
    		   System.out.println("Enter the Password");
    		   String password=scan.next();
    		   //login confirmation.
    		   SqlConnection log=new SqlConnection();
    		   boolean res=log.AdminLoginConfirmation(emialid,password);
    		   if(res==true)
    		   {
    			   System.out.println("Login Successfull");
	    		   System.out.println("1. Register Professor");
	    		   System.out.println("2. Register User");
	    		   System.out.println("3. Register Courses");
	    		   System.out.println("4. View Courses");
	    		   System.out.println("5. View Users");
	    		   System.out.println("6. Delete Courses");
	    		   System.out.println("7. Delete Users");
	    		   System.out.println("8. Return to Main Menu");
	    		   int adminlogin=scan.nextInt();
	    		   switch(adminlogin)
	    		   {
			    		   case 1:
			    				Registration reg=new Registration();
			    				System.out.println("<<<<===========================>>>>");
			    		    	System.out.println("Welcome to the Professor registration page!!!");
			    		    	System.out.println("Please enter your FullName: ");
			    		    	reg.setFullName(scan.next());
			    		    	System.out.println("Please enter your Phone Number: ");
			    		    	reg.setPhonenumber(scan.next());
			    		    	System.out.println("Please enter your Email Id: ");
			    		    	reg.setEmailId(scan.next());
			    		    	System.out.println("Please enter your Age: ");
			    		    	reg.setAge(scan.nextInt());
			    		    	System.out.println("Please enter your Address: ");
			    		    	reg.setAddress(scan.next());
			    		    	System.out.println("Please enter your Password: ");
			    		    	reg.setPassword(scan.next());
			    		    	System.out.println("Registering as a User of an Admin");
			    		    	String role=scan.next();
			    		    	//reg.Role=scan.next();
			    		    	if(role.equals("User"))
			    		    	{
			    		    		reg.setRole(role);
			    		    	}
			    		    	else if(role.equals("Admin"))
			    		    	{
			    		    		reg.setRole(role);
			    		    	}
			    		    	else
			    		    	{
			    		    		System.out.println("Invalid input");
			    		    		AdminLogin();
			    		    	}
			    		    	reg.setProfStud("Professor");
			    		    	SqlConnection con = new SqlConnection();
			    		    	con.Connection(reg);
			    			   break;
	    			   
			    		   case 2:
			    			    Registration reguser=new Registration();
			    				System.out.println("<<<<===========================>>>>");
			    		    	System.out.println("Welcome to the User registration page!!!");
			    		    	System.out.println("Please enter your FullName: ");
			    		    	reguser.setFullName(scan.next());
			    		    	System.out.println("Please enter your Phone Number: ");
			    		    	reguser.setPhonenumber(scan.next());
			    		    	System.out.println("Please enter your Email Id: ");
			    		    	reguser.setEmailId(scan.next());
			    		    	System.out.println("Please enter your Age: ");
			    		    	reguser.setAge(scan.nextInt());
			    		    	System.out.println("Please enter your Address: ");
			    		    	reguser.setAddress(scan.next());
			    		    	System.out.println("Please enter your Password: ");
			    		    	reguser.setPassword(scan.next());
			    		    	reguser.setRole("User");
			    		    	System.out.println("Registering as a Student or a Professor?");
			    		    	String Prostu=scan.next();
			    		    	if(Prostu=="Student")
			    		    	{
			    		    		reguser.setProfStud("Student");
			    		    	}
			    		    	else
			    		    	{
			    		    		reguser.setProfStud("Professor");
			    		    	}
			    		    	SqlConnection con1 = new SqlConnection();
			    		    	con1.Connection(reguser);
			    			   break;
			    			   
			    		   case 3:
			    			   courses course=new courses();
			    			   System.out.println("<<<<===========================>>>>");
			    		       System.out.println("Welcome to the Course registration page!!!");
			    		       System.out.println("Enter the name of the course to be registered");
			    		       course.setCourseName(scan.next());
			    		       System.out.println("Enter the time duration of the course in hours");
			    		       course.setTimeDuration(scan.nextInt());
			    		       System.out.println("Enter the price of the course");
			    		       course.setPrice(scan.nextInt());
			    		       System.out.println("Enter Yes if certification is available for this course otherwise enter No");
			    		       String certi=scan.next();
			    		       if(certi.equals("Yes"))
			    		       {
			    		    	   course.setCertificationavl("Yes");
			    		       }
			    		       else
			    		       {
			    		    	   course.setCertificationavl("No");
			    		       }
			    			   SqlConnection con2 = new SqlConnection();
			    			   boolean coursesuccess=con2.CourseRegistration(course);
			    			   if(coursesuccess==true)
			    			   {
			    				   System.out.println("Course registration successfull");
			    				   Alreadylogedin=true;
			    				   AdminLogin();
			    			   }
			    			   else
			    			   {
			    				   System.out.println("Course registration failed");
			    				   Alreadylogedin=true;
			    				   AdminLogin();
			    			   }
			    			   break;
			    			   
			    		   case 4:
			    			   System.out.println("<<<<===========================>>>>");
			    			   System.out.println("Courses available");
			    			   SqlConnection viewcourses = new SqlConnection();
			    			   viewcourses.CoursesAvailable();
			    			   AdminLogin();
			    			   break;
			    			   
			    		   case 5:
			    			   System.out.println("<<<<===========================>>>>");
			    			   System.out.println("View Courses");
			    			   SqlConnection viewusers = new SqlConnection();
			    			   viewusers.UsersAvailable();
			    			   AdminLogin();
			    			   break;
			    			   
			    		   case 6:
			    			   break;
			    			   
			    		   case 7:
			    			   break;
			    			   
			    		   case 8:
			    			   MainApp.main(null);
			    			   break;
			    			   
			    		default:
			    			System.out.println("Invalid Input");
			    			AdminLogin();
			    		    break;
	    		   }
    		   }
    		   else
    		   {
    			   System.out.println("Login Failed");
    			   AdminLogin();
    		   }
    	   }
    	   catch(Exception ex){
    		   System.out.println(ex.getMessage());
    	   }
       }
       
       public static void UserLogin()
       {
    	   try {
    		   Scanner scan= new Scanner(System.in);
    		   System.out.println("Enter the EmailId: ");
    		   String emialid=scan.next();
    		   System.out.println("Enter the Password");
    		   String password=scan.next();
    		   SqlConnection log=new SqlConnection();
    		   boolean res=log.UserLoginConfirmation(emialid,password);
    		   if(res==true)
    		   {
    			   System.out.println("User Login Successfull");
    			   System.out.println("1.Student Login");
    			   System.out.println("2.Professor Login");
    			   int user=scan.nextInt();
    			   if(user==1)
    			   {
    				   System.out.println("Please enter your EmailId");
    				   String emialId=scan.next();
    				   System.out.println("Please enter your Password");
    				   String Password=scan.next();
    				   boolean student=log.StudentLoginConfirmation(emialId,Password);
    				   if(student==true)
    				   {
    					   System.out.println("Student login successfull");
    					   System.out.println("1.Enroll for the course");
    					   System.out.println("2.View Courses");
    					   System.out.println("3.View Enrolled courses");
    					   System.out.println("4.Change password");
    					   System.out.println("5.View Scores");
    					   System.out.println("6.View Total report card");
    					   System.out.println("7.Main Menu");
    					   int student1=scan.nextInt();
    					   switch(student1)
    					   {
    					   case 1:
    						   break;
    						   
    					   case 2:
    						   break;
    						   
    					   case 3:
    						   break;
    						   
    					   case 4:
    						   break;
    						   
    					   case 5:
    						   break;
    						   
    					   case 6:
    						   break;
    						   
    					   case 7:
    						   MainApp.main(null);
    						   break;
    						   
    					  default:
    						  System.out.println("Invalid Input");
    						  UserLogin();
    						  break;
    					   }
    				   }
    			   }
    			   else if(user==2)
    			   {
    				   //professor login
    				   System.out.println("Please enter your EmailId");
    				   String emialId=scan.next();
    				   System.out.println("Please enter your Password");
    				   String Password=scan.next();
    				   boolean professor=log.ProfessorLoginConfirmation(emialId,Password);
    				   if(professor==true)
    				   {
    					   System.out.println("Professor login successfull");
    					   //System.out.println("1.Enroll for the course");
    					   System.out.println("1.View Courses");
    					   System.out.println("2.View courses handled");
    					   System.out.println("3.Grade Students for the students handled");
    					   //System.out.println("5.View Scores");
    					   //System.out.println("6.View Total report card");
    					   int student1=scan.nextInt();
    					   switch(student1)
    					   {
    					   case 1:
    						   break;
    						   
    					   case 2:
    						   break;
    						   
    					   case 3:
    						   break;
    						   
    					  default:
    						  System.out.println("Invalid Input");
    						  UserLogin();
    						  break;
    					   }
    				   }
    			   }
    			   else
    			   {
    				   System.out.println("Invalid Input");
    				   UserLogin();
    			   }
    		   }
    		   else
    		   {
    			   System.out.println("Login Failed");
    			   UserLogin();
    		   }
    	   }
    	   catch(Exception ex){
    		   throw ex;
    	   }
       }
}
