package Controllers;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
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

	public void run() throws SQLException, NoSuchAlgorithmException, NoSuchProviderException {

		int optionForAccount;
		int AdminOrUserInput;

		WelcomePage.welcomePage();

		optionForAccount = Utils.readInteger();
		

		while (optionForAccount != 1 && optionForAccount != 2) {
			ErrorMenu.invalidInputError();
			optionForAccount = Utils.readInteger();
		}

		if (optionForAccount == 1) {

			AdminOrUserMenu.adminOrUserMenu();
			//authController.run();
			AdminOrUserInput = Utils.readInteger();
			if(AdminOrUserInput == 1)
			{
				//authController.run();
				AdminMenu.adminMenu();
			}
			if (AdminOrUserInput == 2)
			{
				//authController.run();
				LoggedUserMenu.loggedUserMenu();
			}
			else {
				ErrorMenu.invalidInputError();
			}

		} 
		
		
		else if (optionForAccount == 2) {

			AccountMenu.register();
			registerController.run();
		}
		if (authService.getLoggedUser() != null) {
			LoggedUserManagementController loggedUserController = new LoggedUserManagementController();
			loggedUserController.run();

		} else {

			AdministrationController administrationController = new AdministrationController();
			administrationController.run();
		}
		
		
		
	}
	
	
	
}
