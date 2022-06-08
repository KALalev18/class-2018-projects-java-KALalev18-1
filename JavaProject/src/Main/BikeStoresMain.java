package Main;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Controllers.MainController;
import Repositorities.UserRepository;
import Models.User_Info;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import static java.nio.charset.StandardCharsets.UTF_8;

public class BikeStoresMain 
{

	public static void main(String[] args) throws SQLException 
	{
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, UTF_8));
		
		// System.out.println(System.getProperty("file.encoding"));

//		MainController main = new MainController();
//		main.run();
		
		
		
		UserRepository user = new UserRepository();

		
		System.out.println();
		System.out.println("User_Info top 10 records table: ");
		System.out.println();
		user.ShowCustomers();
		
		//user.DeleteCustomer(3);
		//user.ShowCustomers();
		
		System.out.println();
		System.out.println("Randon User_Info row: ");
		System.out.println();
		user.ShowCustomersByID(10000008);
		
		System.out.println();
		
		
		//System.out.println(user.getUsers());		
		
		
		
		//System.out.println(user.getUsersInProject(0));
		
		//user.UpdateCustomer(1, "Kristian", "Lalev");
		//user.ShowCustomers();
	}
}