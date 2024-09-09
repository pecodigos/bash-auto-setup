import java.util.*;

public class AutoBash {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MenuOption menuOption = new MenuOption();

        System.out.println("========== AUTO BASH SETUP FROM FILE ==========");
        System.out.println("============ Made by pecodigos ============");

        int programStart = -1;

        while (programStart != 0) {

            System.out.println("\n1- Execute commands.");
            System.out.println("2- Help.");
            System.out.println("0- Exit program.");

            while (programStart > 2 || programStart < 0) {
                try {
                    System.out.print("\nEnter the number of the option you want to select: ");
                    programStart = sc.nextInt();
                    sc.nextLine();

                    if (programStart > 2 || programStart < 0) {
                        System.out.println("You entered an invalid number. Please, enter a number between 0-2.");
                    }
                    System.out.println();
                } catch (InputMismatchException e) {
                    throw new InputMismatchException();
                }
            }
            switch (programStart) {
                case 1:
                    menuOption.executeCommands();
                    sc.nextLine();
                    menuOption.clearScreen();
                    break;
                case 2:
                    menuOption.getHelp();
                    sc.nextLine();
                    menuOption.clearScreen();
                    break;
                default:
                    System.out.println("See you!");
                    break;
            }
            if (programStart != 0) {
                programStart = -1;
            }
        }
        sc.close();
    }
}