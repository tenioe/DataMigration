package com.sparta.teni.Models;
//Data Access Object-It is a pattern for the persistence layer. All the database operations
//and connections take place within this file

import com.sparta.teni.utilis.Printer;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmployeesDAO {
    private final String URL="jdbc:mysql://localhost:3306/teni_db?rewriteBatchedStatements=true";
    private Connection connection;
    private final Properties properties=new Properties();
    private static final Logger logger = LogManager.getLogger(EmployeesDAO.class);


    public synchronized Connection connectToDatabase(){
        try {
            properties.load(new FileReader("resources/login.properties"));
            connection= DriverManager.getConnection(URL,properties.getProperty("username"),properties.getProperty("password") );
        } catch (IOException e) {
            logger.error("Error with connecting to the database \n Database may not exist. \n Check connection.");
            e.printStackTrace();
        } catch (SQLException E) {
            logger.error("Error with reading file. \nFile may not exist.");
            E.printStackTrace();
        }
        return connection;
    }

    public synchronized void insertDataToSql(ArrayList<Employee> employees){
        String insertForAllEmployees = "INSERT INTO Employees VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connectToDatabase().prepareStatement(insertForAllEmployees);
            Printer.printMessage("Inserting data into table of Employees...");
            int i =0;
            for (Employee employee:employees) {
                preparedStatement.setInt(1, employee.getEmployeeId());
                preparedStatement.setString(2, employee.getTitle());
                preparedStatement.setString(3, employee.getFirstName());
                preparedStatement.setString(4, employee.getInitial());
                preparedStatement.setString(5, employee.getLastName());
                preparedStatement.setString(6, Character.toString(employee.getGender()));
                preparedStatement.setString(7, employee.getEmail());
                preparedStatement.setDate(8, employee.getDateOfBirth());
                preparedStatement.setDate(9, employee.getJoinDate());
                preparedStatement.setInt(10, employee.getSalary());

                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            logger.error("Error executing SQL statement");
            e.printStackTrace();
        }
    }

    public synchronized void clearTableOfEmployees() {
        String dropTable = "TRUNCATE Employees";
        try {
            PreparedStatement preparedStatement = connectToDatabase().prepareStatement(dropTable);
            Printer.printMessage("Dropping Table of Employees...");
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void createTableOfEmployees() {
//private final String createTable = "CREATE TABLE Employees (EmpID INT PRIMARY KEY, Title VARCHAR(5), " +
//        "FirstName VARCHAR(15), initial CHAR(1), LastName VARCHAR(15), Gender CHAR(1), Email VARCHAR(50), " +
//        "DateOfBirth DATE, JoinDate DATE, Salary INT );";
//        try {
//            Statement statement = connectToDatabase().createStatement();
//            Printer.printMessage("Creating Table of Employees...");
//            statement.execute(createTable);
//        } catch (SQLException throwable) {
//            throwable.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
