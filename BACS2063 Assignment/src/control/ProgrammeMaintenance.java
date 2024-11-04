package control;

import boundary.ProgrammeMaintenanceUI;
//Own ADT
import ADT.LinkedList;
import adt.ListInterface;
//Borrow ADT
import adt.LinkedQueue;
import adt.QueueInterface;
import entity.Programme;
import entity.TutorialGroup;
import java.util.InputMismatchException;
import utility.MessageUI;
import java.util.Scanner;
import static utility.designUI.*;

/**
 *
 * @author NicholasTayJunYang
 */
public class ProgrammeMaintenance {

    private StudentMaintenance studentMaintenance;
    private final Scanner scanner;
    private final ListInterface<Programme> programmeList;
    private final ProgrammeMaintenanceUI programmeUI;
    private final TutorialGroupMaintenance tutorialGroupMaintenance;

    public ProgrammeMaintenance(ListInterface<Programme> programme) {
        this.programmeList = programme;
        this.scanner = new Scanner(System.in);
        this.programmeUI = new ProgrammeMaintenanceUI();
        this.tutorialGroupMaintenance = new TutorialGroupMaintenance(studentMaintenance);
        initializeProgrammesAndTutorialGroups();
    }

    public void runProgrammeMaintenance() {
        int choice = 0;
        do {
            choice = programmeUI.getMenuChoice();
            switch (choice) {
                case 0:
                    MessageUI.displayExitMessage();
                    break;
                case 1:
                    addNewProgramme();
                    programmeUI.listAllProgramme(getAllProgramme());
                    break;
                case 2:
                    runSearchMenu();
                    break;
                case 3:
                    programmeUI.listAllProgramme(getAllProgramme());
                    break;
                case 4:
                    runEditProductMaintenance();
                    programmeUI.listAllProgramme(getAllProgramme());
                    break;
                case 5:
                    programmeUI.listAllProgramme(getAllProgramme());
                    deleteProgramme();
                    break;
                case 6:
                    programmeUI.listAllProgramme(getAllProgramme());
                    addTutorialGroupToProgramme();
                    break;
                case 7:
                    removeTutorialGroupFromProgramme();
                    break;
                case 8:
                    listAllTutorialGroupsForProgramme();
                    break;
                case 9:
                    generateReport();
                    break;
                default:
                    MessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != 0);
    }

    public void addNewProgramme() {
        Programme newProgramme = programmeUI.addProgrammeDetails();
        programmeList.add(newProgramme);
    }

    public String getAllProgramme() {
        int i;
        String outputStr = "";
        System.out.println("List Of Programme");
        System.out.println("+-----+----------------+--------------------------------------------------------+"
                + "--------------+------------+");
        System.out.println("| No  |       ID       |                          Name                          |"
                + "  Department  |  Duration  |");
        System.out.println("+-----+----------------+--------------------------------------------------------+"
                + "--------------+------------+");

        for (i = 1; i <= programmeList.getNumberOfEntries(); i++) {

            System.out.printf("| %-3s ", i);
            System.out.println(programmeList.getEntry(i));
            System.out.println("+-----+----------------+--------------------------------------------------------+"
                    + "--------------+------------+");

        }
        return outputStr;
    }

    public void runSearchMenu() {
        int choice;
        do {
            choice = programmeUI.getSearchChoice();
            switch (choice) {
                case 0:
                    MessageUI.displayExitMessage();
                    break;
                case 1:
                    String ID = programmeUI.inputID();
                    Programme foundProgrammeID = searchByID(ID);
                    if (foundProgrammeID != null) {
                        System.out.println(ANSI_GREEN + "Found Programme: " + ANSI_RESET);

                        System.out.println("+----------------+--------------------------------------------------------+"
                                + "--------------+------------+");
                        System.out.println("|       ID       |                          Name                          |"
                                + "  Department  |  Duration  |");
                        System.out.println("+----------------+--------------------------------------------------------+"
                                + "--------------+------------+");
                        System.out.println(foundProgrammeID);
                        System.out.println("+----------------+--------------------------------------------------------+"
                                + "--------------+------------+");
                    } else {
                        System.out.println(ANSI_RED + "No Programme found with name: " + ID + ANSI_RESET);
                    }

                    break;
                case 2:
                    String name = programmeUI.inputName();
                    Programme foundProgrammeName = searchByName(name);
                    if (foundProgrammeName != null) {
                        System.out.println(ANSI_GREEN + "Found Programme: " + ANSI_RESET);
                        System.out.println("+----------------+--------------------------------------------------------+"
                                + "--------------+------------+");
                        System.out.println("|       ID       |                          Name                          |"
                                + "  Department  |  Duration  |");
                        System.out.println("+----------------+--------------------------------------------------------+"
                                + "--------------+------------+");
                        System.out.println(foundProgrammeName);
                        System.out.println("+----------------+--------------------------------------------------------+"
                                + "--------------+------------+");

                    } else {
                        System.out.println(ANSI_RED + "No Programme found with name: " + name + ANSI_RESET);
                    }
                    break;
                default:
                    MessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != 0);
    }

    public Programme searchByName(String name) {
        for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
            Programme prog = programmeList.getEntry(i);
            if (prog.getName().equalsIgnoreCase(name)) {
                return prog;
            }
        }
        return null;
    }

    public Programme searchByID(String id) {
        for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
            Programme prog = programmeList.getEntry(i);
            if (prog.getID().equalsIgnoreCase(id)) {
                return prog;
            }
        }
        return null;
    }

