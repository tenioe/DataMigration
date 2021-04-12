package com.sparta.teni.Models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class CSVReader {
    private static final Logger logger = LogManager.getLogger(CSVReader.class);
    private static ArrayList<Employee> duplicates = new ArrayList<>();


    public Hashtable<Integer,Employee> readEmployees(String employeesFile){
        Hashtable<Integer, Employee> employeeTable = new Hashtable<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(employeesFile));
            String row;
            br.readLine();
            while ((row = br.readLine()) != null) {
                String[] columns = row.split(",");
                Employee employee = new Employee(
                        Integer.parseInt(columns[0]),
                        columns[1], columns[2],
                        columns[3], columns[4],
                        columns[5].charAt(0), columns[6],
                        Employee.parseDateByFormat(columns[7]),
                        Employee.parseDateByFormat(columns[8]),
                        Integer.parseInt(columns[9])
                );

                if(employeeTable.get(employee.getEmployeeId()) == null){
                    employeeTable.put(employee.getEmployeeId(),employee);
                }else{
                    duplicates.add(employee);
                }
            }
        }catch (FileNotFoundException e) {
            logger.error("File does not exist in " + employeesFile + " folder");
            e.printStackTrace();
        }
        catch (IOException e){
            logger.error("File does not exist.");
            e.printStackTrace();
        }
        return employeeTable;
    }

    private static ArrayList<Employee> getDuplicateEmployees() {
        return duplicates;
    }
}
