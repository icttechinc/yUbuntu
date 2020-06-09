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
				authFF();
			} else {
				System.out.println("[ERROR ] File does not exist.");
			}
		} else {
			System.out.println("[ WARN ] Discard previous saved data [yes/no]");
			String discardTrue = sc.nextLine();
			if (discardTrue.equals("yes")) {
				System.out.println("[ INFO ] Discarded.");
			} else {
				System.out.println("[ INFO ] Restarting...");
				main(null);
			}
		}

		///

		System.out.println("[ INFO ] Save login info? [yes/no]");
		String saveLogin = sc.nextLine();
		//write login info
		if (saveLogin.equals("yes")) {
			createFile();
			System.out.println("[ INFO ] Login as: ");
			String user = sc.nextLine();
			writeUsername(user);
			//write password
			System.out.println("[ INFO ] Choose a password: ");
			String passwd = sc.nextLine();
			writePassword(passwd);
			System.out.println("[  OK  ] Login info saved to './loginData.yubuntu'");
			authFF();
		} else {
			System.out.println("[ WARN ] Login data skipped. Proceeding to command line");
		}
	}

	public static void writeUsername(String username) {
		try {
//			FileWriter saveuser = new FileWriter("loginData.yubuntu");
//			saveuser.write(username);
//			saveuser.close();
			File file = new File("loginData.yubuntu");
			FileWriter fr = new FileWriter(file, true);
			fr.write(username + "\n");
			fr.close();
			System.out.println("[  OK  ] Successfully wrote username to the file './loginData.yubuntu'");
		} catch (IOException e) {
			System.out.println("[ERROR ] An error occurred.");
			e.printStackTrace();
		}
	}

	public static void writePassword(String password) {
		try {
//			FileWriter savepass = new FileWriter("loginData.yubuntu");
//			savepass.write(password);
//			savepass.close();
			File file = new File("loginData.yubuntu");
			FileWriter fr = new FileWriter(file, true);
			fr.write(password + "\n");
			fr.close();
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
	public static void authFF() {
		String savedName = "";
		String savedPass = "";
		try {
			Stream<String> lines = Files.lines(Paths.get("loginData.yubuntu"));
			savedName = lines.skip(0).findFirst().get();
			lines.close();

			Stream<String> lines2 = Files.lines(Paths.get("loginData.yubuntu"));
			savedPass = lines2.skip(1).findFirst().get();
			lines2.close();
		} catch (IOException e) {
			System.out.println("[ERROR ] Error reading from file './loginData.yubuntu'");
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("[ AUTH ] USERNAME: ");
		String inputUser = sc.nextLine();
		System.out.println("[ AUTH ] PASSWORD: ");
		String inputPass = sc.nextLine();
		if (savedName.equals(inputUser)) {
			if (savedPass.equals(inputPass)) {
				System.out.println("[ INFO ] AUTH SUCCESS.");
				String aaa = "";
				while (true) {
					aaa = sc.nextLine();
				}
			} else {
				System.out.println("Username/Password incorrect");
				authFF();
			}
		} else {
			System.out.println("Username/Password incorrect");
			authFF();
		}
	}
}