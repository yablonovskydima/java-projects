package com.homework;

import java.util.ArrayList;
import java.util.List;

public class Order
{
    public static List<String> availableAddress = new ArrayList<>();
    public static List<String> pizza = new ArrayList<>();
    public  static List<String> additionalToppings = new ArrayList<>();
    public static List<String> clientName = new ArrayList<>();
    public static List<String> phoneNumber= new ArrayList<>();
    public static List<String> email = new ArrayList<>();
    public static List<String> address = new ArrayList<>();

    static
    {
        availableAddress.add("Sichovi Striltsi Street");
        availableAddress.add("Chornovola Avenue");
        availableAddress.add("Halytska Street");
        availableAddress.add("Nezalezhnosti Street");
        availableAddress.add("Shevchenka Street");
        availableAddress.add("Mykhnivetska Street");
        availableAddress.add("Hetmanska Street");
        availableAddress.add("Vovchynetska Street");
        availableAddress.add("Mazepa Street");
        availableAddress.add("Bandery Street");
    }


}
