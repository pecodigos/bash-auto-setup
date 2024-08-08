import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AutoBash {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Console console = System.console();

        System.out.println("========== BASH COMMAND FROM FILE ==========");
        System.out.println("============ Made by /pecodigos ============");

        System.out.print("\nEnter file's path that you want to execute the commands from: ");
        String filePath = sc.nextLine();

        char[] passwordArray = console.readPassword("\nEnter your sudo password (if needed): ");
        String password = Arrays.toString(passwordArray);

        List<String> list = new ArrayList<>();
        int iteration = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {

            String commandLine;

            while ((commandLine = bufferedReader.readLine()) != null) {
                list.add(commandLine);
            }
            for (String command : list) {
                new ProcessBuilder("bash", "-c", command).start();

                if (command.startsWith("sudo") && iteration == 0) {
                    new ProcessBuilder("bash", "-c", password).start();
                    password = "";
                    iteration++;
                }

                System.out.println("\n" + command + " command was executed.");
            }

            System.out.println("\nYou successfully setup your environment!");

        } catch (IOException e) {
            System.out.println("\nError! File not found.");
        }

        sc.close();
    }
}