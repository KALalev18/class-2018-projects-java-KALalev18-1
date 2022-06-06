package Controllers;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.SQLException;

import Menus.ErrorMenu;
import Services.RegisterService;
import Utils.Utils;

public class RegisterController {
	LoggedUserManagementController loggedUserController = new LoggedUserManagementController();

	private final RegisterService regService;

	public RegisterController() throws SQLException {
		this.regService = RegisterService.getInstance();
	}

	public void run() throws SQLException, NoSuchAlgorithmException, NoSuchProviderException {

		while (regService.getCorrectUser() == false) {

			Utils.writeLine("First name: ");
			String firstName = Utils.read();

			Utils.writeLine("Last name: ");
			String lastName = Utils.read();

			Utils.writeLine("Email: ");
			String email = Utils.read();

			while (!email.endsWith("@gmail.com") ^ !email.endsWith("@yahoo.com") ^ !email.endsWith("@hotmail.com")
					^ !email.endsWith("@codingburgas.com") ^ !email.endsWith("@abv.bg")) {
				ErrorMenu.invalidDomain();
				Utils.writeLine("Email: ");
				email = Utils.read();
				while (email.equals("@gmail.com") ^ email.equals("@yahoo.com") ^ email.equals("@hotmail.com")
						^ email.equals("@codingburgas.com") ^ email.equals("@abv.bg")) {
					ErrorMenu.invalidEmailUsername();
					Utils.writeLine("Email: ");
					email = Utils.read();
				}
			}

			Utils.writeLine("Password: ");
			String password = Utils.read();
			
			String phoneNumber = Utils.read();

			regService.insertUser(1000011, 11, firstName, lastName, email, password, phoneNumber);

			if (regService.getCorrectUser() == false) {
				ErrorMenu.invalidUsername();
			}
		}

		Utils.writeLine("Successful registration!");
		Utils.write("Type 1 to back: ");
		int option = Utils.readInteger();

		while (true) {
			switch (option) {
			case 1: {
				backToMainMenu();
				break;
			}
			default:
				ErrorMenu.invalidInputError();
				option = Utils.readInteger();
			}
		}
	}

	private void backToMainMenu() throws SQLException, NoSuchAlgorithmException, NoSuchProviderException {
		MainController mainMenu = new MainController();
		mainMenu.run();
	}
}
