package control;

import ADT.LinkedList;
import adt.*;
import adt.ListInterface;
import boundary.*;
import utility.MessageUI;
import entity.*;

public class MainMaintenance {

    private MainMaintenanceUI mainUI;
    private ProgrammeMaintenance programmeMaintenance;
    private StudentMaintenance studentMaintenance;
    private TutorialGroupMaintenance tutorialGroupMaintenance;
    private CourseMaintainance courseMaintainance;
    private TutorialGroupMaintenanceUI tutorialGroupUI;  // Added this line

    public MainMaintenance() {
        this.mainUI = new MainMaintenanceUI();

        ListInterface<Programme> programmeList = new LinkedList<>();
        this.programmeMaintenance = new ProgrammeMaintenance(programmeList);
        this.studentMaintenance = new StudentMaintenance();
        HashMap<String, Course> courseMap = new HashMap<>();
        this.courseMaintainance = new CourseMaintainance(courseMap);
        this.tutorialGroupUI = new TutorialGroupMaintenanceUI(studentMaintenance);  // Pass the studentMaintenance object to the UI's constructor
    }

    public void runMainMaintenance() {
        int choice = 0;
        do {
            choice = mainUI.getMenuChoice();
            switch (choice) {
                case 0:
                    MessageUI.displayExitMessage();
                    break;
                case 1:
                    programmeMaintenance.runProgrammeMaintenance();
                    break;
                case 2:
                    tutorialGroupUI.TutorialGrpMenu();  // Run the Tutorial Group menu when case 3 is selected
                    break;
                case 3:
                    courseMaintainance.runCourseMaintainance();
                    break;
                default:
                    MessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != 0);
    }

    public static void main(String[] args) {
        MainMaintenance mainMaintenance = new MainMaintenance();
        mainMaintenance.runMainMaintenance();
    }
}
