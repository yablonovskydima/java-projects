import java.time.Year;
import java.util.*;
import java.util.stream.Stream;

public class    Main
{
    public static void main(String[] args)
    {


    }

    public static  void task1()
    {
        var list = new ArrayList<Integer>();
        Random rand = new Random();
        for(int i = 0; i < 10; i++)
        {
            list.add(rand.nextInt(1000));
        }

        Scanner in = new Scanner(System.in);
        System.out.println("Input a number from 0 to 1000: ");
        int y = in.nextInt();

        System.out.println(list.stream().filter(x -> x % 2 == 0).count());
        System.out.println(list.stream().filter(x -> x % 2 != 0).count());
        System.out.println(list.stream().filter(x -> x == 0).count());
        System.out.println(list.stream().filter(x -> x == y).count());
    }

    public static  void task2()
    {
        var cityList = new ArrayList<String>();
        cityList.add("Ivano-Frankivsk");
        cityList.add("Kyiv");
        cityList.add("Lviv");
        cityList.add("Ternopil");

        cityList.forEach(System.out::println);
        System.out.println(cityList.stream().filter(c -> c.length() > 6));

        Scanner in = new Scanner(System.in);
        System.out.println("Input a name of a city: ");
        var y = in.nextLine();

        System.out.println(cityList.stream().filter(c-> c.equals(y)));

        System.out.println("Input a letter: ");
        var z = in.nextLine();

        System.out.println(cityList.stream().filter(c-> c.startsWith(z)));

    }

    public static  void task3()
    {
        var carList = new ArrayList<Car>();
        carList.add(new Car("Audi", 1990, 10000, "Black", 1.5));
        carList.add(new Car("Mercedes", 1991, 20000, "Red", 3.0));
        carList.add(new Car("BMW", 2001, 12000, "Blue", 5.6));
        carList.add(new Car("Nissan", 2016, 102000, "White", 3.1));

        carList.forEach(System.out::println);

        Scanner in = new Scanner(System.in);

        System.out.println("Input color: ");
        String color = in.nextLine();
        carList.stream().filter(c -> c.color.equals(color));

        System.out.println("Input volume: ");
        double vol = in.nextDouble();
        carList.stream().filter(c -> c.volume == vol);

        System.out.println("Input volume: ");
        int price = in.nextInt();
        carList.stream().filter(c -> c.price > price);

        int minYear, maxYear;
        System.out.println("Input min year: ");
        minYear = in.nextInt();
        System.out.println("Input max year: ");
        maxYear = in.nextInt();
        carList.stream().filter(c-> c.year >= minYear && c.year <= maxYear);

    }

    public  static void task4()
    {
        var tvList = new ArrayList<TV>();
        tvList.add(new TV("Samsung", 2019, 1200, 40.5, "Korea"));
        tvList.add(new TV("Samsung", 2020, 1300, 41.5, "Korea"));
        tvList.add(new TV("LG", 2032, 1350, 45.0, "Korea"));
        tvList.add(new TV("Lg", 2022, 1100, 39, "Korea"));
        tvList.add(new TV("Xiaomi", 2016, 999, 43.0, "Korea"));
        tvList.add(new TV("Xiaomi", 2022, 1500, 50.5, "China"));
        tvList.add(new TV("Sumsung", 2023, 2000, 60.0, "Korea"));

        tvList.forEach(System.out::println);
        Scanner in = new Scanner(System.in);

        System.out.println("Input a diagonal in double: ");
        double diag = in.nextDouble();
        tvList.stream().filter(t -> t.diagonal == diag);

        System.out.println("Input a producer: ");
        String prod = in.nextLine();
        tvList.stream().filter(t -> t.producer.equals(prod));

        tvList.stream().filter(t -> t.year == Year.now().getValue());

        System.out.println("Input a price filter: ");
        int prc = in.nextInt();
        tvList.stream().filter(t -> t.price > prc);

        tvList.stream().sorted(Comparator.comparing(TV::getPrice)).forEach(System.out::println);
        System.out.println("\n");
        tvList.stream().sorted(Comparator.comparing(TV::getPrice).reversed()).forEach(System.out::println);

        System.out.println("\n");
        tvList.stream().sorted(Comparator.comparing(TV::getDiagonal)).forEach(System.out::println);
        System.out.println("\n");
        tvList.stream().sorted(Comparator.comparing(TV::getDiagonal).reversed()).forEach(System.out::println);
    }

}

