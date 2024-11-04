package boundary;

import adt.ListInterface;
import entity.Programme;
import java.util.InputMismatchException;
import java.util.Scanner;
import static utility.designUI.*;

/**
 *
 * @author NicholasTayJunYang
 */
public class ProgrammeMaintenanceUI {

    private ListInterface<Programme> programme;
    Scanner scanner = new Scanner(System.in);

    public int getMenuChoice() {
        int choice = -1;

        do {
            System.out.println("\n=----- Programme Menu -----=");
            System.out.println("1. Add Programme");
            System.out.println("2. Search Programme");
            System.out.println("3. List Programme");
            System.out.println("4. Edit Programme");
            System.out.println("5. Remove Programme");
            System.out.println("6. Add tutorial group to a programme");
            System.out.println("7. Remove a tutorial group to a programme");
            System.out.println("8. List all tutorial groups for a programme");
            System.out.println("9. Generate relevant reports");
            System.out.println("0. Quit");
            System.out.print("Enter choice: ");

            try {
                choice = scanner.nextInt();

                if (choice >= 0 && choice <= 9) {
                    break;
                } else {
                    System.out.println(ANSI_RED + "Please enter a valid choice between 0 and 9." + ANSI_RESET);
                }

            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "Invalid input! Please enter a number." + ANSI_RESET);
                scanner.nextLine();
            }

        } while (true);

        scanner.nextLine();
        System.out.println();
        return choice;
    }

    //================ Add a new programme ====================
    public String inputID() {
        System.out.println("Enter programme id: ");
        String id = scanner.nextLine();
        return id;
    }

    public String inputName() {
        System.out.println("Enter programme name: ");
        String name = scanner.nextLine();
        return name;
    }

    public String inputDepartment() {
        System.out.println("Enter programme department: ");
        String department = scanner.nextLine();
        return department;
    }

    public int inputDuration() {
        int duration = 0;
        boolean valid = false;

        while (!valid) {
            System.out.println("Enter programme duration: ");
            try {
                duration = scanner.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "Error: Please enter a valid number." + ANSI_RESET);
                scanner.next();
            }
        }

        return duration;
    }

    //================ Combine Add a new programme ====================
    public Programme addProgrammeDetails() {
        String id = inputID();
        String name = inputName();
        String department = inputDepartment();
        int duration = inputDuration();
        System.out.println(ANSI_GREEN + "Successful" + ANSI_RESET);
        return new Programme(id, name, department, duration);
    }

    //================  Find programme ====================
    public int getSearchChoice() {
        int choice = -1;

        do {
            System.out.println("\nSearch by");
            System.out.println("1. ID");
            System.out.println("2. Name");
            System.out.println("0. Quit");
            System.out.print("Enter choice: ");

            try {
                choice = scanner.nextInt();

                if (choice >= 0 && choice <= 2) {
                    break;
                } else {
                    System.out.println(ANSI_RED + "Please enter a valid choice between 0 and 2." + ANSI_RESET);
                }

            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "Invalid input! Please enter a number." + ANSI_RESET);
                scanner.nextLine();
            }

        } while (true);

        scanner.nextLine();
        return choice;
    }

    //================ List all the programm ====================
    public void listAllProgramme(String outputStr) {
        System.out.println(outputStr);
    }

    //================ Edit a programme ====================
    public int getEditMenuChoice() {
        int choice = -1;

        do {
            System.out.println("\nSelect the details you want to edit");
            System.out.println("1. Edit Programme ID");
            System.out.println("2. Edit Programme Name");
            System.out.println("3. Edit Programme Department");
            System.out.println("4. Edit programme Duration");
            System.out.println("0. Quit");
            System.out.print("Enter choice: ");

            try {
                choice = scanner.nextInt();

                if (choice >= 0 && choice <= 4) {
                    break;
                } else {
                    System.out.println(ANSI_RED + "Please enter a valid choice between 0 and 4." + ANSI_RESET);
                }

            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "Invalid input! Please enter a number." + ANSI_RESET);
                scanner.nextLine();
            }

        } while (true);

        scanner.nextLine();
        System.out.println();
        return choice;
    }

    public void displayNoProgrammesMessage() {
        System.out.println(ANSI_RED + "No Programmes available to update." + ANSI_RESET);
    }

    //================ Remove a programme ====================
    public String inputTutorialGroupId() {
        System.out.println("Enter tutorial group ID: ");
        return scanner.nextLine();
    }

}
