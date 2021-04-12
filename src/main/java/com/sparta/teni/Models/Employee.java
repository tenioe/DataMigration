package com.sparta.teni.Models;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Employee {
    private int employeeId;
    private String title;
    private String firstName;
    private String initial;
    private String lastName;
    private char gender;
    private String email;
    private Date dateOfBirth;
    private Date dateOfJoining;
    private int salary;

    public Employee(int employeeId, String title, String firstName, String initial, String lastName, char gender,
                     String email, Date dateOfBirth, Date dateOfJoining, int salary) {
        this.employeeId = employeeId;
        this.title = title;
        this.firstName = firstName;
        this.initial = initial;
        this.email = email;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public int getEmployeeId() { return employeeId; }

    public String getTitle() { return title; }

    public String getFirstName() { return firstName; }

    public String getInitial() { return initial; }

    public String getLastName() { return lastName; }

    public char getGender() { return gender; }

    public Date getDateOfBirth() { return dateOfBirth; }

    public Date getJoinDate() { return dateOfJoining; }

    public int getSalary() { return salary; }

    public static java.sql.Date parseDateByFormat (String date){
        java.sql.Date sqlDate = null;
        SimpleDateFormat formatterForDate = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        try{
            java.util.Date dateTemp = formatterForDate.parse(String.valueOf(date));
            sqlDate = new java.sql.Date(dateTemp.getTime());
        }catch(ParseException e){
            e.printStackTrace();
        }
        return sqlDate;
    }

    public String toString() {
        return "EmployeeDTO{" +
                "empID=" + employeeId +
                ", prefix='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleInitial=" + initial +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", joinDate=" + dateOfJoining +
                ", salary=" + salary +
                '}';
    }
}
