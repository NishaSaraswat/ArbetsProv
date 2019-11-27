/*
    EmployeeDetails class with constructor setters and getters
 */
package com.Fast2ArbetsProve;
import com.google.gson.annotations.SerializedName;

public class EmployeeDetails {

        @SerializedName("firstname")
        private String firstname;
        @SerializedName("surname")
        private String surname;
        @SerializedName("gender")
        private String gender;

        public EmployeeDetails(String firstname, String surname, String gender) {
            this.firstname = firstname;
            this.surname = surname;
            this.gender = gender;
        }

        public String getFirstname() {
            return firstname;
        }

        public String getSurname() {
            return surname;
        }

        public String getGender() {
            return gender;
        }
    }



