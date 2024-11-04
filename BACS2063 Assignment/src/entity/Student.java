/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.LinkedStack;
import adt.StackInterface;
import java.util.Date;

/**
 *
 * @author NicholasTayJunYang
 */
public class Student {

    private String id;
    private String name;
    private String contactNo;
    private String email;
    private String nric;
    private String gender;
    private String dateOfBirth;
    private String address;
    private StackInterface<String> programmes = new LinkedStack<>();

    public Student(String id, String name, String contactNo, String email, String nric, String gender, String dateOfBirth, String address) {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.email = email;
        this.nric = nric;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getID() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setNRIC(String nric) {
        this.nric = nric;
    }

    public String getNRIC() {
        return nric;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    // in Student class
    public StackInterface<String> getProgrammes() {
        return programmes;
    }

    public void addProgramme(String programme) {
        programmes.push(programme);
    }

    public void removeProgramme(String programme) {
        StackInterface<String> tempStack = new LinkedStack<>();
        while (!programmes.isEmpty()) {
            String currentProgramme = programmes.pop();
            if (!currentProgramme.equals(programme)) {
                tempStack.push(currentProgramme);
            }
        }
        while (!tempStack.isEmpty()) {
            programmes.push(tempStack.pop());
        }
    }

    public boolean containsProgramme(String programmeID) {
        StackInterface<String> tempStack = new LinkedStack<>();
        boolean found = false;

        while (!programmes.isEmpty()) {
            String currentProgramme = programmes.pop();
            tempStack.push(currentProgramme);
            if (currentProgramme.equals(programmeID)) {
                found = true;
                break;  // If found, no need to continue the loop
            }
        }

        // Restore the original stack
        while (!tempStack.isEmpty()) {
            programmes.push(tempStack.pop());
        }

        return found;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", contactNo=" + contactNo + ", email=" + email + ", nric=" + nric + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", address=" + address + '}';
    }

}
