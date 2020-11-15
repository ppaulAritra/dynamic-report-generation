package com.aritra.report.domain;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Employee extends BaseEntity{
    private String firstName;
    private String lastName;
    private String gender;
    private Date joiningDate;
    private Date birthDate;
    private String designation;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", joiningDate=" + joiningDate +
                ", birthDate=" + birthDate +
                ", designation='" + designation + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
