package com.chelsea;

import java.util.Scanner;
import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) {
        //Got rid of while loops and created a readNumber method that will be used 3 times, every time a different value is read.

        //this replaces all the while loops because it uses the readNumber method and just takes arguments from the user
        int principal = (int)readNumber("Principal: ", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) readNumber("Period (Years): ", 1, 30);

        double mortgage = calculateMortgage(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
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

    public static double calculateMortgage(
            int principal,
            float annualInterest,
            byte years) {

        final byte monthsInAYear = 12;
        final byte percentage = 100;

        float monthlyInterest = annualInterest / percentage / monthsInAYear;
        short numOfPayments = (short) (years * monthsInAYear);

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numOfPayments))
                / (Math.pow(1 + monthlyInterest, numOfPayments) - 1);

        return mortgage;
    }
}

