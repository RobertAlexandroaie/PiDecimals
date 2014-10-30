/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fii.homework.main;

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
            piNumber.buildDecimals(args[0]);
        } else {
            piNumber.buildDecimals("");
        }
        piNumber.buildNumber();
        long t3 = System.currentTimeMillis();

        System.out.println("Pi=" + piNumber.getValue().toString());
        System.out.println("Timpul executiei programului(milisecunde): "
                + (t3 - t1));
    }
}
