package control;

import boundary.TutorialGroupMaintenanceUI;
import entity.TutorialGroup;
import adt.QueueInterface;
import adt.LinkedQueue;
import entity.Student;

public class TutorialGroupMaintenance {

    private QueueInterface<TutorialGroup> tutorialGroups;
    private TutorialGroupMaintenanceUI ui;
    private StudentMaintenance studentMaintenance; // add this line

    public TutorialGroupMaintenance(StudentMaintenance studentMaintenance) {
        this.tutorialGroups = new LinkedQueue<>();
        this.studentMaintenance = studentMaintenance; // add this line

        initializeTutorialGroups();
    }

    private void initializeTutorialGroups() {
        tutorialGroups.enqueue(new TutorialGroup("TG01"));
        tutorialGroups.enqueue(new TutorialGroup("TG02"));
        tutorialGroups.enqueue(new TutorialGroup("TG03"));
        tutorialGroups.enqueue(new TutorialGroup("TG04"));
        tutorialGroups.enqueue(new TutorialGroup("TG05"));
        tutorialGroups.enqueue(new TutorialGroup("TG06"));
        tutorialGroups.enqueue(new TutorialGroup("TG07"));
        tutorialGroups.enqueue(new TutorialGroup("TG08"));
        tutorialGroups.enqueue(new TutorialGroup("TG09"));
        tutorialGroups.enqueue(new TutorialGroup("TG010"));
        tutorialGroups.enqueue(new TutorialGroup("TG011"));
    }

    public boolean addStudentToGroup(String groupId, String studentId) {
        // Check if student exists
        if (studentMaintenance.findStudentById(studentId) == null) {
            System.out.println("Error: Student not found.");
            return false;
        }

        QueueInterface<TutorialGroup> tempQueue = new LinkedQueue<>();
        boolean isAdded = false;
        boolean studentAlreadyInGroup = false;
        boolean studentInAnyGroup = false;

        // Iterate through all tutorial groups to check and add student
        while (!tutorialGroups.isEmpty()) {
            TutorialGroup tg = tutorialGroups.dequeue();

            // Check if the student is already in any group
            if (tg.containsStudent(studentId)) {
                studentInAnyGroup = true;
                tempQueue.enqueue(tg);
                break;
            }

            if (tg.getGroupId().equals(groupId)) {
                if (studentAlreadyInGroup) { // Check if student is already in the group
                    studentAlreadyInGroup = true;
                    tempQueue.enqueue(tg);
                    break; // No need to process further, as we've identified the group and student is already there
                }

                // If student is not already in the group, add the student
                tg.addStudentById(studentId);
                isAdded = true;
            }

            tempQueue.enqueue(tg);
        }

        // Restore the original queue
        while (!tempQueue.isEmpty()) {
            tutorialGroups.enqueue(tempQueue.dequeue());
        }

        if (studentInAnyGroup) {
            System.out.println("Error: Student is already part of another group.");
            return false;
        }

        if (studentAlreadyInGroup) {
            System.out.println("Error: Student is already in the specified group.");
            return false;
        }

        return isAdded;
    }

    public boolean removeStudentFromGroup(String groupId, String studentId) {
        if (studentMaintenance.findStudentById(studentId) == null) {
            System.out.println("Error: Student with ID " + studentId + " not found.");
            return false;
        }

        QueueInterface<TutorialGroup> tempQueue = new LinkedQueue<>();
        boolean studentRemoved = false;

        while (!tutorialGroups.isEmpty()) {
            TutorialGroup currentGroup = tutorialGroups.dequeue();

            if (currentGroup.getGroupId().equals(groupId)) {
                if (currentGroup.containsStudent(studentId)) {
                    studentRemoved = currentGroup.removeStudent(studentId);
                }
            }

            tempQueue.enqueue(currentGroup);
        }

        // Restore the original queue
        while (!tempQueue.isEmpty()) {
            tutorialGroups.enqueue(tempQueue.dequeue());
        }

        if (studentRemoved) {
            System.out.println("Successfully removed student with ID " + studentId + " from group " + groupId + ".");
        } else {
            System.out.println("Error: Could not remove student with ID " + studentId + " from group " + groupId + ". Maybe the student was not part of that group.");
        }

        return studentRemoved;
    }

    public boolean changeTutorialGroupForStudent(String oldGroupId, String newGroupId, String studentId) {
        QueueInterface<TutorialGroup> tempQueue = new LinkedQueue<>();
        TutorialGroup oldGroup = null;
        TutorialGroup newGroup = null;
        boolean studentTransferred = false;

        while (!tutorialGroups.isEmpty()) {
            TutorialGroup tg = tutorialGroups.dequeue();
            tempQueue.enqueue(tg);

            if (tg.getGroupId().equals(oldGroupId)) {
                oldGroup = tg;
            } else if (tg.getGroupId().equals(newGroupId)) {
                newGroup = tg;
            }
        }

        if (oldGroup == null) {
            System.out.println("Error: Old group not found.");
        } else if (newGroup == null) {
            System.out.println("Error: New group not found.");
        } else if (!oldGroup.containsStudent(studentId)) {
            System.out.println("Error: Student not found in the old group.");
        } else if (newGroup.containsStudent(studentId)) {
            System.out.println("Error: Student already exists in the new group.");
        } else {
            oldGroup.removeStudent(studentId);
            newGroup.addStudentById(studentId);
            studentTransferred = true;
        }

        // Restore the original queue
        while (!tempQueue.isEmpty()) {
            tutorialGroups.enqueue(tempQueue.dequeue());
        }

        return studentTransferred;
    }

