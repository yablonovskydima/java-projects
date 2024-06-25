package org.example;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        task1();
        task2();

    }

    public static int reversenum(int num)
    {
        int reverse = 0;
        while(num != 0)
        {
            int remainder = num % 10;
            reverse = reverse * 10 + remainder;
            num = num/10;
        }
        return reverse;
    }
    public  static  void  task1()
    {
        var list = new ArrayList<Integer>();
        Random random = new Random();


        for(int i = 0; i < 20; i++)
        {
            list.add(random.nextInt(-100, 100));
        }

        System.out.println(list.stream().filter(x->x>=0).count());
        System.out.println(list.stream().filter(x->x<0).count());
        System.out.println(list.stream().filter(x->x/10>0).count());
        System.out.println(list.stream().filter(x -> x == reversenum(x)));

    }

    public static void task2()
    {
        var list = new ArrayList<Groceries>();
        list.add(new Groceries("Cheese", "Milk"));
        list.add(new Groceries("Milk", "Milk"));
        list.add(new Groceries("Bread", "Flour products"));
        list.add(new Groceries("Baguette", "Flour products"));
        list.add(new Groceries("Steak", "Meat"));
        list.add(new Groceries("Chicken legs", "Meat"));
        list.add(new Groceries("Salmon", "Fish"));

        list.forEach(System.out::println);
        System.out.println(list.stream().filter(p->p.getName().length() < 5));

        Scanner s = new Scanner(System.in);
        System.out.println("Enter a product name: ");
        String word = s.nextLine();

        System.out.println(list.stream().filter(p->p.getName().equals(word)).count());

        System.out.println("Enter a first letter: ");
        String letter = s.nextLine();

        System.out.println(list.stream().filter(p->p.getName().startsWith(letter)));
        System.out.println(list.stream().filter(p->p.getCategory().equals("Milk")));
    }

    public  static void task3()
    {
        var list = new ArrayList<Gadget>();
        list.add(new Gadget("Iphone 15", 2023, 2100, "White", "Phone"));
        list.add(new Gadget("Iphone 12", 2020, 1600, "Black", "Phone"));
        list.add(new Gadget("Google pixel 8", 2023, 1850, "White", "Phone"));
        list.add(new Gadget("Samsung tv", 2021, 1000, "Grey", "TV"));
        list.add(new Gadget("Xiano tv", 2022, 790, "Black", "TV"));
        list.add(new Gadget("Iphone XR", 2018, 400, "Gold", "Phone"));
        list.add(new Gadget("OnePlus 9", 2021, 500, "Purple", "Phone"));
        list.add(new Gadget("OnePlus Buds Pro", 2021, 200, "White", "Earbuds"));
        list.add(new Gadget("Airpods Pro", 2022, 300, "White", "Earbuds"));
        list.add(new Gadget("Nvidia RTX4080 Ti", 2023, 40000, "Greyish", "Graphics Card"));

        list.forEach(System.out::println);

        Scanner s = new Scanner(System.in);
        System.out.println("Enter a product color: ");
        String word = s.nextLine();
        System.out.println(list.stream().filter(p->p.getColor().equals(word)));

        System.out.println("Enter a product year: ");
        int year = s.nextInt();
        System.out.println(list.stream().filter(p->p.getYear()==year));

        System.out.println("Enter a price: ");
        int price = s.nextInt();
        System.out.println(list.stream().filter(p->p.getPrice()>price));

        System.out.println("Enter a product type: ");
        String type = s.nextLine();
        System.out.println(list.stream().filter(p->p.getType().equals(type)));

        System.out.println("Enter a year range a and b: ");
        int a = s.nextInt();
        int b = s.nextInt();
        System.out.println(list.stream().filter(p->p.getYear() > a && p.getYear() < b));

    }

    private static void task4()
    {
        var list = new ArrayList<Projector>();

        list.add(new Projector("BenQ Projector", 2020, 700, "BenQ"));
        list.add(new Projector("Canon Projector", 2022, 650, "Canon"));
        list.add(new Projector("Canon Projector", 2021, 890, "Canon"));
        list.add(new Projector("BenQ Projector", 2010, 250, "Dell "));
        list.add(new Projector("Dell Projector", 2018, 710, "BenQ"));
        list.add(new Projector("Dell Projector", 2023, 900, "Dell "));
        list.add(new Projector("LG  Projector", 2015, 970, "LG "));
        list.add(new Projector("LG  Projector", 2023, 1050, "LG "));
        list.add(new Projector("LG  Projector", 2019, 1000, "LG "));
        list.add(new Projector("Hitachi  Projector", 2017, 500, "Hitachi "));

        Scanner s = new Scanner(System.in);

        list.forEach(System.out::println);

        System.out.println(list.stream().filter(x->x.getProducer().equals("BenQ")));

        System.out.println(list.stream().filter(x->x.getYear()== LocalDate.now().getYear()));

        System.out.println("Enter a price: ");
        int price = s.nextInt();
        System.out.println(list.stream().filter(x->x.getPrice()>price));

        list.stream().sorted(Comparator.comparing(Projector::getPrice)).forEach(System.out::println);

        list.stream().sorted(Comparator.comparing(Projector::getPrice).reversed()).forEach(System.out::println);

        list.stream().sorted(Comparator.comparing(Projector::getYear)).forEach(System.out::println);

        list.stream().sorted(Comparator.comparing(Projector::getYear).reversed()).forEach(System.out::println);
    }
}