package org.example;

public class GramConvertor
{
    private double gramVal;

    public GramConvertor(double gramVal) {
        this.gramVal = gramVal;
    }

    public double toMiligram()
    {
        return gramVal*1000;
    }

    public double toKG()
    {
        return gramVal/1000;
    }

    public double toCN()
    {
        return gramVal/100000;
    }

    public double toTN()
    {
        return gramVal/1000000;
    }
}
