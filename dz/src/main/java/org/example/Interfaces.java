package org.example;

import java.time.LocalDate;
import java.util.Date;

public class Interfaces
{
    public interface OneArgument
    {
        boolean execute(int year);
    }

    public  interface twoDates
    {
        long execute(LocalDate t1, LocalDate T2);
    }

    public  interface DateDay
    {
        String execute(LocalDate t);
    }

    public interface fractions
    {
        double execute(double numerator1, double denominator1, double numerator2, double denominator2);
    }

    public  interface maxmin
    {
        int execute(int x1, int x2, int x3, int x4);
    }

    public  interface isEquals
    {
        boolean execute(int x, int y);
    }

    public interface  inRange
    {
        boolean execute(int x, int a, int b);
    }
}
