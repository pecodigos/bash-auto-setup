import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuOption {

    public void executeCommands() {
        Scanner sc = new Scanner(System.in);
        Console console = System.console();

        System.out.print("Enter file's path that you want to execute the commands from: ");
        String filePath = sc.nextLine();

        List<String> list = new ArrayList<>();
        boolean sudoRequired = false;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {

            String commandLine;

            while ((commandLine = bufferedReader.readLine()) != null) {
                list.add(commandLine);
                if (commandLine.startsWith("sudo")) {
                    sudoRequired = true;
                }
            }

            String combinedCommands = String.join(" && ", list);

            if (sudoRequired) {
                char[] passwordArray = console.readPassword("\nEnter your sudo password: ");
                String password = new String(passwordArray);
                executeWithSudo(combinedCommands, password);
            } else {
                executeCommand(combinedCommands);
            }

            System.out.println("\nYou successfully setup your environment!");

        } catch (IOException e) {
            System.out.println("\nError! File not found.");
        }
    }

    private void executeCommand(String command) throws IOException {
        Process process = new ProcessBuilder("bash", "-c", command).inheritIO().start();
        waitForProcess(process);
    }

    private void executeWithSudo(String command, String password) throws IOException {
        String sudoCommand = "echo " + password + " | sudo -S bash -c \"" + command.replace("\"", "\\\"") + "\"";
        Process process = new ProcessBuilder("bash", "-c", sudoCommand).inheritIO().start();
        waitForProcess(process);
    }

    private void waitForProcess(Process process) {
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void getHelp() {
        System.out.println("This is a pretty simple program.");

        System.out.println("When you select option 1 (execute command) you'll be prompt for two things...");
        System.out.println("\nFirst: The path where the file that contains the bash commands is.");
        System.out.println("The path should be something like -> /home/yourUserName/Downloads/bashfile.txt");
        System.out.println("\nSecond: Your sudo password (if it's necessary for the commands, if not, leave it blank).");

        System.out.println("\nThat's it! Enjoy.");
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
