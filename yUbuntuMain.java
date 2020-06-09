/**
 * yUbuntu
 * make sure to check out codedash.net (Learn code for free, forever.) and serverimage.xyz (a simple .iso mirror)!
 * Enjoy!
 */

import java.util.Scanner;
import java.io.*;

public class yUbuntuMain {
	public static void main (String[] args) {
		System.out.println("Coming soon!");
		System.out.println("Welcome to yUbuntu! Please wait for the terminal to be initialized...");
		Scanner sc = new Scanner(System.in);
		System.out.println("Load saved data from previous session if exists? [yes/no/discard]");
		String loadDataTrue = sc.nextLine();
		if (loadDataTrue.equals("yes"))
		System.out.println("Save login info? [yes/no]");
		String saveLogin = sc.nextLine();
		if (saveLogin.equals("yes")) {
			createFile();
			String user = sc.nextLine();
			writeUsername(user);
		} else {

		}
	}

	public static void writeUsername(String username) {
		try {
			FileWriter saveuser = new FileWriter("loginData.yubuntu");
			saveuser.write(username);
			saveuser.close();
			System.out.println("[  OK  ] Successfully wrote to the file 'loginData.yubuntu'");
		} catch (IOException e) {
			System.out.println("[ERROR ] An error occurred.");
			e.printStackTrace();
		}
	}

	public static void createFile() {
		try {
			File loginDataF = new File("loginData.yubuntu");
			if (loginDataF.createNewFile()) {
				System.out.println("[  OK  ] File created: " + loginDataF.getName());
			} else {
				System.out.println("[ERROR ] File already exists.");
			}
		} catch (IOException e) {
			System.out.println("[ERROR ] An error occurred.");
			e.printStackTrace();
		}
	}
}