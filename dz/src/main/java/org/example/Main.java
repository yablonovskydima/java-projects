package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //task1
        Interfaces.OneArgument isIntercalary = (int year) ->
        {
            if(year % 4 == 0)
            {
                if(year % 100 != 0 || (year % 100 == 0 && year % 400 == 0))
                {
                    return true;
                }
            }
            return false;
        };

        Interfaces.twoDates numofdays = (LocalDate t1, LocalDate t2) ->
        {
            return t1.until(t2, ChronoUnit.DAYS);
        };

        Interfaces.twoDates numofweeks = (LocalDate t1, LocalDate t2) ->
        {
            return t1.until(t2, ChronoUnit.WEEKS);
        };

        Interfaces.DateDay nameofday = (LocalDate t) ->
        {
            return String.valueOf(t.getDayOfWeek());
        };



        //task2
        Interfaces.fractions addition = (double numerator1, double denominator1, double numerator2, double denominator2) ->
        {
            if (denominator1 == 0 || denominator2 == 0)
            {
                throw new IllegalArgumentException();
            }

            return (numerator1/denominator1) + (numerator2/denominator2);
        };

        Interfaces.fractions subtraction = (double numerator1, double denominator1, double numerator2, double denominator2) ->
        {
            if (denominator1 == 0 || denominator2 == 0)
            {
                throw new IllegalArgumentException();
            }

            return (numerator1/denominator1) - (numerator2/denominator2);
        };

        Interfaces.fractions multiplication = (double numerator1, double denominator1, double numerator2, double denominator2) ->
        {
            if (denominator1 == 0 || denominator2 == 0)
            {
                throw new IllegalArgumentException();
            }

            return (numerator1*numerator2) / (denominator1*denominator2);
        };

        Interfaces.fractions division = (double numerator1, double denominator1, double numerator2, double denominator2) ->
        {
            if (denominator1 == 0 || denominator2 == 0)
            {
                throw new IllegalArgumentException();
            }

            return (numerator1*denominator2) / (numerator2*denominator1);
        };



        //task3
        Interfaces.maxmin maxoffour = (int x1, int x2, int x3, int x4) ->
        {
            return Math.max(Math.max(Math.max(x1, x2), x3), x4);
        };

        Interfaces.maxmin minoffour = (int x1, int x2, int x3, int x4) ->
        {
            return Math.min(Math.min(Math.min(x1, x2), x3), x4);
        };

        //task4
        Interfaces.isEquals isequals = (int x, int y) -> x == y;
        Interfaces.inRange inrange = (int x, int a, int b) -> x > a && x < b;
        Interfaces.OneArgument ispositive = (int x) -> x >= 0;
        Interfaces.OneArgument isnegative = (int x) -> x < 0;

        func(isequals);
        func1(inrange);
        func2(ispositive, isnegative);

    }

    public static void  func(Interfaces.isEquals inter)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num1 = s.nextInt();
        System.out.println("Enter a second number: ");
        int num2 = s.nextInt();

        System.out.println("Is " + num1 + " equals to "+num2+"? " + inter.execute(num1, num2));
    }
    public static void  func1(Interfaces.inRange inter)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a min range: ");
        int min = s.nextInt();
        System.out.println("Enter a max range: ");
        int max = s.nextInt();
        System.out.println("Enter a num: ");
        int num = s.nextInt();

        System.out.println("Is " + num + " is between "+min+" and " + max +" ? "+ inter.execute(num, min, max));
    }

    public static void func2(Interfaces.OneArgument inter1,Interfaces.OneArgument inter2 )
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = s.nextInt();

        System.out.println("Is " + num + " positive or negative? " + inter1.execute(num) + "\t"+inter2.execute(num));

    }

}