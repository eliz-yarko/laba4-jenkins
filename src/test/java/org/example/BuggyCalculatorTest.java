package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class BuggyCalculatorTest {

    private BuggyCalculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new BuggyCalculator();
    }

    // Тести на методи з логами — лише перевіряємо що не падають
    @Test
    public void testAddDoesNotThrow() {
        assertDoesNotThrow(() -> calculator.add(2, 3));
    }

    @Test
    public void testSubtractDoesNotThrow() {
        assertDoesNotThrow(() -> calculator.subtract(7, 4));
    }

    @Test
    public void testPrintOddNumbersDoesNotThrow() {
        assertDoesNotThrow(() -> calculator.printOddNumbers());
    }

    // Тести на testable-методи
    @Test
    public void testTestableAdd() {
        assertEquals(15, calculator.testableAdd(10, 5));
    }

    @Test
    public void testOverflowInAdd() {
        int result = calculator.testableAdd(Integer.MAX_VALUE, 1);
        assertTrue(result < 0); // wraparound
    }

    @Test
    public void testTestableSubtract() {
        assertEquals(5, calculator.testableSubtract(10, 5));
    }

    @Test
    public void testAddWithNegative() {
        assertEquals(-3, calculator.testableAdd(-5, 2));
    }

    @Test
    public void testSubtractWithNegative() {
        assertEquals(-2, calculator.testableSubtract(-4, -2));
    }

    @Test
    public void testAddZero() {
        assertEquals(0, calculator.testableAdd(0, 0));
    }

    @Test
    public void testSubtractZero() {
        assertEquals(10, calculator.testableSubtract(10, 0));
    }

    @Test
    public void testAddWithMaxInt() {
        assertEquals(Integer.MAX_VALUE, calculator.testableAdd(Integer.MAX_VALUE, 0));
    }

    @Test
    public void testSubtractWithMinInt() {
        assertEquals(Integer.MIN_VALUE, calculator.testableSubtract(Integer.MIN_VALUE, 0));
    }
}