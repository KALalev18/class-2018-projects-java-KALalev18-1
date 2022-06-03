package Controllers;

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

	public void run() throws SQLException {

		LoggedUserMenu.loggedUserMenu();

		int choice = Utils.readInteger();

		while (true) {
			switch (choice) {
			
			case 2: {
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

	
	private void backToMainMenu() throws SQLException {
		MainController mainMenu = new MainController();
		mainMenu.run();
	}
}
