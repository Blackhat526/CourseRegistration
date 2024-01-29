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
			    		       System.out.println("Please enter the course Id :");
			    		       course.setCourseId(scan.nextInt());
			    		       System.out.println("Please enter the name of the professor by whom the course is handled by :");
			    		       course.setHangleBy(scan.next());
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
			    			   System.out.println("View users");
			    			   SqlConnection viewusers = new SqlConnection();
			    			   viewusers.UsersAvailable();
			    			   AdminLogin();
			    			   break;
			    			   
			    		   case 6:
			    			   System.out.println("<<<<===========================>>>>");
			    			   System.out.println("Courses available");
			    			   SqlConnection courses = new SqlConnection();
			    			   courses.CoursesAvailable();
			    			   System.out.println("Please type the id of the course that needs to be deleted :");
			    			   int delete=scan.nextInt();
			    			   SqlConnection deletecourse = new SqlConnection();
			    			   deletecourse.DeleteCourse(delete);
			    			   System.out.println("The particular course was deleted");
			    			   AdminLogin();
			    			   break;
			    			   
			    		   case 7:
			    			   System.out.println("<<<<===========================>>>>");
			    			   System.out.println("Users available");
			    			   SqlConnection users = new SqlConnection();
			    			   users.UsersAvailable();
			    			   System.out.println("Please type the id of the user that needs to be deleted :");
			    			   int deleteuser=scan.nextInt();
			    			   SqlConnection deleteUser = new SqlConnection();
			    			   deleteUser.DeleteUser(deleteuser);
			    			   System.out.println("The particular user was deleted");
			    			   AdminLogin();
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
    						   System.out.println("<<<<===========================>>>>");
			    			   System.out.println("Courses available");
			    			   SqlConnection Viewcourses = new SqlConnection();
			    			   Viewcourses.CoursesAvailable();
			    			   System.out.println("Please enter the Id of the course to be enrolled :");
			    			   int CourseId=scan.nextInt();
			    			   System.out.println("Please enter the Student Id :");
			    			   int StudentId=scan.nextInt();
			    			   Viewcourses.EnrollCourse(CourseId,StudentId);
    						   break;
    						   
    					   case 2:
    						   System.out.println("<<<<===========================>>>>");
			    			   System.out.println("Courses available");
			    			   SqlConnection viewcourses = new SqlConnection();
			    			   viewcourses.CoursesAvailable();
			    			   UserLogin();
    						   break;
    						   
    					   case 3:
    						   System.out.println("<<<<===========================>>>>");
			    			   System.out.println("Enrolled Courses");
			    			   SqlConnection enrolledcourses = new SqlConnection();
			    			   enrolledcourses.CoursesEnrolled();
			    			   UserLogin();
    						   break;
    						   
    					   case 4:
    						   System.out.println("<<<<===========================>>>>");
    						   System.out.println("Please enter the Email Id :");
    						   String emailid=scan.next();
    						   System.out.println("Please enter the Old Password :");
    						   String OldPass=scan.next();
    						   System.out.println("Please enter the new Password :");
    						   String NewPass=scan.next();
    						   SqlConnection ChangePass = new SqlConnection();
    						   ChangePass.ChangePassword(emailid,OldPass,NewPass);
    						   UserLogin();
    						   break;
    						   
    					   case 5:
    						   System.out.println("<<<<===========================>>>>");
			    			   System.out.println("Scores");
			    			   SqlConnection scores = new SqlConnection();
			    			   scores.ViewScores();
			    			   UserLogin();
    						   break;
    						   
    					   case 6:
    						   //total report card
    						   System.out.println("Please enter your student id to get your report card");
    						   int Studentid = scan.nextInt();
    						   System.out.println("<<<<===========================>>>>");
			    			   System.out.println("**********Report Card**************");
			    			   SqlConnection reportcard = new SqlConnection();
			    			   reportcard.Reportcard(Studentid);
			    			   UserLogin();
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
    					   System.out.println("4.Main Menu");
    					   //System.out.println("6.View Total report card");
    					   int student1=scan.nextInt();
    					   switch(student1)
    					   {
    					   case 1:
    						   System.out.println("<<<<===========================>>>>");
			    			   System.out.println("Courses available");
			    			   SqlConnection viewcourses = new SqlConnection();
			    			   viewcourses.CoursesAvailable();
			    			   UserLogin();
    						   break;
    						   
    					   case 2:
    						   System.out.println("Please enter the name of the professor :");
    						   String ProfessorName=scan.next();
    						   System.out.println("<<<<===========================>>>>");
			    			   System.out.println("Courses handled");
			    			   SqlConnection courseshandled = new SqlConnection();
			    			   courseshandled.CoursesHandled(ProfessorName);
			    			   UserLogin();
    						   break;
    						   
    					   case 3:
    						   System.out.println("<<<<===========================>>>>");
			    			   System.out.println("Enrolled Courses");
			    			   SqlConnection enrolledcourses = new SqlConnection();
			    			   enrolledcourses.CoursesEnrolled();
    						   //SqlConnection gradestudents = new SqlConnection();
			    			   System.out.println("Please provide the name of the professor :");
			    			   String ProName=scan.next();
			    			   System.out.println("Please provide scores for the enrolled courses out of 100");
			    			   int Scores=scan.nextInt();
			    			   enrolledcourses.ProvideGrades(Scores,ProName);
			    			   UserLogin();
    						   break;
    						   
    					   case 4:
    						   MainApp.main(null);
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