    public void runEditProductMaintenance() {
        Programme selectedProgramme = selectProgrammeFromList(programmeList);

        if (selectedProgramme == null) {
            programmeUI.displayNoProgrammesMessage();
            return;
        }

        int choice;
        do {
            choice = programmeUI.getEditMenuChoice();
            switch (choice) {
                case 0:
                    MessageUI.displayExitMessage();
                    break;
                case 1:
                    String newID = programmeUI.inputID();
                    selectedProgramme.setID(newID);
                    break;
                case 2:
                    String newName = programmeUI.inputName();
                    selectedProgramme.setName(newName);
                    break;
                case 3:
                    String newDepartment = programmeUI.inputDepartment();
                    selectedProgramme.setDepartment(newDepartment);
                    break;
                case 4:
                    int newDuration = programmeUI.inputDuration();
                    selectedProgramme.setDuration(newDuration);
                    break;
                default:
                    MessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != 0);
    }

    public Programme selectProgrammeFromList(ListInterface<Programme> programmeList) {
        getAllProgramme();
        System.out.print("Select the programme you want to update (number): ");
        int selection;
        try {
            selection = scanner.nextInt();
            if (selection <= 0 || selection > programmeList.getNumberOfEntries()) {
                System.out.println(ANSI_RED + "Invalid selection! Please choose a valid number." + ANSI_RESET);
                return null;
            }
            return programmeList.getEntry(selection);
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + "Invalid input! Please enter a valid number." + ANSI_RESET);
            scanner.nextLine();
            return null;
        }
    }

    public void updateProgrammeName(Programme programme, String newName) {

        programme.setName(newName);
    }

    public void updateDepartment(Programme programme, String newDepartment) {

        programme.setDepartment(newDepartment);
    }

    public void updateDuration(Programme programme, int newDuration) {

        programme.setDuration(newDuration);
    }

    public void deleteProgramme() {
        int programmeIndex;
        do {
            programmeIndex = getDeleteMenuChoice();

            if (programmeIndex < 0 || programmeIndex > programmeList.getNumberOfEntries()) {
                System.out.println(ANSI_RED + "Invalid choice. Please select a valid programme number or 0 to quit." + ANSI_RESET);
            } else if (programmeIndex == 0) {
                return; // User wants to quit without deleting
            } else {
                programmeList.remove(programmeIndex);
                System.out.println(ANSI_GREEN + "Programme successfully deleted!" + ANSI_RESET);
            }
        } while (programmeIndex < 0 || programmeIndex > programmeList.getNumberOfEntries());
    }

