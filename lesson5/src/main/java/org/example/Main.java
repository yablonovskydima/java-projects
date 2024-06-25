package org.example;
import lombok.SneakyThrows;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main
{
    @SneakyThrows
    public static void main(String[] args) {

        File file = new File("C:\\Users\\User\\Desktop\\test.txt");
        task7();

    }

    public  static void task12()
    {
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Input file path: \n");
            String path = s.nextLine();
            File file = new File(path);
            Scanner reader = new Scanner(file);
            String data = "";


            while (reader.hasNextLine()) {
                data = reader.nextLine();
                System.out.println(data + "\n");
            }
            reader.close();

            String[] result = data.split(" ");

            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }


        } catch (FileNotFoundException e)
        {
            System.out.println("File is not found");
        }
    }

    public  static void task3()
    {
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Input file path: ");
            String path = s.nextLine();
            System.out.println("Input a word: ");
            String word = s.nextLine();

            File file = new File(path);
            Scanner reader = new Scanner(file);
            String data = "";


            while (reader.hasNextLine())
            {
                data = reader.nextLine();
                System.out.println(data + "\n");
            }
            reader.close();
            String[] words = data.split(" ");

            int count = 0;
            for (var w: words)
            {
                if(w.equals(word)) count++;
            }

            System.out.println("Word " + word + " appeared " + count + " times");

        }
        catch (FileNotFoundException e)
        {
            System.out.println("File is not found");
        }

    }
    public  static void task4()
    {
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Input file path: ");
            String path = s.nextLine();


            File file = new File(path);
            Scanner reader = new Scanner(file);
            String data = "";


            while (reader.hasNextLine())
            {
                data = reader.nextLine();
                System.out.println(data + "\n");
            }
            reader.close();
            data = data.trim();

            int numcount = 0, charcount = 0, othercharcount = 0;


            for (int i = 0; i < data.length(); i++)
            {
                if(data.charAt(i) >= 48 && data.charAt(i) <= 57)
                {
                    numcount++;
                }
                else if((data.charAt(i) >= 65 && data.charAt(i) <= 90) || (data.charAt(i) >= 97 && data.charAt(i) <= 122))
                {
                    charcount++;
                }
                else
                {
                    othercharcount++;
                }
            }

            System.out.println("Num of numbers: " + numcount + "\tNum of letters: " + charcount+"\tNum of other characters: "+othercharcount);

        }
        catch (FileNotFoundException e)
        {
            System.out.println("File is not found");
        }

    }

    public  static void task5() {
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Input file path: \n");
            String path = s.nextLine();
            System.out.println("Input a word to be changed: \n");
            String cword = s.nextLine();
            System.out.println("Input a new word: \n");
            String newword = s.nextLine();
            File file = new File(path);
            Scanner reader = new Scanner(file);
            StringBuilder data = new StringBuilder();

            int count = 0;

            while (reader.hasNextLine()) {
                data = new StringBuilder(reader.nextLine());
                System.out.println(data + "\n");
            }
            reader.close();

            String[] result = data.toString().split(" ");

            for (int i = 0; i < result.length; i++)
            {
                if(result[i].equals(cword) && i + 1 < result.length)
                {
                    count++;
                    result[i+1] = newword;
                }
            }

            for (var w:result)
            {
                System.out.println(w);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
        }
    }

    public  static void task6() {
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Input file1 path: \n");
            String path1 = s.nextLine();
            System.out.println("Input file2 path: \n");
            String path2 = s.nextLine();
            System.out.println("Input file3 path: \n");
            String path3 = s.nextLine();
            System.out.println("Input file4 path: \n");
            String path4 = s.nextLine();

            String data1 = " ", data2 = " ", data3 = " ", wholetext;

            File file1 = new File(path1);
            File file2 = new File(path2);
            File file3 = new File(path3);
            Scanner reader1 = new Scanner(file1);
            Scanner reader2 = new Scanner(file2);
            Scanner reader3 = new Scanner(file3);
            while (reader1.hasNextLine()) {
                data1 = reader1.nextLine();
            }
            reader1.close();

            while (reader2.hasNextLine()) {
                data2 = reader2.nextLine();
            }
            reader2.close();

            while (reader3.hasNextLine()) {
                data3 = reader3.nextLine();
            }
            reader3.close();

            wholetext = data1 + data2 + data3;

            try
            {
               FileOutputStream outputStream = new FileOutputStream(path4);
               byte[] bytetext = wholetext.getBytes();
               outputStream.write(bytetext);
               System.out.println(bytetext.length + " bytes was written in a file");
               outputStream.close();
            }
            catch (IOException e)
            {
                System.out.println("An error occurred.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
        }
    }

    public  static void task7() {
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Input file path: ");
            String path = s.nextLine();
            System.out.println("Input a list of banned words: ");
            String ws = s.nextLine();
            String[] words = ws.split(" ");

            File file = new File(path);
            Scanner reader = new Scanner(file);
            String data = " ";
            while (reader.hasNextLine())
            {
                data = reader.nextLine();
            }
            reader.close();

            String[] text = data.split(" ");

            for (int i =0; i<text.length;i++)
            {
                for (int j = 0; j < words.length; j++)
                {
                    if(text[i].equals(words[j])) text[i] = " ";
                }
            }

            for (var w:text)
            {
                System.out.println(w+"\t");
            }


            try
            {
                FileWriter writer = new FileWriter(path);
                for (var w:text)
                {
                    if(!w.equals(" "))
                    {
                        writer.write(w + " ");
                    }
                }
                writer.close();

            }
            catch (IOException e)
            {
                System.out.println("An error occurred.");
            }

            System.out.println("Banned words removed: ");
            for (var w:words)
            {
                System.out.println(w);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
        }
    }

}