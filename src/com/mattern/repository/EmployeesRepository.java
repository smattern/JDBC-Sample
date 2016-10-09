package com.mattern.repository;

import com.mattern.domain.Employees;

import java.util.ArrayList;

/**
 * smattern on 09/10/16.
 */
public interface EmployeesRepository {

    /**
     * Get Employees by name.
     *
     * @param firstName, the name of entity "Employees"
     */
    ArrayList<Employees> getEmployeeByName(String firstName);

    /**
     * Hiring a new employee.
     *
     * @param emp the new employee
     */
    void insertNewEmployee(Employees emp);

    /**
     * Delete a employee.
     *
     * @param id employee id to be fired
     */
    void deleteEmployeeByID(int id);

    /**
     * Update employee by id.
     *
     * @param id employee to be updated
     */
    void updateEmployeeLastNameByID(int id, String newLastName);
}
