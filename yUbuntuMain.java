/**
 * yUbuntu
 * make sure to check out codedash.net (Learn code for free, forever.) and serverimage.xyz (a simple .iso mirror)!
 * Enjoy!
 */

import java.nio.file.*;
import java.util.Scanner;
import java.io.*;
import java.util.stream.Stream;

public class yUbuntuMain {
	public static void main (String[] args) {
		String savedName = "";
		String savedPass = "";

		//

		System.out.println("[ BETA ] Coming soon!");
		System.out.println("[ INFO ] Welcome to yUbuntu! Please wait for the terminal to be initialized...");
		Scanner sc = new Scanner(System.in);
		System.out.println("[ INFO ] Load saved data from previous session if exists? [yes/discard]");
		String loadDataTrue = sc.nextLine();
		if (loadDataTrue.equals("yes")) {
			//check if file exists
			File lgnDatExists = new File("loginData.yubuntu");
			boolean lDEtrue = lgnDatExists.exists();

			//if file exists
			if (lDEtrue == true) {
				try (Stream<String> lines = Files.lines(Paths.get("loginData.yubuntu"))) {
					savedName = lines.skip(0).findFirst().get();
					savedPass = lines.skip(1).findFirst().get();
				} catch (IOException e) {
					System.out.println("[ERROR ] Failed to read file.");
				} finally {

				}
			} else {
				System.out.println("[ERROR ] File does not exist.");
			}
		} else {
			System.out.println("[ WARN ] Discard previous saved data [yes/no]");
			String discardTrue = sc.nextLine();
			if (discardTrue.equals("yes")) {
				//not implemented
			} else {
				//not implemented
			}
		}

		///


		System.out.println("[ INFO ] Save login info? [yes/no]");
		String saveLogin = sc.nextLine();
		if (saveLogin.equals("yes")) {
			createFile();
			System.out.println("[ INFO ] Login as: ");
			String user = sc.nextLine();
			writeUsername(user);
			//write password
			System.out.println("[ INFO ] Choose a password: ");
			String passwd = sc.nextLine();
			writePassword(passwd);
		} else {
			System.out.println("[ WARN ] Login data skipped. Proceeding to command line");
		}
	}

	public static void writeUsername(String username) {
		try {
			FileWriter saveuser = new FileWriter("loginData.yubuntu");
			saveuser.write(username);
			saveuser.close();
			System.out.println("[  OK  ] Successfully wrote username to the file './loginData.yubuntu'");
		} catch (IOException e) {
			System.out.println("[ERROR ] An error occurred.");
			e.printStackTrace();
		}
	}

	public static void writePassword(String password) {
		try {
			FileWriter savepass = new FileWriter("loginData.yubuntu");
			savepass.write(password);
			savepass.close();
			System.out.println("[  OK  ] Successfully wrote password to the file './loginData.yubuntu'");
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
				System.out.println("[ERROR ] Aborting. Restarting...");
				main(null);
			}
		} catch (IOException e) {
			System.out.println("[ERROR ] An error occurred.");
			e.printStackTrace();
		}
	}

	//authentication from saved login info
	public static void authFF(String user, String passwd) {
		//
	}

	//THE terminal
	public static void terminal() {
		System.out.println("[ INFO ] Not coded yet...");
	}
}