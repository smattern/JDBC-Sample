package com.mattern.repository.impl;

import com.mattern.domain.Employees;
import com.mattern.domain.Salaries;
import com.mattern.repository.EmployeesRepository;
import com.mattern.repository.connection.ConnectionHandling;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * smattern on 09/10/16.
 * <p>
 * Attention: closing statement and result set
 */
public class EmployeesRepositoryImpl implements EmployeesRepository {

    // logger (const)
    private static final Logger LOG = Logger.getLogger(EmployeesRepositoryImpl.class.getName());

    // select statements (const)
    private final String SELECT_SALARY_BY_EMPLOYEES_ID = "select * from salaries where emp_no =";
    private final String SELECT_EMPLOYEES_BY_FIRST_NAME = "select * from employees where first_name like ";

    // database connection (const)
    private final ConnectionHandling CONN;

    public EmployeesRepositoryImpl(ConnectionHandling CONN) {
        this.CONN = CONN;
    }

    @Override
    public ArrayList<Employees> getEmployeeByName(String firstName) {
        ArrayList<Employees> resultList = new ArrayList<>();
        try {
            Statement statement = CONN.getConnection().createStatement();
            ResultSet result = statement.executeQuery(SELECT_EMPLOYEES_BY_FIRST_NAME + "\"" + firstName + "\";");
            LOG.log(Level.INFO, "SQL-Query: " + SELECT_EMPLOYEES_BY_FIRST_NAME + "\"" + firstName + "\";");

            while (result.next()) {
                Employees emp = new Employees();
                emp.setId(Integer.parseInt(result.getString("emp_no")));
                emp.setFirstName(result.getString("first_name"));
                emp.setLastName(result.getString("last_name"));
                emp.setSalaries(getSalaryByEmployeeID(emp.getId()));
                resultList.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }

    @Override
    public void insertNewEmployee(Employees emp) {
        String query = "insert into employees values (?, ?, ?)";

        try {
            PreparedStatement statement = CONN.getConnection().prepareStatement(query);
            statement.setString(1, "Sebastian");
            statement.setString(2, "Sebastian");
            statement.setString(3, "Sebastian");

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    private ArrayList<Salaries> getSalaryByEmployeeID(int id) {
        ArrayList<Salaries> resultlist = new ArrayList<>();
        Statement stmt;
        try {
            stmt = CONN.getConnection().createStatement();
            ResultSet resultSetSalary = stmt.executeQuery(SELECT_SALARY_BY_EMPLOYEES_ID + id + ";");

            while (resultSetSalary.next()) {
                Salaries salary = new Salaries();
                salary.setSalary(Integer.parseInt(resultSetSalary.getString("salary")));
                resultlist.add(salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultlist;
    }// end method


}
