/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fii.homework.main;

import java.util.Scanner;

import com.fii.homework.model.PiNumber;

/**
 *
 * @author Robert
 */
public class Main {

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        long t1 = System.currentTimeMillis();

        PiNumber piNumber = new PiNumber();
        if (args.length > 0) {
            buildDecimalsWithCorrectInput(piNumber, args[0]);
        } else {
            buildDecimalsWithCorrectInput(piNumber);
        }
        piNumber.buildNumber();
        long t3 = System.currentTimeMillis();

        System.out.println("Pi=" + piNumber.getValue().toString());
        System.out.println("Timpul executiei programului(milisecunde): "
                + (t3 - t1));
    }

    /**
     * @param piNumber
     */
    private static void buildDecimalsWithCorrectInput(PiNumber piNumber) {
        Scanner scan = new Scanner(System.in);
        boolean testCondition = true;
        String decimals = "";
        while (testCondition) {
            try {
                piNumber.buildDecimals(decimals);
                testCondition = false;
            } catch (NumberFormatException e) {
                System.out.println("Va rugam introduceti un numar natural:");
                decimals = scan.nextLine();
            }
        }
        scan.close();
    }

    /**
     * @param piNumber
     */
    private static void buildDecimalsWithCorrectInput(PiNumber piNumber,
            String value) {
        Scanner scan = new Scanner(System.in);
        boolean testCondition = true;
        String decimals = value;
        while (testCondition) {
            try {
                piNumber.buildDecimals(decimals);
                testCondition = false;
            } catch (NumberFormatException e) {
                System.out.println("Va rugam introduceti un numar natural:");
                decimals = scan.nextLine();
            }
        }
        scan.close();
    }
}
