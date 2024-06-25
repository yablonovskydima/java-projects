package org.example;

public class CmConvertor
{
    private double valueCm;
    public CmConvertor(double val)
    {
        valueCm = val;
    }

    public double toMM()
    {
        return valueCm*10;
    }

    public double toCM()
    {
        return valueCm;
    }

    public double toDM()
    {
        return valueCm/10;
    }

    public double toMeters()
    {
        return valueCm/100;
    }

    public double toKM()
    {
        return valueCm/100000;
    }

}
