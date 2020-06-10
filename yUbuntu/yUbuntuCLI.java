package yUbuntu;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

import yUbuntu.yUbuntuHelp;
import yUbuntu.yUbuntuIO;


public class yUbuntuCLI
{
    public static void main(String[] args) {
        System.out.println("Welcome to yUbuntu CLI!");
        System.out.println("Version 13.00 BETA Revision 7.1");

        Scanner sc = new Scanner(System.in);

        System.out.println("Disk space: 400 GB TOTAL, 5.42 GB used.");
        System.out.println("Memory:     16  GB TOTAL, 0.19 GB used.");
        System.out.println("CPU:        6 CORES TOTAL, 1 PHYSICAL CPU, 2.40 GHz");
        System.out.println("Note: These IP addresses are virtual. They do not affect the real-world ones in any way.");
        System.out.println("To generate IPs, run [help] for more info.");
        System.out.println("Global IPv4: 111.111.0.1/16, Global IPv6: aaaa:bbbb:cccc::1/48, Local IPv4: 192.168.0.2/16");
        System.out.println("Drive 0   || 352 GiB ||   Partition 1 [sda1] mounted at /              -- 2 additional partition(s) exist(s)");
        System.out.println("          --  16 GiB --   Partition 2 [sda2] mounted at /vault         -- 1 additional partition(s) exist(s)");
        System.out.println("          --  32 GiB --   Partition 3 [sda3] mounted as swap partition -- 0 additional partition(s) exist(s)");
        System.out.println(" ");
        System.out.println("Note: Change hostname in /etc/hostname.yubuntu");

        String usern = "";
        try {
            Stream<String> lines = Files.lines(Paths.get("..\\loginData.yubuntu"));
            usern = lines.skip(0).findFirst().get();
            lines.close();
        } catch (IOException e) {
            System.out.println("[ERROR ] Error reading from file './loginData.yubuntu'");
        }

        String pwd = (System.getProperty("user.dir"));

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
            runCommand(latestInput, pwd);
        }
    }

    public static void runCommand(String cmd, String pwd) {
        if (cmd.startsWith("echo ")) {
            String substr = cmd.substring(5);
            System.out.println(substr);
        } else if (cmd.startsWith("help -p ")) {
            String substr = cmd.substring(8);
            int pageNum = Integer.parseInt(substr);
            yUbuntuHelp.printHelp(pageNum);
        } else if (cmd.startsWith("help")) {
            yUbuntuHelp.printHelp(1);
        } else if (cmd.startsWith("mkdir ")) {
            String substr = cmd.substring(6);
            mkdirCMD(substr, pwd);
        } else if (cmd.startsWith("touch ")) {
            String substr = cmd.substring(6);
            touchCMD(substr, pwd);
        } else if (cmd.startsWith("openf ")) {
            String filepath = cmd.substring(6);
            yUbuntuIO yUIO = new yUbuntuIO();
            yUIO.openf(filepath);
        } else if (cmd.startsWith("cd ")) {
            String cdPath = cmd.substring(3);
            try {
                File file = new File(".\\pwd.yubuntu");
                FileWriter fr = new FileWriter(file, true);
                yUbuntuIO yUIO = new yUbuntuIO();
                //System.out.println(yUIO.rawDir); //debug
                String truePath = (yUIO.rawDir + "\\" + cdPath);
                fr.write(truePath);
                fr.close();
                System.out.println("[  OK  ] Successfully wrote password to the file './pwd.yubuntu'");
            } catch (IOException e) {
                System.out.println("[ERROR ] An error occurred.");
                Scanner sc = new Scanner(System.in);
                System.out.println("Print stack trace? [yes/no]");
                if (sc.nextLine().equals("yes")) {
                    e.printStackTrace();
                } else {

                }
            }
        } else if (cmd.startsWith("pwd")) {
            try {
                Stream<String> lines = Files.lines(Paths.get(".\\pwd.yubuntu"));
                String npwd = lines.skip(0).findFirst().get();
                System.out.println(npwd);
                lines.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                Scanner sc = new Scanner(System.in);
                System.out.println("Print stack trace? [yes/no]");
                if (sc.nextLine().equals("yes")) {
                    e.printStackTrace();
                }
            } finally {
                System.err.println("Unknown error. Please contact info@codedash.net for support.");
            }
        } else if (cmd.startsWith("appendf -n ")) { ///////////////////////////////////////////////////////////////// APPEND4
            yUbuntuIO yUIO = new yUbuntuIO();
            String appendFName = cmd.substring(11, cmd.indexOf("-t"));
            String npwd = "";

            try {
                Stream<String> lines = Files.lines(Paths.get(".\\pwd.yubuntu"));
                npwd = lines.skip(0).findFirst().get();
                lines.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                Scanner sc = new Scanner(System.in);
                System.out.println("Print stack trace? [yes/no]");
                if (sc.nextLine().equals("yes")) {
                    e.printStackTrace();
                }
            } finally {
                System.err.println("Unknown error. Please contact info@codedash.net for support.");
            }

            String appendName = (npwd + appendFName);
            int indexN = (cmd.indexOf("-t") + 3);
            String appendText = cmd.substring(indexN);
            yUIO.appendf(appendName, appendText);
        } else if (cmd.startsWith("delf ")) {
            //
        } else if (cmd.startsWith("readf -f")) {
            //
        } else if (cmd.startsWith("readf -l ")) {
            //
        } else if (cmd.startsWith("wipef")) {
            //
        } else if (cmd.startsWith("pfp")) {
            //
        } else {
            System.err.println("The command you entered is either invalid or has not been implemented yet.");
            System.err.println("Please run 'help' for a list of possible commands.");
        }
    }

    public static void mkdirCMD(String dirname, String pwd) {
        System.out.println("Creating directory '" + dirname + "'... ");
        String dirFullPath = (pwd + "\\" + dirname);
        File file = new File(dirFullPath);
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory '" + dirname + "' created.");
            } else {
                System.out.println("Error: Failed to create directory '" + dirname + "'. It may already exist.");
            }
        }
    }

    public static void touchCMD(String filename, String pwd) {
        String dirFullPath = (pwd + "\\" + filename);
        try {
            File mkFile = new File(dirFullPath);
            if (mkFile.createNewFile()) {
                System.out.println("File created: '" + mkFile.getName() + "'");
            } else {
                System.out.println("Error: File already exists.");
            }
        } catch (IOException e) {
            System.out.println("Java File IO Exception: An error occurred.");
            Scanner sc = new Scanner(System.in);
            System.out.println("Print stack trace? [yes/no]");
            if (sc.nextLine().equals("yes")) {
                e.printStackTrace();
            } else {

            }
        }
    }
}
