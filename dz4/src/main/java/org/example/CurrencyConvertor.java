package org.example;

public class CurrencyConvertor
{
    public double valInUah;
    CurrencyConvertor(double val)
    {
        valInUah = val;
    }

    public double toDollar()
    {
        return valInUah/36.52;
    }

    public double toEuro()
    {
        return valInUah/38.66;
    }

    public double toPounds()
    {
        return valInUah/44.33;
    }

    public double toYen()
    {
        return valInUah/0.24;
    }



}
