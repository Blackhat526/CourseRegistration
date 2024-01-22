package com.package1;
import java.util.Scanner;

import com.sun.tools.javac.Main;

public class Login {
       public static void AdminLogin() throws Exception
       {
    	   try {
    		   Scanner scan= new Scanner(System.in);
    		   System.out.println("Enter the EmailId: ");
    		   String emialid=scan.next();
    		   System.out.println("Enter the Password");
    		   String password=scan.next();
    		   //login confirmation.
    		   
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
		    			   break;
		    			   
		    		   case 8:
		    			   Main.main(null);
		    			   break;
		    			   
		    		default:
		    			System.out.println("Invalid Input");
		    			AdminLogin();
		    		    break;
    		   }
    	   }
    	   catch(Exception ex){
    		   throw ex;
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
    		   
    	   }
    	   catch(Exception ex){
    		   throw ex;
    	   }
       }
}
