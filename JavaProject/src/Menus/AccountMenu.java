package Menus;

import Utils.Utils;

public class AccountMenu {
	
	public static void login() {

		Utils.writeLine("+------------------------------------------------------------------+");
		Utils.writeLine("|                                                                  |");
		Utils.writeLine("|                              Login                               |");
		Utils.writeLine("|                                                                  |");
		Utils.writeLine("+------------------------------------------------------------------+");
		Utils.writeLine("|                                                                  |");
		Utils.writeLine("|                 Please type your names and password              |");
		Utils.writeLine("|                                                                  |");
		Utils.writeLine("+------------------------------------------------------------------+");
		Utils.writeLine("                                                                    ");
		Utils.write("First name: ");
		Utils.write("Last name: ");
	}

	public static void register() {

		Utils.writeLine("+------------------------------------------------------------------+");
		Utils.writeLine("|                                                                  |");
		Utils.writeLine("|                         Create an account                        |");
		Utils.writeLine("|                                                                  |");
		Utils.writeLine("+------------------------------------------------------------------+");
		Utils.writeLine("|                                                                  |");
		Utils.writeLine("|                       Please type your data                      |");
		Utils.writeLine("|                                                                  |");
		Utils.writeLine("+------------------------------------------------------------------+");
		Utils.writeLine("                                                                    ");
	}
}