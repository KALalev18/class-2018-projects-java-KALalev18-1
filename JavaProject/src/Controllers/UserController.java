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
	
	public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String userName = sc.nextLine();
        System.out.println("Enter your password: ");
        String userPassword = sc.nextLine();

        Boolean isValid = userService.isLogin(userName, userPassword);

        if(isValid) {
            //TODO: check if regular user or admin
            System.out.println("You are logged in successfully!");
            HomeController.loggedUser = userService.getLoggedInUser(userName, userPassword);


        } else {
            System.out.println("Wrong username or password! Please try again!");
        }
    }

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String userName = sc.nextLine();
        System.out.println("Enter your password: ");
        String userPassword = sc.nextLine();
        System.out.println("Enter your first name: ");
        String firstName = sc.nextLine();
        System.out.println("Enter your last name: ");
        String lastName = sc.nextLine();
        System.out.println("Enter your phone: ");
        String phoneNumber = sc.nextLine();

        Boolean success = userService.addUser(userName, userPassword, firstName, lastName, phoneNumber);

        if(success)
        {
            System.out.println("User registered successfully!");
        }
        else
        {
            System.out.println("There was a problem with your registeration!");
        }
    }

    public void printManagement() {
        Scanner sc = new Scanner(System.in);
        printManageUsersMenu();

        Integer command = Integer.parseInt(sc.nextLine());
        while(command!=5) {
            switch(command) {
                case 1:
                    listAllUsers();
                    break;
                case 2:
                    editUser();
                    break;
                case 3:
                    deleteUser();
                    break;
                case 4:
                    addNewUser();
                    break;

                default:
                    System.out.println("Wrong command!");
            }

            printManageUsersMenu();

            command = Integer.parseInt(sc.nextLine());
        }
    }

    private void listAllUsers() {
        List<User> users = userService.getAllUsers();
        System.out.println(new String("-").repeat(60));
        System.out.println(String.format("|%s|", PrintUtils.center("USERS LIST", 58)));
        System.out.println(new String("-").repeat(60));
        System.out.println(
                String.format(
                        "|%1$-5s|%2$-20s|%3$-15s|%4$-15s|",
                       "ID", "Username", "Customer ID", "Is admin?"
                )
        );

        for (User user : users) {
            String adminStatus = (user.getAdmin() ? "Yes" : "No");
            System.out.println(
                    String.format(
                            "|%1$-5s|%2$-20s|%3$-15s|%4$-15s|",
                            user.getUserId(), user.getUserName(), user.getCustomerId(), adminStatus
                    )
            );
        }
        System.out.println(new String("-").repeat(60));

    }

    private void editUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID of the user that you want to edit: ");
        Long userId = Long.parseLong(sc.nextLine());

        User user = userService.getUserById(userId);
        if(user!=null)
        {
            System.out.println("Current userName: " + user.getUserName());
            System.out.println("Current password: " + user.getUserPassword());
            System.out.println("Current admin status: " + user.getAdmin());

            System.out.println("Enter new userName: ");
            String userName = sc.nextLine();
            System.out.println("Enter new password: ");
            String userPassword = sc.nextLine();

            System.out.println("Enter new status: ");
            Boolean isAdmin = Boolean.parseBoolean(sc.nextLine());

            Boolean result = userService.updateUser(userId, userName, userPassword, isAdmin);
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

    private void deleteUser()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID of the user that you want to delete: ");
        Long userId = Long.parseLong(sc.nextLine());

        Boolean result = userService.deleteUser(userId);

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
        System.out.println("Enter userName: ");
        String userName = sc.nextLine();

        System.out.println("Enter password: ");
        String password = sc.nextLine();

        System.out.println("Enter first name: ");
        String firstName = sc.nextLine();

        System.out.println("Enter last name: ");
        String lastName = sc.nextLine();

        System.out.println("Enter phone number: ");
        String phoneNumber = sc.nextLine();

        Boolean result = userService.addUser(userName, password, firstName, lastName, phoneNumber);

        if(result)
        {
            System.out.println("User added succesfully!");
        }
        else
        {
            System.out.println("There was a problem with adding the user");
        }
    }
    private void printManageUsersMenu() {
        System.out.println(new String("-").repeat(60));
        System.out.println(String.format("|%s|", PrintUtils.center("USERS MANAGEMENT", 58)));
        System.out.println(new String("-").repeat(60));
        System.out.println(String.format("|%1$-58s|", "1. List all users"));
        System.out.println(String.format("|%1$-58s|", "2. Edit user"));
        System.out.println(String.format("|%1$-58s|", "3. Delete user"));
        System.out.println(String.format("|%1$-58s|", "4. Add new user"));
        System.out.println(String.format("|%1$-58s|", "5. Go back"));
        System.out.println(new String("-").repeat(60));
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
