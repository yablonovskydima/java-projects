package org.example;

public class Calculator {

    public int addition(int a, int b) {
        return a + b;
    }

    public int subtraction(int a, int b) {
        return a - b;
    }

    public int multiplication(int a, int b) {
        return a * b;
    }

    public int division(int a, int b) {
        if (b == 0) throw new IllegalArgumentException();

        return a / b;
    }

    public int greaterThan(int a, int b) {
        return a > b ? a : b;
    }

    public int smallerThan(int a, int b) {
        return a < b ? a : b;
    }

    public double percent(double x, double percent)
    {
        return  (x*percent)/100;
    }

    public  int pow(int x, int grade)
    {
        if(grade < 0)
            throw new IllegalArgumentException();

        for(int i = grade; i > 1; i--)
        {
            x *= x;
        }
        return x;
    }
}
