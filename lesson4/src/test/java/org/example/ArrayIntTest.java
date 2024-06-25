package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntTest {



    @Test
    void sum()
    {
        ArrayInt arrayInt = new ArrayInt(1,2,3,4,5,6);
        assertEquals(21, arrayInt.sum());
    }

    @Test
    void average()
    {
        ArrayInt arrayInt = new ArrayInt(2,3,5,1,7,15,2);
        assertEquals(5, arrayInt.average());
    }

    @Test
    void max()
    {
        ArrayInt arrayInt = new ArrayInt(2,6,123,56,1235,10385,12);
        assertEquals(10385, arrayInt.max());
    }

    @Test
    void min()
    {
        ArrayInt arrayInt = new ArrayInt(2,6,23,56,212,4247,12);
        assertEquals(2, arrayInt.min());
    }
}