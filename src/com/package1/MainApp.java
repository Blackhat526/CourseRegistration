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
    			 Login log=new Login();
    			 log.Newlogin();
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