    public void findStudentInGroup(String studentId) {
        QueueInterface<TutorialGroup> tempQueue = new LinkedQueue<>();
        boolean studentFound = false;

        while (!tutorialGroups.isEmpty()) {
            TutorialGroup tg = tutorialGroups.dequeue();
            if (tg.containsStudent(studentId)) {
                System.out.println("Student " + studentId + " is in group " + tg.getGroupId());
                studentFound = true;
            }
            tempQueue.enqueue(tg);
        }

        // Restore the original queue
        while (!tempQueue.isEmpty()) {
            tutorialGroups.enqueue(tempQueue.dequeue());
        }

        if (!studentFound) {
            System.out.println("Student not found in any group.");
        }
    }

    public void listAllStudentsInGroup(String groupId) {
        QueueInterface<TutorialGroup> tempGroupQueue = new LinkedQueue<>();
        QueueInterface<String> tempStudentIdQueue = new LinkedQueue<>();
        boolean groupFound = false;

        while (!tutorialGroups.isEmpty()) {
            TutorialGroup currentGroup = tutorialGroups.dequeue();

            if (currentGroup.getGroupId().equals(groupId)) {
                groupFound = true;
                System.out.println("Students in group " + groupId + ":");

                // If the group has no students inside, display an error
                if (currentGroup.isEmpty()) {
                    System.out.println("Error: No students in this group.");
                    break;
                }

                // Print table headers with adjusted column widths
                System.out.println("+-----------+--------------+----------+-------------------+-------------+-------+-------------+--------------+");
                System.out.println("| ID        | Name         | Contact  | Email             | NRIC       | Gender| DateOfBirth | Address      |");
                System.out.println("+-----------+--------------+----------+-------------------+-------------+-------+-------------+--------------+");

                QueueInterface<String> studentIdQueue = currentGroup.getStudents();
                while (!studentIdQueue.isEmpty()) {
                    String studentId = studentIdQueue.dequeue();
                    Student student = studentMaintenance.findStudentById(studentId);
                    if (student != null) { // Ensure the student was found
                        System.out.printf("| %-9s | %-10s | %-8s | %-17s | %-11s | %-5s | %-11s | %-12s |\n",
                                student.getID(), student.getName(), student.getContactNo(), student.getEmail(),
                                student.getNRIC(), student.getGender(), student.getDateOfBirth(), student.getAddress());
                    }
                    tempStudentIdQueue.enqueue(studentId); // Store the ID to the temporary queue
                }

                // Restore student IDs to the original queue
                while (!tempStudentIdQueue.isEmpty()) {
                    studentIdQueue.enqueue(tempStudentIdQueue.dequeue());
                }

                System.out.println("+-----------+--------------+----------+-------------------+-------------+-------+-------------+--------------+");
            }
            tempGroupQueue.enqueue(currentGroup);
        }

        // Restore the original group queue
        while (!tempGroupQueue.isEmpty()) {
            tutorialGroups.enqueue(tempGroupQueue.dequeue());
        }

        if (!groupFound) {
            System.out.println("Error: Group not found.");
        }
    }

    public void addNewTutorialGroup(String groupId) {
        tutorialGroups.enqueue(new TutorialGroup(groupId));
    }

    public boolean removeTutorialGroup(String groupId) {
        QueueInterface<TutorialGroup> tempQueue = new LinkedQueue<>();
        boolean isRemoved = false;

        while (!tutorialGroups.isEmpty()) {
            TutorialGroup tg = tutorialGroups.dequeue();
            if (tg.getGroupId().equals(groupId)) {
                isRemoved = true;
            } else {
                tempQueue.enqueue(tg);
            }
        }

        while (!tempQueue.isEmpty()) {
            tutorialGroups.enqueue(tempQueue.dequeue());
        }

        return isRemoved;
    }
    
    public QueueInterface<TutorialGroup> getTutorialGroups() {
    // assuming you have a list of tutorial groups in this class
    return this.tutorialGroups; 
}

    public TutorialGroup getTutorialGroupById(String groupId) {
        QueueInterface<TutorialGroup> tempQueue = new LinkedQueue<>();
        TutorialGroup foundGroup = null;

        while (!tutorialGroups.isEmpty()) {
            TutorialGroup currentGroup = tutorialGroups.dequeue();
            if (currentGroup.getGroupId().equals(groupId)) {
                foundGroup = currentGroup;
            }
            tempQueue.enqueue(currentGroup);
        }

        // Restore the original queue
        while (!tempQueue.isEmpty()) {
            tutorialGroups.enqueue(tempQueue.dequeue());
        }

        return foundGroup;
    }

}
