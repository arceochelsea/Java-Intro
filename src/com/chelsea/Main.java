package com.chelsea;

import java.util.Scanner;
import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) {

        //For each question we want to validate the value that the user enters. If invalid we want to ask the same question again.
        //const variables
        final byte monthsInAYear = 12;
        final byte percentage = 100;

        //these were removed out of the code block so it is able to be accessed globally
        int principal = 0;
        float monthlyInterest = 0;
        int numOfPayments = 0;

        //created scanner obj & imported up top automatically as well
        Scanner scanner = new Scanner(System.in);

        while (true) {  //infinite loops
            System.out.print("Principle: ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000) //if valid value break if not print error
                break;
            System.out.println("Enter a value between 1000 and 1000000");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterest = scanner.nextFloat();
            if (annualInterest >= 1 && annualInterest <= 30) {
                monthlyInterest = annualInterest / percentage / monthsInAYear;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        while (true) {
            System.out.print("Period: (Years): ");
            byte years = scanner.nextByte();
            if (years >= 1 && years <= 30) {
                numOfPayments = years * monthsInAYear;
                break;
            }
            System.out.println("Enter a value between 1 and 30.");
        }

        //this will work the same because consts were placed outside of local scope (inside code block) to outside of it!
        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numOfPayments)) / (Math.pow(1 + monthlyInterest, numOfPayments) - 1);

        //This is utilizing NumberFormat class to format it as currency
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}
