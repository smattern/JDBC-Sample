package com.mattern.domain;

import com.mattern.enumeration.Gender;

import java.util.ArrayList;

/**
 * smattern on 09/10/16.
 */
public class Employees {

    private int id;

    private String firstName;

    private String lastName;

    private Gender gender;

    // one to many (1:n)
    private ArrayList<Salaries> salaries;

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

    public ArrayList<Salaries> getSalaries() {
        return salaries;
    }

    public void setSalaries(ArrayList<Salaries> salaries) {
        this.salaries = salaries;
    }
}
