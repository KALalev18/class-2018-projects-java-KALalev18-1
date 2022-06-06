package Utils;

import java.util.Scanner;

import Menus.ErrorMenu;

public class Utils {
	private static final Scanner sc = new Scanner(System.in);

	public static void write(String line) {
		System.out.print(line);
	}

	public static void writeLine(String line) {
		System.out.println(line);
	}

	public static void writeNewLine() {
		System.out.println();
	}

	public static void clear() {
		for (int i = 0; i <= 30; i++) {
			System.out.println();
		}
	}

	public static String read() {
		return sc.nextLine();
	}

	public static void writeInteger(int number) {
		System.out.print(number);
	}

	public static int readInteger() {

		int result = 0;

		while (result == 0) {
			try {
				result = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				ErrorMenu.invalidInputError();
			}
		}
		return result;
	}

	public static void writeDouble(double number) {
		System.out.print(number);
	}
	
	public static double readDouble() {

		Double result = null;

		while (result == null) {
			try {
				result = Double.parseDouble(sc.nextLine());
			} catch (NumberFormatException e) {
				ErrorMenu.invalidInputError();
			}
		}
		return result;
	}

	public static String readString() {

		String result = null;
		while (result == null) {
			try {
				result = sc.nextLine();
			} catch (NumberFormatException e) {
				ErrorMenu.invalidInputError();
			}
		}
		return result;
	}

}