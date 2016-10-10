package com.mattern.domain;

import com.mattern.enumeration.Gender;

/**
 * smattern on 09/10/16.
 */
public class Employees {

    private int id;

    private String firstName;

    private String lastName;

    private Gender gender;

    // one to one (1:1)
    private Salaries salaries;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Salaries getSalaries() {
        return salaries;
    }

    public void setSalaries(Salaries salaries) {
        this.salaries = salaries;
    }
}
