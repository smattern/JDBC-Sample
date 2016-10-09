package com.mattern.repository.impl;

import com.mattern.domain.Employees;
import com.mattern.domain.Salaries;
import com.mattern.repository.EmployeesRepository;
import com.mattern.repository.connection.ConnectionHandling;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * smattern on 09/10/16.
 */
public class EmployeesRepositoryImpl implements EmployeesRepository {

    // logger (const)
    private static final Logger log = Logger.getLogger(EmployeesRepositoryImpl.class.getName());

    // select statements (const)
    private final String SELECT_SALARY_BY_EMPLOYEES_ID = "select * from salaries where emp_no =";

    // database connection (const)
    private final ConnectionHandling conn;

    public EmployeesRepositoryImpl(ConnectionHandling conn) {
        this.conn = conn;
    }

    @Override
    public ArrayList<Employees> getEmployeeByName(String firstName) {
        return null;
    }

    @Override
    public void insertNewEmployee(Employees emp) {

    }

    @Override
    public void deleteEmployeeByID(int id) {

    }

    @Override
    public void updateEmployeeLastNameByID(int id, String newLastName) {

    }

    /**
     * Get the salary by employee ID;
     *
     * @return salary
     */
    private Salaries getSalaryByEmployeeID(int id) {
        Salaries salary = new Salaries();
        Statement stmt;

        try {
            stmt = conn.getConnection().createStatement();
            ResultSet resultSetSalary = stmt.executeQuery(SELECT_SALARY_BY_EMPLOYEES_ID + id + ";");

            while (resultSetSalary.next()) {
                salary.setSalary(Integer.parseInt(resultSetSalary.getString("salary")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return salary;
    }// end method

}
