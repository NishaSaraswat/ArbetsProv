package com.Fast2ArbetsProve;
import java.util.*;

import static com.Fast2ArbetsProve.PrintMenu.printMenu;
import static com.Fast2ArbetsProve.Formater.*;


public class Main {
    public static void main(String[] args) {
        EmployeeUtil employeeUtil = new EmployeeUtil();
        //Taking user's choice
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            printMenu();
            System.out.println("\nEnter your choice:->");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Task 2 - Write two separate list with Most frequently occurring
                    // FirstNames and Surnames
                    System.out.println("Displaying statistic of the most frequently occurring FirstName:");
                    System.out.println(starLine);
                    ListManager.displayRecurringFirstNameList();
                    System.out.println("\nDisplaying statistic of the most frequently occurring Surname:");
                    System.out.println(starLine);
                    ListManager.displayRecurringSurNameList();
                    break;
                case 2:
                    //Task3 - Sorted all firstName and surname(1.Ascending order)
                    System.out.println("Displaying the Sorted list by FirstName :");
                    System.out.println(starLine);
                    ListManager.displayFirstNamesInAscendingOrder();
                    System.out.println("\nDisplaying the Sorted list by Surname :");
                    System.out.println(starLine);
                    ListManager.displaySurNamesInAscendingOrder();
                    break;
                case 3:
                    // Tas4 - Select sort order of the list

                    System.out.println("Select an sort order list of employee:\nstarLine" +
                            "\n1.Sorted list by FirstName:Ascending.\n2.Sorted list by Surname:Ascending\n" +
                            "3.Sorted list by FirstName:Descending.\n4.Sorted list by Surname:Descending");
                    int choice1 = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice1) {
                        case 1:

                            System.out.println("Displaying the Sorted list by FirstName :Ascending order");
                            System.out.println(starLine);
                            ListManager.displayFirstNamesInAscendingOrder();
                            break;
                        case 2:
                            System.out.println("\nDisplaying the Sorted list by Surname :Ascending order");
                            System.out.println(starLine);
                            ListManager.displaySurNamesInAscendingOrder();
                            break;
                        case 3:
                            System.out.println("\nDisplaying the Sorted list by FirstName :Descending order");
                            System.out.println(starLine);
                            ListManager.displayFirstNamesInDescendingOrder();
                            break;
                        case 4:
                            System.out.println("\nDisplaying the Sorted list by Surname :Descending order");
                            System.out.println(starLine);
                            ListManager.displaySurNamesInDescendingOrder();
                            break;
                    }
                    break;
                case 4:
                    //Task5- Filternames by gender
                    //select option 1.Female 2.Male
                    System.out.println("Select an option to filter name : \nstarLine" +
                            "\n1.Filter list by female employee.\n2.Filter list by male employee");
                    int choice2 = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice2) {
                        case 1:
                            System.out.println("\nName of female employees");
                            System.out.println(starLine);
                            ListManager.displayFirstNamesByFemaleGender();
                            break;
                        case 2:
                            System.out.println("\nName of male employees");
                            System.out.println(starLine);
                            ListManager.displayFirstNamesByMaleGender();
                            break;
                    }
                    break;
                case 5:
                    //Task6-Display names with odd number occurrence and even number of occurrence
                    System.out.println("Select an option for odd & even no. of name occurrence: \nstarLine" +
                            "\n1.Names with odd number occurrence.\n2.Names with even number occurrence.");
                    int choice3 = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice3) {
                        case 1:
                            System.out.println("\nName of employees with odd number of occurrence");
                            System.out.println(starLine);
                            ListManager.displayRecurringFirstNamesWithOddCounts();
                            ListManager.displayRecurringSurNamesWithOddCounts();
                            break;
                        case 2:
                            System.out.println("\nName of employees with even number of occurrence");
                            System.out.println(starLine);
                            ListManager.displayRecurringFirstNamesWithEvenCounts();
                            ListManager.displayRecurringSurNamesWithEvenCounts();

                            break;
                    }
                    break;
                case 6:
                    quit = true;
                    System.out.println("Thank you for using ListManager - See you next time");
                    break;


            }
        }
    }

}


