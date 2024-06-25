package org.example;

import lombok.Getter;
import lombok.Setter;

public class MinMaxtask implements Runnable
{

    private int[] arr;
    @Getter @Setter
    private int max;
    @Getter @Setter
    private int min;

    public MinMaxtask(int[] arr)
    {
        this.arr = arr;
        this.max = arr[0];
        this.min = arr[0];
    }

    @Override
    public  void run()
    {
        for (int i:arr)
        {
            if(i < min)
            {
                min = i;
            }
            if(i > max)
            {
                max = i;
            }
        }
    }
}
