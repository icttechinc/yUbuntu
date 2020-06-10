package yUbuntu;

import java.io.*;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class yUbuntuIO {
    public String openFP = "";
    public String openPWD = "";
    public String FP = "";

    public static void main(String[] args) {

    }

    public void openf(String FP) {
        System.out.println("Opening file '" + FP + "'...");
        openFP = FP;
        openPWD = (new File("").getAbsolutePath());
        FP = (openPWD + "\\" + openFP);
        System.out.println(FP);
        System.out.println("File '" + openFP + "' opened.");
    }

    public void appendf(String appendText) {
        try {
            File file = new File(FP);
            FileWriter fr = new FileWriter(file, true);
            fr.write(appendText + "\n");
            fr.close();
            System.out.println("Successfully wrote '" + appendText + "' to file '" + openFP + "'.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            Scanner sc = new Scanner(System.in);
            System.out.println("Print stack trace? [yes/no]");
            if (sc.nextLine().equals("yes")) {
                e.printStackTrace();
            } else {
                //
            }
        }
    }

    public void delf() {
        File file = new File(FP);
        if (file.delete()) {
            System.out.println("Deleted file '" + openFP + "'.");
        } else {
            System.out.println("Error. Failed to delete file '" + openFP + "'.");
        }
    }

    public void readff() {
        try {
            FileReader fr = new FileReader(FP);
            int i;
            while ((i=fr.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (Exception e) {

        }
    }

    public void readfl(int lineNumber) {
        try {
            Stream<String> lines = Files.lines(Paths.get(FP));
            System.out.println(FP);
            String readflSTR = lines.skip(lineNumber).findFirst().get();
            System.out.println(readflSTR);
            lines.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            Scanner sc = new Scanner(System.in);
            System.out.println("Print stack trace? [yes/no]");
            if (sc.nextLine().equals("yes")) {
                //e.printStackTrace();
                System.out.println(FP);
            } else {

            }
        }
    }

    public void wipef() {
        try {
            PrintWriter writer = new PrintWriter(FP);
            writer.print("");
            writer.close();
        } catch (IOException e) {

        }
    }

    public void pfp() {
        System.out.println(FP);
    }
}
