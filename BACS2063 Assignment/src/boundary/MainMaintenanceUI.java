/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import java.util.InputMismatchException;
import java.util.Scanner;
import static utility.designUI.*;

/**
 *
 * @author NicholasTayJunYang
 */
public class MainMaintenanceUI {

    Scanner scanner = new Scanner(System.in);

//    
    public int getMenuChoice() {
        int choice = -1;  

        do {
          System.out.println("\n████████  ██     █████    ██   ██     ███    ██   ████████ ");
            System.out.println("    ██    ██   ██  ██   ██  ██    ██   ████   ████     ██    ");
            System.out.println("    ██    ██████  █████   ██     ██  ██  ████ ██     ██    ");
            System.out.println("    ██    ██   ██  ██   ██  ██    ██   ██   ██   ██     ██    ");
            System.out.println("    ██    ██   ██  ██   ██   █████    ██         ██     ██    ");

            System.out.println("\n================== MAIN MENU =====================");
            System.out.println("|\t1. Programme Controller                  |");
            System.out.println("|\t2. Tutorial Group Controller             |");
            System.out.println("|\t3. Course Controller                     |"); 
            System.out.println("|\t0. Quit                                  |");
            System.out.println("==================================================");
            System.out.print("\nEnter your choice: ");

            try {
                choice = scanner.nextInt();

                if (choice >= 0 && choice <= 4) {
                    break; 
                } else {
                    System.out.println(ANSI_RED+"Please enter a valid choice between 0 and 4."+ANSI_RESET);
                }

            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED+"Invalid input! Please enter a number."+ANSI_RESET);
                scanner.nextLine(); 
            }

        } while (true);

        scanner.nextLine(); 
        System.out.println();
        return choice;
    }

}
