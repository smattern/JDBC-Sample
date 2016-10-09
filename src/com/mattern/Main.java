package com.mattern;

import com.mattern.service.SampleService;

public class Main {

    public Main() {
        doAction();
    }

    private void doAction() {
        SampleService service = new SampleService();
        service.doSampleAction();
    }

    public static void main(String[] args) {
	    new Main();
    }
}
