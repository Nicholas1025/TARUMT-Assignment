/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import static utility.designUI.*;

/**
 *
 * @author NicholasTayJunYang
 */
public class MessageUI {
  
  
  public static void displayInvalidChoiceMessage() {
    System.out.println(ANSI_RED+"\nInvalid choice");
  }

  public static void displayExitMessage() {
    System.out.println("\nExiting system");
  }
  
  public static void displayDeleteSuccessMessage() {
    System.out.println("Programme successfully deleted!");
}

public static void displayDeleteFailureMessage() {
    System.out.println("Error deleting the programme. Please try again.");
}
  
}
