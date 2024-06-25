package org.example;

public class ArrayInt {

    private  int[] arr;

    public ArrayInt(int... args) {
        this.arr = args;
    }
    public  int sum()
    {
        int res = 0;
        for(int i = 0; i < arr.length; i++ )
        {
            res += arr[i];
        }
        return  res;
    }

    public  double average()
    {
        return sum() / arr.length;
    }

    public  int max()
    {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            if(max < arr[i])
            {
                max = arr[i];
            }
        }
        return max;
    }

    public  int min()
    {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            if(min > arr[i])
            {
                min = arr[i];
            }
        }
        return min;
    }



}