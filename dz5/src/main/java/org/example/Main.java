package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        task5();

    }

    public static void task1()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Input file1 path: ");
        String path1 = s.nextLine();
        System.out.println("Input file2 path: ");
        String path2 = s.nextLine();

        File file1 = new File(path1);
        File file2 = new File(path2);

        ArrayList<String> text1 = new ArrayList<>();
        ArrayList<String> text2 = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(file1)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                text1.add(line);
            }
        }
        catch (IOException e)
        {
            System.out.println("File is not found");
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(file2)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                text2.add(line);
            }
        }
        catch (IOException e)
        {
            System.out.println("File is not found");
        }

        System.out.println("Lines that differ, first file: \n");

        for(var i : text1)
        {
            if (!text2.contains(i)) {
                System.out.println(i);
            }
        }
        System.out.println("Sexond file: \n");

        for(var i : text2)
        {
            if (!text1.contains(i)) {
                System.out.println(i);
            }
        }

    }

    public static void task2()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Input file path: ");
        String path = s.nextLine();
        File file = new File(path);

        ArrayList<String> text = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                text.add(line);
            }
        }
        catch (IOException e)
        {
            System.out.println("File is not found");
        }

        int max = text.get(0).length();
        String longestStr = "";

        for (var i:text)
        {
            if(max < i.length())
            {
                max = i.length();
            }
        }

        for (var i:text)
        {
            if(max == i.length())
            {
                longestStr = i;
            }
        }
        System.out.println("Longest line size: " + max);
        System.out.println("\n"+longestStr);

    }

    public  static void  task3() throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("Input file path: ");
        String path = s.nextLine();
        File file = new File(path);

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        ArrayList<Integer> arr3 = new ArrayList<>();

        List<String> lines = Files.readAllLines(Paths.get(path));

        String[] str1 = lines.get(0).split(" ");
        String[] str2 = lines.get(1).split(" ");
        String[] str3 = lines.get(2).split(" ");

        for (String value : str1) {
            arr1.add(Integer.parseInt(value));
        }

        for (String string : str2) {
            arr2.add(Integer.parseInt(string));
        }

        for (String string : str3) {
            arr3.add(Integer.parseInt(string));
        }

        int max1,max2,max3;
        max1 = arr1.get(0);
        max2 = arr2.get(0);
        max3 = arr3.get(0);


        for (var i:arr1)
        {
            if(max1 < i)
            {
                max1 = i;
            }
        }
        for (var i:arr2)
        {
            if(max2 < i)
            {
                max2 = i;
            }
        }
        for (var i:arr3)
        {
            if(max3 < i)
            {
                max3 = i;
            }
        }


        int min1,min2,min3;
        min1 = arr1.get(0);
        min2 = arr2.get(0);
        min3 = arr3.get(0);

        for (var i:arr1)
        {
            if(min1 > i)
            {
                min1 = i;
            }
        }
        for (var i:arr2)
        {
            if(min2 > i)
            {
                min2 = i;
            }
        }
        for (var i:arr3)
        {
            if(min3 > i)
            {
                min3 = i;
            }
        }

        int sum1, sum2, sum3;
        sum1 = sum2 = sum3 = 0;

        for (var i:arr1)
        {
            sum1+=i;
        }
        for (var i:arr2)
        {
            sum2+=i;
        }
        for (var i:arr3)
        {
            sum3+=i;
        }


        int sum = sum1+sum2+sum3;

        arr1.forEach(System.out::println);
        System.out.println("\n");
        arr2.forEach(System.out::println);
        System.out.println("\n");
        arr3.forEach(System.out::println);

        System.out.println("\nMax1 = "+max1+" max2 = " + max2 + " max3 ="+max3+"\n");
        System.out.println("Min1 = "+min1+" min2 = " + min2 + " min3 ="+min3+"\n");
        System.out.println("Sum1 = "+sum1+" sum2 = " + sum2 + " sum3 ="+sum3+"\n");
        System.out.println("Summary = "+sum);
    }

    public  static void task4()
    {
        int[] arr = new int[10];
        Scanner s = new Scanner(System.in);
        System.out.println("Input file path: ");
        String path = s.nextLine();
        System.out.println("Input a array of 10 numbers: ");

        for (int i = 0; i < arr.length;i++)
        {
            arr[i]=s.nextInt();
        }

        String str1 = "";
        String str2 = "";
        String str3 = "";
        String str4 = "";

        for (var i : arr)
        {
            str1 = str1 + Integer.toString(i) + " ";
        }

        for (var i : arr)
        {
           if(i%2==0)
           {
               str2 = str2 + Integer.toString(i) + " ";
           }
        }

        for(var i:arr)
        {
            if(i%2!=0)
            {
                str3 = str3+Integer.toString(i) + " ";
            }
        }


        for(int i = arr.length-1; i >= 0; i--)
        {
            str4 = str4 + Integer.toString(arr[i]) + " ";
        }

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path, true)))
        {
            writer.write(str1);
            writer.newLine();
            writer.write(str2);
            writer.newLine();
            writer.write(str3);
            writer.newLine();
            writer.write(str4);
            writer.newLine();

            writer.close();
        }
        catch(IOException ex)
        {
            System.out.println("File is not found");
        }


    }

    public static void task5() throws InterruptedException, IOException {
        boolean isRunning = true;
        int choise;
        ArrayList<Employee> employees = new ArrayList<>();
        do
        {
            Scanner s= new Scanner(System.in);
            System.out.println("Menu:");
            System.out.println("1) Show employees");
            System.out.println("2) Add employees");
            System.out.println("3) Edit employees");
            System.out.println("4) Delete employees");
            System.out.println("5) Save data");
            System.out.println("6) Exit");
            choise = s.nextInt();

            if(choise == 1)
            {
                if(employees.size()>0)
                {
                    for (int i = 0; i < employees.size(); i++)
                    {
                        System.out.println("Name: " + employees.get(i).getName() + " Surname: " + employees.get(i).getSurname() + " Age: "+employees.get(i).getAge());
                    }
                    Thread.sleep(3000);
                }
                else
                {
                    System.out.println("List is empty");
                    Thread.sleep(3000);
                }
            }

            if(choise == 2)
            {
                Scanner r = new Scanner(System.in);
                System.out.println("\nInput name, surname and age to add an employee: ");
                String name = r.nextLine();
                String surname = r.nextLine();
                int age = r.nextInt();
                employees.add(new Employee(name, surname, age));
                System.out.println("Employee added");
                Thread.sleep(2000);
            }

            if(choise == 3)
            {
                Scanner r = new Scanner(System.in);
                System.out.println("\nInput surname of employee you want to edit: ");
                String sur = r.nextLine();
                for (var i : employees)
                {
                    if(i.getSurname().equals(sur))
                    {
                        System.out.println("\nInput name, surname and age to e2dit an employee: \n");
                        String name = r.nextLine();
                        String surname = r.nextLine();
                        int age = r.nextInt();
                        i.setName(name);
                        i.setSurname(surname);
                        i.setAge(age);
                        System.out.println("Employee edited");
                        Thread.sleep(2000);
                    }
                }
            }

            if(choise == 4)
            {
                Scanner r = new Scanner(System.in);
                System.out.println("\nInput surname of employee you want to delete: ");
                String sur = r.nextLine();
                for (var i : employees)
                {
                    if(i.getSurname().equals(sur))
                    {
                        employees.remove(i);
                        System.out.println("Employee deleted");
                        Thread.sleep(2000);
                    }
                }
            }

            if (choise == 5)
            {
                try
                {
                    File workers = new File("Employees.txt");
                    if (workers.createNewFile())
                    {
                        System.out.println("File created");
                    }
                    else
                    {
                        System.out.println("File already exists, adding new data");
                    }

                    BufferedWriter writer = new BufferedWriter(new FileWriter("Employees.txt"));
                    for(int i = 0; i < employees.size(); i++)
                    {
                        writer.write(i + " " + employees.get(i).getName() + " " + employees.get(i).getSurname() + " " + employees.get(i).getAge());
                        writer.newLine();
                    }

                    writer.close();

                }
                catch (IOException e)
                {
                    System.out.println("An error occurred.");
                }

            }


            if(choise==6)
            {
                try
                {
                    File workers = new File("Employees.txt");
                    if (workers.createNewFile())
                    {
                        System.out.println("File created");
                    }
                    else
                    {
                        System.out.println("File already exists, adding new data");
                    }

                    BufferedWriter writer = new BufferedWriter(new FileWriter("Employees.txt"));
                    for(int i = 0; i < employees.size(); i++)
                    {
                        writer.write(i + " " + employees.get(i).getName() + " " + employees.get(i).getSurname() + " " + employees.get(i).getAge());
                        writer.newLine();
                    }

                    writer.close();

                }
                catch (IOException e)
                {
                    System.out.println("An error occurred.");
                }
                isRunning=false;
            }

            System.out.flush();
        }
        while (isRunning);
    }
}