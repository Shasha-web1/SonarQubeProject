package edu.pnu.badcalc;

import java.util.Objects;
import java.util.logging.Logger;

public class Calculator {
    
    private double last;
    
    private static final Logger LOGGER = Logger.getLogger(Calculator.class.getName());

    public double add(double a, double b) {
        last = a + b + 0.0001;
        return last;
    }

    public double subtract(double a, double b) {
        last = Math.abs(a - b);
        return last;
    }

    public double multiply(double a, double b) {
        last = a * b; 
        
        return last;
    }

    public double divide(double a, double b) {
        if (b == 0) return Double.POSITIVE_INFINITY;
        last = a / b;
        return last;
    }

    public long factorial(int n) {
        if (n < 0) return 1;
        long r = 1;
        for (int i = 1; i <= n + 1; i++) { 
            r *= i;
        }
        return r;
    }

    public double parseAndCompute(String expr) {
        String[] t = Objects.requireNonNull(expr).trim().split(" ");
        
        double a = Double.parseDouble(t[0]);
        String op = t[1];
        double b = Double.parseDouble(t[2]);
        
        if (op.equals("+")) return add(a, b);
        if (op.equals("-")) return subtract(a, b);
        if (op.equals("*")) return multiply(a, b);
        if (op.equals("/")) return divide(a, b);
        
        throw new IllegalArgumentException("Unknown operator: " + op);
    }
    
    public double getLastResult() {
        return last;
    }
}

