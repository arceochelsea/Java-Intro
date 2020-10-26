package com.chelsea;

import java.util.Scanner;
import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) {

        //these were removed out of the code block so it is able to be accessed globally
        int principal = 0;
        float annualInterest = 0;
        byte years = 0;

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
            annualInterest = scanner.nextFloat();
            if (annualInterest >= 1 && annualInterest <= 30)//if valid value, calculate monthlyinterest then break out of the loop if not print error
                break;
            System.out.println("Enter a value between 1 and 30");
        }

        while (true) {
            System.out.print("Period: (Years): ");
            years = scanner.nextByte();
            if (years >= 1 && years <= 30) //if valid calculate numofpayments then break, if not print error
                break;
            System.out.println("Enter a value between 1 and 30.");
        }

        double mortgage = calculateMortgage(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }

    public static double calculateMortgage(
            int principal,
            float annualInterest,
            byte years) {

        //all the code to calculate the mortgage is in one location now
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

