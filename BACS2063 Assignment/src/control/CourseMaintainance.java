/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import boundary.CourseMaintainanceUI;
import adt.*;
import entity.*;
import boundary.*;
import java.util.Scanner;
/**
 *
 * @author Pang Jin Siang
 */
public class CourseMaintainance {
    private HashMap<String, Course> courseMap = new HashMap<>();
    private CourseMaintainanceUI courseUI = new CourseMaintainanceUI();
    private Scanner scanner = new Scanner(System.in);
    
    public CourseMaintainance(HashMap<String, Course> courseMap){
        this.courseMap = courseMap;
        Course course1 = new Course("CSCI101", "Introduction to Computer Science", "Basic computer science concepts.");
        Course course2 = new Course("MATH202", "Calculus II", "Advanced calculus topics.");
        
        courseMap.put(course1.getCode(), course1);
        courseMap.put(course2.getCode(), course2);
    }

    public void runCourseMaintainance() {
        while (true) {
            int choice = courseUI.getMenuChoice();
            switch (choice) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    removeCourse();
                    break;
                case 3:
                    findCourse();
                    break;
                case 4:
                    amendCourseDetails();
                    break;
                case 5:
                    listAllCourses();
                    break;
                case 6:
                    clearAllCourses();
                    break;
                case 7:
                    System.out.println("Exiting the Course Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void addCourse() {
        System.out.println("---Add Course---");
        String code = getStringInput("Enter course code: ");
        if (courseMap.containsKey(code)) {
            System.out.println("Course with the same code already exists.");
            return;
        }
        
        String name = getStringInput("Enter course name: ");
        String detail = getStringInput("Enter course detail: ");
        Course course = new Course(code, name, detail);
        courseMap.put(code, course);
        System.out.println("Course added successfully.");
        System.out.println("\n");
    }

    public void removeCourse() {
        listAllCourses();
        System.out.println("\n");
        String code = getStringInput("Enter course code to remove: ");
        Course removedCourse = courseMap.remove(code);
        if (removedCourse != null) {
            System.out.println("Course removed successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }

    public void findCourse() {
        String code = getStringInput("Enter course code to find: ");
        Course course = courseMap.get(code);
        if (course != null) {
            System.out.println("Course found: " + course);
            System.out.println("\n");
        } else {
            System.out.println("Course not found.");
            System.out.println("\n");
        }
    }

    public void amendCourseDetails() {
        listAllCourses();
        System.out.println("\n");
        String code = getStringInput("Enter course code to amend details: ");
        Course course = courseMap.get(code);
        if (course != null) {
            String detail = getStringInput("Enter new course detail: ");
            course.setDetail(detail);
            System.out.println("Course details amended successfully.");
            System.out.println("\n");
        } else {
            System.out.println("Course not found.");
            System.out.println("\n");
        }
    }

     public void listAllCourses() {
        HashMap.EntryList<String, Course> entryList = courseMap.entrySet();
        System.out.println("List of Course");
        System.out.println("--------------");
        while (entryList != null) {
            Course course = entryList.entry.getValue();
            System.out.println(course);
            entryList = entryList.next;
        }
    }

    public void clearAllCourses() {
        courseMap.clear();
        System.out.println("All courses have been cleared.");
        System.out.println("\n");
    }

    public String getStringInput(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
}
