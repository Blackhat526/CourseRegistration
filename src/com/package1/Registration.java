package com.package1;
import java.util.Scanner;

public class Registration {
    
	public static String getFullName() {
		return FullName;
	}

	public static void setFullName(String fullName) {
		FullName = fullName;
	}

	public static String getPhonenumber() {
		return Phonenumber;
	}

	public static void setPhonenumber(String phonenumber) {
		Phonenumber = phonenumber;
	}

	public static String getEmailId() {
		return EmailId;
	}

	public static void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public static int getAge() {
		return Age;
	}

	public static void setAge(int age) {
		Age = age;
	}

	public static String getAddress() {
		return Address;
	}

	public static void setAddress(String address) {
		Address = address;
	}

	public static String getPassword() {
		return Password;
	}

	public static void setPassword(String password) {
		Password = password;
	}
	
	public static String getRole() {
		return Role;
	}

	public static void setRole(String role) {
		Role = role;
	}
	
	public static String getProfStud() {
		return ProfStud;
	}

	public static void setProfStud(String profStud) {
		ProfStud = profStud;
	}

	private static String FullName;
	private static String Phonenumber;
	private static String EmailId;
	private static int Age;
	private static String Address;
	private static String Password;
	private static String Role;
	private static String ProfStud;

	public static void RegisterNewUser()
	{
		int slno=1;
		try {
			Scanner scan= new Scanner(System.in);
			Registration reg=new Registration();
			System.out.println("<<<<===========================>>>>");
	    	System.out.println("Welcome to the registration page!!!");
	    	System.out.println("Please enter your FullName: ");
	    	reg.FullName = scan.next();
	    	System.out.println("Please enter your Phone Number: ");
	    	reg.Phonenumber=scan.next();
	    	System.out.println("Please enter your Email Id: ");
	    	reg.EmailId=scan.next();
	    	System.out.println("Please enter your Age: ");
	    	reg.Age=scan.nextInt();
	    	System.out.println("Please enter your Address: ");
	    	reg.Address=scan.next();
	    	System.out.println("Please enter your Password: ");
	    	reg.Password=scan.next();
	    	System.out.println("Registering as a User of an Admin");
	    	String role=scan.next();
	    	//reg.Role=scan.next();
	    	if(role.equals("User"))
	    	{
	    		reg.Role=role;
	    	}
	    	else if(role.equals("Admin"))
	    	{
	    		reg.Role=role;
	    	}
	    	else
	    	{
	    		System.out.println("Invalid input");
	    		RegisterNewUser();
	    	}
	    	System.out.println("Registering as a Student of a Professor");
	    	String ProfStud=scan.next();
	    	if(ProfStud.equals("Professor"))
	    	{
	    		reg.ProfStud=ProfStud;
	    	}
	    	else if(ProfStud.equals("Student"))
	    	{
	    		reg.ProfStud=ProfStud;
	    	}
	    	else
	    	{
	    		System.out.println("Invalid input");
	    		RegisterNewUser();
	    	}
	    	System.out.println("Thank you");
	    	SqlConnection con=new SqlConnection();
	    	con.Connection(reg);
	    	//slno++;
	    	System.out.println("<<<<===========================>>>>");
	    	MainApp.main(null);
	    	}
	    catch(Exception ex)
	    {
	    	System.out.println(ex.getMessage());
	    }
	}

	
}
