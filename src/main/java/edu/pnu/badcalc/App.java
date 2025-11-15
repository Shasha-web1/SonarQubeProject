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
            // Replaced System.out.print("> ") with logger info
            LOGGER.info("> "); 
            
            String line = s.nextLine();

            if (line.equals("quit")) {
                break;
            }

            try {
                // Replaced System.out.println("= " + ...) with logger info
                LOGGER.info("= " + c.parseAndCompute(line));
            } catch (Exception e) {
                // Lambda used to defer string concatenation (L28 fix)
                LOGGER.log(Level.SEVERE, e, () -> "Calculation error occurred for input: " + line);
                // Replaced System.out.println("err") with logger warning (L29 fix)
                LOGGER.log(Level.WARNING, "err");
            }
        }
    }
    
    public static Calculator getCalculator() {
        return c;
    }
}

