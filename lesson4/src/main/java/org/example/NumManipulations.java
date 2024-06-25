package org.example;

public class NumManipulations
{
    private int number;

    public NumManipulations(int number) {
        this.number = number;
    }

    public int get()
    {
        return number;
    }

    public void set(int _num)
    {
        number = _num;
    }

    public  String toOcto()
    {
        return Integer.toOctalString(number);
    }
    public  String toHex()
    {
        return Integer.toHexString(number);
    }

    public  String toBinary()
    {
        return Integer.toBinaryString(number);
    }


}
