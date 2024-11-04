package boundary;

import control.StudentMaintenance;
import control.TutorialGroupMaintenance;
import java.util.Scanner;

public class TutorialGroupMaintenanceUI {

    private TutorialGroupMaintenance controller;
    private Scanner scanner;

    public TutorialGroupMaintenanceUI(StudentMaintenance studentMaintenance) {
        this.controller = new TutorialGroupMaintenance(studentMaintenance); // Correctly pass the studentMaintenance here
        this.scanner = new Scanner(System.in);
    }

    public void TutorialGrpMenu() {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    handleAddStudentToGroup();
                    break;
                case 2:
                    handleRemoveStudentFromGroup();
                    break;
                case 3:
                    handleChangeTutorialGroupForStudent();
                    break;
                case 4:
                    handleFindStudentInGroup();
                    break;
                case 5:
                    handleListAllStudentsInGroup();
                    break;
                case 6:
                    handleAddNewTutorialGroup();
                    break;
                case 7:
                    handleRemoveTutorialGroup();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private void displayMenu() {
        System.out.println("\nTutorial Group Maintenance Menu");
        System.out.println("1. Add Student to Tutorial Group");
        System.out.println("2. Remove Student from Tutorial Group");
        System.out.println("3. Change Tutorial Group for a Student");
        System.out.println("4. Find a Student in a Tutorial Group");
        System.out.println("5. List All Students in a Tutorial Group");
        System.out.println("6. Add a New Tutorial Group");
        System.out.println("7. Remove a Tutorial Group");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    private void handleAddStudentToGroup() {
        System.out.print("\nEnter group ID: ");
        String groupId = scanner.nextLine();

        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        boolean isAdded = controller.addStudentToGroup(groupId, studentId);
        if (isAdded) {
            System.out.println("Student added to the group successfully.");
        } else {
            System.out.println("Failed to add student to the group.");
        }
    }

    private void handleRemoveStudentFromGroup() {
        System.out.print("Enter group ID: ");
        String groupId = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        controller.removeStudentFromGroup(groupId, studentId);
    }

    private void handleChangeTutorialGroupForStudent() {
        System.out.print("Enter old group ID: ");
        String oldGroupId = scanner.nextLine();
        System.out.print("Enter new group ID: ");
        String newGroupId = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        controller.changeTutorialGroupForStudent(oldGroupId, newGroupId, studentId);
    }

    private void handleFindStudentInGroup() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        controller.findStudentInGroup(studentId);
    }

    private void handleListAllStudentsInGroup() {
        System.out.print("Enter group ID: ");
        String groupId = scanner.nextLine();
        controller.listAllStudentsInGroup(groupId);
    }

    private void handleAddNewTutorialGroup() {
        System.out.print("Enter new group ID: ");
        String groupId = scanner.nextLine();
        controller.addNewTutorialGroup(groupId);
    }

    private void handleRemoveTutorialGroup() {
        System.out.print("Enter group ID to remove: ");
        String groupId = scanner.nextLine();
        controller.removeTutorialGroup(groupId);
    }
}
