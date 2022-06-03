package Controllers;

import java.sql.SQLException;

import Menus.*;
import Services.AuthenticationService;
import Utils.Utils;

public class MainController {

	private AuthenticationController authController = new AuthenticationController();
	private RegisterController registerController = new RegisterController();

	private AuthenticationService authService;

	public MainController() throws SQLException {
		this.authService = AuthenticationService.getInstance();
	}

	public void run() throws SQLException {

		int optionForAccount;

		WelcomePage.welcomePage();

		optionForAccount = Utils.readInteger();

		while (optionForAccount != 1 && optionForAccount != 2) {
			ErrorMenu.invalidInputError();
			optionForAccount = Utils.readInteger();
		}

		if (optionForAccount == 1) {

			AccountMenu.login();
			authController.run();

			if (authService.getLoggedUser() != null) {
				LoggedUserManagementController loggedUserController = new LoggedUserManagementController();
				loggedUserController.run();

			} else {

				AdministrationController administrationController = new AdministrationController();
				administrationController.run();
			}

		} else if (optionForAccount == 2) {

			AccountMenu.register();
			registerController.run();
		}
	}
}
