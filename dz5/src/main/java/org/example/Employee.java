package org.example;

import lombok.Getter;
import lombok.Setter;

public class Employee
{
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String surname;
    @Getter @Setter
    private int age;

    public Employee(String name, String surname, int age)
    {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}
