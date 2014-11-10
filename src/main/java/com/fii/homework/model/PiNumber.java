/**
 * 
 */
package com.fii.homework.model;

import java.math.BigDecimal;

/**
 * @author ralexandroaie
 *
 */
public class PiNumber {
    private int decimals;
    private BigDecimal value;

    /**
     * Constructor
     */
    public PiNumber() {
        decimals = 2;
        value = new BigDecimal(3.14);
    }

    /**
     * Calculeza pi
     */
    public void buildNumber() {
        if (decimals > 2) {
            long t2 = System.currentTimeMillis();
            BigDecimal x = new BigDecimal(0.0);
            int i = 1;
            BigDecimal k = new BigDecimal(0.0);
            BigDecimal u = new BigDecimal(1.0);
            BigDecimal temp = new BigDecimal(0.0);
            BigDecimal p = new BigDecimal(4);

            for (i = 1; i <= 2000000; i++) {
                k = new BigDecimal(2 * i - 1);
                temp = u.divide(k, decimals, BigDecimal.ROUND_FLOOR);

                if (i % 2 == 0)
                    temp = temp.negate();

                x = x.add(temp);
            }

            value = x;
            value = value.multiply(p);

            long t3 = System.currentTimeMillis();
            System.out.println("Timpul calcularii lui pi(milisecunde): "
                    + (t3 - t2));
        }
    }

    /**
     * 
     * @param decimalsString
     *            The string to be converted to int
     */
    public void buildDecimals(String decimalsString)
            throws NumberFormatException {
        setDecimals(Integer.parseInt(decimalsString));
    }

    /**
     * @return the decimals
     */
    public int getDecimals() {
        return decimals;
    }

    /**
     * @param decimals
     *            the decimals to set
     */
    private void setDecimals(int decimals) {
        if (decimals > 2) {
            this.decimals = decimals;
        }
    }

    /**
     * @return the value
     */
    public BigDecimal getValue() {
        return value;
    }
}
