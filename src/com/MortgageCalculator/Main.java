package com.MortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        final byte MONTHS_PER_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);
        //Principal(P)
        System.out.print("Principal Balance: ");
        int principal = scanner.nextInt();

        //Annual Interest Rate(r): Entered number needs to be divided by 100 then 12 for monthly interest
        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / PERCENT / MONTHS_PER_YEAR;

        //Loan Period Length in Years(n): number needs to be multiplied by 12
        System.out.print("Loan Period (Years): ");
        short years = scanner.nextShort();
        int numberOfPayments = years * MONTHS_PER_YEAR;

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
