package edu.pnu.badcalc;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static final Calculator c = new Calculator();
    private static final Scanner s = new Scanner(System.in);
    
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        LOGGER.info("Bad Calculator v0.0.1");

        while (true) {
            LOGGER.info("> "); 
            
            String line = s.nextLine();

            if (line.equals("quit")) {
                break;
            }

            try {
                // FIX: Use LOGGER.log with a lambda to defer the expensive call
                // c.parseAndCompute(line) and the string concatenation
                LOGGER.log(Level.INFO, () -> "= " + c.parseAndCompute(line));
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, e, () -> "Calculation error occurred for input: " + line);
                LOGGER.log(Level.WARNING, "err");
            }
        }
    }
    
    public static Calculator getCalculator() {
        return c;
    }
}

