package com.Fast2ArbetsProve;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class PrintMenu {
    private static Date date = new Date();
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss)");

    public static void printMenu() {
        //Display welcome
        System.out.println("\nWelcome to List Manager" + " " + "(Date & Time: " + date + ")");
        System.out.println("************************************************************************");
        System.out.println("Pick an option");
        System.out.println("(1) - Displaying statistic of the most frequently occurring FirstName & Surname:");
        System.out.println("(2) - Displaying the Sorted list by FirstName & Surname :");
        System.out.println("(3) - Select an sort order list of employee:");
        System.out.println("(4) - Display Names - Filter By Gender");
        System.out.println("(5) - Display name of employees with even & odd number of occurrence");
        System.out.println("(6) - Quit Program");

    }
}