    public int getDeleteMenuChoice() {
        System.out.println("\nSelect the programme number you want to delete");

        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
        int choice = -1;
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + "Invalid input! Please enter a number." + ANSI_RESET);
            scanner.nextLine();
        }
        scanner.nextLine();
        return choice;
    }

    private boolean containsTutorialGroup(ListInterface<TutorialGroup> list, TutorialGroup tg) {
        for (int i = 1; i <= list.getLength(); i++) {
            if (list.get(i).getGroupId().equals(tg.getGroupId())) {
                return true;
            }
        }
        return false;
    }

    public void addTutorialGroupToProgramme() {
        getAllProgramme();  // Display the list of programmes.
        System.out.print("Select the programme to which you want to add a tutorial group (number): ");
        int selection;
        try {
            selection = scanner.nextInt();
            if (selection <= 0 || selection > programmeList.getNumberOfEntries()) {
                System.out.println(ANSI_RED + "Invalid selection! Please choose a valid number." + ANSI_RESET);
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + "Invalid input! Please enter a valid number." + ANSI_RESET);
            scanner.nextLine();
            return;
        }
        Programme programme = programmeList.getEntry(selection);

        if (programme != null) {
            System.out.println("Available tutorial groups to add: ");

            QueueInterface<TutorialGroup> availableGroups = tutorialGroupMaintenance.getTutorialGroups();
            QueueInterface<TutorialGroup> tempQueue = new LinkedQueue<>();  // Temporary queue

            while (!availableGroups.isEmpty()) {
                TutorialGroup tg = availableGroups.dequeue();
                tempQueue.enqueue(tg);

                if (!isTutorialGroupAssociated(tg)) {
                    System.out.println("- " + tg.getGroupId());
                }
            }

            while (!tempQueue.isEmpty()) {
                availableGroups.enqueue(tempQueue.dequeue());
            }

            String groupId = programmeUI.inputTutorialGroupId();
            TutorialGroup groupToAdd = tutorialGroupMaintenance.getTutorialGroupById(groupId);

            if (groupToAdd != null) {
                if (!isTutorialGroupAssociated(groupToAdd)) {
                    programme.addTutorialGroup(groupToAdd);
                    System.out.println("\n===================================");
                    System.out.println(ANSI_GREEN + "Tutorial group added successfully!" + ANSI_RESET);
                    System.out.println("====================================\n");
                } else {
                    System.out.println("\n======================================");
                    System.out.println(ANSI_RED + "Error: Tutorial group already associated with another programme!" + ANSI_RESET);
                    System.out.println("======================================\n");
                }
            } else {
                System.out.println("\n===================================");
                System.out.println("Tutorial group not found!");
                System.out.println("====================================\n");
            }
        } else {
            System.out.println("\n===================================");
            System.out.println("Error: Programme not found!");
            System.out.println("====================================\n");
        }
    }

