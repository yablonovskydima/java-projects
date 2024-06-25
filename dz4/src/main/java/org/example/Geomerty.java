package org.example;

import static java.lang.Math.sqrt;

public class Geomerty
{
    private double side1;
    private double side2;
    private int height;
    public Geomerty(double side)
    {
        this.side1 = side;
    }

    public Geomerty(double side1, double side2)
    {
        this.side1 = side1;
        this.side2 = side2;
    }

    public Geomerty(double side1, int height)//для ромба
    {
        this.side1 = side1;
        this.height = height;
    }

    public double SquareS()
    {
        return side1*side1;
    }

    public double TriangleS() //мається на увазі рівносторонній трикутник
    {
        double s;
        s = (side1*side1*sqrt(3))/4;
        return s;
    }

    public double RectangleS()
    {
        return side1 * side2;
    }

    public  double diamondS()
    {
        return side1 * height;
    }

}
