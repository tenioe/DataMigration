package com.sparta.teni.Controllers;

import com.sparta.teni.Models.CSVReader;
import com.sparta.teni.Models.Employee;
import com.sparta.teni.Models.EmployeesDAO;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

public class EmployeeManager {
    private static EmployeesDAO employeeDAO = new EmployeesDAO();
    private static ArrayList<Employee> employeeArray;
    private ExecutorService threads;

    public void getEmployeesData(String employeesFile) {
        employeeDAO.clearTableOfEmployees();
        CSVReader reader = new CSVReader();
        employeeArray = new ArrayList<>(reader.readEmployees(employeesFile).values());
    }

    public static void insertDataFromFileThreadless() {
        employeeDAO.insertDataToSql(employeeArray);
    }

    public void insertWithThreads(int amountOfThreads){
        if(amountOfThreads <= 0){
            insertDataFromFileThreadless();
        }

        ThreadTasker[] threads = new ThreadTasker[amountOfThreads];
        int tasksPerThread = (int)Math.ceil(employeeArray.size()/ (double) amountOfThreads);
        for (int i = 0; i < amountOfThreads; i++) {
            int fromIndex = tasksPerThread * i;
            int toIndex = tasksPerThread * (i + 1);

            if (fromIndex > employeeArray.size()) {
                break;
            }

            if (toIndex >= employeeArray.size()) {
                toIndex = employeeArray.size();
            }

            threads[i] = new ThreadTasker(new ArrayList<>(employeeArray.subList(fromIndex, toIndex)));
            threads[i].run();
        }
    }

    public static void insertBatchWithThreads(ArrayList<Employee> employees) {
        employeeDAO.insertDataToSql(employees);
    }
}
