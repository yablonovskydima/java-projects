package org.example;

import lombok.Getter;
import lombok.Setter;

public class AvgSumtask implements Runnable
{
    private int[] arr;
    @Getter
    @Setter
    private int sum;
    @Getter @Setter
    private double avg;

    public AvgSumtask(int[] arr)
    {
        this.arr = arr;
        this.sum = arr[0];
        this.avg = arr[0];
    }

    @Override
    public  void run()
    {
        for (int i:arr)
        {
            sum += i;
        }

        avg = (double)sum / arr.length;
    }
}
