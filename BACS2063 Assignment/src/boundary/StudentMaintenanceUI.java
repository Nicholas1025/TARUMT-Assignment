/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import entity.Student;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StudentMaintenanceUI {

    private Scanner scanner;

    public StudentMaintenanceUI() {
        scanner = new Scanner(System.in);
    }

    public int getMenuChoice() {
        System.out.println("\nTutorial Group Maintenance Menu");
        System.out.println("1. Add Student ");
        System.out.println("2. Remove Student ");
        System.out.println("3. Edit Student");
        System.out.println("4. Find Student ");
        System.out.println("5. List All Students ");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return choice;
    }

    public Student getStudentDetails() {
        String id;
        do {
            System.out.print("Enter student ID (12ABC3456): ");
            id = scanner.nextLine();
            if (!isValidID(id)) {
                System.out.println("Invalid ID. Please enter again.");
            }
        } while (!isValidID(id));

        String name;
        do {
            System.out.print("Enter student name: ");
            name = scanner.nextLine();
            if (!isValidName(name)) {
                System.out.println("Invalid name. Please enter again using only letters and spaces.");
            }
        } while (!isValidName(name));

        String email;
        do {
            System.out.print("Enter email: ");
            email = scanner.nextLine();
            if (!isValidEmail(email)) {
                System.out.println("Invalid email. Please enter again.");
            }
        } while (!isValidEmail(email));

        String contactNo;
        do {
            System.out.print("Enter contact number: ");
            contactNo = scanner.nextLine();
            if (!isValidContactNumber(contactNo)) {
                System.out.println("Invalid contact number. Please enter again.");
            }
        } while (!isValidContactNumber(contactNo));

        String nric;
        do {
            System.out.print("Enter NRIC: ");
            nric = scanner.nextLine();
            if (!isValidNric(nric)) {
                System.out.println("Invalid NRIC. Please enter again.");
            }
        } while (!isValidNric(nric));

        String gender;
        do {
            System.out.print("Enter gender (Male/Female/Other): ");
            gender = scanner.nextLine();
            if (!isValidGender(gender)) {
                System.out.println("Invalid gender. Please enter 'Male', 'Female', or 'Other'.");
            }
        } while (!isValidGender(gender));

        String dateOfBirth;
        do {
            System.out.print("Enter date of birth (dd/MM/yyyy): ");
            dateOfBirth = scanner.nextLine();
            if (!isValidDate(dateOfBirth)) {
                System.out.println("Invalid date format. Please enter again.");
            }
        } while (!isValidDate(dateOfBirth));

        String address;
        do {
            System.out.print("Enter address: ");
            address = scanner.nextLine();
            if (address.trim().isEmpty()) {
                System.out.println("Address cannot be blank. Please enter again.");
            }
        } while (address.trim().isEmpty());

        return new Student(id, name, contactNo, email, nric, gender, dateOfBirth, address);
    }

    public String inputProgramme() {
        System.out.println("Enter the programme name: ");
        return scanner.nextLine();
    }

    private boolean isValidName(String name) {
        return name.matches("^[a-zA-Z ]+$");
    }

    private boolean isValidNric(String nric) {
        return nric.matches("\\d{9,12}");
    }

    private boolean isValidGender(String gender) {
        return gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female") || gender.equalsIgnoreCase("Other");
    }

    private boolean isValidID(String id) {
        return id.length() == 9;
    }

    private boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(email).matches();
    }

    private boolean isValidContactNumber(String contactNo) {
        return contactNo.matches("\\d{10,12}");
    }

    private boolean isValidDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public String inputID() {
        String id;
        do {
            System.out.print("Enter student ID: ");
            id = scanner.nextLine();
            if (!isValidID(id)) {
                System.out.println("Invalid ID. Please enter again.");
            }
        } while (!isValidID(id));

        return scanner.nextLine();
    }

}
