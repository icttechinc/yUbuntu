package yUbuntu;

public class yUbuntuHelp {
    public static void main(String[] args) {
        System.err.println("You're not meant to run this file directly...");
        System.err.println("Please run this file through yUbuntuMain.java, which will run yUbuntuCLI.java, which will run this.");
        System.err.println("Or, you can check out our websites: codedash.net and serverimage.xyz ;)");
        System.err.println("Enjoy!");
    }

    public static void printHelp(int pageNumber) {
        if (pageNumber == 1) {
            System.out.println("yUbuntu Help Page " + pageNumber);
            System.out.println("help -p 39: Displays page 39 in the help manual.");
            System.out.println("echo test: outputs the text 'test'");
            System.out.println("touch [fileName]: creates a file with the name 'fileName'");
            System.out.println("mkdir [dirName]: creates a directory called 'dirName'");
            System.out.println("lsF: lists the files in the current directory");
            System.out.println("lsD: lists the directories in the current directory");
            System.out.println("---===---");
            System.out.println("There is another page after this. Run 'help -p 2'");
            System.out.println("---===---");
        } if (pageNumber == 2) {
            System.out.println("---===---");
            System.out.println("There is another page before this. Run 'help -p 1' to read it.");
            System.out.println("---===---");
            System.out.println("sudo apt install softwareName: installs the package called 'softwareName'");
            System.out.println("clear: clears the screen (in reality, it scrolls you down very far).");
            System.out.println("END OF HELP.. for now. More coming soon!");
        } else {
            System.err.println("Invalid page number.");
        }
    }
}
