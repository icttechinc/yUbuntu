package yUbuntu;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class yUbuntuIO {
    String openFP = "";
    public static void main(String[] args) {

    }

    public void openf(String filePath) {
        System.out.println("Opening file '" + openFP + "'...");
        openFP = filePath;
        System.out.println("File '" + openFP + "' opened.");
    }

    public void appendf(String appendText) {
        try {
            File file = new File(openFP);
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

            }
        }
    }

    public void delf() {
        File file = new File(openFP);
        if (file.delete()) {
            System.out.println("Deleted file '" + openFP + "'.");
        } else {
            System.out.println("Error. Failed to delete file '" + openFP + "'.");
        }
    }

    public void readff() {
        try {
            FileReader fr = new FileReader(openFP);
            int i;
            while ((i=fr.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (Exception e) {

        }
    }

    public void readfl(int lineNumber) {
        try {
            Stream<String> lines = Files.lines(Paths.get(openFP));
            String readflSTR = lines.skip(lineNumber).findFirst().get();
            System.out.println(readflSTR);
            lines.close();
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

    public void wipef() {
        try {
            PrintWriter writer = new PrintWriter(openFP);
            writer.print("");
            writer.close();
        } catch (IOException e) {

        }
    }
}
