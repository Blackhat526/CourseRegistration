package com.package1;
import java.util.Scanner;

public class MainApp {
     public static void main(String args[])
     {
    	 try {
    		 Scanner scan = new Scanner(System.in);
    		 System.out.println("Welcome to the course registration Application");
    		 System.out.println("1. Register as new user");
    		 System.out.println("2. Login");
    		 int ans=scan.nextInt();
    		 switch(ans)
    		 {
    		 case 1:
    			 Registration reg = new Registration();
    			 reg.RegisterNewUser();
    			 break;
    		 case 2:
    			 System.out.println("1.Admin Login.");
    			 System.out.println("2.User Login.");
    			 int login=scan.nextInt();
    			 Login log=new Login();
    			 if(login==1)
    			 {
    				 log.AdminLogin();
    			 }
    			 else if(login==2)
    			 {
    				 log.UserLogin();
    			 }
    			 else
    			 {
    				 System.out.println("Invalid input");
    				 main(null);
    			 }
    			 break;
			default:
				System.out.println("Invalid Input");
				main(null);
				break;
    		 }
    	 }
    	 catch(Exception ex){
    		 System.out.println(ex.getMessage());
    	 }
     }
}
