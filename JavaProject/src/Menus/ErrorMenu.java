package Menus;

import Utils.Utils;

public class ErrorMenu {

	public static void invalidInputError() {

		Utils.writeLine("+------------------------------------------------------------------+");
		Utils.writeLine("|                   Please enter a valid option!                   |");
		Utils.writeLine("+------------------------------------------------------------------+");
		Utils.writeLine("                                                                    ");
		Utils.write("Please choose: ");
	}

	public static void invalidDataError() {

		Utils.writeLine("+------------------------------------------------------------------+");
		Utils.writeLine("|                     Please enter a valid data!                   |");
		Utils.writeLine("+------------------------------------------------------------------+");
		Utils.writeLine("                                                                   ");
	}

	public static void invalidDomain() {

		Utils.writeLine("+------------------------------------------------------------------+");
		Utils.writeLine("|                       Invalid email domain                       |");
		Utils.writeLine("+------------------------------------------------------------------+");
		Utils.writeLine("                                                                   ");
	}

	public static void invalidUsername() {

		Utils.writeLine("+------------------------------------------------------------------+");
		Utils.writeLine("|                      Username already exist                      |");
		Utils.writeLine("+------------------------------------------------------------------+");
		Utils.writeLine("                                                                    ");
	}

	public static void invalidEmailUsername() {

		Utils.writeLine("+------------------------------------------------------------------+");
		Utils.writeLine("|                      Invalid email username                      |");
		Utils.writeLine("+------------------------------------------------------------------+");
		Utils.writeLine("                                                                   ");
	}
}
