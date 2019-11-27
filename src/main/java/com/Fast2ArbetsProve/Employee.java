/*
Parent class to read from the json file by using serialization annotations
and use EmployeeDetails class as a type.
 */
package com.Fast2ArbetsProve;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Employee {
    @SerializedName("names")
    private List<EmployeeDetails> employeeDetails;

    public Employee(List<EmployeeDetails> employeeDetails) {
        this.employeeDetails = employeeDetails;
    }

    public List<EmployeeDetails> getEmployeeDetails() {
        return employeeDetails;
    }
}