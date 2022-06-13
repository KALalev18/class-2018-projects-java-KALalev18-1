package Controllers;

import Utils.Utils;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Menus.ErrorMenu;
import Menus.ListMenu;
import Models.User_Info;
import Models.Admin_Info;
import Services.AuthenticationService;
import Services.UserService;

public class UserController {
	private final UserService userService;
	private final AuthenticationService authService;
	//private final AdministrationService adminService;

	User_Info user = null;

	public UserController() throws SQLException {
		this.userService = UserService.getInstance();
		this.authService = AuthenticationService.getInstance();
	}

	public void viewAllUsers() throws SQLException {

		ListMenu.viewAllUsers();

		List<User_Info> users = userService.getAllUsers();
		users.stream().forEach(user -> {

			Utils.writeNewLine();
			Utils.write("User Id: ");
			Utils.writeInteger(user.getUser_ID());
			Utils.write("Email: ");
			Utils.write(user.getUser_Email());
			Utils.write("Password: ");
			Utils.write(user.getUser_Password());
			Utils.write("First name: ");
			Utils.write(user.getFirst_Name());
			Utils.write("Last name: ");
			Utils.write(user.getLast_Name());
			Utils.write("Phone Number: ");
			Utils.write(user.getPhone_Number());
			Utils.writeNewLine();

		});

		Utils.writeNewLine();

		Utils.writeLine("Press 1 to go back: ");
		int option = Utils.readInteger();
		System.out.println();

		while (true) {
			switch (option) {
			case 1: {
				backToAdminMenu();
				break;
			}

			default:
				ErrorMenu.invalidInputError();
				option = Utils.readInteger();
			}
		}
	}

	public void viewAllAdmins() throws SQLException {

		ListMenu.viewAllAdmins();

		List<Admin_Info> admins = userService.getAllAdmins();

		admins.stream().forEach(admin -> {

			Utils.writeNewLine();
			Utils.write("Admin Id: ");
			Utils.writeInteger(admin.getAdmin_ID());
			Utils.write("Email: ");
			Utils.write(admin.getAdmin_Email());
			Utils.write("Password: ");
			Utils.write(user.getUser_Password());
			Utils.write("First name: ");
			Utils.write(admin.getAdmin_First_Name());
			Utils.write("Last name: ");
			Utils.write(admin.getAdmin_Last_Name());
			Utils.write("Password: ");
			Utils.write(admin.getAdmin_Password());
			Utils.write("Phone Number: ");
			Utils.write(admin.getAdmin_Phone_Number());
			Utils.writeNewLine();

		});

		Utils.writeNewLine();

		Utils.writeLine("Press 1 to go back: ");
		int option = Utils.readInteger();
		System.out.println();

		while (true) {
			switch (option) {
			case 1: {
				backToAdminMenu();
				break;
			}

			default:
				ErrorMenu.invalidInputError();
				option = Utils.readInteger();
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

			Utils.write("First name: ");
			Utils.writeLine(user.getFirst_Name());
			Utils.write("Last name: ");
			Utils.writeLine(user.getLast_Name());
		});
		Utils.writeNewLine();

		Utils.write("Type the id of the user you want to delete: ");
		int id = Utils.readInteger();

		while (!getAllIds.contains(id)) {
			Utils.writeNewLine();
			ErrorMenu.invalidDataError();
			Utils.write("Type the id of the user you want to delete: ");
			id = Utils.readInteger();
			Utils.writeNewLine();
		}

		userService.deleteUserById(id);

		Utils.writeNewLine();
		Utils.writeLine("Successfully deleted!");
		Utils.write("Type 1 to back: ");
		int option = Utils.readInteger();
		Utils.writeNewLine();

		while (option != 1) {
			Utils.writeNewLine();
			ErrorMenu.invalidInputError();
			Utils.write("Type 1 to back: ");
			option = Utils.readInteger();
			Utils.writeNewLine();
		}

		backToAdminMenu();
	}
    private void editUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID of the user that you want to edit: ");
        int user_ID = Integer.parseInt(sc.nextLine());

        User_Info user = userService.getUserById(user_ID);
        if(user!=null)
        {
        	System.out.println("Current user id: " + user.getUser_ID());
        	System.out.println("Current registration id: " + user.getRegistration_ID());
            System.out.println("Current first name: " + user.getFirst_Name());
            System.out.println("Current last name: " + user.getLast_Name());
            System.out.println("Current email: " + user.getUser_Email());
            System.out.println("Current password: " + user.getUser_Password());
            System.out.println("Current phone number: " + user.getPhone_Number());

            
            System.out.println("Enter new first name: ");
            String firstName = sc.nextLine();
            System.out.println("Enter new last name: ");
            String lastName = sc.nextLine();
            System.out.println("Enter new email: ");
            String userEmail = sc.nextLine();
            System.out.println("Enter new password: ");
            String userPassword = sc.nextLine();
            System.out.println("Enter new phone number: ");
            String phoneNumber = sc.nextLine();

            Boolean result = userService.updateUser(user_ID, firstName, lastName, userEmail, userPassword, phoneNumber);
            if(result)
            {
                System.out.println("User updated successfully!");
            }
            else
            {
                System.out.println("There was a problem with updating the user.");
            }
        }
        else
        {
            System.out.println("The id is not valid!");
        }
    }

    private void deleteUser() throws SQLException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID of the user that you want to delete: ");
        int userId = Integer.parseInt(sc.nextLine());

        Boolean result = userService.deleteUserById(userId);

        if(result)
        {
            System.out.println("The user has been deleted successfully!");
        }
        else
        {
            System.out.println("There was a problem with deleting the user.");
        }
    }

    private void addNewUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter email: ");
        String email = sc.nextLine();

        System.out.println("Enter password: ");
        String password = sc.nextLine();

        System.out.println("Enter first name: ");
        String firstName = sc.nextLine();

        System.out.println("Enter last name: ");
        String lastName = sc.nextLine();

        System.out.println("Enter phone number: ");
        String phoneNumber = sc.nextLine();

        Boolean result = userService.addUser(email, password, firstName, lastName, phoneNumber);

        if(result)
        {
            System.out.println("User is added succesfully!");
        }
        else
        {
            System.out.println("There was a problem with adding the user.");
        }
    }

	public void logOut() throws SQLException {
		return;
	}

	public void viewSportRequest() throws SQLException {

	}

	public void removeSportRequest() throws SQLException {

	}

	public void deletePersonalAccount() throws SQLException {

	}

	public void deleteAdmin() throws SQLException {

	}

	public void editPersonalAccount() throws SQLException {
		
	}

	private void backToAdminMenu() throws SQLException {
		AdministrationController administrationController = new AdministrationController();
		administrationController.run();
	}

	private void backToMainMenu() throws SQLException, NoSuchAlgorithmException, NoSuchProviderException {
		MainController mainMenu = new MainController();
		mainMenu.run();
	}

	private void backToUserMenu() throws SQLException, NoSuchAlgorithmException, NoSuchProviderException {
		LoggedUserManagementController loggedUserManagementController = new LoggedUserManagementController();
		loggedUserManagementController.run();
	}
}
