package com.MortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        final byte MONTHS_PER_YEAR = 12;
        final byte PERCENT = 100;

        int principal = 0;
        float monthlyInterest = 0;
        int numberOfPayments = 0;

        Scanner scanner = new Scanner(System.in);
        //Principal(P)
        while (true) {
            System.out.print("Principal Balance ($1K - $1M): ");
            principal = scanner.nextInt();
            if (principal >= 1_000 && principal <= 1_000_000)
                break;
            System.out.println("Please enter a value between $1,000 and $1,000,000");
        }


        //Annual Interest Rate(r): Entered number needs to be divided by 100 then 12 for monthly interest
        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterest = scanner.nextFloat();
            if (annualInterest >= 0 && annualInterest <= 30) {
                monthlyInterest = annualInterest / PERCENT / MONTHS_PER_YEAR;
                break;
            }
            System.out.println("Please enter a value between 0 and 30");

        }

        //Loan Period Length in Years(n): number needs to be multiplied by 12
        while (true) {
            System.out.print("Loan Period (Years): ");
            byte years = scanner.nextByte();
            if (years >= 1 && years <= 30) {
                numberOfPayments = years * MONTHS_PER_YEAR;
                break;
            }
            System.out.println("Enter a number between 1 and 30");
        }

        //                                      r(1+r)^n
        //Monthly Mortgage Calculation:  M = --------------
        //                                     (1+r)^n - 1
        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest,numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments)- 1);
        String monthlyPayment = NumberFormat.getCurrencyInstance().format(mortgage);
        String usdMortage = monthlyPayment.replace("¤","$");
        System.out.print("Monthly Mortgage: " + usdMortage);


    }
}
