/**
 * 
 */
package com.fii.homewok.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fii.homework.model.PiNumber;

/**
 * @author ralexandroaie
 *
 */
public class PiNumberTest {
    private PiNumber testedObject;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        testedObject = new PiNumber();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test method for {@link com.fii.homework.model.PiNumber#PiNumber()}.
     */
    @Test
    public void testPiNumber() {
        PiNumber object = new PiNumber();
        assertEquals(2, object.getDecimals());
        assertEquals(new BigDecimal(3.14), object.getValue());
    }

    /**
     * Test method for {@link com.fii.homework.model.PiNumber#buildNumber()}.
     * when there is not decimal number provided
     */
    @Test
    public void testBuildNumberWhenNoDecimals() {
        testedObject.buildNumber();
        assertEquals(new BigDecimal(3.14), testedObject.getValue());
    }

    /**
     * Test method for {@link com.fii.homework.model.PiNumber#buildNumber()}.
     * when provided correct decimals number
     */
    @Test
    public void testBuildNumberWhenDecimals() {
        testedObject.buildDecimals("4");
        testedObject.buildNumber();
        assertTrue(testedObject.getValue().compareTo(new BigDecimal(3.1401)) >= 0);
    }

    /**
     * Test method for {@link com.fii.homework.model.PiNumber#buildDecimals()}.
     * when provided NotANumber decimals
     */
    @Test(expected = NumberFormatException.class)
    public void testBuildDecimalsWhenDecimalsProvidedNAN() {
        testedObject.buildDecimals("not a number");
    }

    /**
     * Test method for {@link com.fii.homework.model.PiNumber#buildDecimals()}.
     * when provided negative decimals number
     */
    @Test
    public void testBuildDecimalsWhenDecimalsProvidedNegative() {
        String decimalsValue = "-4";
        testedObject.buildDecimals(decimalsValue);
        assertEquals(2, testedObject.getDecimals());
    }

    /**
     * Test method for {@link com.fii.homework.model.PiNumber#buildDecimals()}.
     * when provided correct decimals number
     */
    @Test
    public void testBuildDecimalsWhenDecimalsProvided() {
        String decimalsValue = "4";
        int decimalsIntValue = Integer.parseInt(decimalsValue);
        testedObject.buildDecimals(decimalsValue);
        assertEquals(decimalsIntValue, testedObject.getDecimals());
    }

    /**
     * Test method for {@link com.fii.homework.model.PiNumber#getDecimals()}.
     */
    @Test
    public void testGetDecimals() {
        assertTrue(testedObject.getDecimals() >= 2);
    }

    /**
     * Test method for {@link com.fii.homework.model.PiNumber#getValue()}.
     */
    @Test
    public void testGetValue() {
        assertTrue(testedObject.getValue().compareTo(new BigDecimal(3.14)) >= 0);
    }

}
