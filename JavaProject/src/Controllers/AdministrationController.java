package Controllers;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.SQLException;

import Menus.*;
import Services.AuthenticationService;
import Utils.Utils;

public class AdministrationController {
	private final AuthenticationService authenticationService;

	public AdministrationController() throws SQLException {
		this.authenticationService = AuthenticationService.getInstance();

	}

	public void run() throws SQLException {

		Utils.writeNewLine();
		AdminMenu.adminMenu();

		int choice = Utils.readInteger();

		while (true) {
			switch (choice) {
			
			case 1: {
				editPersonalAccount();
				break;
			}
			case 2: {
				editUser();
				break;
			}
			case 3: {
				deleteUser();
				break;
			}
			case 4: {
				deleteAdmin();
				break;
			}
			case 5: {
				deletePersonalAccount();
				break;
			}
			case 6: {
				viewAllUsers();
				break;
			}
			case 7: {
				viewAllAdmins();
				break;
			}
			case 8: {
				logOut();
				break;
			}
			case 9: {
				viewSportRequests();
				break;
			}
			case 10: {
				removeSportRequests();
				break;
			}
			default:
				ErrorMenu.invalidInputError();
				choice = Utils.readInteger();
			}
		}
	}

	private void logOut() throws SQLException {
		UserController logOut = new UserController();
		logOut.logOut();
	}

	private void viewSportRequests() throws SQLException {
		UserController viewRequests = new UserController();
		viewRequests.viewSportRequest();
	}

	private void removeSportRequests() throws SQLException {
		UserController removeRequests = new UserController();
		removeRequests.removeSportRequest();
	}

	private void deletePersonalAccount() throws SQLException {
		UserController users = new UserController();
		users.deletePersonalAccount();
	}

	private void deleteAdmin() throws SQLException {
		UserController deleteAdmin = new UserController();
		deleteAdmin.deleteAdmin();
	}

	private void editUser() throws SQLException {
		UserController editUsers = new UserController();
	}

	private void editPersonalAccount() throws SQLException {
		UserController editMyAcc = new UserController();
		editMyAcc.editPersonalAccount();
	}

	private void viewAllUsers() throws SQLException {
		UserController users = new UserController();
		users.viewAllUsers();
	}

	private void viewAllAdmins() throws SQLException {
		UserController admins = new UserController();
		admins.viewAllAdmins();
	}

	private void deleteUser() throws SQLException {
		UserController users = new UserController();
		users.deleteUserById();
	}

	private void backToMainMenu() throws SQLException, NoSuchAlgorithmException, NoSuchProviderException {
		MainController mainController = new MainController();
		mainController.run();
	}
}
