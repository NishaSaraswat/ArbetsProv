/**
 * Util class to map and sort data
 */
package com.Fast2ArbetsProve;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class EmployeeUtil {

    InputStream inputStream = getClass().getResourceAsStream("/names.json");
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

    public static List<EmployeeDetails> getEmployeeList() {
        EmployeeUtil employeeUtil = new EmployeeUtil();
        Gson gson = new Gson();

        // create parser
        JsonReader jsonReader =  new JsonReader(employeeUtil.reader);
        // Convert JSON File to Java Object
        Employee employee = gson.fromJson(jsonReader, Employee.class);
        List<EmployeeDetails> employeeDetailsList = employee.getEmployeeDetails();
        return employeeDetailsList;
    }

        public static List<String> getEmployeeFirstNameList(List<EmployeeDetails> employeeDetailsList) {
            List<String> firstNameList = new ArrayList<String>();
            for (EmployeeDetails employeeDetails : employeeDetailsList) {
                firstNameList.add(employeeDetails.getFirstname());
            }
            return firstNameList;
        }

        public static List<String> getEmployeeSurNameList(List<EmployeeDetails> employeeDetailsList) {
            List<String> surNameList = new ArrayList<String>();
            for (EmployeeDetails employeeDetails : employeeDetailsList) {
                surNameList.add(employeeDetails.getSurname());
            }
            return surNameList;
        }

        public static Map<String, Integer> getRecurringNameList(List<String> itemList) {
            // hashmap to store the frequency of element
            Map<String, Integer> hashMap = new HashMap<String, Integer>();
            Map<String, Integer> recurringNamesHashMap = new HashMap<String, Integer>();
            // Adding Keys and Value to the HashMap, also updating the Value by 1 for a recurring Key
            for (String itemKey : itemList) {
                Integer itemValue = hashMap.get(itemKey);
                hashMap.put(itemKey, (itemValue == null) ? 1 : itemValue + 1);
            }

            // displaying the odd occurring items in the Map
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                if (entry.getValue() > 1) {
                    String key = entry.getKey();
                    Integer value = entry.getValue();
                    recurringNamesHashMap.put(key, value);
                }
            }
            return recurringNamesHashMap;
        }

        // Function returns an Ordered List of 'String' (1 = Ascending, 2 = Descending)
        public static List<String> getSortedListByOrder(List<String> itemList, int orderOption) {
            if (!itemList.isEmpty()) {
                if (orderOption == 1) {
                    Collections.sort(itemList);
                    return itemList;
                } else if (orderOption == 2) {
                    Collections.sort(itemList, Collections.reverseOrder());
                    return itemList;
                } else {
                    System.out.println("You have entered an invalid ordering option !!!");
                }
            } else {
                System.out.println("Provided List is Empty, can't be Sorted !!!");
            }
            return null;
        }

        public static List<EmployeeDetails> displayFilteredListByGender(List<EmployeeDetails> edList, int genderOption) {
            if (!edList.isEmpty()) {
                List<EmployeeDetails> filteredList = new ArrayList<EmployeeDetails>();

                if (genderOption == 1) {
                    for (EmployeeDetails employeeDetailsObject : edList) {
                        if (employeeDetailsObject.getGender().equals("female")) {
                            filteredList.add(employeeDetailsObject);
                        }
                    }
                    return filteredList;
                } else if (genderOption == 2) {
                    for (EmployeeDetails employeeDetailsObject : edList) {
                        if (employeeDetailsObject.getGender().equals("male")) {
                            filteredList.add(employeeDetailsObject);
                        }
                    }
                    filteredList.forEach(edObject -> System.out.println(edObject.getFirstname()));
                    return filteredList;
                } else {
                    System.out.println("Invalid Gender option provided for filtering !!!");
                }
            } else {
                System.out.println("Provided List is Empty, can't be Filtered !!!");
            }
            return null;
        }

        public static Map<String, Integer> getNamesWithOddEvenOccurrence(List<String> itemList, int oeOptionValue) {

            if (!itemList.isEmpty()) {
                // hashmap to store the frequency of element
                Map<String, Integer> hashMap = new HashMap<String, Integer>();
                Map<String, Integer> oddHashMap = new HashMap<String, Integer>();
                Map<String, Integer> evenHashMap = new HashMap<String, Integer>();

                // Adding Keys and Value to the HashMap, also updating the Value by 1 for a recurring Key
                for (String itemKey : itemList) {
                    Integer itemValue = hashMap.get(itemKey);
                    hashMap.put(itemKey, (itemValue == null) ? 1 : itemValue + 1);
                }

                // Adding the values in oddHashMap
                if (oeOptionValue == 1) {
                    for (Map.Entry<String, Integer> item : hashMap.entrySet()) {
                        if (item.getValue() > 1 && item.getValue() % 2 != 0) {
                            oddHashMap.put(item.getKey(), item.getValue());
                        }
                    }
                    if (oddHashMap.size() > 0) {
                        return oddHashMap;
                    } else {
                        System.out.println("No Odd item found with multiple occurrence !!!");
                    }
                }

                // Adding the values in evenHashMap
                if (oeOptionValue == 2) {
                    for (Map.Entry<String, Integer> item : hashMap.entrySet()) {
                        if (item.getValue() > 1 && item.getValue() % 2 == 0) {
                            evenHashMap.put(item.getKey(), item.getValue());
                        }
                    }
                    if (evenHashMap.size() > 0) {
                        return evenHashMap;
                    } else {
                        System.out.println("No Even item found with multiple occurrence !!!");
                    }
                }
            } else {
                System.out.println("Provided List is Empty, No Odd/Even occurrence can be found !!!");
            }
            return null;
        }
    }


