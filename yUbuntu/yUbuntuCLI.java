package yUbuntu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class yUbuntuCLI
{
    public static void main(String[] args) {
        System.out.println("Welcome to yUbuntu CLI!");
        System.out.println("Version 12.44 BETA");

        Scanner sc = new Scanner(System.in);

        System.out.println("Disk space: 64 GB TOTAL, 5.42 GB used.");
        System.out.println("Memory:     6  GB TOTAL, 0.19 GB used.");
        System.out.println("Global IPv4: xxx.xxx.xxx.xxx/32, Global IPv6: aaaa:aaaa:aaaa:aaaa::1/64, Local IPv4: 192.168.1.38");
        System.out.println("");
        System.out.println("Note: Change hostname in /etc/hostname.yubuntu");

        String usern = "";
        try {
            Stream<String> lines = Files.lines(Paths.get("loginData.yubuntu"));
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
            System.out.print("[ " + user + "@" + "hostnameNotImplemented ] [ " + pwd + " ]");
            latestInput = sc.nextLine();
            switchC(latestInput);
        }
    }

    public static void switchC(String cmd) {
        switch (cmd) {
            case ("echo"):
        }
    }
}
