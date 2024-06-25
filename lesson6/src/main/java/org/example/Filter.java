package org.example;

import lombok.Getter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Predicate;

public class Filter implements Runnable
{
    private int[] arr;
    private String fileName;
    @Getter
    private int count = 0;
    private  Predicate<Integer> predicate;

    public Filter(int[] arr, String fileName, Predicate<Integer> predicate) {
        this.arr = arr;
        this.fileName = fileName;
        this.predicate = predicate;
    }

    @Override
    public  void run()
    {
        try
        {
            FileWriter writer = new FileWriter(fileName);
            for(int i : arr)
            {
                if(predicate.test(i))
                {
                    writer.write(i + " ");
                    count++;
                }
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
