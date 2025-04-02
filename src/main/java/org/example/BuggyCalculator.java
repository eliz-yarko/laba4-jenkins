package org.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BuggyCalculator {

    private static final Logger logger = Logger.getLogger(BuggyCalculator.class.getName());

    public void add(int a, int b) {
        int result = a + b;
        if (logger.isLoggable(Level.INFO)) {
            logger.log(Level.INFO, "Result is: {0}", result);
        }
    }

    public void subtract(int a, int b) {
        int result = a - b;
        if (logger.isLoggable(Level.INFO)) {
            logger.log(Level.INFO, "Result is: {0}", result);
        }
    }

    public void printOddNumbers() {
        for (int i = 0; i < 5; i++) {
            if (i % 2 != 0 && logger.isLoggable(Level.INFO)) {
                logger.log(Level.INFO, "Odd number: {0}", i);
            }
        }
    }

    public int testableAdd(int a, int b) {
        return a + b;
    }

    public int testableSubtract(int a, int b) {
        return a - b;
    }

}
