package entity;

import adt.QueueInterface;
import adt.LinkedQueue;

public class TutorialGroup {

    private String groupId;
    private QueueInterface<String> studentIds;  // Just store the student IDs

    public TutorialGroup(String groupId) {
        this.groupId = groupId;
        this.studentIds = new LinkedQueue<>();
    }

    public void addStudentById(String studentId) {
        studentIds.enqueue(studentId);  // Just add the student ID
    }

    public boolean removeStudent(String studentId) {
        QueueInterface<String> tempQueue = new LinkedQueue<>();
        boolean isRemoved = false;

        while (!studentIds.isEmpty()) {
            String currentStudentId = studentIds.dequeue();
            if (currentStudentId.equals(studentId)) {
                isRemoved = true;
            } else {
                tempQueue.enqueue(currentStudentId);
            }
        }

        while (!tempQueue.isEmpty()) {
            studentIds.enqueue(tempQueue.dequeue());
        }

        return isRemoved;
    }

    public boolean containsStudent(String studentId) {
        QueueInterface<String> tempQueue = new LinkedQueue<>();
        boolean isFound = false;

        while (!studentIds.isEmpty()) {
            String currentStudentId = studentIds.dequeue();
            tempQueue.enqueue(currentStudentId);
            if (currentStudentId.equals(studentId)) {
                isFound = true;
            }
        }

        while (!tempQueue.isEmpty()) {
            studentIds.enqueue(tempQueue.dequeue());
        }

        return isFound;
    }

    public void listAllStudents() {
        QueueInterface<String> tempQueue = new LinkedQueue<>();

        while (!studentIds.isEmpty()) {
            String studentId = studentIds.dequeue();
            System.out.println(studentId);
            tempQueue.enqueue(studentId);
        }

        while (!tempQueue.isEmpty()) {
            studentIds.enqueue(tempQueue.dequeue());
        }
    }

    // Checks if the TutorialGroup is empty (has no students)
    public boolean isEmpty() {
        return studentIds.isEmpty();
    }

    // Returns the queue of student IDs
    public QueueInterface<String> getStudents() {
        QueueInterface<String> tempQueue = new LinkedQueue<>();
        QueueInterface<String> copyOfStudents = new LinkedQueue<>();

        while (!studentIds.isEmpty()) {
            String studentId = studentIds.dequeue();
            tempQueue.enqueue(studentId);
            copyOfStudents.enqueue(studentId);
        }

        while (!tempQueue.isEmpty()) {
            studentIds.enqueue(tempQueue.dequeue());
        }

        return copyOfStudents;
    }

    // Getter for groupId
    public String getGroupId() {
        return groupId;
    }
}
