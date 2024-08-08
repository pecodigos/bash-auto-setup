import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("========== BASH COMMAND FROM FILE ==========");
        System.out.println("============ Made by /pecodigos ============");

        System.out.print("\nEnter file's path that you want to execute the commands from: ");
        String filePath = sc.nextLine();

        List<String> list = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {

            String commandLine;

            while ((commandLine = bufferedReader.readLine()) != null) {
                list.add(commandLine);
            }
            for (String command : list) {
                new ProcessBuilder("bash", "-c", command).start();
                System.out.println(command + " command was executed.");
            }
            System.out.println("\nYou succesfully setup your environment!");

        } catch (IOException e) {
            System.out.println("\nError! File not found.");
        }

        sc.close();
    }
}
