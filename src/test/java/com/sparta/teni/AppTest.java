package com.sparta.teni;

import static org.junit.Assert.assertTrue;

import com.sparta.teni.Controllers.EmployeeManager;
import com.sparta.teni.utilis.Printer;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.Duration;
import java.time.Instant;


public class AppTest 
{
    private EmployeeManager employeeManager = new EmployeeManager();

    @Test
    @DisplayName("Testing performance of inserting data of 10k without threads")
    public void testOfDataMigrationOf10kWithoutThreads()
    {

        Printer.printMessage("Testing 10K file without threads...");
        employeeManager.getEmployeesData("resources/employees.csv");
        Instant start = java.time.Instant.now();
        employeeManager.insertDataFromFileThreadless();
        Instant end = java.time.Instant.now();
        Duration between = java.time.Duration.between(start,end);
        Printer.printTestTimeResultsOfThreadless(between);
    }

    @Test
    @DisplayName("Testing performance of inserting data of 65k without threads")
    public void testOfDataMigrationOf65kWithoutThreads()
    {

        Printer.printMessage("Testing 65K file without threads...");
        employeeManager.getEmployeesData("resources/EmployeeRecordsLarge.csv");
        Instant start = java.time.Instant.now();
        employeeManager.insertDataFromFileThreadless();
        Instant end = java.time.Instant.now();
        Duration between = java.time.Duration.between(start,end);
        Printer.printTestTimeResultsOfThreadless(between);
    }

    @Test
    @DisplayName("Testing performance of inserting data of 65k with threads")
    public void testOfDataMigrationOf10kWithThreads()
    {

        Printer.printMessage("Testing 10K file with 10 threads...");
        employeeManager.getEmployeesData("resources/employees.csv");
        Instant start = java.time.Instant.now();
        employeeManager.insertWithThreads(10);
        Instant end = java.time.Instant.now();
        Duration between = java.time.Duration.between(start,end);
        Printer.printTestTimeResultsOfThreadless(between);
    }

    @Test
    @DisplayName("Testing performance of inserting data of 65k with threads")
    public void testOfDataMigrationOf65kWithThreads()
    {

        Printer.printMessage("Testing 65K file with 10 threads...");
        employeeManager.getEmployeesData("resources/EmployeeRecordsLarge.csv");
        Instant start = java.time.Instant.now();
        employeeManager.insertWithThreads(10);
        Instant end = java.time.Instant.now();
        Duration between = java.time.Duration.between(start,end);
        Printer.printTestTimeResultsOfThreadless(between);
    }
}
