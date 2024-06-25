public class TV
{
    public String name;
    public int year;
    public int price;
    public double diagonal;
    public String producer;

    public TV(String name, int year, int price, double diagonal, String producer)
    {
        this.name = name;
        this.year = year;
        this.price = price;
        this.diagonal = diagonal;
        this.producer = producer;
    }

    public int getPrice()
    {
        return this.price;
    }

    public double getDiagonal()
    {
        return this.diagonal;
    }
}
