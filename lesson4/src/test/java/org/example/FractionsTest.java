package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionsTest {

    static Fractions fractions;
    @BeforeAll
    static void setup()
    {
        fractions = new Fractions();
    }

    @Test
    void addition() {
        assertThrows(IllegalArgumentException.class, ()->fractions.addition(1, 0, 2, 0));
        assertEquals(1.16, fractions.addition(1, 2, 2, 3) , 0.01);
    }

    @Test
    void subtraction() {
        assertThrows(IllegalArgumentException.class, ()->fractions.subtraction(1, 0, 2, 0));
        assertEquals(-0.16, fractions.subtraction(1, 2, 2, 3) , 0.01);
    }

    @Test
    void multiplication() {
        assertThrows(IllegalArgumentException.class, ()->fractions.multiplication(1, 0, 2, 0));
        assertEquals(0.33, fractions.multiplication(1, 2, 2, 3) , 0.01);
    }

    @Test
    void division() {
        assertThrows(IllegalArgumentException.class, ()->fractions.division(1, 0, 2, 0));
        assertEquals(0.75, fractions.division(1, 2, 2, 3) , 0.01);

    }
}