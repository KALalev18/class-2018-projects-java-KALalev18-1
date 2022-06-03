package Controllers;

import Utils.Utils;

import java.sql.SQLException;

import Menus.ErrorMenu;
import Services.AuthenticationService;

public class AuthenticationController {

	private final AuthenticationService authService;

	public AuthenticationController() throws SQLException {
		this.authService = AuthenticationService.getInstance();
	}

	public void run() {

		while (authService.getLoggedUser() == null) {
			
			String firstName = Utils.read();
			String lastName = Utils.read();
			Utils.writeLine("Password: ");
			String password = Utils.read();

			authService.authenticateUser(firstName, lastName, password);

			if (authService.getLoggedUser() == null) {
				ErrorMenu.invalidDataError();
			}
		}
	}
}
