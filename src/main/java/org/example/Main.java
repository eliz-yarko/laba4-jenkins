package org.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        BuggyCalculator calc = new BuggyCalculator();

        try {
            calc.add(5, 5);
            calc.add(10, 2);
            calc.subtract(10, 3);
            calc.printOddNumbers();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error during calculator operation", e);
        }

        try {
            if (logger.isLoggable(Level.INFO)) {
                logger.info(String.format("Program finished at: %d", System.currentTimeMillis()));
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error during final log message", e);
        }
    }
}
