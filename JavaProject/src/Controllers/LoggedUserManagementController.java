package Controllers;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.SQLException;

import Menus.LoggedUserMenu;
import Services.AuthenticationService;
import Utils.Utils;
import Menus.ErrorMenu;

public class LoggedUserManagementController {
	private final AuthenticationService authenticationService;

	public LoggedUserManagementController() throws SQLException {
		this.authenticationService = AuthenticationService.getInstance();

	}

	public void run() throws SQLException, NoSuchAlgorithmException, NoSuchProviderException {

		LoggedUserMenu.loggedUserMenu();

		int choice = Utils.readInteger();

		while (true) {
			switch (choice) {
			case 1: {
				viewAllProducts();
				break;
			}
			case 2: {
				viewYourPayments();
				break;
			}
			case 3: {
				viewYourCart();
				break;
			}
			case 4: {
				viewAllFieldPhotos();
				break;
			}
			case 5: {
				editAccount();
				break;
			}
			case 6: {
				deleteAccount();
				break;
			}
			case 7: {
				logOut();
				break;
			}
			case 8: {
				authenticationService.destroySession();
				backToMainMenu();
				break;
			}
			default:
				ErrorMenu.invalidInputError();
				choice = Utils.readInteger();
				break;
			}
		}
	}


	private void logOut() {
		// TODO Auto-generated method stub
		
	}

	private void deleteAccount() {
		// TODO Auto-generated method stub
		
	}

	private void editAccount() {
		// TODO Auto-generated method stub
		
	}

	private void viewYourCart() {
		// TODO Auto-generated method stub
		
	}

	private void viewYourPayments() {
		// TODO Auto-generated method stub
		
	}
	
	private void viewAllFieldPhotos() {
		// TODO Auto-generated method stub
		
	}

	private void viewAllProducts() {
		// TODO Auto-generated method stub
		
	}

	private void backToMainMenu() throws SQLException, NoSuchAlgorithmException, NoSuchProviderException {
		MainController mainMenu = new MainController();
		mainMenu.run();
	}
}
