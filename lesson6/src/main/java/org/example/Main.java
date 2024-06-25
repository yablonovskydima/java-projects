package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException
    {
        task4();
    }

    public  static  void  task1() throws InterruptedException
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Input a length of array: ");
        int size = s.nextInt();

        int[] arr = new int[size];

        System.out.println("Input a elements of array: ");
        for (int i = 0; i < size; i++)
        {
                arr[i] = s.nextInt();
        }

        MinMaxtask obj = new MinMaxtask(arr);
        Thread thread = new Thread(obj);
        thread.start();
        thread.join();

        System.out.println("Max num: " + obj.getMax());
        System.out.println("Min num: " + obj.getMin());
    }

    public  static  void task2() throws InterruptedException
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Input a length of array: ");
        int size = s.nextInt();

        int[] arr = new int[size];
        System.out.println("Input a elements of array: ");
        for (int i = 0; i < size; i++)
        {
            arr[i] = s.nextInt();
        }

        AvgSumtask obj = new AvgSumtask(arr);
        Thread thread = new Thread(obj);
        thread.start();
        thread.join();

        System.out.println("Avg: " + obj.getAvg());
        System.out.println("Sum: " + obj.getSum());
    }

    public static void task3() throws IOException, InterruptedException {
        Scanner s = new Scanner(System.in);
        System.out.println("Input a path to file: ");
        String path = s.nextLine();

        BufferedReader reader = new BufferedReader(new FileReader(path));
        String nums = reader.readLine();
        String[] numbers = nums.split("\\s+");

        int[] numbersarr = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++)
        {
            numbersarr[i] = Integer.parseInt(numbers[i]);
        }

        Filter filterEven = new Filter(numbersarr, "resultsEven.txt", (x)->x%2==0);
        Filter filterOdd = new Filter(numbersarr, "resultsOdd.txt", (x)->x%2!=0);

        Thread thread1 = new Thread(filterEven);
        Thread thread2 = new Thread(filterOdd);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Even numbers: " + filterEven.getCount());
        System.out.println("Odd numbers: " + filterOdd.getCount());
    }

    public  static void task4() throws IOException, ExecutionException, InterruptedException {
        Scanner s = new Scanner(System.in);
        System.out.println("Input a path to file: ");
        String path = s.nextLine();

        System.out.println("Input a word to find: ");
        String word = s.nextLine();

        BufferedReader reader = new BufferedReader(new FileReader(path));
        String wds = reader.readLine();
        String[] words = wds.split("\\s+");

        FindWord findWord = new FindWord(words, word);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(findWord);

        System.out.println("Found " + future.get() + " words of " + word);
    }
}