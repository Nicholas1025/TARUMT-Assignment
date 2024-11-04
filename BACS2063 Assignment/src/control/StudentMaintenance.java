/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.StackInterface;
import adt.LinkedStack;
import entity.Student;
import boundary.StudentMaintenanceUI;

public class StudentMaintenance {

   
    private StackInterface<String> programmes = new LinkedStack<>();
    private StudentMaintenanceUI studentMaintenanceUI;
    private StackInterface<Student> students;

    public StudentMaintenance() {

        studentMaintenanceUI = new StudentMaintenanceUI();
        students = new LinkedStack<>(); // Using LinkedStack for the stack ADT.

        // Add example students to the tutorial group
        students.push(new Student("23WMR11456", "Wei Yik", "6015-154 2097", "wy@email.com", "0211456987", "Male", "02/11/23", "123 asdasdasdasd"));
        students.push(new Student("23WMR03666", "Lin", "87654321", "Lin@email.com", "0122569874", "Female", "02/10/23", "456 asdasdasdasd"));
        students.push(new Student("23WMR75899", "Joe Mama", "55555555", "Joe@email.com", "256321478966", "Female", "02/21/23", "789 asdasdasd"));
        students.push(new Student("23WMR78991", "Jacelyn Lin", "11111111", "Jacelyn@email.com", "021145874468", "Female", "02/21/23", "987 asdasdasd"));
        students.push(new Student("23WMR78992", "Jack Tan", "11111111", "Jack@email.com", "0263998745", "Male", "02/21/23", "987 asdasdasd"));
        students.push(new Student("23WMR78993", "John Low", "11111111", "John@email.com", "023666984412", "Male", "02/21/23", "987 asdasdasd"));
        students.push(new Student("23WMR78994", "Jackson Wang", "11111111", "Jackson@email.com", "036654120239", "Male", "02/21/23", "987 asdasdasd"));
        students.push(new Student("23WMR78995", "Elyn Chong", "11111111", "Elyn@email.com", "059633363654", "Female", "02/21/23", "987 asdasdasd"));
        students.push(new Student("23WMR78996", "Jennifer Wong", "11111111", "Jennifer@email.com", "021202023654", "Female", "02/21/23", "987 asdasdasd"));
        students.push(new Student("23WMR78997", "Soocy Lim", "11111111", "Soocy@email.com", "026369874123", "Female", "02/21/23", "987 asdasdasd"));

        //... Add more example students in the same manner
    }

    public void runStudentMaintenance() {
        int choice;
        do {
            choice = studentMaintenanceUI.getMenuChoice();
            switch (choice) {
                case 0:
                    System.out.println("Exiting...");
                    break;
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    editStudentDetails();
                    break;
                case 4:
                    findStudent();
                    break;
                case 5:
                    listAllStudents();
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        } while (choice != 0);
    }

    private void addStudent() {
        Student newStudent = studentMaintenanceUI.getStudentDetails();
        students.push(newStudent);
    }

    private void removeStudent() {
        if (!students.isEmpty()) {
            students.pop();
            System.out.println("Student removed from tutorial group.");
        } else {
            System.out.println("No students in the tutorial group.");
        }
    }

    private void editStudentDetails() {
        System.out.println("Enter the ID of the student you want to change: ");
        String id = studentMaintenanceUI.inputID();

        StackInterface<Student> tempStack = new LinkedStack<>();
        boolean found = false;

        while (!students.isEmpty() && !found) {
            Student student = students.pop();

            if (student.getID().equals(id)) {
                System.out.println("Found the student. Now enter the new details: ");
                Student newStudent = studentMaintenanceUI.getStudentDetails();
                tempStack.push(newStudent);
                found = true;
            } else {
                tempStack.push(student);
            }
        }

        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }

    private void findStudent() {
        System.out.println("Enter the ID of the student you want to find: ");
        String id = studentMaintenanceUI.inputID();

        StackInterface<Student> tempStack = new LinkedStack<>();
        boolean found = false;

        while (!students.isEmpty() && !found) {
            Student student = students.pop();
            tempStack.push(student);

            if (student.getID().equals(id)) {
                System.out.println("Found the student: " + student);
                found = true;
            }
        }

        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }

    public Student findStudentById(String id) {
        // Assuming your students are stored in a Stack named students
        StackInterface<Student> tempStack = new LinkedStack<>();
        Student targetStudent = null;

        while (!students.isEmpty()) {
            Student student = students.pop();
            if (student.getID().equals(id)) {
                targetStudent = student;
            }
            tempStack.push(student);
        }

        // Restore the original students stack from tempStack
        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }

        return targetStudent;
    }

    public void listAllStudents() {
        StackInterface<Student> tempStack = new LinkedStack<>();

        System.out.println("List Of Students in Tutorial Group");
        System.out.println("+-----+---------------+-------------------------------------------------------+------------+--------------------------------+-----------------+--------+--------------+------------------------------------------------+");
        System.out.println("| No  |      ID       |                          Name                         | Contact No |              Email             |      NRIC       | Gender | DateOfBirth  |                     Address                    |");
        System.out.println("+-----+---------------+-------------------------------------------------------+------------+--------------------------------+-----------------+--------+--------------+------------------------------------------------+");

        int i = 1;
        while (!students.isEmpty()) {
            Student student = students.pop();
            System.out.printf("| %-3d | %-13s | %-53s | %-10s | %-30s | %-15s | %-6s | %-12s | %-46s |\n",
                    i++,
                    student.getID(),
                    student.getName(),
                    student.getContactNo(),
                    student.getEmail(),
                    student.getNRIC(),
                    student.getGender(),
                    student.getDateOfBirth().toString(),
                    student.getAddress());
            tempStack.push(student); // Store students into a temp stack since we're popping from the main stack
        }

// Restore the students to the main stack from tempStack
        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }

        System.out.println("+-----+---------------+-------------------------------------------------------+------------+--------------------------------+-----------------+--------+--------------+------------------------------------------------+");

        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }
    }

}
