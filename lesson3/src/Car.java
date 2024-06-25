public class Car
{
    public String name;
    public int year;
    public int price;
    public String color;
    public double volume;

    public Car(String name, int year, int price, String color, double volume)
    {
        this.name = name;
        this.year = year;
        this.price = price;
        this.color = color;
        this.volume = volume;
    }

    public int getPrice()
    {
        return price;
    }
}
