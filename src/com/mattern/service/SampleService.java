package com.mattern.service;

import com.mattern.repository.EmployeesRepository;
import com.mattern.repository.connection.ConnectionHandling;
import com.mattern.repository.impl.EmployeesRepositoryImpl;

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
    public void doSampleAction(){
        ConnectionHandling conn = new ConnectionHandling();
        employeesRepository = new EmployeesRepositoryImpl(conn);

    }// end method

    /**
     * Aux.
     */
    private void showRecords(String name){

    }// end method
}
