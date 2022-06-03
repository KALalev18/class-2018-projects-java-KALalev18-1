package Menus;
import Utils.Utils;
public class WelcomePage {
	public static void welcomePage() {
		Utils.writeLine("+------------------------------------------------------------------+");
		Utils.writeLine("|                                                                  |");
		Utils.writeLine("|                             WELCOME                              |");
		Utils.writeLine("|                                                                  |");
		Utils.writeLine("+------------------------------------------------------------------+");
		Utils.writeLine("|                                                                  |");
		Utils.writeLine("|                      DO YOU HAVE AN ACCOUNT?                     |");
		Utils.writeLine("|        __________________________________________________        |");
		Utils.writeLine("|                                                                  |");
		Utils.writeLine("|                             1. Yes                               |");
		Utils.writeLine("|                             2. No                                |");
		Utils.writeLine("|                                                                  |");
		Utils.writeLine("+------------------------------------------------------------------+");
		Utils.writeLine("                                                                   ");
		Utils.write("Please choose: ");
	}
}
