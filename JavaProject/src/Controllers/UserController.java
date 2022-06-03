package Controllers;

import Utils.Utils;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import Menus.ErrorMenu;
import Menus.ListMenu;
import Models.User_Info;
import Services.AuthenticationService;
import Services.UserService;

public class UserController {
	private final UserService userService;
	private final AuthenticationService authService;
	
	User_Info user = null;
	
	public UserController() throws SQLException {
		this.userService = UserService.getInstance();
		this.authService = AuthenticationService.getInstance();	
    }
	
	public void viewAllUsers() throws SQLException {
		
		ListMenu.viewAllUsers();
		
		List<User_Info> users = userService.getAllUsers();
		
		Utils.writeLine("User names:");
		Utils.writeNewLine();
		users.stream().forEach(user-> {
		
			Utils.writeNewLine();
			Utils.write("User Id: ");
			Utils.writeInteger(user.getUser_ID());
			Utils.write(" |  First name: ");
			Utils.write(user.getFirst_Name());
			Utils.write(" |  Last name: ");
			Utils.write(user.getLast_Name());
			Utils.write(" |  Email: ");
			Utils.write(user.getUser_Email());
			Utils.write(" |  Password: ");
			Utils.write(user.getUser_Password());
			Utils.write(" |  Phone Number: ");
			Utils.write(user.getPhone_Number());
			Utils.writeNewLine();
		
		});
		
		
		Utils.writeNewLine();
		 
		Utils.writeLine("Press 1 to go back:"); int option = Utils.readInteger();
		System.out.println();
		
		while(true) {
			switch (option) {
				case 1: {
					backToAdminMenu();
					break;
				}
				
				default:
					ErrorMenu.invalidInputError(); option = Utils.readInteger();
			}	
		}	
	}
	
	public void viewAllAdmins() throws SQLException {
		
		ListMenu.viewAllAdmins();
		
		List<User_Info> admins = userService.getAllAdmins();
		
		Utils.writeLine("User names:");
		Utils.writeNewLine();
		
		admins.stream().forEach(admin-> { 
			
			Utils.writeNewLine();
			Utils.write("User Id: ");
			Utils.writeInteger(user.getUser_ID());
			Utils.write(" |  First name: ");
			Utils.write(user.getFirst_Name());
			Utils.write(" |  Last name: ");
			Utils.write(user.getLast_Name());
			Utils.write(" |  Email: ");
			Utils.write(user.getUser_Email());
			Utils.write(" |  Password: ");
			Utils.write(user.getUser_Password());
			Utils.write(" |  Phone Number: ");
			Utils.write(user.getPhone_Number());
			Utils.writeNewLine();

			
			});
		
		Utils.writeNewLine();
		 
		Utils.writeLine("Press 1 to go back:"); int option = Utils.readInteger();
		System.out.println();
		
		while(true) {
			switch (option) {
				case 1: {
					backToAdminMenu();
					break;
				}
				
				default:
					ErrorMenu.invalidInputError(); option = Utils.readInteger();
			}	
		}	
	}
	
	public void deleteUserById() throws SQLException {
		
		Utils.writeNewLine();
		ListMenu.deleteUserMenu();
		Utils.writeNewLine();

		List<User_Info> users = userService.getAllUsers();
		List<Integer> getAllIds = users.stream().map(id -> id.getUser_ID()).collect(Collectors.toList());

		Utils.writeNewLine();
		users.stream().forEach(user -> {

			Utils.write("User ID: ");
			Utils.writeInteger(user.getUser_ID());
	
			Utils.write(" | First name: ");
			Utils.writeLine(user.getFirst_Name());
			Utils.write(" | Last name: ");
			Utils.writeLine(user.getLast_Name());
		});
		Utils.writeNewLine();

		Utils.write("Type the id of the user you want to delete: "); int id = Utils.readInteger();

		while(!getAllIds.contains(id)) {
			Utils.writeNewLine();
			ErrorMenu.invalidDataError();
			Utils.write("Type the id of the user you want to delete: "); id = Utils.readInteger();
			Utils.writeNewLine();
		}

		userService.deleteUserById(id);

		Utils.writeNewLine();
		Utils.writeLine("Successfully deleted!");
		Utils.write("Type 1 to back: "); int option = Utils.readInteger();
		Utils.writeNewLine();

		while(option != 1) {
			Utils.writeNewLine();
			ErrorMenu.invalidInputError();
			Utils.write("Type 1 to back: "); option = Utils.readInteger();
			Utils.writeNewLine();
		}

		backToAdminMenu();
	}
	
	public void logOut() throws SQLException
	{
		
	}
	
	public void viewSportRequest() throws SQLException
	{
		
	}
	
	public void removeSportRequest() throws SQLException
	{
		
	}
	
	public void deletePersonalAccount() throws SQLException
	{
		
	}
	
	public void deleteAdmin() throws SQLException
	{
		
	}
	
	public void editPersonalAccount() throws SQLException
	{
		
	}
	
	public void makeUserAdminById() throws SQLException {
		
		Utils.writeNewLine();
		ListMenu.makeUserAdmin();
		Utils.writeNewLine();
		
		List<User_Info> users = userService.getAllUsers();
		List<Integer> getAllIds = users.stream().map(id -> id.getUser_ID()).collect(Collectors.toList());
		
		Utils.writeNewLine();
		users.stream().forEach(user -> {

			Utils.write("User ID: ");
			Utils.writeInteger(user.getUser_ID());
	
			Utils.write(" | Username: ");
			Utils.writeLine(user.getFirst_Name());
		});
		Utils.writeNewLine();
		
		Utils.write("Type the id of the user you want to make admin: "); int id = Utils.readInteger();
		
		while(!getAllIds.contains(id)) {
			Utils.writeNewLine();
			ErrorMenu.invalidDataError();
			Utils.write("Type the id of the user you want to make admin: "); id = Utils.readInteger();
			Utils.writeNewLine();
		}
			
		userService.makeUserAdmin(id);
		
		Utils.writeNewLine();
		Utils.writeLine("Successfully done!");
		Utils.write("Type 1 to back: "); int option = Utils.readInteger();
		Utils.writeNewLine();

		while(option != 1) {
			Utils.writeNewLine();
			ErrorMenu.invalidInputError();
			Utils.write("Type 1 to back: "); option = Utils.readInteger();
			Utils.writeNewLine();
		}

		backToAdminMenu();
	}
	
	private void backToAdminMenu() throws SQLException {
		AdministrationController administrationController = new AdministrationController();
		administrationController.run();
    }
	
	private void backToMainMenu() throws SQLException {
		MainController mainMenu = new MainController();
		mainMenu.run();
    }
	
	private void backToUserMenu() throws SQLException {
		LoggedUserManagementController loggedUserManagementController = new LoggedUserManagementController();
		loggedUserManagementController.run();
    }
}

