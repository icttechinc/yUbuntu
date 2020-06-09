package yUbuntu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

import yUbuntu.yUbuntuHelp;

public class yUbuntuCLI
{
    public static void main(String[] args) {
        System.out.println("Welcome to yUbuntu CLI!");
        System.out.println("Version 12.44 BETA");

        Scanner sc = new Scanner(System.in);

        System.out.println("Disk space: 64 GB TOTAL, 5.42 GB used.");
        System.out.println("Memory:     6  GB TOTAL, 0.19 GB used.");
        System.out.println("Note: These IP addresses are the IPs for our server.");
        System.out.println("To generate IPs, run [help] for more info.");
        System.out.println("Global IPv4: 111.111.0.1/16, Global IPv6: aaaa:bbbb:cccc::1/48, Local IPv4: 192.168.0.2/16");
        System.out.println("");
        System.out.println("Note: Change hostname in /etc/hostname.yubuntu");

        String usern = "";
        try {
            Stream<String> lines = Files.lines(Paths.get("..\\loginData.yubuntu"));
            usern = lines.skip(0).findFirst().get();
            lines.close();
        } catch (IOException e) {
            System.out.println("[ERROR ] Error reading from file './loginData.yubuntu'");
        }

        String pwd = "/root";

        boolean run = true;

        while (run == true) {
            cli(usern, pwd, run);
        }
    }

    public static void cli(String user, String pwd, boolean runCLI) {
        String latestInput = "";
        Scanner sc = new Scanner(System.in);
        while (runCLI == true) {
            System.out.print("[ " + user + "@" + "hostnameNotImplemented ] [ " + pwd + " ] ");
            latestInput = sc.nextLine();
            runCommand(latestInput);
        }
    }

    public static void runCommand(String cmd) {
        if (cmd.startsWith("echo ")) {
            String substr = cmd.substring(5);
            System.out.println(substr);
        } if (cmd.startsWith("help")) {
            System.out.println("Please run 'help -p x', where x is the page number.");
            System.out.println("---===---");
            System.out.println("If unsure, run 'help -p 1'.");
        } if (cmd.startsWith("help -p ")) {
            String substr = cmd.substring(8);
            int pageNum = Integer.parseInt(substr);
            yUbuntuHelp.printHelp(pageNum);
        } if (cmd.startsWith("mkdir ")) {
            String substr = cmd.substring(6);
            mkdirCMD(substr);
        } else {
            System.err.println("The command you entered is either invalid or has not been implemented yet.");
            System.err.println("Please run 'help' for a list of possible commands.");
        }
    }

    public static void mkdirCMD(String dirname) {
        System.out.println("Creating directory " + dirname);
    }

    public static void touchCMD(String filename) {
        //
    }
}
