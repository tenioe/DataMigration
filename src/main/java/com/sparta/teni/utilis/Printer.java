package com.sparta.teni.utilis;

import java.time.Duration;

public class Printer {

    public static void printMessage(String message){
        System.out.println( message);
    }
    public static void printTestTimeResultsOfThreadless(Duration between){
        System.out.format("\nThe data migration took 0.%1d without threads.",between.toMillis());
    }
    public static void printTestTimeResultsThread(Duration between){
        System.out.format("\nThe data migration took 0.%1d without threads.",between.toMillis());
    }
}
