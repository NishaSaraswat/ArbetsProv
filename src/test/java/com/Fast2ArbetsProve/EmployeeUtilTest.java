package com.Fast2ArbetsProve;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.util.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

public class EmployeeUtilTest {
    private List<String> nameListForTest = new ArrayList<String>();
    private List<String> firstNamesListFTRV = new ArrayList<String>();
    private List<String> surNamesListFTRV = new ArrayList<String>();
    private List<String> recurringFirstNamesListFTRV = new ArrayList<String>();
    private List<String> recurringSurNamesListFTRV = new ArrayList<String>();
    private Map<String, Integer> recurringNamesHashMapFRTV = new HashMap<String, Integer>();
    private List<EmployeeDetails> edListForTest = new ArrayList<EmployeeDetails>();
    private List<EmployeeDetails> employeeDetailsListForTest = new ArrayList<EmployeeDetails>();
    private List<EmployeeDetails> femaleDetailsListFRTV = new ArrayList<EmployeeDetails>();

    @Before
    public void setUp() throws Exception {
        // Preparing Data for Tests
        nameListForTest.addAll(Arrays.asList("Fritz", "Anneli", "Fritz", "Wille", "Anneli", "Vanja", "Fritz", "Vera"));

        employeeDetailsListForTest.add(new EmployeeDetails("Fritz","Larsson","male"));
        employeeDetailsListForTest.add(new EmployeeDetails("Anneli","Sundberg","female"));
        employeeDetailsListForTest.add(new EmployeeDetails("Fritz","Sundberg","male"));
        employeeDetailsListForTest.add(new EmployeeDetails("Anneli","Larsson","female"));
        employeeDetailsListForTest.add(new EmployeeDetails("Vera","Larsson","female"));
        employeeDetailsListForTest.add(new EmployeeDetails("Wille","Larsson","male"));
        employeeDetailsListForTest.add(new EmployeeDetails("Vanja","Larsson","female"));

        // Preparing Data for Test results verification
        firstNamesListFTRV.addAll(Arrays.asList("Fritz", "Anneli", "Fritz", "Anneli", "Vera", "Wille", "Vanja"));
        surNamesListFTRV.addAll(Arrays.asList("Larsson", "Sundberg", "Sundberg", "Larsson", "Larsson", "Larsson", "Larsson"));


        recurringFirstNamesListFTRV.addAll(Arrays.asList("Fritz", "Anneli"));
        recurringSurNamesListFTRV.addAll(Arrays.asList("Larsson", "Sundberg"));

        recurringNamesHashMapFRTV.put("Fritz", 3);
        recurringNamesHashMapFRTV.put("Anneli", 2);

        femaleDetailsListFRTV.add(new EmployeeDetails("Anneli","Sundberg","female"));
        femaleDetailsListFRTV.add(new EmployeeDetails("Anneli","Larsson","female"));
        femaleDetailsListFRTV.add(new EmployeeDetails("Vera","Larsson","female"));
        femaleDetailsListFRTV.add(new EmployeeDetails("Vanja","Larsson","female"));
    }
    @After
    public void tearDown() throws Exception {
        nameListForTest.clear();
        edListForTest.clear();
        employeeDetailsListForTest.clear();
    }
    @Test
    public void getEmployeeList() {
        edListForTest = EmployeeUtil.getEmployeeList();
        assert (101 == edListForTest.size());
    }

    @Test
    public void getEmployeeFirstNameList() {
        List<String> recurringFirstNamesListResult = EmployeeUtil.getEmployeeFirstNameList(employeeDetailsListForTest);
        // Comparing the contents of predefined List with contents of List returned from getEmployeeFirstNameList
        assertEquals (firstNamesListFTRV, recurringFirstNamesListResult);
    }

    @Test
    public void getEmployeeSurNameList() {
        List<String> recurringSurNamesListResult = EmployeeUtil.getEmployeeSurNameList(employeeDetailsListForTest);
        // Comparing the contents of predefined List with contents of List returned from getEmployeeSurNameList
        assertEquals (surNamesListFTRV, recurringSurNamesListResult);
    }

    @Test
    public void getRecurringNameList() {
        Map<String, Integer> rnHashMapResult = EmployeeUtil.getRecurringNameList(nameListForTest);
        // Comparing the contents of predefined Map with contents of Map returned from getRecurringNameList
        assertEquals(recurringNamesHashMapFRTV.entrySet(), rnHashMapResult.entrySet());
    }

    @Test
    public void getSortedListByOrder() {
        List<String> sortedListInAscOrderResult = EmployeeUtil.getSortedListByOrder(nameListForTest, 1);
        assert sortedListInAscOrderResult != null;
        // Comparing 'Anneli' with the first item of the sorted List
        assertEquals("Anneli", sortedListInAscOrderResult.get(0));
    }

    @Test
    public void displayFilteredListByGender() {
        // Gender filter options -> 1 = female, 2 = male
        List<EmployeeDetails> femaleDetailsListResult = EmployeeUtil.displayFilteredListByGender(employeeDetailsListForTest, 1);
        assert femaleDetailsListResult != null;
        // Comparing the size of femaleDetailsListFRTV with the results from the List returned from 'displayFilteredListByGender'
        assertEquals(femaleDetailsListFRTV.size(), femaleDetailsListResult.size());
    }

    @Test
    public void getNamesWithOddEvenOccurrence() {
        // 1 = Odd Occurrence, 2 = Even Occurrence
        Map<String, Integer> nameWithEvenOccurrenceMapResult = EmployeeUtil.getNamesWithOddEvenOccurrence(nameListForTest, 1);
        assert nameWithEvenOccurrenceMapResult != null;
        assertEquals("Fritz", nameWithEvenOccurrenceMapResult.entrySet().iterator().next().getKey());
    }
}