// Check if a tutorial group is already associated with any programme
    private boolean isTutorialGroupAssociated(TutorialGroup tg) {
        for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
            Programme prog = programmeList.getEntry(i);
            ListInterface<TutorialGroup> programmeGroups = prog.getTutorialGroups();
            if (containsTutorialGroup(programmeGroups, tg)) {
                return true;
            }
        }
        return false;
    }

    public void removeTutorialGroupFromProgramme() {
        getAllProgramme();  // Display the list of programmes.
        System.out.print("Select the programme to which you want to remove from tutorial group (number): ");
        int selection;
        try {
            selection = scanner.nextInt();
            if (selection <= 0 || selection > programmeList.getNumberOfEntries()) {
                System.out.println(ANSI_RED + "Invalid selection! Please choose a valid number." + ANSI_RESET);
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + "Invalid input! Please enter a valid number." + ANSI_RESET);
            scanner.nextLine();
            return;
        }
        Programme programme = programmeList.getEntry(selection);

        if (programme != null) {
            System.out.println("Available tutorial groups to remove: ");
            ListInterface<TutorialGroup> tutorialGroups = programme.getTutorialGroups();
            for (int j = 1; j <= tutorialGroups.getLength(); j++) {
                TutorialGroup tg = tutorialGroups.get(j);
                System.out.println("- " + tg.getGroupId());
            }

            String groupId = programmeUI.inputTutorialGroupId();
            boolean removed = programme.removeTutorialGroupById(groupId);

            if (removed) {
                System.out.println("\n======================================");
                System.out.println(ANSI_GREEN + "Tutorial group removed successfully!" + ANSI_RESET);
                System.out.println("\n======================================");
            } else {
                System.out.println("\n=================================================");
                System.out.println(ANSI_RED + "Error: Tutorial group not found in this programme!" + ANSI_RESET);
                System.out.println("\n================================================= ");
            }
        } else {
            System.out.println("\n==============================");
            System.out.println("Error: Programme not found!");
            System.out.println("==============================\n");
        }
    }

    public void listAllTutorialGroupsForProgramme() {
        String programmeId = programmeUI.inputID();
        Programme programme = searchByID(programmeId);

        if (programme != null) {
            ListInterface<TutorialGroup> tutorialGroups = programme.getTutorialGroups();

            System.out.println("\n=================================================");
            System.out.println("Tutorial Groups for Programme ID: " + programmeId);
            System.out.println("\n=================================================");

            if (tutorialGroups == null || tutorialGroups.isEmpty()) {
                System.out.println(ANSI_RED + "Error: No tutorial groups found for this programme!" + ANSI_RESET);
            } else {
                for (int i = 1; i <= tutorialGroups.getLength(); i++) {
                    System.out.println("- " + tutorialGroups.get(i).getGroupId());
                }
            }
            System.out.println();

        } else {
            System.out.println("\n==============================");
            System.out.println(ANSI_RED + "Error: Programme not found!" + ANSI_RESET);
            System.out.println("==============================\n");
        }
    }

    public void generateReport() {
        if (programmeList.isEmpty()) {
            System.out.println(ANSI_RED + "No programmes available to generate a report." + ANSI_RESET);
            return;
        }

        System.out.println("\n" + "========== Programmes and Tutorial Groups Report ==========");
        System.out.println();

        for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
            Programme currentProgramme = programmeList.getEntry(i);

            System.out.println("Programme " + i + ": ");
            System.out.println("-------------------------------------------------");
            System.out.println("Programme ID: " + currentProgramme.getID());
            System.out.println("Programme Name: " + currentProgramme.getName());
            System.out.println("Programme Department: " + currentProgramme.getDepartment());
            System.out.println("Programme Duration: " + currentProgramme.getDuration() + " years");

            ListInterface<TutorialGroup> tutorialGroups = currentProgramme.getTutorialGroups();

            if (tutorialGroups.isEmpty()) {
                System.out.println(ANSI_RED + "-> No tutorial groups for this programme." + ANSI_RESET);
            } else {
                System.out.println(ANSI_BLUE + "Tutorial Groups:" + ANSI_RESET);
                for (int j = 1; j <= tutorialGroups.getLength(); j++) {
                    TutorialGroup tg = tutorialGroups.get(j);
                    System.out.println("    - " + tg.getGroupId());
                }
            }
            System.out.println("-------------------------------------------------\n");
        }
    }

    private void initializeProgrammesAndTutorialGroups() {

        // Add Programmes  
        System.out.println("Total Programmes in List: " + programmeList.getNumberOfEntries());
        programmeList.add(new Programme("A1001", "Master of Business Administration", "FAFB", 4));
        programmeList.add(new Programme("A1002", "Bachelor of Accounting", "FAFB", 2));
        programmeList.add(new Programme("A1003", "Diploma in Accounting SCIENCE", "FAFB", 2));

        programmeList.add(new Programme("B1001", "Doctor of Philosophy (Information Technology)", "FOCS", 3));
        programmeList.add(new Programme("B1002", "Master of Information Technology", "FOCS", 3));
        programmeList.add(new Programme("B1003", "Diploma in Information Technology", "FOCS", 2));

        programmeList.add(new Programme("C1001", "Master of Engineering Science", "FOET", 2));
        programmeList.add(new Programme("C1002", "Bachelor of Mechanical Engineering", "FOET", 2));
        programmeList.add(new Programme("C1003", "Diploma of Mechanical Engineering", "FOET", 2));

        programmeList.add(new Programme("D1001", "Master of Arts (Psychology)", "FSSH", 2));
        programmeList.add(new Programme("D1002", "Bachelor of Social Science (Honours)", "FSSH", 2));
        programmeList.add(new Programme("D1003", "Diploma in Counselling", "FSSH", 2));

        programmeList.add(new Programme("E1001", "Master of Arts in Communication", "FCCI", 2));
        programmeList.add(new Programme("E1002", "Bachelor of Communication (Honours)", "FCCI", 2));
        programmeList.add(new Programme("E1003", "Diploma in Advertising", "FCCI", 2));

        // Add TutorialGroups to Programmes
        TutorialGroup tg1 = new TutorialGroup("SG01");
        TutorialGroup tg2 = new TutorialGroup("SG02");
        TutorialGroup tg3 = new TutorialGroup("SG03");

        TutorialGroup tg4 = new TutorialGroup("SG04");
        TutorialGroup tg5 = new TutorialGroup("SG05");
        TutorialGroup tg6 = new TutorialGroup("SG06");

        Programme prog1 = programmeList.getEntry(1);
        prog1.addTutorialGroup(tg1);
        prog1.addTutorialGroup(tg2);
        prog1.addTutorialGroup(tg3);

        Programme prog2 = programmeList.getEntry(2);
        prog2.addTutorialGroup(tg4);
        prog2.addTutorialGroup(tg5);
        prog2.addTutorialGroup(tg6);
    }

}
