package com.mattern.service;

import com.mattern.domain.Employees;
import com.mattern.domain.Salaries;
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

        for (Employees employees : resultList) {
            log.log(Level.INFO,
                    employees.getFirstName() + ", "
                            + employees.getLastName() + ", " );

            ArrayList<Salaries> salaries = employees.getSalaries();
            for (Salaries salary : salaries) {
                log.log(Level.INFO, "Gehalt: " + String.valueOf(salary.getSalary()));
            }

        }

        conn.endConnection();

    }// end method

    /**
     * Aux.
     */
    private void showRecords(String name) {

    }// end method
}
