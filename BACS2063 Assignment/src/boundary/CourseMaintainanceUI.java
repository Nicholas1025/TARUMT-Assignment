/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.*;
import entity.*;
import control.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Pang Jin Siang
 */
public class CourseMaintainanceUI {
    private HashMap<String, Course> courseMap = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public int getMenuChoice() {
            System.out.println("Course Management System Menu:");
            System.out.println("1. Add a new course");
            System.out.println("2. Remove a course");
            System.out.println("3. Find course");
            System.out.println("4. Amend course details");
            System.out.println("5. List all courses");
            System.out.println("6. Clear all courses");
            System.out.println("7. Exit");
            
            int choice = getInput("Enter your choice: ");
            
            return choice;
    }
    
        public int getInput(String message) {
        int choice = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(message);
                choice = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        return choice;
    }
}
