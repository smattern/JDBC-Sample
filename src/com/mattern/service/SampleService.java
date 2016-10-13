package com.mattern.service;

import com.mattern.domain.Employees;
import com.mattern.enumeration.Gender;
import com.mattern.repository.EmployeesRepository;
import com.mattern.repository.connection.ConnectionHandling;
import com.mattern.repository.impl.EmployeesRepositoryImpl;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * smattern on 09/10/16.
 */
public class SampleService {

    private static final Logger log = Logger.getLogger(SampleService.class.getName());

    private EmployeesRepository employeesRepository;

    /**
     * Do same action.
     */
    public void doSampleAction() {
        ConnectionHandling conn = new ConnectionHandling();
        conn.beginConnection();
        employeesRepository = new EmployeesRepositoryImpl(conn);
        ArrayList<Employees> resultList = employeesRepository.getEmployeeByName("Max");

        showRecords(resultList);

        // Insert into
        Employees emp = new Employees();
        emp.setFirstName("Max");
        emp.setLastName("Mustermann");
        emp.setGender(Gender.M);
        employeesRepository.insertNewEmployee(emp);

        ArrayList<Employees> insertResult = employeesRepository.getEmployeeByName("Max");

        showRecords(insertResult);

        conn.endConnection();

    }// end method

    /**
     * Aux.
     */
    private void showRecords(ArrayList<Employees> list) {
        for (Employees employees : list) {
            log.log(Level.INFO,
                    employees.getFirstName() + ", "
                            + employees.getLastName() + ", "
                            + employees.getSalaries().getSalary());
        }
    }// end method
}
