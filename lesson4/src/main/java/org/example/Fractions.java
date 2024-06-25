package org.example;

public class Fractions {
    public  double addition(double numerator1, double denominator1, double numerator2, double denominator2)
    {
        if(denominator1 == 0 || denominator2 == 0)
            throw  new IllegalArgumentException();

        return (numerator1/denominator2) + (numerator2/denominator2);
    }

    public  double subtraction(double numerator1, double denominator1, double numerator2, double denominator2)
    {
        if(denominator1 == 0 || denominator2 == 0)
            throw  new IllegalArgumentException();

        return (numerator1/denominator1) - (numerator2/denominator2);
    }

    public  double multiplication(double numerator1, double denominator1, double numerator2, double denominator2)
    {
        if(denominator1 == 0 || denominator2 == 0)
            throw  new IllegalArgumentException();

        return (numerator1*numerator2) / (denominator1*denominator2);
    }

    public  double division(double numerator1, double denominator1, double numerator2, double denominator2)
    {
        if(denominator1 == 0 || denominator2 == 0)
            throw  new IllegalArgumentException();

        return  (numerator1*denominator2) / (numerator2*denominator1);
    }
}
