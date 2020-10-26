package com.chelsea;

import java.util.Scanner;
import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) {

        //const variables
        final byte monthsInAYear = 12;
        final byte percentage = 100;

        //created scanner obj & imported up top automatically as well
        Scanner scanner = new Scanner(System.in);
        System.out.print("Principle: ");
        int principal = scanner.nextInt(); //storing in INT because this allows us to store value up to 2 billion
        System.out.println("Your principle is " + principal);

        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat(); //notice that all variables have meaningful and descriptive names
        System.out.println("Your Annual Interest Rate is " + annualInterest);
        float monthlyInterest = annualInterest / percentage / monthsInAYear;

        System.out.print("Period: ");
        byte years = scanner.nextByte(); //one byte is enough to store the number 30 & anything smaller.
        int numOfPayments = years * monthsInAYear;
        System.out.println("Your Period is " + years);

          /*
        M = P [ i(1 + i)^n ] / [ (1 + i)^n – 1]
        P = principal loan amount
        i = monthly interest rate
        n = number of months required to repay the loan
        */

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numOfPayments)) / (Math.pow(1 + monthlyInterest, numOfPayments) - 1);

        //This is utilizing NumberFormat class to format it as currency
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}
