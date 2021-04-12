package com.sparta.teni.Controllers;

import com.sparta.teni.Models.Employee;

import java.util.ArrayList;

public class ThreadTasker implements Runnable{
    private ArrayList<Employee> employees;

    public ThreadTasker(ArrayList<Employee>employees) {this.employees = employees;}

    @Override
    public void run(){
        EmployeeManager.insertBatchWithThreads(employees);
    }
}
