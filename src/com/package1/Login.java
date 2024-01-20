package com.package1;
import java.util.Scanner;

public class Login {
       public static void Newlogin()
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
