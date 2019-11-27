package com.Fast2ArbetsProve;

import java.util.List;
import java.util.Map;
import static com.Fast2ArbetsProve.Formater.*;
public class ListManager {
    private static List<EmployeeDetails> edList = EmployeeUtil.getEmployeeList();
    private static List<String> fnList = EmployeeUtil.getEmployeeFirstNameList(edList);
    private static List<String> snList = EmployeeUtil.getEmployeeSurNameList(edList);

    public static void displayEmployeeList() {
        System.out.format(formatter3, "FirstName", "SurName", "Gender");
        System.out.println(dottedLine);
        edList = EmployeeUtil.getEmployeeList();
        edList.forEach(edItem -> System.out.format(formatter3, edItem.getFirstname(), edItem.getSurname(), edItem.getGender()));
    }

    public static void displayRecurringFirstNameList() {
        Map<String, Integer> rfnHashMap = EmployeeUtil.getRecurringNameList(fnList);

        System.out.format(formatter2, "FirstName", "Occurrence");
        System.out.println(dashLine);
        rfnHashMap.forEach((firstname, occurrence) -> System.out.format(formatter2, firstname, occurrence));
    }

    public static void displayRecurringSurNameList() {
        Map<String, Integer> rsnHashMap = EmployeeUtil.getRecurringNameList(snList);
        System.out.format(formatter2, "SurName", "Occurrence");
        ;
        System.out.println(dashLine);
        rsnHashMap.forEach((surname, occurrence) -> System.out.format(formatter2, surname, occurrence));
    }

    public static void displayRecurringFirstNamesWithOddCounts() {
        Map<String, Integer> rfnHashMapWithOddCounts = EmployeeUtil.getNamesWithOddEvenOccurrence(fnList, 1);
        System.out.println("\nDisplaying FirstNames with Odd recurrence");
        System.out.println(dashLine);
        System.out.format(formatter2, "FirstName", "OddOccurrenceCount");
        ;
        System.out.println(dottedLine);
        rfnHashMapWithOddCounts.forEach((firstName, occurrence) -> System.out.format(formatter2, firstName, occurrence));
    }

    public static void displayRecurringFirstNamesWithEvenCounts() {
        Map<String, Integer> rfnHashMapWithEvenCounts = EmployeeUtil.getNamesWithOddEvenOccurrence(fnList, 2);
        System.out.println("\nDisplaying FirstNames with Even recurrence");
        System.out.println(dashLine);
        System.out.format(formatter2, "FirstName", "EvenOccurrenceCount");
        ;
        System.out.println(dottedLine);
        rfnHashMapWithEvenCounts.forEach((firstName, occurrence) -> System.out.format(formatter2, firstName, occurrence));
    }

    public static void displayRecurringSurNamesWithOddCounts() {
        Map<String, Integer> rsnHashMapWithOddCounts = EmployeeUtil.getNamesWithOddEvenOccurrence(fnList, 1);
        System.out.println("\nDisplaying surname with odd recurrence");
        System.out.println(dashLine);
        System.out.format(formatter2, "\nSurName", "OddOccurrenceCount");
        ;
        System.out.println(dottedLine);
        rsnHashMapWithOddCounts.forEach((surname, occurrence) -> System.out.format(formatter2, surname, occurrence));
    }

    public static void displayRecurringSurNamesWithEvenCounts() {
        Map<String, Integer> rsnHashMapWithEvenCounts = EmployeeUtil.getNamesWithOddEvenOccurrence(fnList, 2);
        System.out.println("\nDisplaying surname with even recurrence");
        System.out.println(dashLine);
        System.out.format(formatter2, "\nSurName", "EvenOccurrenceCount");
        ;
        System.out.println(dottedLine);
        rsnHashMapWithEvenCounts.forEach((surname, occurrence) -> System.out.format(formatter2, surname, occurrence));
    }

    public static void displayFirstNamesInAscendingOrder() {
        List<String> fnAscList = EmployeeUtil.getSortedListByOrder(fnList, 1);
        if (fnAscList != null) {
            fnAscList.forEach(firstName -> System.out.format(formatter1, firstName));
        }
    }

    public static void displayFirstNamesInDescendingOrder() {
        List<String> fnDscList = EmployeeUtil.getSortedListByOrder(fnList, 2);
        if (fnDscList != null) {
            fnDscList.forEach(firstName -> System.out.format(formatter1, firstName));
        }
    }

    public static void displaySurNamesInAscendingOrder() {
        List<String> snAscList = EmployeeUtil.getSortedListByOrder(snList, 1);
        if (snAscList != null) {
            snAscList.forEach(surName -> System.out.format(formatter1, surName));
        }
    }

    public static void displaySurNamesInDescendingOrder() {
        List<String> snDscList = EmployeeUtil.getSortedListByOrder(snList, 2);
        if (snDscList != null) {
            snDscList.forEach(surName -> System.out.format(formatter1, surName));
        }
    }

    public static void displayFirstNamesByFemaleGender() {
        List<EmployeeDetails> fnFemaleList = EmployeeUtil.displayFilteredListByGender(edList, 1);
        System.out.println("Original size of the List is: " + edList.size());
        System.out.println(dashLine);
        System.out.println("Number of femal employee: " + fnFemaleList.size());
        System.out.println(dashLine);
        fnFemaleList.forEach(edObject -> System.out.format(formatter1, edObject.getFirstname()));
    }

    public static void displayFirstNamesByMaleGender() {


        System.out.println("Original size of the List is: " + edList.size());
        System.out.println(dashLine);
        List<EmployeeDetails> fnMaleList = EmployeeUtil.displayFilteredListByGender(edList, 2);
        System.out.println("Number of male gender: " + fnMaleList.size());
        System.out.println(dashLine);
        fnMaleList.forEach(edObject -> System.out.format(edObject.getFirstname()));


    }
}


