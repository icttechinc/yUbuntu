package yUbuntu;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class yUbuntuIO {
    public String openFP;
    public String openPWD;
    public String fullPath;

    public static void main(String[] args) {

    }

    public void openf(String FP) {
        //
    }

    public void appendf(String apName, String apText) {
        try {
            File file = new File(apName);
            FileWriter fr = new FileWriter(file, true);
            fr.write(apText);
            fr.close();
            System.out.println(apText + " --] " + apName);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            Scanner sc = new Scanner(System.in);
            System.out.println("Print stack trace? [yes/no]");
            if (sc.nextLine().equals("yes")) {
                e.printStackTrace();
            } else {

            }
        }
    }

    public void delf() {
        //
    }

    public void readff() {
        //
    }

    public void readfl(int lineNumber) {
        //
    }

    public void wipef() {
        //
    }

    public void pfp() {
        //
    }
}
