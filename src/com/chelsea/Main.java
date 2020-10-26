package com.chelsea;

import java.util.Scanner;
import java.text.NumberFormat;

public class Main {

    final static byte monthsInAYear = 12;
    final static byte percentage = 100;

    public static void main(String[] args) {
        //Got rid of while loops and created a readNumber method that will be used 3 times, every time a different value is read.

        //this replaces all the while loops because it uses the readNumber method and just takes arguments from the user
        int principal = (int)readNumber("Principal: ", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) readNumber("Period (Years): ", 1, 30);

        printMortgage(principal, annualInterest, years);

        printPaymentSchedule(principal, annualInterest, years);
    }

    private static void printMortgage(int principal, float annualInterest, byte years) {
        double mortgage = calculateMortgage(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    private static void printPaymentSchedule(int principal, float annualInterest, byte years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= years * monthsInAYear; month++) {
            double balance = calculateBalance(principal, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double readNumber(String prompt, double min, double max) {
        //Scanner obj moved outside of code block
        //1 and 30 were replaced with params min and max so numbers are not hard coded
        //value is now any of the values user puts in for principal, annualInterest, years

        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }

    public static double calculateBalance(
            int principal,
            float annualInterest,
            byte years,
            short numberOfPaymentsMade) {

        float monthlyInterest = annualInterest / percentage / monthsInAYear;
        short numOfPayments = (short) (years * monthsInAYear);

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numOfPayments) - 1);

        return balance;
    }

    public static double calculateMortgage(
            int principal,
            float annualInterest,
            byte years) {

        float monthlyInterest = annualInterest / percentage / monthsInAYear;
        short numOfPayments = (short) (years * monthsInAYear);

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numOfPayments))
                / (Math.pow(1 + monthlyInterest, numOfPayments) - 1);

        return mortgage;
    }
}

