package com.sparta.teni.Controllers;

import com.sparta.teni.Models.Employee;
import com.sparta.teni.utilis.Printer;

public class Starter {
    public static void start(){
        EmployeeManager employeeManager = new EmployeeManager();

        // File with 10k
//        employeeManager.getEmployeesData("resources/employees.csv");

        // File with 65k
        employeeManager.getEmployeesData("resources/EmployeeRecordsLarge.csv");

        // Threadless data migrater.
//        employeeManager.insertDataFromFile();
        // Data migration with threads
        employeeManager.insertWithThreads(10);
    }
}
